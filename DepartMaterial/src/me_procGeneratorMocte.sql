USE [fanski]
GO
/****** Object:  StoredProcedure [dbo].[me_procGeneratorMocte]    Script Date: 06/24/2013 08:34:05 ******/
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
    @DEPARTMENT CHAR(10)
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
   --BEGIN TRANSACTION

    --创建临时表，存放生成的信息
    CREATE TABLE #V_MOCTE(
    OVERPICK CHAR(1),
    MB001 CHAR(20),
    VALUE decimal(20,4),
    TA001 CHAR(4),
    TA002 CHAR(11))


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
			SELECT @KYKC=KYKC FROM V_INVMC_MOCTE WHERE PH=@PH

			--将该品号可领工单别，工单号，工单可领量插入临时表
			INSERT INTO #TEMPMOCTB
			SELECT TB001,TB002, (TB004-TB005)-ISNULL(TE005,0),TA009
			FROM  MOCTB
			LEFT JOIN MOCTA ON TB001=TA001 AND TB002=TA002
			LEFT JOIN(SELECT ISNULL(SUM(TE005),0) TE005 ,TE004,TE011,TE012 FROM MOCTE  LEFT JOIN MOCTC ON TC001=TE001 AND TC002=TE002 WHERE TC009='N' GROUP BY TE011,TE012,TE004) AS A  ON TE011=MOCTA.TA001 AND TE012=TA002 AND TE004=TB003
			WHERE TA013='Y' AND TA011<>'Y' AND TA011<>'y' AND TA011<>'1' AND MOCTA.TA001+MOCTA.TA002 IN(SELECT TC004+TC005 FROM SFCTC WHERE TC004=MOCTA.TA001 AND TC005=MOCTA.TA002)
			AND TB003=@PH  --AND (TB004-TB005)-ISNULL(TE005,0) >0
			ORDER BY TA009

		    --工单总可补量
			select @ZKBL=ISNULL(SUM(GDKBL),0) from #TEMPMOCTB WHERE GDKBL>=0


			--库存总可补量
			select @KCZKBL=ISNULL(KYKC,0) from V_INVMC_MOCTE_EDWIN where PH=@PH


			--如果库存可补数量大于等于申补数量,且工单可补量大于等于申补量
			IF  @KCZKBL-@VALUE>=0 AND @ZKBL-@VALUE >=0
			BEGIN
				SET @BLSL=@VALUE
				SET @CLSL=0
			END

			--如果库存可补数量大于等于申补数量,且工单可补量小于申补量
			IF  @KCZKBL-@VALUE>=0 AND @ZKBL-@VALUE<0
			BEGIN
				SET @BLSL=@ZKBL
				SET @CLSL=@VALUE-@ZKBL
			END

			--如果库存可补数量小于申补数量,且工单可补量大于等于申补量
			IF  @KCZKBL-@VALUE<0 AND @ZKBL-@VALUE>=0
			BEGIN
				SET @BLSL=@KCZKBL
				SET @CLSL=0
			END


			--如果库存可补数量小于申补数量,且工单可补量小于申补量
			IF  @KCZKBL-@VALUE<0 AND @ZKBL-@VALUE <0
			BEGIN

				--如果工单总可补量大于0，且库存可补量大于等于工单总可补量
				IF @ZKBL>0 AND @KCZKBL-@ZKBL>=0
				BEGIN
					SET @BLSL=@ZKBL
					SET @CLSL=@KCZKBL-@ZKBL
				END


				--如果工单总可补量大于0，且库存可补量小于工单总可补量
				IF @ZKBL>0 AND @KCZKBL-@ZKBL<0
				BEGIN
					SET @BLSL=@KCZKBL
					SET @CLSL=0
				END

				--如果工单总可补量小于等于0，且库存可补量大于等于工单总可补量
				IF @ZKBL<=0 AND @KCZKBL-@ZKBL>=0
				BEGIN
					SET @BLSL=0
					SET @CLSL=@KCZKBL
				END

				--如果工单总可补量小于等于0，且库存可补量小于工单总可补量
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
					IF @BLSL-@GDKBL>=0
						BEGIN
						 INSERT INTO #V_MOCTE VALUES('N',@PH,@GDKBL,@TA001,@TA002)
						 SET @BLSL=@BLSL-@GDKBL
						END
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


    SELECT   TA001+'--'+TA002 FROM #V_MOCTE WHERE VALUE>0



    --插入MOCTC

    --插入MOCTD

    --插入MOCTE

	--COMMIT TRANSACTION







END
