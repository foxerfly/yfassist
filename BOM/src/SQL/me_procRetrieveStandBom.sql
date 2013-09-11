/****** Object:  StoredProcedure [dbo].[me_procRetrieveStandBom]    Script Date: 09/11/2013 22:36:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
--传入三参数，重置本阶品号的下阶品号，并导入标准BOM
-- =============================================
ALTER PROCEDURE [dbo].[me_procRetrieveStandBom]
	-- Add the parameters for the stored procedure here
	@PH CHAR(20),   --配置品号
	@PZH CHAR(15),  --配置编号
	@SJPH char(20),    --上阶品号
	@BJCJ char(60),    --本阶层级
	@BJPH CHAR(20)   --本阶品号
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
    CREATE TABLE #VIEW_A(SN Int IDENTITY(1,1),CJ CHAR(60),PH CHAR(20),FLAG CHAR(1))
    CREATE TABLE #VIEW_B(SN Int IDENTITY(1,1),CJ CHAR(60),PH CHAR(20) )
   
    
    --清除原配置方案中的内容，免去对比标准BOM步骤，以标准BOM直接插入,PS:最顶层品号在COPTR中有数据,TR004=TR009，所以加入限制TR009<>@BJPH
    DELETE  FROM COPTR WHERE TR001=@PH AND TR002=@PZH  AND TR003 like RTRIM(@BJCJ)+'%'  AND TR009<>@BJPH
    
    --清除原配置方案中的COPTV,除本阶层级外，且以本阶层级起始的数据删除
    DELETE  FROM COPTV WHERE TV001=@PH AND TV002=@PZH  AND  TV003 like RTRIM(@BJCJ)+'%'  AND TV003<>@BJCJ
    
    --将层级信息插入临时表
    INSERT INTO #VIEW_B(CJ,PH)
	SELECT  RTRIM(@BJCJ)+RIGHT(REPLICATE('000',1)+LTRIM((ROW_NUMBER() OVER  (ORDER BY MD002)-1)),3) ,MD003
	 FROM BOMMD 
	 LEFT JOIN BOMMC ON MC001=MD001
	 WHERE MD001=@BJPH
			 
	--将本阶品号的直接下层插入COPTR
	INSERT INTO COPTR
	SELECT  'fanski','09771','0501' ,CONVERT(CHAR(8),GETDATE(),112),'','',1,
	@PH,@PZH, RTRIM(@BJCJ)+RIGHT(REPLICATE('000',1)+LTRIM((ROW_NUMBER() OVER  (ORDER BY MD002)-1)),3) ,@BJPH,MC004,MC005,'','Y',
	MD003,MD006,MD007,MD008,MD009,MD018,MD011,MD012,MD013,0,'Y','N',MD017,'','','','','','',  0,0,  '','Y',   ''   ,MD024,'','',
	0,0,0,MD030,MD031,MD032,0,0,0,
	'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0,''
	 FROM BOMMD 
	 LEFT JOIN BOMMC ON MC001=MD001
	 WHERE MD001=@BJPH

	 --如果层级为 000  则插入一笔初始数据
	 IF NOT EXISTS(SELECT  * FROM COPTR WHERE TR001=@PH AND TR002=@PZH and TR003='000' ) AND @BJCJ='000' AND @PH=@BJPH
	 BEGIN
	  INSERT INTO COPTR
		SELECT  'fanski','09771','0501' ,CONVERT(CHAR(8),GETDATE(),112),'','',1,@PH,@PZH,'000',@BJPH,1,'','','Y',
		@BJPH,1,1,0,'',0,'','','',0,'','N','','','','','','','',0,0,'','Y','','Y','','',
		0,0,0,0,'N','0',0,0,0,
		'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0,''
	 END

	--将本阶品号的直接下层插入COPTV
	INSERT INTO COPTV		
	SELECT 'fanski','09771','0501' ,CONVERT(CHAR(8),GETDATE(),112),'','',1,
	@PH,@PZH,CJ,MQ003,MQ004,MQ005,MQ006,'','','',0,0,0,
	'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0
	FROM #VIEW_B 
	INNER  JOIN  BOMMQ  ON MQ001=@BJPH AND MQ007=PH
	 
	 DELETE FROM #VIEW_B
	 
	--将自制件，委外加，虚设件及对应层级加入临时表	
	INSERT INTO #VIEW_A(CJ,PH,FLAG)
	SELECT  RTRIM(@BJCJ)+RIGHT(REPLICATE('000',1)+LTRIM((ROW_NUMBER() OVER  (ORDER BY MD002)-1)),3) ,MD003,CASE WHEN MB025 IN('Y','S','M') THEN 'N'	     ELSE 'Y' END
	 FROM BOMMD 
	 LEFT JOIN BOMMC ON MC001=MD001
	 LEFT JOIN INVMB ON MB001=MD003
	 WHERE MD001=@BJPH
	 

	DECLARE 
		@SN Int ,
		@A_CJ CHAR(60),  --本阶层级
		@A_PH CHAR(20)   --本阶品号
		
	DECLARE C_A CURSOR FOR SELECT SN,CJ,PH FROM #VIEW_A WHERE FLAG='N' FOR UPDATE
	OPEN C_A
	FETCH NEXT FROM C_A INTO @SN,@A_CJ ,@A_PH
	  
	WHILE @@FETCH_STATUS =0
	BEGIN
	
		--将各层级号插入临时表
		INSERT INTO #VIEW_B(CJ,PH)
		SELECT RTRIM(@A_CJ)+RIGHT(REPLICATE('000',1)+LTRIM((ROW_NUMBER() OVER  (ORDER BY MD002)-1)),3) ,MD003
			 FROM BOMMD 
			 LEFT JOIN BOMMC ON MC001=MD001
			 WHERE MD001=@A_PH
		
		--将本阶品号的直接下层插入COPTR
		INSERT INTO COPTR
			SELECT  'fanski','09771','0501' ,CONVERT(CHAR(8),GETDATE(),112),'','',1,
			@PH,@PZH, RTRIM(@A_CJ)+RIGHT(REPLICATE('000',1)+LTRIM((ROW_NUMBER() OVER  (ORDER BY MD002)-1)),3) ,@A_PH,MC004,MC005,'','Y',
			MD003,MD006,MD007,MD008,MD009,MD018,MD011,MD012,MD013,0,'Y','N',MD017,'','','','','','',  0,0,  '','Y',   ''   ,MD024,'','',
			0,0,0,MD030,MD031,MD032,0,0,0,
			'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0,''
			 FROM BOMMD 
			 LEFT JOIN BOMMC ON MC001=MD001
			 WHERE MD001=@A_PH
			 
		--将本阶品号的直接下层插入COPTV
		INSERT INTO COPTV		
		SELECT 'fanski','09771','0501' ,CONVERT(CHAR(8),GETDATE(),112),'','',1,
		@PH,@PZH,CJ,MQ003,MQ004,MQ005,MQ006,'','','',0,0,0,
		'','','','','','',0,0,0,0,0,0,'','','','','','',0,0,0,0,0,0
		FROM #VIEW_B 
		INNER  JOIN  BOMMQ  ON MQ001=@A_PH AND MQ007=PH
		
		
		
		DELETE FROM #VIEW_B
			
		--插入后更新FLAG 为Y，	 
		UPDATE #VIEW_A
		SET FLAG='Y'
		WHERE SN=@SN AND CJ=@A_CJ  AND PH=@A_PH
		

		INSERT INTO #VIEW_A(CJ,PH,FLAG)
		SELECT  RTRIM(@A_CJ)+RIGHT(REPLICATE('000',1)+LTRIM((ROW_NUMBER() OVER  (ORDER BY MD002)-1)),3) ,MD003,CASE WHEN MB025 IN('Y','S','M')                  THEN 'N' ELSE 'Y' END
		FROM BOMMD 
		LEFT JOIN BOMMC ON MC001=MD001
		LEFT JOIN INVMB ON MB001=MD003
		WHERE MD001=@A_PH
			
	FETCH NEXT FROM C_A INTO @SN,@A_CJ ,@A_PH
	END
	CLOSE C_A   
	DEALLOCATE C_A   
    

 

END
