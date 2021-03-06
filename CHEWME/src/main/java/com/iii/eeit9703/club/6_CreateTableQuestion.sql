use CMDB;

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'replys')
BEGIN
IF (OBJECT_ID('FK_QR_quetionID', 'F') IS NOT NULL)
BEGIN
    Alter TABLE replys DROP CONSTRAINT FK_QR_quetionID 
END
END   
go

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'questions')      
BEGIN
	DROP Table questions;
END
go

CREATE TABLE questions
(questionId int PRIMARY KEY IDENTITY(1,1) NOT NULL,
clubId int NOT NULL,
qTitle varchar(50),
qcontent varchar(300),
askerId int,
readed bit)

go
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'clubs')
BEGIN
Alter TABLE questions ADD CONSTRAINT FK_CQ_ClubID FOREIGN KEY(clubId) REFERENCES clubs(clubId)
END 
go


insert into questions values (1,'番薯島小霸王提問','你好,我是番薯島小霸王,看到你們的社團感到十分興趣,請問你們大概是多久出團一次呢',1,0);


select * from questions;