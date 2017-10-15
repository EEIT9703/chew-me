use CMDB;
go

drop table m_friends_lists;

create table m_friends_lists(
memberId    varchar(30),
friendId    varchar(30),
fstatus     varchar(20),

constraint mfriendslists_foreign_key foreign key (memberId)REFERENCES members(memberId) 
);

insert into m_friends_lists(memberId,friendId,fstatus) values('eeit970301','eeit970303','好友')
insert into m_friends_lists(memberId,friendId,fstatus) values('eeit970301','eeit970304','好友')
insert into m_friends_lists(memberId,friendId,fstatus) values('eeit970301','eeit970305','待確認')
insert into m_friends_lists(memberId,friendId,fstatus) values('eeit970301','eeit970306','好友')
