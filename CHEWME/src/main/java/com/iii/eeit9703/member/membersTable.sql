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
values('eeit970301','���a��','�f���q�p�Q��','eeit970301',24,'eeit970301@gmail.com','�x�_���j�w�ϩM���F��1��','0912-345-678','�z��������','���`','�@��|��')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970302','�����q','Ĺ����','eeit970302',35,'eeit970302@gmail.com','�򶩥������ϩM���F��5��','0987-645-321','�ڷR�M���ȹC','���`','���κ޲z��')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970303','���ا�','��������','eeit970303',53,'eeit970303@gmail.com','�x�_���������]�e��257��','0966-555-444','�ڳ��w���s','���`','�@��|��')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970304','���@��','���G���W�n��','eeit970304',27,'eeit970304@gmail.com','��饫�k�����k����7��','0922-777-789','���̦����G�����̥h','���`','�@��|��')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970305','�����','���Y����','eeit970305',15,'eeit970305@gmail.com','�s�_���s���Ϥ�����246��','0987-948-947','�~���i�D���p','�¦W��','�@��|��')
insert into members(memberId,mname,mnickn,mpwd,mage,mmail,maddr,mphone,mintr,mstatus,mrole) 
values('eeit970306','������','�p�s����','eeit970306',32,'eeit970306@gmail.com','����������Ϥ��R��42��','0956-565-566','�ˤl�ȹC�ڳ̦�','���`','�@��|��')

create table mfriendslists(
memberId    varchar(30),
friendId    varchar(30),
fstatus     varchar(20),

constraint mfriendslists_foreign_key foreign key (memberId)REFERENCES members(memberId) 
);

insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970303','�n��')
insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970304','�n��')
insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970305','�ݽT�{')
insert into mfriendslists(memberId,friendId,fstatus) values('eeit970301','eeit970306','�n��')


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
