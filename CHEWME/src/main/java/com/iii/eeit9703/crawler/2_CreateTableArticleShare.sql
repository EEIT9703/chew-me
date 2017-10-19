--建立分享文表格

use CMDB;
go
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'article_share')      
BEGIN
drop table article_share
END
go



create table article_share(
articleID            int  IDENTITY (1,1) not null,
memberID       int,
contents          varchar(MAX),

constraint article_share_primary_key primary key (articleID));



select * from article_share
