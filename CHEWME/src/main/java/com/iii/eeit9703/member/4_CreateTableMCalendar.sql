USE CMDB;
GO
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'mcalendar')      
BEGIN
	--Alter TABLE ISSUE DROP CONSTRAINT FK_IssueClubID
	--Alter TABLE Club DROP CONSTRAINT FK_MemID
DROP TABLE mcalendar;
END
go

CREATE TABLE mcalendar(
calendarId  int not null,
memberId    varchar(30),
collectID   varchar(30),

CONSTRAINT mcalendar_primary_key PRIMARY KEY (calendarId),
); 
ALTER TABLE mcalendar ADD CONSTRAINT mcalendar_foreign_key FOREIGN KEY (collectID)REFERENCES collections(collectID),
--�ѩ�n�s���{�����٥�����