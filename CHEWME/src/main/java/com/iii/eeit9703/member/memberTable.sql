drop table member;

create table member(
member_Id    INT IDENTITY PRIMARY KEY,
m_name       varchar(20),
m_nickn      varchar(20),
m_pwd        varchar(20),
m_age        int,
m_mail       varchar(50),
m_addr       varchar(max),
m_phone      varchar(15),
m_intr       varchar(max),
m_photo      varbinary(max),
)

insert into member(m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr) 
values('½²ªü¹Ç','µfÁ¦®q¤pÅQ¤ý','eeit9703',18,'f12345678@gmail.com','¤ÑÀs¥«¤ÑÀs°Ï¤ÑÀs¨½¤ÑÀs¸ô1¸¹','0912-345-678','«z«¢«¢«¢«¢')