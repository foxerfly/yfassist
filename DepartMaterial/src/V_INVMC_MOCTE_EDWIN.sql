USE [mytest]
GO

/****** Object:  View [dbo].[V_INVMC_MOCTE]    Script Date: 06/24/2013 13:19:58 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO





create VIEW [dbo].[V_INVMC_MOCTE_EDWIN]
AS

SELECT *
FROM(
SELECT MC001 AS PH,MC002 AS CK,ISNULL((ISNULL(MC007,0)-ISNULL(TAB1.TE005_SUM,0)),0) AS KYKC FROM INVMC
LEFT JOIN
(SELECT TE004,TE008,SUM(ISNULL(TE005,0)) AS TE005_SUM FROM MOCTE WHERE TE019='N' GROUP BY TE004,TE008) TAB1
ON MC001=TAB1.TE004 AND MC002=TAB1.TE008
WHERE MC002 IN('31','30','29','21','20','12','11','10','01','01A','01')) AS A
WHERE A.KYKC>0

--SELECT MC001 AS PH,ISNULL((ISNULL(SUM(MC007),0)-TAB1.TE005_SUM),0) AS KYKC FROM INVMC
--LEFT JOIN
--(SELECT TE004,SUM(ISNULL(TE005,0)) AS TE005_SUM FROM MOCTE WHERE TE019='N' GROUP BY TE004) TAB1
--ON MC001=TAB1.TE004
--GROUP BY MC001,TAB1.TE005_SUM





GO



