use CMDB;
go

drop table m_calendar;

create table m_calendar(
calendarId  int not null,
memberId    varchar(30),
collectID   varchar(30),

constraint m_calendar_primary_key primary key (calendarId),
constraint m_calendar_foreign_key foreign key (memberId)REFERENCES members(memberId),
constraint m_calendar_foreign_key foreign key (collectID)REFERENCES collections(collectID),
); 