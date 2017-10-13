drop table members;
drop table mfriendslists;
drop table mcalendar;

create table members(
memberId    varchar(30),
mname       varchar(20),
mnickn      varchar(20),
mpwd        varchar(20),
mage        int,
mmail       varchar(50),
maddr       varchar(max),
mphone      varchar(15),
mintr       varchar(max),
mphoto      varbinary(max),
mstatus     varchar(20),
mrole       varchar(20),

constraint member_primary_key primary key (memberId)
);

insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970301','蔡家華','番薯島小霸王','eeit970301',24,'eeit970301@gmail.com','台北市大安區和平東路1號','0912-345-678','哇哈哈哈哈','正常','一般會員')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970302','馬立夯','贏馬赫','eeit970302',35,'eeit970302@gmail.com','基隆市中正區和平東路5號','0987-645-321','我愛騎車旅遊','正常','社團管理員')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970303','陳建志','見仁見智','eeit970303',53,'eeit970303@gmail.com','台北市中正區館前路257號','0966-555-444','我喜歡爬山','正常','一般會員')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970304','黃一芳','水果茶超好喝','eeit970304',27,'eeit970304@gmail.com','桃園市歸仁區歸仁路7號','0922-777-789','哪裡有水果茶哪裡去','正常','一般會員')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970305','莊曉癸','鬼頭鬼腦','eeit970305',15,'eeit970305@gmail.com','新北市新店區中興路246號','0987-948-947','才不告訴膩雷','黑名單','一般會員')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970306','廖美芽','小新的媽','eeit970306',32,'eeit970306@gmail.com','高雄市左營區仁愛路42號','0956-565-566','親子旅遊我最行','正常','一般會員')

create table mfriendslists(
memberId    varchar(30),
friendId    varchar(30),
fstatus     varchar(20),

constraint mfriendslists_foreign_key foreign key (memberId)REFERENCES members(memberId) 
);

insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970303','好友')
insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970304','好友')
insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970305','待確認')
insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970306','好友')


create table mcalendar(
calendarId  int not null,
memberId    varchar(30),
collectID   varchar(30),

constraint mcalendar_primary_key primary key (calendarId),
constraint mcalendar_foreign_key foreign key (memberId)REFERENCES members(memberId),
constraint collections_foreign_key foreign key (collectID)REFERENCES members(collectID),
); 

create table messages(
msgId   int not null,)
