USE CMDB;
GO
IF EXISTS (SELECT name FROM sysobjects
            WHERE type='u' AND name = 'members')      
BEGIN
	--Alter TABLE ISSUE DROP CONSTRAINT FK_IssueClubID
	--Alter TABLE Club DROP CONSTRAINT FK_MemID
drop table members
END
go


CREATE TABLE members(
memberId    varchar(30),
mname       varchar(20),
mnickn      varchar(20),
mpwd        varchar(20),
mbirthday   date,
mmail       varchar(50),
maddr       varchar(max),
mphone      varchar(15),
mintr       varchar(max),
mphoto      varbinary(max),
mstatus     varchar(20),
mrole       varchar(20),

CONSTRAINT members_primary_key PRIMARY KEY(memberId)
);

INSERT INTO members(memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mstatus,mrole) 
VALUES('eeit970301','蔡家華','番薯島小霸王','eeit970301','1990/10/11','eeit970301@gmail.com','台北市大安區和平東路1號','0912-345-678','哇哈哈哈哈','正常','一般會員')
INSERT INTO members(memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mstatus,mrole) 
VALUES('eeit970302','馬立夯','贏馬赫','eeit970302','1973/07/25','eeit970302@gmail.com','基隆市中正區和平東路5號','0987-645-321','我愛騎車旅遊','正常','社團管理員')
INSERT INTO members(memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mstatus,mrole) 
VALUES('eeit970303','陳建志','見仁見智','eeit970303','1970/01/05','eeit970303@gmail.com','台北市中正區館前路257號','0966-555-444','我喜歡爬山','正常','一般會員')
INSERT INTO members(memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mstatus,mrole) 
VALUES('eeit970304','黃一芳','水果茶超好喝','eeit970304','1987/07/08','eeit970304@gmail.com','桃園市歸仁區歸仁路7號','0922-777-789','哪裡有水果茶哪裡去','正常','一般會員')
INSERT INTO members(memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mstatus,mrole) 
VALUES('eeit970305','莊曉癸','鬼頭鬼腦','eeit970305','2002/03/26','eeit970305@gmail.com','新北市新店區中興路246號','0987-948-947','才不告訴膩雷','黑名單','一般會員')
INSERT INTO members(memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mstatus,mrole) 
VALUES('eeit970306','廖美芽','小新的媽','eeit970306','1985/05/27','eeit970306@gmail.com','高雄市左營區仁愛路42號','0956-565-566','親子旅遊我最行','正常','一般會員')
