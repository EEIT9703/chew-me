use CMDB;

IF EXISTS (SELECT name FROM sysobjects
            WHERE name = 'issues')      
BEGIN
	Alter TABLE issues DROP CONSTRAINT FK_clubID
	--Alter TABLE Club DROP CONSTRAINT FK_MemID
	DROP Table issues;
END
go

CREATE TABLE issues
(issueID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
clubID varchar NOT NULL,
issueTitle varchar,
issueContent varchar,
proposerID int,
issuepic varbinary(max))

go

Alter TABLE issues ADD CONSTRAINT FK_ClubID FOREIGN KEY(ClubID) REFERENCES Club(ClubID)
--Alter TABLE issue ADD CONSTRAINT FK_proposerID FOREIGN KEY(proposerID) REFERENCES member(member_ID)
go
--Alter TABLE club ADD CONSTRAINT FK_MemID FOREIGN KEY(ManagerID) REFERENCES club_member_list(MemID)
go