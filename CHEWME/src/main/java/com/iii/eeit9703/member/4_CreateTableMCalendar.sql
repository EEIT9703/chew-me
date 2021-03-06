USE CMDB;
GO
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'mcalendar')      
BEGIN
DROP TABLE mcalendar;
END
go

CREATE TABLE mcalendar(
calendarId  int not null,
memberId    varchar(30),
collectID   varchar(30),

CONSTRAINT mcalendar_primary_key PRIMARY KEY (calendarId),
); 

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'collections')      
BEGIN
ALTER TABLE mcalendar ADD CONSTRAINT mcalendar_foreign_key FOREIGN KEY (collectID)REFERENCES collections(collectID),
END
--未確定行程收藏表格,因此暫時別使用此表