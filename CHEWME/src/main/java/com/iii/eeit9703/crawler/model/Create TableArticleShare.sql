--建立分享文表格

use CMDB;
go

drop table ArticleShare

create table ArticleShare(
articleID            int  IDENTITY (1,1) not null,
memberID       int,
contents          varchar(MAX),

constraint ArticleShare_primary_key primary key (articleID));
