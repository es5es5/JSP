create table ihwac_member(
	im_id varchar2(10 char) primary key, 	-- id
	im_pw varchar2(10 char) not null, 		-- pw
	im_name varchar2(10 char) not null,		-- �̸�
	im_addr varchar2(10 char) not null,		-- ������
	im_birthday date not null,				-- �������
	im_img varchar2(100 char) not null		-- ����
);

select * from IHWAC_MEMBER;