
USE [fanski]
GO

/****** Object:  StoredProcedure [dbo].[me_COST_cal]    Script Date: 2013/7/23 20:04:44 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[me_COST_cal] (@ITEMNO VARCHAR(80))
AS  
BEGIN
Set nocount on
    --BOM展阶
 --@ITEMNO：查询品号
 --返回:元件品号V1001，主件品号V1002，阶码V1004，阶层次V1005，尾阶标志V1006，展开标志V1007，组成用量V1011，底数V1012，损耗率%V1013,VZ 累计组成用量
 DECLARE @ITEM_CHILD VARCHAR(80), @ITEM_EXPAND VARCHAR(80), @ITEM_LEVELNO INT, @COUNT INT
 DECLARE @BATCH_NUMBER NUMERIC(18,4)
 CREATE TABLE  #VIEW1 (V1001 VARCHAR(80), V1002 VARCHAR(80), V1004 VARCHAR(80) DEFAULT '', V1005 INT DEFAULT 0, V1006 CHAR(1) DEFAULT '0', V1007 CHAR(1) DEFAULT '0'
 , V1011 NUMERIC(18,4) DEFAULT 0, V1012 NUMERIC(18,4) DEFAULT 0, V1013 NUMERIC(18,4) DEFAULT 0,VZ  NUMERIC(18,4) DEFAULT 0) 
 
 CREATE TABLE #VIEW2(LV INT DEFAULT 0,MD001 VARCHAR(80),MD003 VARCHAR(80),MB025 CHAR(1),MD006 NUMERIC(18,4) DEFAULT 0, MD007 NUMERIC(18,4) DEFAULT 0,VZ NUMERIC(18,4) DEFAULT 0)
 --CREATE TABLE #CostTemp()

--delete from me_BOM_view


 DECLARE @FMB025 CHAR(1)

 SELECT @ITEM_LEVELNO = 1

 INSERT INTO #VIEW1 (V1001, V1002, V1004, V1005, V1011, V1012, V1013,VZ)
 SELECT MD003, @ITEMNO, MD002, 1, ROUND(MD006,4) , ROUND(MD007,4),MD008,ROUND((MD006/MD007)/MC004,4) FROM BOMMC, BOMMD WHERE BOMMC.MC001 = BOMMD.MD001 AND MC001 = @ITEMNO

 DECLARE BOMEXPAND CURSOR FOR SELECT V1001, V1004, V1005, VZ FROM #VIEW1 WHERE V1007 = '0' FOR UPDATE
    OPEN BOMEXPAND  /* 打开游标 */
 FETCH NEXT FROM BOMEXPAND INTO @ITEM_CHILD, @ITEM_EXPAND, @ITEM_LEVELNO, @BATCH_NUMBER
 WHILE @@FETCH_STATUS = 0   /* 用WHILE循环控制游标活动*/
 BEGIN
  --SELECT @ITEM_LEVELNO, @ITEM_CHILD
  UPDATE #VIEW1 SET V1007 = '1' WHERE CURRENT OF BOMEXPAND
  SELECT @COUNT = COUNT(*) FROM BOMMC, BOMMD WHERE BOMMC.MC001 = BOMMD.MD001 AND MC001 = @ITEM_CHILD
  IF @COUNT = 0
   UPDATE #VIEW1 SET V1006 = '1' WHERE CURRENT OF BOMEXPAND
  ELSE
   BEGIN
    INSERT INTO #VIEW1 (V1001, V1002, V1004, V1005, V1011, V1012, V1013,VZ)
    SELECT MD003, @ITEM_CHILD, @ITEM_EXPAND + '.' + MD002, @ITEM_LEVELNO + 1,  ROUND(MD006,4) , round(MD007,4),  MD008 ,round((MD006 * @BATCH_NUMBER)/MD007/MC004,4)FROM BOMMC, BOMMD WHERE BOMMC.MC001 = BOMMD.MD001 AND MC001 = @ITEM_CHILD
   END
  FETCH NEXT FROM BOMEXPAND INTO @ITEM_CHILD, @ITEM_EXPAND, @ITEM_LEVELNO, @BATCH_NUMBER /* 在循环体内将读取其余行数据 */
 END
 CLOSE BOMEXPAND   /* 关闭游标 */
 DEALLOCATE BOMEXPAND   /* 删除游标 */
   
  --insert into me_BOM_view
  INSERT INTO #VIEW2
  SELECT  cast(V1005  as varchar)  as LV,V1002 as MD001,V1001 as MD003,MB025 ,
         V1011 as MD006,V1012 as MD007 ,VZ
         FROM #VIEW1 
         INNER JOIN  INVMB ON V1001=MB001
         left join BOMMD ON MD001=V1002 AND MD003=V1001
 ORDER BY V1005 ASC
 
 --select * from #VIEW2
 
 --INSERT INTO #VIEW2      --将A码插入表中
 --SELECT 0,RTRIM(@ITEMNO),'',MB025,1,1
 --FROM INVMB
 --WHERE MB001=@ITEMNO
 
 DELETE FROM INVMBD   --清除表中数据
 
 INSERT INTO INVMBD   --插入BOM
 SELECT MD003,0,0,0,0,0,MD006,MD007,VZ
 FROM #VIEW2
 
 --SELECT * FROM #VIEW2
 DECLARE @LV INT ,@MD001 VARCHAR(80),@MD003 VARCHAR(80),@MB025 CHAR(1),@MD006 NUMERIC(18,4) ,@MD007 NUMERIC(18,4) ,@Flag INT,
		 @materialPrice numeric(18,4),@laborePrice numeric(18,4),@madePrice numeric(18,4),@cooperationPrice numeric(18,4),@sumPrice  numeric(18,4),@VZ  NUMERIC(18,4) 
				
-- CREATE TABLE #CostTemp(MB001 CHAR(20),materialPrice numeric(18,4),laborePrice numeric(18,4),madePrice numeric(18,4),cooperationPrice numeric(18,4),sumPrice  numeric(18,4))
 
 DECLARE CostFlag CURSOR FOR SELECT DISTINCT LV FROM #VIEW2 ORDER BY LV DESC  --为了获得阶层顺序
 OPEN CostFlag
 FETCH NEXT FROM CostFlag INTO @Flag
 WHILE @@FETCH_STATUS=0
  BEGIN
		 DECLARE CostExpand CURSOR FOR SELECT LV,MD001,MD003,MB025,MD006,MD007,VZ FROM #VIEW2 WHERE LV=@Flag
		 OPEN CostExpand	 
		 FETCH NEXT FROM CostExpand INTO @LV,@MD001,@MD003,@MB025,@MD006,@MD007,@VZ
		 WHILE @@FETCH_STATUS=0
			BEGIN
			SET @materialPrice=0
			SET @laborePrice=0
			SET @madePrice=0
			SET @cooperationPrice=0
			SET @sumPrice=0
			     IF @MB025='P'
				    BEGIN
					  SELECT @materialPrice=ISNULL(materialPrice,0),@laborePrice=isnull(laborePrice,0),@madePrice=isnull(madePrice,0),@cooperationPrice=isnull(cooperationPrice,0),@sumPrice=ROUND(ISNULL((@VZ)*ISNULL(materialPrice,0),0),4)
					  FROM INVMBC 
					  WHERE MB001=@MD003

					   SELECT @sumPrice=ROUND(ISNULL((@VZ)*( @materialPrice+@madePrice+@laborePrice+@cooperationPrice),0),4)

				    END
			  IF @MB025<>'P'
					BEGIN
					  SELECT @materialPrice=SUM(ISNULL(sumPrice,0))
					  FROM INVMBD
					  WHERE RTRIM(MB001)+RTRIM(@MD003) IN(SELECT RTRIM(MD003)+RTRIM(MD001) FROM #VIEW2 where RTRIM(MD001)=@MD003)				
					  SELECT @laborePrice=ISNULL(laborePrice,0),@madePrice=round(ISNULL(laborePrice*0.4,0),4),@cooperationPrice=ISNULL(cooperationPrice,0)
					  FROM INVMBC 
					  WHERE MB001=@MD003
					  SELECT @sumPrice=ROUND(ISNULL((@VZ)*( @materialPrice+@madePrice+@laborePrice+@cooperationPrice),0),4)
					END
				
			  UPDATE INVMBD
			  SET materialPrice=ISNULL(@materialPrice,0),laborePrice=ISNULL(@laborePrice,0),madePrice=ISNULL(@madePrice,0),cooperationPrice=ISNULL(cooperationPrice,0),sumPrice=ISNULL(@sumPrice,0)
			  WHERE MB001=@MD003
			
              FETCH NEXT FROM CostExpand INTO @LV,@MD001,@MD003,@MB025,@MD006,@MD007,@VZ	 
			END
		 CLOSE CostExpand
		 DEALLOCATE CostExpand
		 
      FETCH NEXT FROM CostFlag INTO @Flag
  END
  CLOSE CostFlag
  DEALLOCATE CostFlag



			SET @materialPrice=0
			SET @laborePrice=0
			SET @madePrice=0
			SET @cooperationPrice=0
			SET @sumPrice=0

  
 --若输入品号为采购件，把采购件插入

 	  INSERT INTO INVMBD      --将查询码插入表中
	 SELECT RTRIM(@ITEMNO),0,0,0,0,0,1,1,1


  SELECT @FMB025=MB025 FROM INVMB  WHERE MB001=@ITEMNO
 IF @FMB025='P'
  BEGIN

  --   INSERT INTO INVMBD      --将A码插入表中
	 --SELECT RTRIM(@ITEMNO),0,0,0,0,0,1,1,1

	SELECT @materialPrice=ISNULL(materialPrice,0),@laborePrice=isnull(laborePrice,0),@madePrice=round(ISNULL(laborePrice*0.4,0),4),@cooperationPrice=isnull(cooperationPrice,0),@sumPrice=ROUND(ISNULL((@VZ)*ISNULL(materialPrice,0),0),4)
					  FROM INVMBC 
					  WHERE MB001=@ITEMNO

					   SELECT @sumPrice=ROUND(ISNULL((@VZ)*( @materialPrice+@madePrice+@laborePrice+@cooperationPrice),0),4)
 
	 UPDATE INVMBD
	 SET materialPrice=ISNULL(@materialPrice,0),laborePrice=ISNULL(@laborePrice,0),madePrice=ISNULL(@madePrice,0),cooperationPrice=ISNULL(@cooperationPrice,0),sumPrice=ISNULL(@sumPrice,0)
	 WHERE MB001=RTRIM(@ITEMNO)


  END


   IF @FMB025<>'P'
  BEGIN


	SELECT @materialPrice=SUM(ISNULL(sumPrice,0))
	FROM INVMBD
	WHERE RTRIM(MB001)+RTRIM(@ITEMNO) IN(SELECT RTRIM(MD003)+RTRIM(@ITEMNO) FROM #VIEW2 where RTRIM(MD001)=@ITEMNO)		
					  
	 SELECT @laborePrice=ISNULL(laborePrice,0),@madePrice=ROUND(ISNULL(laborePrice*0.4,0),4),@cooperationPrice=ISNULL(cooperationPrice,0)
	 FROM INVMBC 
	 WHERE MB001=RTRIM(@ITEMNO)
 
	 SELECT @sumPrice= ROUND(ISNULL(@materialPrice+@laborePrice+@madePrice+@cooperationPrice,0),4)
 
	 UPDATE INVMBD
	 SET materialPrice=ISNULL(@materialPrice,0),laborePrice=ISNULL(@laborePrice,0),madePrice=ISNULL(@madePrice,0),cooperationPrice=ISNULL(@cooperationPrice,0),sumPrice=ISNULL(@sumPrice,0)
	 WHERE MB001=RTRIM(@ITEMNO)

  END
 


  
 SELECT * FROM INVMBD
 --SELECT * FROM #VIEW2

END 


GO


