USE CMDB;
GO

DROP TABLE m_friends_lists;

CREATE TABLE m_friends_lists(
memberId    varchar(30),
friendId    varchar(30),
fstatus     varchar(20),
);
ALTER TABLE m_friends_lists ADD CONSTRAINT mfriendslists_foreign_key FOREIGN KEY (memberId)REFERENCES members(memberId) 


INSERT INTO m_friends_lists(memberId,friendId,fstatus) VALUES('eeit970301','eeit970303','好友')
INSERT INTO m_friends_lists(memberId,friendId,fstatus) VALUES('eeit970301','eeit970304','好友')
INSERT INTO m_friends_lists(memberId,friendId,fstatus) VALUES('eeit970301','eeit970305','待確認')
INSERT INTO m_friends_lists(memberId,friendId,fstatus) VALUES('eeit970301','eeit970306','好友')
