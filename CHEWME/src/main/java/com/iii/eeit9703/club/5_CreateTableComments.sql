use CMDB;

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'comments')      
BEGIN
	--Alter TABLE ISSUE DROP CONSTRAINT FK_IssueClubID
	--Alter TABLE Club DROP CONSTRAINT FK_MemID
	DROP Table comments;
END
go

CREATE TABLE comments
(commentID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
issueID int NOT NULL,
content varchar,
commenterId int,
commentDate Date)

go

Alter TABLE comments ADD CONSTRAINT FK_commentIssueID FOREIGN KEY(issueID) REFERENCES issues(issueID)
go