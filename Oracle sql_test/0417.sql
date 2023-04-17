--1.
select b.*
from book b, orders o
where b.bookid = o.bookid;

select o.*
from book b, orders o
where b.bookid = o.bookid;

CREATE TABLE NewBook(
bookid NUMBER,
BOOKNAME VARCHAR2(20),
PUBLISHER VARCHAR2(20),
PRICE NUMBER,
PRIMARY KEY (BOOKID));

DROP TABLE NewBook;
Drop table NewOrders;
drop table NewCustomer;

CREATE TABLE NewBook(
BOOKID NUMBER,
BOOKNAME VARCHAR2(20) NOT NULL,
PUBLISHER VARCHAR2(20)UNIQUE,
PRICE NUMBER DEFAULT 10000 CHECK(PRICE>1000),
PRIMARY KEY(BOOKID,PUBLISHER));

CREATE TABLE NewCustomer(
custid number unique,
name VARCHAR2(40),
address VARCHAR2(40),
phone VARCHAR2(30));

create table NewOrders(
orderid number,
custid number not null,
bookid number not null,
saleprice number,
orderdate date,
primary key(orderid),
foreign key(custid) references NewCustomer(custid) ON DELETE CASCADE);

create table NewBook(
bookid NUMBER unique,
bookname VARCHAR2(20),
publisher VARCHAR2(20),
price NUMBER);

create table NewOrders(
orderid number,
custid number,
bookid number,
saleprice number,
orderdate date,
primary key(orderid),
foreign key(bookid) references NewBook(bookid) on delete cascade,
foreign key(custid) references NewCustomer(custid) on delete cascade);
--neworders ���̺� �����ϰ� newbook���̺�����ϰ�
--bookid�� �⺻Ű��  unique�� �����ؼ� �ٽ� ������ �� neworders���̺����!
--SQL ����: ORA-02270: no matching unique or primary key for this column-list
--�� �����Ǿ����� �Ӽ��� pk �� unique�ؾ��Ѵ�!
--�������� ������ ORDERS���̺� ���� CUSTOMER, BOOK
--�⺻Ű �ΰ� �����ѵ� �����̸����� �ٸ����ǻ� �ִ� ��� ���� �⺻Ű�� �����ϱ����Ѱ�
--number ����Ʈ 8.2 
--char varchar ������ ������( �Ⱦ��� ������) ����
--null ����Ʈ
--insert ���̺��̸� ���θ� �������� values �������
--alter ���� update ��
--drop ���� delete ��
--rollback�� ddl ������ 
--SQL ����: ORA-02292: integrity constraint  ���Ἲ��������

Create table newbook(bookid number,bookname varchar2(20),
publisher varchar2(20), price number);

create table newcustomer(custid number primary key, name varchar2(40),
address varchar2(40), phone varchar2(30));

create table neworders(orderid number, custid number not null,
bookid number not null, saleprice number,orderdate date,
primary key(orderid),
foreign key(custid) references newcustomer(custid) on delete cascade);

alter table newbook add isbn varchar2(13);

alter table newbook modify isbn number;

alter table newbook drop column isbn;

alter table newbook modify bookid number not null;

alter table newbook add primary key(bookid);

insert into book(bookid, bookname, publisher, price)
values (11, '������ ����', '�Ѽ����м���', 90000);

insert into book(bookid, bookname, publisher)
values(14, '������ ����', '�Ѽ����м���');

SELECT * from book where bookname like '������ ����';

insert into book(bookid, bookname, price, publisher)
select bookid, bookname, price, publisher
from imported_book;

select * from book;

select * from customer;

update customer
set address='���ѹα� �λ�'
where custid =5;

rollback;

update customer
set address =(select address from customer where name='�迬��') 
where name='�ڼ���';

update customer
set address='���ѹα� ����'
where name='�ڼ���';

delete from customer;

--����ڰ� ���� ���̺��
select *
from user_tables;

--����ڰ� ���� �������ǵ� system catalog �б����� 
select *
from user_constraints;

delete from customer
where CUSTID=5;

select * from customer;

�������� ������ ������ ���ǻ�� ���� ���ǻ翡�� ������ ������ ���� �̸�
select name 
from orders o, customer c, book b
where c.custid=o.custid and b.bookid= o.bookid and name != '������' 
and B.PUBLISHER in (select B.PUBLISHER from orders o, customer c, book b
where c.custid=o.custid and b.bookid= o.bookid and name = '������');


�ΰ� �̻� ���� �ٸ� ���ǻ� ���� ������ ���̸�
select name
from customer c1
where 2<=(select count(distinct publisher)
          from customer c, orders o, book b
          where c.custid =o.custid and b.bookid=o.bookid
          and c1.name=c.name);
          
��ü ���� 30% �̻��� ������ ����
select count(*)*0.3
from customer;

select b.bookname
from  orders o, book b
where  b.bookid=o.bookid 
group by b.bookname
having count(*)>=(select count(*)*0.3
from customer);

SELECT bookname
from book b1
where((select count(DISTINCT custid) from orders
      where bookid =b1.bookid) 
      >=0.3*(select count(*)
            from customer));
                                            
insert into book
values (11,'������ ����', '���ѹ̵��', 10000);


delete from book
where PUBLISHER='�Ｚ��';

--�ܷ�Ű �������Ἲ ���� ���� �����Ұ�
delete from book
where PUBLISHER='�̻�̵��';

update book
set publisher ='�������ǻ�'
where publisher ='���ѹ̵��';

--main query- subquery
--��Į�� �μ����� (select��)
--�ζ��� ��
--�μ����� (where��)
--�� ?  ����  �ڵ尣��ȭ
--�ε��� ����
--rownum topandcut ����ڷ� �ڸ���
--round 1 �Ҽ��� 1�ڸ��� �ݿø� -1 1���ڸ� ���� �ݿø� 


select abs(-4.5)
from dual;
--4.5
select ceil(4.1)
from dual;
--5
select floor(4.1)
from dual;
--4
select round(567.567,0)
from dual;
--568
select round(567.567,-1)
from dual;
--570
select round(567.567,1)
from dual;
--567.6
select ln(10)
from dual;
--2.302585092
select log(10,200)
from dual;

select power(2,3)
from dual;
--8
select sqrt(9.0)
from dual;
--3
select sign(3.45)
from dual;
--1

select abs(-78), abs(+78)
from dual;

select round(4.875,1)
from dual;

select custid "����ȣ", round(sum(saleprice)/count(*),-2)"��ձݾ�"
from orders
group by custid;

--����¥�� �� 
select *
from dual;

select sysdate from dual;
--23-04-17
select chr(68) from dual;
--D
select concat('����','����') from dual;
--���缭��
select initcap('the soap') from dual;
--The Soap

select lower('MR.SCOTT') from dual;
--mr.scott

select lpad('Page 1',10,'*') from dual;
--****page 1

select ltrim('<==>browning<==>','<>=') from dual;
--browning<==>
select replace('JACK and JUE','J','BL') from dual;
--'BLACK and BLUE'
select rpad('AbC', 5, '*') from dual;
--'AbC**'
select rtrim('<==>browning<==>','<>=') from dual;
--<==>browning
select substr('ABCDEFG',3,4) from dual;
--'CDEF'
select trim('='from'==>browning<==') from dual;
-->browning<