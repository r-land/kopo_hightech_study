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
--neworders 테이블 삭제하고 newbook테이블삭제하고
--bookid를 기본키나  unique로 지정해서 다시 생성한 후 neworders테이블생성!
--SQL 오류: ORA-02270: no matching unique or primary key for this column-list
--즉 참조되어지는 속성은 pk 나 unique해야한다!
--삭제순서 참조된 ORDERS테이블 다음 CUSTOMER, BOOK
--기본키 두개 가능한데 같은이름으로 다른출판사 있는 경우 같이 기본키는 구분하기위한것
--number 디폴트 8.2 
--char varchar 고정형 가변형( 안쓰면 돌려줌) 차이
--null 디폴트
--insert 테이블이름 전부면 생략가능 values 순서대로
--alter 구조 update 값
--drop 구조 delete 값
--rollback은 ddl 전까지 
--SQL 오류: ORA-02292: integrity constraint  무결성제약조건

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
values (11, '스포츠 의학', '한솔의학서적', 90000);

insert into book(bookid, bookname, publisher)
values(14, '스포츠 의학', '한솔의학서적');

SELECT * from book where bookname like '스포츠 의학';

insert into book(bookid, bookname, price, publisher)
select bookid, bookname, price, publisher
from imported_book;

select * from book;

select * from customer;

update customer
set address='대한민국 부산'
where custid =5;

rollback;

update customer
set address =(select address from customer where name='김연아') 
where name='박세리';

update customer
set address='대한민국 대전'
where name='박세리';

delete from customer;

--사용자가 만든 테이블들
select *
from user_tables;

--사용자가 만든 제약조건들 system catalog 읽기전용 
select *
from user_constraints;

delete from customer
where CUSTID=5;

select * from customer;

박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name 
from orders o, customer c, book b
where c.custid=o.custid and b.bookid= o.bookid and name != '박지성' 
and B.PUBLISHER in (select B.PUBLISHER from orders o, customer c, book b
where c.custid=o.custid and b.bookid= o.bookid and name = '박지성');


두개 이상 서로 다른 출판사 도서 구매한 고객이름
select name
from customer c1
where 2<=(select count(distinct publisher)
          from customer c, orders o, book b
          where c.custid =o.custid and b.bookid=o.bookid
          and c1.name=c.name);
          
전체 고객의 30% 이상이 구매한 도서
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
values (11,'스포츠 세계', '대한미디어', 10000);


delete from book
where PUBLISHER='삼성당';

--외래키 참조무결성 으로 인해 삭제불가
delete from book
where PUBLISHER='이상미디어';

update book
set publisher ='대한출판사'
where publisher ='대한미디어';

--main query- subquery
--스칼라 부속질의 (select절)
--인라인 뷰
--부속질의 (where절)
--뷰 ?  보안  코드간결화
--인덱스 색인
--rownum topandcut 행숫자로 자르기
--round 1 소수점 1자리인 반올림 -1 1의자리 에서 반올림 


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

select custid "고객번호", round(sum(saleprice)/count(*),-2)"평균금액"
from orders
group by custid;

--한줄짜리 값 
select *
from dual;

select sysdate from dual;
--23-04-17
select chr(68) from dual;
--D
select concat('마당','서점') from dual;
--마당서점
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