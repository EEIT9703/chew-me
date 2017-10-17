use CMDB;


IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'issues ')      
BEGIN
Alter TABLE issues DROP CONSTRAINT FK_IC_IssueID 
END   

IF EXISTS (SELECT name FROM sysobjects
            WHERE name = 'issues')      
BEGIN
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

Alter TABLE issues ADD CONSTRAINT FK_CI_ClubID FOREIGN KEY(ClubID) REFERENCES clubs(ClubID)
go

insert into issues values (1,1,'第一個在社團裡面的議題','',1,null);
insert into issues values (2,1,'第二個在社團裡面的議題','因為是第二個社團示範一題',2,null);

select * from issues 