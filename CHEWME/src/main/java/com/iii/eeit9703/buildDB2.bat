cd C:\_EEITProject\repository\chewme\CHEWME\src\main\java\com\iii\eeit9703


sqlcmd -E -i club\3_CreateTableClubs.sql
sqlcmd -E -i club\1_CreateTableClubMemberList.sql
sqlcmd -E -i club\2_CreateTableClubActivityList.sql

sqlcmd -E -i member\1_CreateTableMembers.sql
sqlcmd -E -i member\2_CreateTableMFriendsLists.sql
sqlcmd -E -i club\4_CreateTableIssues.sql
sqlcmd -E -i club\5_CreateTableComments.sql
sqlcmd -E -i club\6_CreateTableQuestion.sql
sqlcmd -E -i club\7_CreateTableReplys.sql


pause
