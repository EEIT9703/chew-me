cd C:\_EEITProject\repository\chewme\CHEWME\src\main\java\com\iii\eeit9703


::  create�U�j�����D��,�Ѥ���l���s��
sqlcmd -E -i   club\1_CreateTableClubs.sql
sqlcmd -E -i   member\1_CreateTableMembers.sql
sqlcmd -E -i   activity\1_CreateTableActivity.sql
sqlcmd -E -i   crawler\1_CreateTableAttractions.sql
sqlcmd -E -i   crawler\2_CreateTableArticleShare.sql

::  create member���l��
sqlcmd -E -i   member\2_CreateTableMFriendsLists.sql
sqlcmd -E -i   member\3_CreateTableMsgRooms_Msgs.sql
sqlcmd -E -i   member\4_CreateTableMCalendar.sql


:: create club���l��
sqlcmd -E -i   club\2_CreateTableClubActivityList.sql
sqlcmd -E -i   club\3_CreateTableClubMemberList.sql
sqlcmd -E -i   club\4_CreateTableIssues.sql
sqlcmd -E -i   club\5_CreateTableComments.sql
sqlcmd -E -i   club\6_CreateTableQuestion.sql
sqlcmd -E -i   club\7_CreateTableReplys.sql

:: create1��{�s�边�ҷ|�Ψ쪺�a�I�N�X
sqlcmd -E -i   actEditor\1_CreateTableCountrys.sql

:: create��x�ҷ|�Ψ쪺���
sqlcmd -E -i   backstage\Collection.sql
sqlcmd -E -i   backstage\Report.sql


pause