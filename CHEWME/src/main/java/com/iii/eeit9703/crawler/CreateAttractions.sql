--建立景點表格

use CMDB;
go

drop table Attractions

create table Attractions(
attractionID      int IDENTITY (1,1) not null,
name                   varchar(20),
county                varchar(20),
type                     varchar(20),
address              varchar(50),
tel                         varchar(20),
intro                    varchar(MAX),
image                 varbinary(MAX),

constraint Attractions_primary_key primary key (attractionID));

insert into Attractions values ('�E���ѵ�','�s�_��','���I','�s�_����ڰϨT����89��','02-2406-3270','�E���O�O�W�s�_����ڰϪ��@�Ӧa�ϡA�����]���������q�ӿ����A�q�|�����p�ɫ�@�רS���C1990�~�N��A�]�q�v�m�d�������n��E�������A�E�����W�S�¦��ؿv�B�Y�a�έ����z�L�����l�ްꤺ�~���`�ءA�]�����a�ϭ��s�a�ӥ;��A�ثe�w�g�����@�ӫܨ��w�諸�[�����I�C',null)
insert into Attractions values ('���a������','�s�_��','����','�s�_����ڰϽݱT��5��','02 2497 6505','�s���M�դp��E���@���O�x�W�ۦW���I���@�A��M�[���Ȥ]��ö�����ԡA���M�H�鲳�h�A���٬O�Ѥ��F�E�����������a�����ꡨ �u�O���H�Ѥ��F���n�����ڡI�I�q�H�e�ǥͮɥN�ӳo����  �N�ӦY�L���a������A�p�p������W�h�D�`�����Y�L�X�a�E�������� �A�٬O���a���̦n�Y�I',null)
insert into Attractions values ('������J�_���_','�s�_��','����','�s�_����ڰϰ�s��90��','02 2496 -7795','������J�_�O�@�Ӧ�������J�_�B�����B�E���ѵ󪺥𶢹s���A���ͻ{���ȱo���˪����G��J�_�B���_�B��H��J�_�B���_���B��Z�̯�J�_�C',null)


--建立分享文表格

use CMDB;
go

drop table ArticleShare

create table ArticleShare(
articleID            int  IDENTITY (1,1) not null,
memberID       int,
contents          varchar(MAX),

constraint ArticleShare_primary_key primary key (articleID));
