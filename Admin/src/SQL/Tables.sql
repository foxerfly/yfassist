
CREATE TABLE AuthorizeDetail
    (

     AuthorizeID CHAR (30) NOT NULL ,
     AuthorizeName CHAR (60) ,
     RelatedModule CHAR (60) ,
     Describe VARCHAR (255) ,
     CONSTRAINT AuthorizeDetail_PK PRIMARY KEY CLUSTERED ( AuthorizeID)
     WITH (
     ALLOW_PAGE_LOCKS = ON ,
     ALLOW_ROW_LOCKS = ON )
     ON "default"
    )
    ON "default"
GO





CREATE TABLE UserAccount
    (

     UserId CHAR (10) NOT NULL ,
     UserName CHAR (10) ,
     PassWord CHAR (10)  ,
     UserGroup CHAR (10)  ,
     Depart CHAR (10) ,
     CONSTRAINT UserAccount_PK PRIMARY KEY CLUSTERED ( UserId)
     WITH (
     ALLOW_PAGE_LOCKS = ON ,
     ALLOW_ROW_LOCKS = ON )
     ON "default"
    )
    ON "default"
GO





CREATE TABLE UserAuthorize
    (

     UserId CHAR (10) NOT NULL ,
     AuthorizeID CHAR (30) NOT NULL ,
     C CHAR (1) ,
     R CHAR (1) ,
     U CHAR (1) ,
     D CHAR (1) ,
     S CHAR (1) ,
     CS CHAR (1) ,
     CONSTRAINT UserAuthorize_PK PRIMARY KEY CLUSTERED (UserId)
     WITH (
     ALLOW_PAGE_LOCKS = ON ,
     ALLOW_ROW_LOCKS = ON )
     ON "default"
    )
    ON "default"
GO 