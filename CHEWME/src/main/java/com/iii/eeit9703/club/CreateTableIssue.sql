use CMDB;

IF EXISTS (SELECT name FROM sysobjects
            WHERE name = 'ISSUE')      
BEGIN
	Alter TABLE issue DROP CONSTRAINT FK_clubID
	--Alter TABLE Club DROP CONSTRAINT FK_MemID
	DROP Table issue;
END
go

CREATE TABLE issue
(issueID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
clubID varchar NOT NULL,
issueTitle varchar,
issueContent varchar,
proposerID int,
issuepic varbinary(max))

go

Alter TABLE ISSUE ADD CONSTRAINT FK_ClubID FOREIGN KEY(ClubID) REFERENCES Club(ClubID)
--Alter TABLE issue ADD CONSTRAINT FK_proposerID FOREIGN KEY(proposerID) REFERENCES member(member_ID)
go
--Alter TABLE club ADD CONSTRAINT FK_MemID FOREIGN KEY(ManagerID) REFERENCES club_member_list(MemID)
go