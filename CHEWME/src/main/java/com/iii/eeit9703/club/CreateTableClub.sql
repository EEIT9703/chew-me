use CMDB;

Alter TABLE ClubMemberList DROP CONSTRAINT FK_ClubID
--Alter TABLE Club DROP CONSTRAINT FK_MemID
go
DROP Table club
go

CREATE TABLE club
(clubID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
clubNAME varchar NOT NULL,
managerID int ,
location  int NOT NULL,
brief varchar,
refURL varchar,
vistors int,
vistorsInMonth int,
addr varchar)

go

Alter TABLE club_Member_list ADD CONSTRAINT FK_clubID FOREIGN KEY(clubID) REFERENCES club(ClubID)
go
--Alter TABLE Club ADD CONSTRAINT FK_MemID FOREIGN KEY(ManagerID) REFERENCES ClubMemberList(MemID)
go