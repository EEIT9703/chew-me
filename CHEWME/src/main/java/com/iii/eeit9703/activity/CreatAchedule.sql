--刪除行程表格
drop table Achedule

--建立編輯行程表格

create table Achedule(

scheduleID        int    identity (1,1) not null,  --行程編號
Day               int,                             --行程天數(天)
period            vachar(max),                     --行程時段(HH:MM)
Desc1             varchar(max),                    --備註說明	

--商家 景點 餐廳	
attractionID      int;                             --景點ID

constraint Achedule_primary_key primary key (scheduleID));
 
--新增行程
INSERT INTO Achedule VALUES ('1','09:00','無','九份老街','新北市','美食');

