
-- ================================================
-- Template generated from Template Explorer using:
-- Create Scalar Function (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the function.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date, ,>
-- Description:	<Description, ,>
-- =============================================
ALTER FUNCTION [dbo].[fn_me_GetMoctbCapable]
(
	-- Add the parameters for the function here
	
	@TB001 CHAR(4),
	@TB002 CHAR(11),
	@TB003 CHAR(20)
)
RETURNS NUMERIC(16,4)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @TB004 NUMERIC(16,4),
			@TB005 NUMERIC(16,4),
			@TB027 NUMERIC(16,4),
			@ORIGINALKLY NUMERIC(16,4),--工单需领量-最少需领量
			@TE005 NUMERIC(16,4) , --未审领料单
			@TZ005 NUMERIC(16,4) , --所以补料及超领数量
			@TTE NUMERIC(16,4)  --返回值
	
	SET @TB004=0
	SET @TB005=0
	SET @TB027=0
	SET @ORIGINALKLY=0
	SET @TE005=0
	SET @TZ005=0
	SET @TTE=0
			
	
	SELECT @TB004=TB004,@TB005=TB005,@TB027=TB027,@ORIGINALKLY=TB004-TB027 FROM MOCTB WHERE TB001=@TB001 AND TB002=@TB002 AND TB003=@TB003
	
	SELECT @TE005=ISNULL(SUM(TE005),0) FROM MOCTE  LEFT JOIN MOCTC ON TC001=TE001 AND TC002=TE002 WHERE TC009='N' AND TE011=@TB001 AND TE012=@TB002 AND TE004=@TB003 
	
	SELECT @TZ005=SUM(TE005) FROM MOCTE WHERE TE001 IN('5430','5450') AND TE011=@TB001 AND TE012=@TB002 AND TE004=@TB003
	
	IF @TB005-@TB027>=0
	BEGIN
		SET @TTE=@TB004-@TB005-@TE005
	END
	ELSE IF @TB005-@TB027<0 AND @ORIGINALKLY-@TZ005<=0
	BEGIN
	 SET @TTE=0
	END
	ELSE IF @TB005-@TB027<0 AND @ORIGINALKLY-@TZ005>0
	BEGIN
		SET @TTE=@ORIGINALKLY-@TZ005
	END
	
	RETURN @TTE

END
GO

