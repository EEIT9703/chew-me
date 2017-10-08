use CMDB;
go

DROP TABLE ClubMemberList;
go 

CREATE TABLE ClubMemberList
(
MemID int NOT NULL,
ClubID int NOT NULL
CONSTRAINT [PK_ClassHistory] PRIMARY KEY CLUSTERED 
(
[MemID],
[ClubID]
) ON [PRIMARY] 
)