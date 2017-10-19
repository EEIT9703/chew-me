use CMDB;
go
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'collect')      
BEGIN
DROP TABLE collect;

END                                                                                                                                                                                                                                                                                                                                                                                                                                                    
go

CREATE TABLE collect
(
memID int NOT NULL,
actID int NOT NULL,
[status] int

CONSTRAINT [PK_collect] PRIMARY KEY CLUSTERED 
(
[memID],
[actID]
) ON [PRIMARY] 
)
go

select * from collect;
go