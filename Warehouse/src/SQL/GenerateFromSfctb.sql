
create table GenerateFromSfctb(
GGUID uniqueidentifier NOT NULL,
DB CHAR(4),
DH CHAR(11)
)


create table GenerateFromSfctbVBA(
GGUID int NOT NULL,
DB CHAR(4),
DH CHAR(11)
)



create PROCEDURE [dbo].[procGenerateFromSfctb]
	-- Add the parameters for the stored procedure here
	@GGUID uniqueidentifier
AS



GO
/****** Object:  StoredProcedure [dbo].[procGenerateFromSfctb]    Script Date: 08/20/2013 14:44:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
create PROCEDURE [dbo].[procGenerateFromSfctbVBA]
	-- Add the parameters for the stored procedure here
	@GGUID int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
    --根据投产单列表插入临时数据  投产单表：GenerateFromSfctb
    CREATE TABLE #VIEW_A(
		MB001 CHAR(20),
		VALUE NUMERIC(16,4),
		TB006 CHAR(4),
		TB009 CHAR(10),
		GDB CHAR(4),
		GDH CHAR(11),
		TCDB CHAR(4),
		TCDH CHAR(11),
		TCXH CHAR(4),
		GZZX CHAR(10),
		TA073 char(15)
		
    )
    
    CREATE TABLE #VIEW_B(
		DB CHAR(4),
		DH CHAR(11)
    )
    
    DECLARE 
		@TCDB CHAR(4),
		@TCDH CHAR(11)

	--按仓库及工作中心分类，依次生产领料单
	DECLARE
				@TB006 CHAR(4),
				@TB009 CHAR(10),
				@CENTER CHAR(10), --工作中心
				@LLDB CHAR(4),   --领料单别
				@LLDH CHAR(11),   --领料单号
				@CCC CHAR(10),
				@BM CHAR(6)
    
    SET @LLDB='5420'
	SET @CCC='noone'
			
    DECLARE C_A CURSOR FOR 
	SELECT DB,DH FROM GenerateFromSfctbVBA WHERE GGUID=@GGUID
	
	OPEN C_A 
	FETCH NEXT FROM C_A INTO @TCDB,@TCDH
	
	WHILE @@FETCH_STATUS=0
		BEGIN
			
		INSERT INTO #VIEW_A
		SELECT TB003,CEILING(ROUND(TC014*(TB027/TA015),2)) SL,TB006,TB009,TC004,TC005,TC001,TC002,TC003,CASE WHEN TB006='****' THEN  TA021 ELSE MW005 END GZZX,TA073
		FROM SFCTC
		LEFT JOIN MOCTA ON TA001=TC004 AND TA002=TC005
		LEFT JOIN MOCTB ON TB001=TC004 AND TB002=TC005
		LEFT JOIN CMSMW ON MW001=TB006
		WHERE TC001=@TCDB AND TC002=@TCDH
		

			DECLARE  C_B CURSOR FOR
			SELECT distinct TB006,TB009,CASE WHEN TB006='****' THEN  TA021 ELSE MW005 END GZZX
			FROM SFCTC
			LEFT JOIN MOCTA ON TA001=TC004 AND TA002=TC005
			LEFT JOIN MOCTB ON TB001=TC004 AND TB002=TC005
			LEFT JOIN CMSMW ON MW001=TB006
			WHERE TC001=@TCDB AND TC002=@TCDH
			
			OPEN C_B
			FETCH NEXT FROM C_B INTO @TB006,@TB009,@CENTER
			
			WHILE @@FETCH_STATUS=0
				BEGIN
				
						--获取单号
						SELECT @CCC=ISNULL(MAX(TC002),'noone') FROM MOCTC WHERE SUBSTRING(TC002,1,6)=SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),3,8) AND TC001=@LLDB
						IF @CCC='noone'
						BEGIN
						SELECT @LLDH=SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),3,8)+'001'
						END
						IF @CCC<>'noone'
						BEGIN
						SELECT @LLDH= MAX(TC002)+1 FROM MOCTC WHERE SUBSTRING(TC002,1,6)=SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),3,8) AND TC001=@LLDB
						END
						
						
						SELECT @BM=MD015 FROM CMSMD WHERE MD001=@CENTER
						
						--插入MOCTC
						INSERT INTO MOCTC
						SELECT 'fanski','11080','1003',SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','',1,
							   @LLDB,@LLDH,SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'1000',@CENTER,'','','54',
							   'N',0,'N','1','N',SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','N',0,'0',@TCDB,@TCDH,@BM,'','','',0,0,0,'',0,0,'',
							   '','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0
					

						--插入MOCTD  当补料的多个品号同属一张工单时，只需插入一次MOCTD,多次插入会提示KEY值重复错误
						--插入MOCTD
						--IF NOT EXISTS (SELECT TD001 
						--			   FROM MOCTD 
						--			   RIGHT JOIN(SELECT VIEW_A.GDB,VIEW_A.GDH 
						--						  FROM VIEW_A
						--						  LEFT JOIN MOCTB ON TB001=VIEW_A.GDB AND TB002=VIEW_A.GDH AND TB003=#V_MOCTE.MB001
						--						  WHERE   VALUE>0  AND OVERPICK=@CLFLAG AND MOCTB.TB009=@CK) AS A ON TD003=A.TA001 AND TD004=A.TA002
						--						  WHERE  TD001=@BLDB AND TD002=@BLDH )
						--BEGIN
						    INSERT INTO MOCTD
							SELECT  DISTINCT 'fanski','11080','1003',SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','',1,
							@LLDB,@LLDH,#VIEW_A.GDB,#VIEW_A.GDH,'1',1,
							MB017,'1','','','','','N','','1','','1','','N','','','',0,0,0,'2','',
							'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0
							FROM #VIEW_A
							LEFT JOIN INVMB ON INVMB.MB001=#VIEW_A.MB001
							WHERE TB009=@TB009 AND GZZX=@CENTER AND TB006=@TB006
						--END

						 --   SELECT @BLDB,@BLDH,#V_MOCTE.TA001,#V_MOCTE.TA002,@CK
							--FROM #V_MOCTE
							--LEFT JOIN INVMB ON INVMB.MB001=#V_MOCTE.MB001
							--LEFT JOIN MOCTB ON TB001=#V_MOCTE.TA001 AND TB002=#V_MOCTE.TA002 AND TB003=#V_MOCTE.MB001
							--WHERE   VALUE>0  AND OVERPICK=@CLFLAG AND MOCTB.TB009=@CK


						--插入MOCTE
						INSERT INTO MOCTE
						SELECT 'fanski','11080','1003',SUBSTRING(CONVERT(VARCHAR(8),GETDATE(),112),1,8),'','',1,@LLDB,@LLDH ,
						right(replicate('0',4)+ltrim(ROW_NUMBER() OVER (ORDER BY NEWID())),4) as rowid,
								#VIEW_A.MB001,#VIEW_A.VALUE,MB004,'',TB009,TB006,'********************',
								#VIEW_A.GDB,#VIEW_A.GDH,'','','','1',MB002,MB003,'N','',0,'','',0,'****',MB004,#VIEW_A.VALUE,'','','',0,0,0,2,'N',
								'','','','','','',0,0,0,0,0,0,'','','','','','BLGJ',0,0,0,0,0,0,'','',''
						FROM #VIEW_A
						LEFT JOIN INVMB ON INVMB.MB001=#VIEW_A.MB001
						WHERE TB009=@TB009 AND GZZX=@CENTER AND TB006=@TB006
				
				
				INSERT INTO #VIEW_B VALUES(@LLDB,@LLDH)
			
				SET @LLDB='5420'
				SET @CCC='noone'
				FETCH NEXT FROM C_B INTO @TB006,@TB009,@CENTER
				END 
			CLOSE C_B   /* 关闭游标 */
			DEALLOCATE C_B   /* 删除游标 */

		FETCH NEXT FROM C_A INTO @TCDB,@TCDH
		END
	CLOSE C_A   /* 关闭游标 */
	DEALLOCATE C_A   /* 删除游标 */
	
	SELECT * FROM #VIEW_B
	 
END
