USE CMDB;
GO

DROP TABLE mcalendar;

CREATE TABLE mcalendar(
calendarId  int not null,
memberId    varchar(30),
collectID   varchar(30),

CONSTRAINT mcalendar_primary_key PRIMARY KEY (calendarId),
); 
ALTER TABLE mcalendar ADD CONSTRAINT mcalendar_foreign_key FOREIGN KEY (collectID)REFERENCES collections(collectID),
--由於要連到行程收藏還未完成