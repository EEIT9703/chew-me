use CMDB;

Alter TABLE ClubMemberList DROP CONSTRAINT FK_ClubID
--Alter TABLE Club DROP CONSTRAINT FK_MemID
go
DROP Table Club
go

CREATE TABLE Club
(ClubID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
ClubNAME varchar NOT NULL,
ManagerID int ,
Location  int NOT NULL,
Brief varchar,
RefURL varchar,
Vistors int,
VistorsInMonth int,
Addr varchar)

go

Alter TABLE ClubMemberList ADD CONSTRAINT FK_ClubID FOREIGN KEY(ClubID) REFERENCES Club(ClubID)
go
--Alter TABLE Club ADD CONSTRAINT FK_MemID FOREIGN KEY(ManagerID) REFERENCES ClubMemberList(MemID)
go