--DB놀이 4.1
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

-----------DB2.1
select count(*) as 주문건수, max(saleprice)as 최고주문액
from orders
group by custid;

--2.
select count(*) as 주문건수, sum(saleprice)as 총판매액
from orders
group by bookid;

--3.
select count(*) as 주문건수, sum(saleprice)as 총판매액
from orders
group by bookid
order by bookid;

--4.
select count(*) as 주문건수
from orders
where saleprice > 10000
group by bookid
having count(*)>=2;

--5.
select sum(o.saleprice) as 총주문금액
from orders o, customer c
where o.custid = c.custid 
and c.name like '장미란';

--6.
select bookname, price
from book
where price >= 10000;

--7.
select *
from book
where bookid ='3';

--8.
select count(*)
from customer;

--9.
select DISTINCT count(custid)
from orders;

--10.
select count(*)
from customer c left outer join orders o on (o.CUSTID = c.CUSTID)
where o.ORDERID is null;

--11.
select DISTINCT c.name
from customer c left outer join orders o on (o.CUSTID = c.CUSTID)
where o.ORDERID is not null;

--12.
select DISTINCT c.name
from customer c left outer join orders o on (o.CUSTID = c.CUSTID)
where o.ORDERID is null;

--13.
select b.bookname, o.SALEPRICE
from orders o, book b
where o.BOOKID = b.bookid;

--14.
select orderdate, orderid
from orders
where orderdate BETWEEN '14/07/01' and '14/07/05';

--15.
select *
from book
order by publisher, price desc;

--16.
select *
from orders o, book b
where o.BOOKID = b.bookid;

--17.
select *
from orders o, book b
where o.BOOKID = b.bookid
order by b.BOOKID;

--18.
select bookname, price
from book;

--19.
select b.bookname, c.name, c.phone
from orders o, book b, customer c
where c.custid=o.custid and b.bookid= o.bookid ;

--20
select c.name, o.saleprice
from orders o, book b, customer c
where c.custid=o.custid and b.bookid= o.bookid 
and b.bookname = '축구의 역사';

--21.
select b.bookname, c.name
from book b left outer join orders o on (o.bookid = b.bookid) 
left outer join customer c on (c.custid = o.custid);

--22.
select bookname, price
from (select * from book order by price desc)
where rownum =1 ;

--23.
select avg(saleprice)
from orders
group by custid;

--24.
select c.name, b.bookname, o.orderdate
from orders o, book b, customer c
where c.custid=o.custid and b.bookid= o.bookid 
and o.custid = '1';

--25.
select c.name, c.phone
from customer c
where exists (select c.custid from orders o);

--26.
select name
from orders o, customer c
where c.custid = o.custid
group by c.name
having avg(saleprice)
 > (select avg(saleprice) 
from orders);

--27.
select b.bookname
from orders o, book b, customer c
where c.custid=o.custid and b.bookid= o.bookid 
and c.name like '김연아';

--28.
select b.bookname
FROM customer c, orders o, book b
minus
select b.bookname
FROM customer c, orders o, book b
where c.custid=o.custid and b.bookid= o.bookid and name = '김연아';

--29.
SELECT *
FROM book b, orders o
WHERE b.BOOKID = o.BOOKID
AND b.PRICE-o.SALEPRICE = (
SELECT max(b.PRICE-o.SALEPRICE)
FROM book b, ORDERS o
WHERE b.BOOKID = o.BOOKID
);

--30
select b.bookname, b.publisher
from( select * from (select bookid from orders order by 1 desc)
where rownum=1) o, book b
where b.bookid = o.bookid;






