use CMDB;
go
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'club_activity_list')      
BEGIN
DROP TABLE club_activity_list;

END                                                                                                                                                                                                                                                                                                                                                                                                                                                    
go

CREATE TABLE club_activity_list
(
actId int NOT NULL,
clubId int NOT NULL
CONSTRAINT [PK_ClassHistory] PRIMARY KEY CLUSTERED 
(
[actId],
[clubId]
) ON [PRIMARY] 
)
go

