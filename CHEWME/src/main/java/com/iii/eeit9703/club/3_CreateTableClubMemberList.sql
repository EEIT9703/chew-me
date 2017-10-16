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
CONSTRAINT [PK_club_member_list] PRIMARY KEY CLUSTERED 
(
[memID],
[clubID]
) ON [PRIMARY] 
)
go

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'clubs')      
BEGIN
--增加外鍵(FK)
Alter TABLE club_member_list ADD CONSTRAINT FK_CM_clubID FOREIGN KEY(clubID) REFERENCES clubs(clubID)
END
go
