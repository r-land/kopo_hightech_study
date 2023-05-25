--1
create table nbook(
bookid number,
bookname varchar2(20),
publisher varchar2(20),
price number default 11000 check(price > 2000));

--2
alter table nbook add primary key(bookid);

--3
alter table nbook add author VARCHAR2(10);

--4
alter table nbook modify author varchar2(20);

--5,7
alter table nbook drop column author;

--6
alter table nbook modify price number null;
alter table nbook modify price number not null;

--8
create table nbook2(
bookid number,
bookname varchar2(20),
publisher varchar2(20),
price number default 11000 check(price > 2000));

--9
INSERT INTO NBOOK (BOOKNAME, BOOKID, PUBLISHER, PRICE)
        VALUES('자바의정석', '1', '도우출판', '30000');
        
--10
INSERT INTO NBOOK (BOOKNAME, BOOKID, PUBLISHER, PRICE)
        VALUES('스포츠의학', '2', '한솔의학서적', '20000');
        
--11
insert into nbook2 (BOOKNAME, BOOKID, PUBLISHER, PRICE)
        select BOOKNAME, BOOKID, PUBLISHER, PRICE
        from nbook;
        
--12
update nbook
set price = 22000
where bookname = '스포츠의학';

--13
create table ncust(
custid varchar2(20),
name varchar2(20) unique,
address varchar2(20) default '대전시 가양동',
phone varchar2(20),
primary key (custid));

--14
insert into ncust (custid, name, address, phone)
      values(2, '방실', default, 010-1111-2222);
      
--15
insert into ncust (custid, name, address, phone)
      values(1, '오사랑', '대전시 은행동', 010-2222-3333);

--16
update ncust
set address=(select address
              from ncust 
              where name='오사랑')
where name='방실';

--17
delete from ncust
where name='방실';

--18
delete from ncust;

--19
create table norders(
orderid number primary key,
custid number references ncust(custid) on delete cascade,
bookid number not null,
saleprice number default 11000 check(saleprice < 20000),
orderdaate date);

--19(1)
alter table norders rename column orderdaate to orderdate;
alter table ncust modify custid not null;
alter table ncust modify custid number;

create table ncust_temp2 as select * from ncust;
delete from ncust;
insert into ncust select * from ncust_temp2;

--19(2)
alter table norders add primary key(custid);
foreign key(custid) references ncust(custid) on delete cascade)

--20
insert into norders (orderid, custid, bookid, saleprice, orderdate)
      values(1, 1, 1, 15000, '23/05/20');
      
insert into norders (orderid, custid, bookid, saleprice, orderdate)
      values(2, 1, 2, 19000, '23/05/15');

--21
delete from ncust
where custid=1;

select * from norders;

--43
select * from dual;