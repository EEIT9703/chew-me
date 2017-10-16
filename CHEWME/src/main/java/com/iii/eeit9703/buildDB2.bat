cd C:\_EEITProject\repository\chewme\CHEWME\src\main\java\com\iii\eeit9703

:: create各大項的主表,供之後子表的連接
sqlcmd -E -i club\1_CreateTableClubs.sql
sqlcmd -E -i member\1_CreateTableMembers.sql
sqlcmd -E -i activity\1_CreatTableActivity.sql

:: create member的子表
sqlcmd -E -i member\2_CreateTableMFriendsLists.sql
sqlcmd -E -i member\3_CreateTableMsgRooms&Msgs.sql
sqlcmd -E -i member\4_CreateTableMCalendar.sql


::create club的子表
sqlcmd -E -i club\2_CreateTableClubActivityList.sql
sqlcmd -E -i club\3_CreateTableClubMemberList.sql
sqlcmd -E -i club\4_CreateTableIssues.sql
sqlcmd -E -i club\5_CreateTableComments.sql
sqlcmd -E -i club\6_CreateTableQuestion.sql
sqlcmd -E -i club\7_CreateTableReplys.sql

sqlcmd -E -i actEditor\1_CreateTableCountrys.sql
sqlcmd -E -i actEditor\2_CreateTableCountys.sql

pause
