
-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
alter PROCEDURE me_procGeneratorMocte
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
    

    --创建临时表，存放生成的信息
    CREATE TABLE #V_MOCTE(
    OVERPICK CHAR(1),
    VMB001 CHAR(20),
    VVALUE decimal(20,4),
    STORE CHAR(10),
    VTA001 CHAR(4),
    VTA002 CHAR(11)
    )
    

    
 
    
    

    
    
    
    
	
END
GO
