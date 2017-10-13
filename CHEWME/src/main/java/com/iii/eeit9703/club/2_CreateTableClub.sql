use CMDB;

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'clubs')      
BEGIN
Alter TABLE club_member_list DROP CONSTRAINT FK_clubID

DROP Table clubs
END
go

CREATE TABLE clubs
(clubID int  PRIMARY KEY  IDENTITY(1,1) NOT NULL, 
clubName varchar(50) NOT NULL,
managerId int ,
locationId  int NOT NULL,
brief varchar(50),
refURL varchar(50),
vistors int,
vistorsInMonth int,
addr varchar(50))

go


Alter TABLE club_member_list ADD CONSTRAINT FK_clubID FOREIGN KEY(clubID) REFERENCES clubs(clubID)
go

insert into clubs values('chewme�Ȧ��',1,1,'�ڭ̬Ochewme�Ȧ��,�Ʊ�j�a����ӳo�����n��','http://www.chewme.com',6,2,'�x�_���j�w�Ϥj�w���B��');
insert into clubs values('�ط~�Ȧ��',1,1,'�ط~�Ȧ��,���ѭ�����{','http://www.chianya.com',2,1,'�s�_���s���ϥ��v��');

select * from clubs