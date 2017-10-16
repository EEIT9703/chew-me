USE CMDB;
GO

DROP TABLE msg_rooms
DROP TABLE msgs

CREATE TABLE msg_rooms(
msgroomId    int not null,
memberId     varchar(30),
CONSTRAINT msg_rooms_primary_key PRIMARY KEY(msgroomId),
)
ALTER TABLE msg_rooms ADD CONSTRAINT msg_rooms_foreign_key FOREIGN KEY (memberId)REFERENCES members(memberId) 

CREATE TABLE msgs(
msgroomId     int not null,
msgno         int not null,
memberId      varchar(30),
msg           text,
msgtime       timestamp,
msgstatus     bit,
CONSTRAINT msgs_primary_key PRIMARY KEY(msgno)
)
ALTER TABLE msgs ADD CONSTRAINT msg_foreign_key foreign key (msgroomId)REFERENCES msg_rooms(msgroomId) 
