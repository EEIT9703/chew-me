drop table member;

create table member(
member_Id    varchar(30),
m_name       varchar(20),
m_nickn      varchar(20),
m_pwd        varchar(20),
m_age        int,
m_mail       varchar(50),
m_addr       varchar(max),
m_phone      varchar(15),
m_intr       varchar(max),
m_photo      varbinary(max),
constraint member_primary_key primary key (member_Id)
);

insert into member(member_Id,m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr) 
values('eeit970301','������','�f���q�p�Q��','eeit97032017',18,'f12345678@gmail.com','���s�����s�Ϥ��s�����s��1��','0912-345-678','�z��������')