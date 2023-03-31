CREATE TABLE student
(
stu_no varchar2(50) primary key
,stu_name VARCHAR2(50)
,stu_score number(10,0) );

select * from student;

commit;

CREATE TABLE member
(
mem_id VARCHAR2(50) PRIMARY KEY
,mem_pass varchar2(50)
,mem_name VARCHAR2(50)
,mem_point NUMBER(10,0)
);

SELECT mem_id, mem_pass, mem_name, mem_point FROM member;

insert into member
(mem_id, mem_pass, mem_name, mem_point)
values
('a001', '1234', '고길동', 70);

insert into member
(mem_id, mem_pass, mem_name, mem_point)
values
('a002', '1234', '마이콜', 20);

insert into member
(mem_id, mem_pass, mem_name, mem_point)
values
('a005', '1234', '오이콜', 80);

COMMIT;