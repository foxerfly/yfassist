USE [fanski]
GO
/****** Object:  StoredProcedure [dbo].[me_procGeneratorMocte]    Script Date: 06/25/2013 23:36:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
ALTER PROCEDURE [dbo].[me_procGeneratorMocte]
	-- Add the parameters for the stored procedure here
	@randomID int
AS
declare
	@PH	char(20),
	@VALUE decimal(20,4),
	@USERNAME CHAR(20),
    @DEPARTMENT CHAR(10),
    @ZHU CHAR(10),   --组
    @BM CHAR(6),      --部门
    @GZZX CHAR(10),    --工作中心
    @UID CHAR(20)
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
   --BEGIN TRANSACTION

    --取出组，部门编号，工作中心编号
    SELECT top 1 @UID=USERNAME FROM tmpDB where randomID=@randomID

   SELECT @ZHU=ISNULL(A.MG009,''),@BM=ISNULL(MV004,''),@GZZX=ISNULL(MD001,'')
   FROM (SELECT DISTINCT MG001,MG009 FROM ADMMG) AS A
   LEFT JOIN CMSMV ON MV001=A.MG001
   LEFT JOIN CMSMD ON MV004=MD015
   WHERE MV001=@UID



    --创建临时表，存放生成的信息
    CREATE TABLE #V_MOCTE(
    OVERPICK CHAR(1),
    MB001 CHAR(20),
    VALUE decimal(20,4),
    TA001 CHAR(4),
    TA002 CHAR(11))

    --创建临时表，存放生成的领料单别，单号
    CREATE TABLE #V_GENERATEMOCTC(
    TC001 CHAR(4),
    TC002 CHAR(11)
    )


    DECLARE @KYKC  decimal(20,4),   --品号可用库存，包含未审核领料单
			@GDKBL  decimal(20,4),   --工单可补量
			@LLDWSL decimal(20,4),    --该工单的未审领料单总量
			@ZKBL decimal(20,4),    --该品号总可补量（补料单）
			@KCZKBL decimal(20,4),   --该品号库存总可补量
			@BLSL decimal(20,4),   --补料数量
			@CLSL decimal(20,4),   --超领数量
			@TA001 CHAR(4),
			@TA002 CHAR(11),
			@TE011 CHAR(4),
			@TE012 CHAR(11),
			@DB CHAR(4),
			@DH CHAR(11)

	CREATE TABLE #TEMPMOCTB (DB CHAR(4),DH CHAR(11),GDKBL decimal(20,4),TA009 CHAR(8))

    --获取临时表中的请求补料数据
    DECLARE C_A CURSOR  FOR
    SELECT PH,VALUE,USERNAME,DEPARTMENT FROM tmpDB WHERE randomID=@randomID


    OPEN C_A
    FETCH NEXT FROM C_A INTO @PH,@VALUE,@USERNAME,@DEPARTMENT
    WHILE @@FETCH_STATUS = 0
		BEGIN

		    --获取该品号可用库存，包含未审的领料单量
			--SELECT @KYKC=KYKC FROM V_INVMC_MOCTE WHERE PH=@PH

			--清除上一循环数据
			DELETE FROM #TEMPMOCTB

			--将该品号可领工单别，工单号，工单可领量插入临时表
			INSERT INTO #TEMPMOCTB
			SELECT TB001,TB002, (TB004-TB005)-ISNULL(TE005,0),TA009
			FROM  MOCTB
			LEFT JOIN MOCTA ON TB001=TA001 AND TB002=TA002
			LEFT JOIN(SELECT ISNULL(SUM(TE005),0) TE005 ,TE004,TE011,TE012 FROM MOCTE  LEFT JOIN MOCTC ON TC001=TE001 AND TC002=TE002 WHERE TC009='N' GROUP BY TE011,TE012,TE004) AS A  ON TE011=MOCTA.TA001 AND TE012=TA002 AND TE004=TB003
			WHERE TA013='Y' AND TA011<>'Y' AND TA011<>'y' AND TA011<>'1' AND MOCTA.TA001+MOCTA.TA002 IN(SELECT TC004+TC005 FROM SFCTC WHERE TC004=MOCTA.TA001 AND TC005=MOCTA.TA002 AND TC022='Y')
			AND TB003=@PH  --AND SUBSTRING(MOCTA.TA001,1,2)='51' --AND (TB004-TB005)-ISNULL(TE005,0) >0
			ORDER BY TA009

		    --工单总可补量
			select @ZKBL=ISNULL(SUM(GDKBL),0) from #TEMPMOCTB WHERE GDKBL>=0


			--库存总可补量
			select @KCZKBL=ISNULL(KYKC,0) from V_INVMC_MOCTE_EDWIN where PH=@PH


			--如果库存可补数量@KCZKBL大于等于申补数量@VALUE,且工单可补量@ZKBL大于等于申补量@VALUE
			IF  @KCZKBL-@VALUE>=0 AND @ZKBL-@VALUE >=0
			BEGIN
				SET @BLSL=@VALUE
				SET @CLSL=0
			END

			--如果库存可补数量@KCZKBL大于等于申补数量@VALUE,且工单可补量@ZKBL小于申补量@VALUE
			IF  @KCZKBL-@VALUE>=0 AND @ZKBL-@VALUE<0
			BEGIN
				SET @BLSL=@ZKBL
				SET @CLSL=@VALUE-@ZKBL
			END

			--如果库存可补数量@KCZKBL小于申补数量@VALUE,且工单可补量@ZKBL大于等于申补量@VALUE
			IF  @KCZKBL-@VALUE<0 AND @ZKBL-@VALUE>=0
			BEGIN
				SET @BLSL=@KCZKBL
				SET @CLSL=0
			END


			--如果库存可补数量@KCZKBL小于申补数量@VALUE,且工单可补量@ZKBL小于申补量@VALUE
			IF  @KCZKBL-@VALUE<0 AND @ZKBL-@VALUE <0
			BEGIN

				--如果工单总可补量@ZKBL大于0，且库存可补量@KCZKBL大于等于工单总可补量@ZKBL
				IF @ZKBL>0 AND @KCZKBL-@ZKBL>=0
				BEGIN
					SET @BLSL=@ZKBL
					SET @CLSL=@KCZKBL-@ZKBL
				END


				--如果工单总可补量@ZKBL大于0，且库存可补量@KCZKBL小于工单总可补量@ZKBL
				IF @ZKBL>0 AND @KCZKBL-@ZKBL<0
				BEGIN
					SET @BLSL=@KCZKBL
					SET @CLSL=0
				END

				--如果工单总可补量@ZKBL小于等于0，且库存可补量@KCZKBL大于等于工单总可补量@ZKBL
				IF @ZKBL<=0 AND @KCZKBL-@ZKBL>=0
				BEGIN
					SET @BLSL=0
					SET @CLSL=@KCZKBL
				END

				--如果工单总可补量@ZKBL小于等于0，且库存可补量@KCZKBL小于工单总可补量@ZKBL
				IF @ZKBL<=0 AND @KCZKBL-@ZKBL<0
				BEGIN
					SET @BLSL=0
					SET @CLSL=0
				END


			END


			--生成补料单数据
			DECLARE C_B CURSOR  FOR
			SELECT DB,DH,GDKBL FROM #TEMPMOCTB WHERE GDKBL>0 ORDER BY TA009

			OPEN C_B
			FETCH NEXT FROM C_B INTO @TA001,@TA002,@GDKBL


			--WHILE @@FETCH_STATUS = 0
			WHILE   @@FETCH_STATUS = 0 AND @BLSL>0
				BEGIN

					--如果补料数量大于该张工单可补数量，则以该张工单可补数量插入临时表
					IF @BLSL-@GDKBL>=0
						BEGIN
						 INSERT INTO #V_MOCTE VALUES('N',@PH,@GDKBL,@TA001,@TA002)
						 SET @BLSL=@BLSL-@GDKBL
						END

					--如果补料数量小于该张工单可补数量，则以补料数量插入临时表
					IF @BLSL-@GDKBL<0
						BEGIN
						 INSERT INTO #V_MOCTE VALUES('N',@PH,@BLSL,@TA001,@TA002)
						 SET @BLSL=@BLSL-@GDKBL
						END

				FETCH NEXT FROM C_B INTO @TA001,@TA002,@GDKBL
				END
			CLOSE C_B   /* 关闭游标 */
			DEALLOCATE C_B   /* 删除游标 */


			--生成超领单数据

			--DECLARE C_B CURSOR  FOR
			--SELECT DB,DH,GDKBL FROM #TEMPMOCTB

			--OPEN C_B
			--FETCH NEXT FROM C_B INTO @TA001,@TA002,@GDKBL
			--WHILE @@FETCH_STATUS = 0
			--WHILE  @CLSL>0
			--	BEGIN

			SELECT TOP 1  @TE011=DB ,@TE012=DH FROM #TEMPMOCTB ORDER BY TA009
			INSERT INTO #V_MOCTE VALUES('Y',@PH,@CLSL,@TE011,@TE012)

			--		SET @BLSL=@CLSL-@GDKBL
			--	FETCH NEXT FROM C_B INTO @TA001,@TA002,@GDKBL
			--	END
			--CLOSE C_B   /* 关闭游标 */
			--DEALLOCATE C_B   /* 删除游标 */




	FETCH NEXT FROM C_A INTO @PH,@VALUE,@USERNAME,@DEPARTMENT
	END

	CLOSE C_A   /* 关闭游标 */
    DEALLOCATE C_A   /* 删除游标 */


 --   SELECT  #V_MOCTE.OVERPICK,#V_MOCTE.MB001,#V_MOCTE.TA001,#V_MOCTE.TA002,#V_MOCTE.VALUE,MOCTB.TB009
	--FROM #V_MOCTE
	--LEFT JOIN INVMB ON INVMB.MB001=#V_MOCTE.MB001
	--LEFT JOIN MOCTB ON TB001=TA001 AND TB002=TA002 AND TB003=#V_MOCTE.MB001
	--WHERE VALUE>0

	DECLARE @CK CHAR(10),     --仓库编号
			@CLFLAG CHAR(1),   --超领标志
			@CCC CHAR(10),
			@BLDB CHAR(4),   --补料单别
			@BLDH CHAR(11),   --补料单号
			@EMB001 CHAR(20),--领料品号
			@EVALUE decimal(20,4) --领料数量

SET @CCC='noone'



    DECLARE C_C CURSOR FOR
	SELECT DISTINCT #V_MOCTE.OVERPICK,MOCTB.TB009
	FROM #V_MOCTE
	LEFT JOIN INVMB ON INVMB.MB001=#V_MOCTE.MB001
	LEFT JOIN MOCTB ON TB001=TA001 AND TB002=TA002 AND TB003=#V_MOCTE.MB001
	WHERE VALUE>0

	OPEN C_C
	FETCH NEXT FROM C_C INTO @CLFLAG,@CK
	WHILE @@FETCH_STATUS=0
		BEGIN
					IF @CLFLAG='N'  --如果为补领单
					BEGIN
						SET @BLDB='5430'
					END

					IF @CLFLAG='Y'  --如果为超领单
					BEGIN
							SET @BLDB='5450'
					END

						SELECT @CCC=ISNULL(MAX(TC002),'noone') FROM MOCTC WHERE SUBSTRING(TC002,1,6)=SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),3,8) AND TC001=@BLDB
						IF @CCC='noone'
						BEGIN
						SELECT @BLDH=SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),3,8)+'001'
						END
						IF @CCC<>'noone'
						BEGIN
						SELECT @BLDH= MAX(TC002)+1 FROM MOCTC WHERE SUBSTRING(TC002,1,6)=SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),3,8) AND TC001=@BLDB
						END




						--插入MOCTC
						INSERT INTO MOCTC
						SELECT 'fanski',@USERNAME,@ZHU,SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','',1,
							   @BLDB,@BLDH,SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'1000',@GZZX,'','','54',
							   'N',0,'N','1','N',SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','N',0,'0','','',@BM,'','','',0,0,0,'',0,0,'',
							   '','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0

						--插入MOCTD
						INSERT INTO MOCTD
						SELECT  'fanski',@USERNAME,@ZHU,SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','',1,@BLDB,@BLDH,#V_MOCTE.TA001,#V_MOCTE.TA002,'1',1,
						@CK,'1','','','','','N','','1','','1','','N','','','',0,0,0,'2','',
						'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0
						FROM #V_MOCTE
						LEFT JOIN INVMB ON INVMB.MB001=#V_MOCTE.MB001
						LEFT JOIN MOCTB ON TB001=#V_MOCTE.TA001 AND TB002=#V_MOCTE.TA002 AND TB003=#V_MOCTE.MB001
						WHERE   VALUE>0  AND OVERPICK=@CLFLAG AND MOCTB.TB009=@CK


						--插入MOCTE
						INSERT INTO MOCTE
						SELECT 'fanski',@USERNAME,@ZHU,SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','',1,@BLDB,@BLDH ,right(replicate('0',4)+ltrim(ROW_NUMBER() OVER (ORDER BY NEWID())),4) as 序号,
								#V_MOCTE.MB001,#V_MOCTE.VALUE,MB004,'',MB017,TB006,'********************',
								#V_MOCTE.TA001,#V_MOCTE.TA002,'','','','1',MB002,MB003,'N','',0,'','',0,'****',MB004,0,'','','',0,0,0,2,'N',
								'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0,'','',''
						FROM #V_MOCTE
						LEFT JOIN INVMB ON INVMB.MB001=#V_MOCTE.MB001
						LEFT JOIN MOCTB ON TB001=#V_MOCTE.TA001 AND TB002=#V_MOCTE.TA002 AND TB003=#V_MOCTE.MB001
						WHERE VALUE>0  AND  OVERPICK=@CLFLAG AND MOCTB.TB009=@CK

						INSERT INTO #V_GENERATEMOCTC VALUES(@BLDB,@BLDH)



			 --   --取出同仓库，同领料单别的品号
			 --   DECLARE C_D CURSOR FOR
				--    SELECT MB001,VALUE,TA001,TA002
				--    FROM #V_MOCTE
				--    LEFT JOIN INVMB ON INVMB.MB001=#V_MOCTE.MB001
				--	LEFT JOIN MOCTB ON TB001=TA001 AND TB002=TA002 AND TB003=#V_MOCTE.MB001
				--	WHERE VALUE>0 AND OVERPICK=@CLFLAG AND MOCTB.TB009=@CK

				--OPEN C_D
				--FETCH NEXT FROM C_D INTO  @EMB001,@EVALUE,@TA001,@TA002
				--WHILE @@FETCH_STATUS=0
				--BEGIN

				--	--插入MOCTD
				--	   --INSERT INTO MOCTD
				--	   --SELECT 'fanski',@USERNAME,'usr_group',SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','',1,'5420',@BLDH,@TA001,@TA002,'1',1,

				--	   SELECT TOP 1 * FROM MOCTD ORDER BY TD002 DESC

				--	--插入MOCTE

				--FETCH NEXT FROM C_D INTO  @EMB001,@EVALUE,@TA001,@TA002
				--END
				--CLOSE C_D   /* 关闭游标 */
				--DEALLOCATE C_D   /* 删除游标 */

		FETCH NEXT FROM C_C INTO @CLFLAG,@CK
		END
	CLOSE C_C   /* 关闭游标 */
    DEALLOCATE C_C   /* 删除游标 */



    SELECT  TC001+'--'+TC002 FROM #V_GENERATEMOCTC

	--COMMIT TRANSACTION







END
