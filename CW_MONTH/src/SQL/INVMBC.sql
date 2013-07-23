
USE [fanski]
GO

/****** Object:  Table [dbo].[INVMBC]    Script Date: 2013/7/23 20:03:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[INVMBC](
	[GUID] [uniqueidentifier] NOT NULL,
	[MB001] [char](40) NOT NULL,
	[MB002] [char](60) NULL,
	[MB003] [char](60) NULL,
	[MB110] [char](60) NULL,
	[MB004] [char](10) NULL,
	[MB025] [char](10) NULL,
	[materialPrice] [numeric](16, 4) NULL,
	[laborePrice] [numeric](16, 4) NULL,
	[madePrice] [numeric](16, 4) NULL,
	[cooperationPrice] [numeric](16, 4) NULL,
	[DH] [char](20) NULL,
	[ORDERNO] [char](20) NULL,
	[UDF01] [varchar](255) NULL,
	[UDF02] [varchar](255) NULL,
	[UDF03] [varchar](255) NULL,
	[UDF04] [varchar](255) NULL,
	[UDF05] [varchar](255) NULL,
	[UDF06] [varchar](255) NULL,
	[UDF07] [numeric](16, 4) NULL,
	[UDF08] [numeric](16, 4) NULL,
	[UDF09] [numeric](16, 4) NULL,
	[UDF010] [numeric](16, 4) NULL,
	[UDF011] [numeric](16, 4) NULL,
	[UDF012] [numeric](16, 4) NULL,
 CONSTRAINT [PK_INVMBC] PRIMARY KEY CLUSTERED 
(
	[GUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[INVMBC] ADD  DEFAULT (newid()) FOR [GUID]
GO

ALTER TABLE [dbo].[INVMBC] ADD  DEFAULT ((0)) FOR [materialPrice]
GO

ALTER TABLE [dbo].[INVMBC] ADD  DEFAULT ((0)) FOR [laborePrice]
GO

ALTER TABLE [dbo].[INVMBC] ADD  DEFAULT ((0)) FOR [madePrice]
GO

ALTER TABLE [dbo].[INVMBC] ADD  DEFAULT ((0)) FOR [cooperationPrice]
GO


