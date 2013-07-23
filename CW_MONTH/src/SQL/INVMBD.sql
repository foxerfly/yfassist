
USE [fanski]
GO

/****** Object:  Table [dbo].[INVMBD]    Script Date: 2013/7/23 20:03:56 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[INVMBD](
	[MB001] [char](20) NULL,
	[materialPrice] [numeric](18, 4) NULL,
	[laborePrice] [numeric](18, 4) NULL,
	[madePrice] [numeric](18, 4) NULL,
	[cooperationPrice] [numeric](18, 4) NULL,
	[sumPrice] [numeric](18, 4) NULL,
	[MD006] [numeric](18, 4) NULL,
	[MD007] [numeric](18, 4) NULL,
	[VZ] [numeric](18, 4) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


