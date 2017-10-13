--刪除行程表格
drop table activity

--建立行程表格
create table activity(

actID             int    identity (1,1) not null,
Day               int,
Period            varchar(max),
Desc1              varchar(max),
--AttactionID       int,
name              varchar(max),
County            varchar(max),
type              varchar(max),

constraint activity_primary_key primary key (actID));
 
--新增行程
INSERT INTO activity VALUES ('1','09:00','無','九份老街','新北市','美食');
INSERT INTO activity VALUES ('2','10:00','無','Hotel','新北市','住宿');
INSERT INTO activity VALUES ('3','11:00','無','九份芋圓','新北市','餐廳');
