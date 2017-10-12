use CMDB;
go

DROP TABLE club_member_list;
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