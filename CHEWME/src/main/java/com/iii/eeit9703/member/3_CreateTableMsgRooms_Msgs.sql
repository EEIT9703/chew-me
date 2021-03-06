USE CMDB;
GO


IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'msgs')      
BEGIN
IF (OBJECT_ID('msg_foreign_key', 'F') IS NOT NULL)
BEGIN
    ALTER TABLE msgs DROP CONSTRAINT msg_foreign_key 
END
END
go


IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'msg_rooms')      
BEGIN
DROP TABLE msg_rooms
END
go

IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'msgs')      
BEGIN

DROP TABLE msgs
END
go




CREATE TABLE msg_rooms(
msgRoomId    int not null,
memberId     varchar(30),
CONSTRAINT msg_rooms_primary_key PRIMARY KEY(msgroomId),
)
ALTER TABLE msg_rooms ADD CONSTRAINT msg_rooms_foreign_key FOREIGN KEY (memberId)REFERENCES members(memberId) 

CREATE TABLE msgs(
msgRoomId     int not null,
msgNo         int not null,
memberId      varchar(30),
msg           text,
msgTime       timestamp,
msgStatus     int,
CONSTRAINT msgs_primary_key PRIMARY KEY(msgno)
)
ALTER TABLE msgs ADD CONSTRAINT msg_foreign_key foreign key (msgRoomId)REFERENCES msg_rooms(msgRoomId) 

select * from msg_rooms
select * from msgs
go