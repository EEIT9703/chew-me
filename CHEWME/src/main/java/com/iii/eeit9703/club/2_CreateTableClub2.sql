use CMDB;
go
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'club_member_list')      
BEGIN
DROP TABLE club_member_list;

END                                                                                                                                                                                                                                                                                                                                                                                                                                                    
go

CREATE TABLE club_member_list
(
memID int NOT NULL,
clubID int NOT NULL
CONSTRAINT [PK_ClassHistory] PRIMARY KEY CLUSTERED 
(
[memID],
[clubID]
) ON [PRIMARY] 
)
go