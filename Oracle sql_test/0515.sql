--1 판매가가 제일 높은 3개 주문정보
select * from (select * from orders order by saleprice desc ) where rownum <=3;

select * from orders order by saleprice desc;
--2 도서 정가가 제일 싼 5개 도서정보
select * from( select * from book order by price ) where rownum <= 5;
--3 고객별 주문액 합계가 제일 많은 3개 주문정보 출력 
select * from orders where custid in(select custid from(select custid from orders group by custid order by sum(saleprice) desc) where rownum <=3);
--4 고객별 주문액 합계가 제일 적은 3개 고객정보 출력
select * from customer where custid in(select custid from(select custid from orders group by custid order by sum(saleprice)) where rownum <=3);

--1단계 고객별 판매액 합계 작은것부터 정렬 고객번호와 판매액 합계 출력
select custid, sum(saleprice) from orders group by custid order by sum(saleprice);

--2단계 고객별 판매액 합계 작은것 부터 정렬 하여 고객번호 출력
select custid from orders group by custid order by sum(saleprice);

--3단계 고객별 판매액 합계 작은것 부터 정렬 하여 고객번호 최상위 3명 고객번호 출력
select custid from(select custid from orders group by custid order by sum(saleprice)) where rownum <=3;

--4단계 최상위 3명의 고객정보
select * from customer where custid in(select custid from(select custid from orders group by custid order by sum(saleprice)) where rownum <=3);

--5 대한미디어 출판사에서 출판된 도서 중 제일 많이 판매된 도서2개 출력
select * from(select bookid from orders where publisher = '대한미디어') where bookid in(select bookid from orders group by bookid order by sum(saleprice) desc) where rownum <=2; 

-- 대한미디어 출판사에서 출판된 도서들이 몇번씩 주문되었는지 확인
select b.bookid, count(*)
from book b, orders o
where b.bookid=o.bookid and publisher = '대한미디어'
group by b.bookid;
--데이터 삽입
INSERT INTO orders VALUES (11, 4, 3, 21000, '14/07/05');

INSERT INTO orders VALUES (12, 3, 3, 21000, '14/07/01');

INSERT INTO orders VALUES (13, 1, 4, 21000, '14/07/02');

--6 대한미디어 출판사에서 출판된 도서 중 제일 많이 판매된 도서2개를 구매한 고객정보 출력
--6-1 대한미디어 출판사에서 출판된 도서 중 판매 횟수
select b.bookid, COUNT(*) from book b, orders o where b.bookid = o.bookid and b.publisher = '대한미디어' group by b.bookid;
--6-2 대한미디어 출판사에서 출판된 도서 중 판매된 도서의 도서번호와 판매 횟수
select b.bookid, COUNT(*) from book b, orders o where b.bookid = o.bookid and b.publisher = '대한미디어' group by b.bookid  order by count(*) desc;
--6-3 대한미디어 출판사에서 출판된 도서 중 판매된 도서의 판매횟수가 많은순으로 정렬
select * from(select b.bookid, COUNT(o.orderid) from book b, orders o where b.bookid = o.bookid and b.publisher = '대한미디어' group by b.bookid order by count(*) desc) where rownum <=2;
--6-4 그 도서를 구매한 고객정보

select * from customer where custid in(
select o.custid from book b, CUSTOMER c, orders o
WHERE b.bookid = o.bookid and c.custid = o.custid and  b.bookid in(
select bookid from (select b.bookid from book b, orders o where b.bookid = o.bookid and b.publisher = '대한미디어' group by b.bookid order by count(*) desc) where rownum <=2));


select distinct c.* 
from CUSTOMER c, orders o
WHERE c.custid = o.custid 
and bookid in(
select bookid from (select b.bookid from book b, orders o where b.bookid = o.bookid and b.publisher = '대한미디어' group by b.bookid order by count(*) desc) where rownum <=2);

--7 주문날짜별 판매 건수 출력
select orderdate, count(*) from ORDERS group by ORDERDATE;

insert into orders values(14, 1, 10, 8000, '2014/07/07');

--9.날짜별 판매 건수가 제일 많은 날짜의 주문정보 출력
select * from(select orderdate, count(*) from ORDERS group by ORDERDATE order by count(*) desc)where rownum <=1;

select * from orders where orderdate in(select orderdate from (select orderdate from ORDERS group by ORDERDATE order by count(*) desc)where rownum <=1);

--10 전체도서의 판매가 평균보다 비싸게 팔린 도서정보
select avg(saleprice) from orders; 

select * 
from orders 
where SALEPRICE > (select avg(saleprice) from orders);  

select * from book where bookid in(select bookid
                                   from orders
                                  where SALEPRICE>(select avg(saleprice) from orders));

--11 도서별 주문건수
select bookid, count(*) from orders group by bookid;
--12 도서별 판매가 평균 이상 팔린 도서정보
select * 
from book 
where bookid in(
                select bookid 
                from orders o1
                where SALEPRICE > (select avg(saleprice) 
                                    from orders o2 
                                    where o1.BOOKID = o2.BOOKID 
                                    group by bookid
                                  ));

select bookid, avg(saleprice) from orders group by bookid;

select saleprice from orders where bookid = 7;


--13 고객별 판매가 평균 미만 팔린 주문정보
select * 
from orders o1 
where SALEPRICE < (select avg(saleprice) 
                    from orders o2 
                    where o1.custid = o2.custid
                    );
                    
select custid, avg(saleprice) from orders group by custid;                    

--14 도서 정가가 10000원 이하인 도서들의 판매액 합계,주문건수
select count(*), sum(o.SALEPRICE) from orders o, book b where b.bookid = o.bookid and b.price <= 10000 ;
select o.bookid, sum(o.SALEPRICE) from orders o, book b where b.bookid = o.bookid and b.price <= 10000 group by o.bookid;
--15 대한민국 거주 고객에게 판매한 도서의 총 판매액 
select sum(sALEPRICE) from orders o, customer c where o.custid = c.custid and c.address like '%대한민국%';

select sum(saleprice) from orders o where EXISTS (select * from customer c where address like '%대한민국%' and c.custid = o.custid);

--16 마당서점 고객별 판매액  (고객이름 고객별 판매액)
select (select name from customer c where c.custid = o.custid)name, sum(saleprice) from orders o group by o.custid;

------
alter table orders add bookname varchar2(40);

update orders
set bookname=(select bookname from book where book.bookid=orders.bookid);

--15.
alter table orders add name varchar2(40);

update orders
set name =(select name from customer where orders.custid=customer.custid);

--16. 고객번호가 2이하인 고객의 판매액 (고객이름 고객별 판매액 출력)
select o.custid, c.name, sum(o.saleprice) from orders o, customer c where c.custid = o.custid and c.custid<=2 group by o.custid, c.NAME;

select c.name, sum(o.saleprice) 
from (select custid, name from customer where custid <=2) c, orders o 
where c.custid = o.custid 
group by c.name;

--17. 3,4,5인 도서의 판매액 합계를 도서명과 출판사와 함께 출력
select b.bookname, b.publisher, sum(o.saleprice) from orders o, book b where o.bookid = b.bookid and b.bookid in(3, 4, 5) group by b.bookname, b.PUBLISHER;


alter table orders drop column name;
alter table orders drop column bookname;

--18.  고객별 주소와 주문액 합계 스칼라
select custid, (select address from customer c where c.custid = o.custid) "address", sum(saleprice) "total" from orders o group by o.custid;

-- 고객별 주문액 평균 고객이름 인라인뷰
select c.name, s
from (select custid, avg(saleprice)s from orders group by custid)o, customer c where c.custid=o.custid;

-- 고객번호 3이하인 고객의 주문액 합계 중첩질의
select sum(saleprice)"total" from orders o where exists (select * from customer c where custid <=3 and c.custid =o.custid);

--
CREATE view vw_Book
as select * from Book where bookname like '%축구%';

--대한미디어 출판사에서 출판한 도서를 구매한 고객의 이름 주소 전화번호 도서명으로 vw _pub이라는 뷰를 생성하시오
CREATE view vw_pub
as select c.name, c.address, c.phone, b.BOOKNAME from Book b, customer c, orders o where b.bookid=o.bookid and o.custid = c.custid and  publisher like '대한미디어';

select * from VW_CUSTOMER;

--
CREATE view vw_Orders(orderid, custid, name, bookid, bookname, saleprice, orderdate)
as select o.orderid, o.custid, c.name, o.bookid, b.BOOKNAME, o.saleprice, o.ORDERDATE from Book b, customer c, orders o where b.bookid=o.bookid and o.custid = c.custid;

--
create or replace view vw_customer(custid, name, address)
as select custid, name, address 
from customer 
where address like '%영국%';

drop view vw_pub;

select * from user_views;

--연습문제 8 -1 판매가격 20000원 이상인 도서의 도서번호 도서이름 출판사 판매가격을 보여주는 highorders 뷰 생성
create view vw_highorders(bookid, bookname, publisher, saleprice)
as select b.BOOKID, b.bookname, b.PUBLISHER, o.saleprice 
from book b, orders o
where b.bookid = o.bookid and o.SALEPRICE <= 20000;

--8-2
select bookname, name
from VW_highorders;
--8-3
create or replace view vw_highorders(bookid, bookname, name, publisher, saleprice)
as select b.BOOKID, b.bookname, c. name, b.PUBLISHER, o.saleprice 
from book b, orders o, customer c
where b.bookid = o.bookid and c.custid = o.custid and o.SALEPRICE >= 20000;

--인덱스
create  