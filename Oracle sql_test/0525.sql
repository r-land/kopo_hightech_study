--1 ����ڰ� ���� ��� 
select * from user_views;

--2 �ε��� ����
create index ix_book on book(bookname);

--3.
create index ix_book2 on book(publisher, price);

--4 ������ �籸��  ���� ���� ���� �ɶ� �����Ҷ� 
alter index ix_book rebuild;

--5 �ε��� ����
drop index ix_book;
drop index ix_book2;

--16(1)
select name from customer where name like '�ڼ���';

--16(3)
create index ix_cust on customer(name);

--16(5)
drop index ix_cust;
