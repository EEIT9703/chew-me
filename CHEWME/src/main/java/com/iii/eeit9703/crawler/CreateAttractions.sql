--建立景點表格

use CMDB;
go

drop table Attractions

create table Attractions(
attractionID      int IDENTITY (1,1) not null,
name                   varchar(20),
county                varchar(20),
type                     varchar(20),
address              varchar(50),
tel                         varchar(20),
intro                    varchar(MAX),
image                 varbinary(MAX),

constraint Attractions_primary_key primary key (attractionID));

insert into Attractions values ('九份老街','新北市','景點','新北市瑞芳區汽車路89號','02-2406-3270','九份是臺灣新北市瑞芳區的一個地區，早期因為盛產金礦而興盛，礦坑挖掘殆盡後一度沒落。1990年代後，因電影《悲情城市》於九份取景，九份的獨特舊式建築、坡地及風情透過此片吸引國內外的注目，也為此地區重新帶來生機，目前已經成為一個很受歡迎的觀光景點。',null)
insert into Attractions values ('阿柑姨芋圓','新北市','美食','新北市瑞芳區豎崎路5號','02 2497 6505','山中清幽小鎮九份一直是台灣著名景點之一，當然觀光客也絡繹不絕拉，雖然人潮眾多，但還是忘不了九份的美“阿柑姨芋圓” 真是讓人忘不了的好滋味啊！！從以前學生時代來這玩時  就來吃過阿柑姨芋圓，小小的階梯上去非常隱秘吃過幾家九份的芋圓 ，還是阿柑姨最好吃！',null)
insert into Attractions values ('阿蘭草仔粿芋粿','新北市','美食','新北市瑞芳區基山街90號','02 2496 -7795','阿蘭草仔粿是一個有阿蘭草仔粿、平價、九份老街的休閒零食，網友認為值得推薦的有：草仔粿、芋粿、菜埔草仔粿、芋粿巧、菜蒲米草仔粿。',null)


--建立分享文表格

use CMDB;
go

drop table ArticleShare

create table ArticleShare(
articleID            int  IDENTITY (1,1) not null,
memberID       int,
contents          varchar(MAX),

constraint ArticleShare_primary_key primary key (articleID));
