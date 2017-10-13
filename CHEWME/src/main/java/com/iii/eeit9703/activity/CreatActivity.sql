--刪除行程表格
drop table activity

--建立行程表格
create table activity(

actID             int    identity (1,1) not null,
Day               time,
Period            varchar(max),
Desc              varchar(max),
--AttactionID       int,
Name              varchar(max),
County            varchar(max),
type              varchar(max),

constraint activity_primary_key primary key (actID));

--新增行程
INSERT INTO activity VALUES ('一天','09:00','無','九份老街','新北市','美食',null)
