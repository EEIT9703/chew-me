use CMDB;

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'Comment')      
BEGIN
	--Alter TABLE ISSUE DROP CONSTRAINT FK_IssueClubID
	--Alter TABLE Club DROP CONSTRAINT FK_MemID
	DROP Table comment;
END
go

CREATE TABLE comment
(commentID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
issueID int NOT NULL,
content varchar,
commenter int,
cdate Date)

go

Alter TABLE comment ADD CONSTRAINT FK_commentIssueID FOREIGN KEY(issueID) REFERENCES issue(issueID)
go