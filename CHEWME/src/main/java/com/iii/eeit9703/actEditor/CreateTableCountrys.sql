--建立台灣縣市表格

use CMDB;
go

drop table countrys;

create table countrys (
 queue			int,
 countryID       varchar(5) not null,
 countryName			varchar(10),
 constraint countrys_primary_key primary key (countryID));

insert into countrys values (1,'KEE','基隆市');
insert into countrys values (2,'TPE','臺北市');
insert into countrys values (3,'NWT','新北市');
insert into countrys values (4,'TAO','桃園市');
insert into countrys values (5,'HSZ','新竹市');
insert into countrys values (6,'HSQ','新竹縣');
insert into countrys values (7,'MIA','苗栗縣');
insert into countrys values (8,'TXG','臺中市');
insert into countrys values (9,'NAN','南投縣');
insert into countrys values (10,'CHA','彰化縣');
insert into countrys values (11,'YUN','雲林縣');
insert into countrys values (12,'CYI','嘉義市');
insert into countrys values (13,'CYQ','嘉義縣');
insert into countrys values (14,'TNN','臺南市');
insert into countrys values (15,'KHH','高雄市');
insert into countrys values (16,'PIF','屏東縣');
insert into countrys values (17,'ILA','宜蘭縣');
insert into countrys values (18,'HUA','花蓮縣');
insert into countrys values (19,'TTT','臺東縣');
insert into countrys values (20,'LIE','連江縣');
insert into countrys values (21,'KIN','金門縣');
insert into countrys values (22,'PEN','澎湖縣');
