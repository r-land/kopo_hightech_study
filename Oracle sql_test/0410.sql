--1.도서번호 1번이 아닌 도서의 이름
select bookid, bookname from book where bookid != 1;
--2. 가격이 10000원 미만인 도서명,출판사
select bookname, publisher from book where PRICE < 10000;
--3. 김연아(고객번호2번)의 구매액 / 테이블1개이용(고객번호로)/ 테이블2개이용(이름으로)
select sum(saleprice) as "김연아 구매액" from orders where custid =2;
select c.name, sum(o.SALEPRICE)
from customer c, orders o
where o.custid=c.custid and c.name = '김연아'
group by name;
--4. 김연아가 구매한 도서의 수와 주문액 합계
select count(*) as "김연아 도서수", sum(saleprice) as "주문액" from orders where custid =2;
select c.name, sum(o.SALEPRICE), count(*)
from customer c, orders o
where o.custid=c.custid and c.name = '김연아'
group by name;
--5. 마당서점 도서 총 개수 
select count(*) as "도서 총 수" from book;
--6. 마당서점 출판사 총 개수
select count(distinct publisher) as "출판사 수" from book;
--7. 주문건수
select count(*) as "주문건수" from orders;
--8. 주문한 고객 수 
select count(distinct custid) as "주문 고객수" from orders;
--9. 2014년 7월 1일부터 3일 까지 주문액 합계
select sum(saleprice) from orders where orderdate between '14/07/01' and '14/07/03';
--10.성이 김씨인 고객의 이름과 주소
select name, address from CUSTOMER where NAME like '김%';
--------------------------------------------------------------------------------

--1. 김연아 주문 일자는
select o.orderdate as "김연아 주문일"
FROM orders o, customer c
where o.custid = c.custid and c.name = '김연아';

--2. 모든 도서 주문 정보 안팔린 도서까지 
SELECT *
FROM BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID);

--3.Olympic Champions라는 도서 총 주문 건수와 판매금액 총액 주문일자 검색
select count(*) as 주문건수, SUM(o.SALEPRICE) as 판매총액, o.orderdate
FROM ORDERS O, CUSTOMER C, BOOK B
WHERE B.BOOKID = O.BOOKID AND O.CUSTID =C.CUSTID AND B.BOOKNAME = 'Olympic Champions'
group by o.orderdate;

SELECT count(*) as 주문건수, SUM(o.SALEPRICE) as 판매총액, o.orderdate
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID=O.CUSTID) INNER JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE BOOKNAME = 'Olympic Champions'
group by o.orderdate;

--4. 도서 구매한 고객이름
select distinct c.name
from orders o, customer c
where O.custid = c.custid;

SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);

--5. Pearson 출판사의 도서 구매한 고객이름
SELECT c.NAME
from customer c, orders o, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and b.PUBLISHER ='Pearson'; 

SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE BOOKID IN (SELECT BOOKID FROM BOOK WHERE PUBLISHER = 'Pearson'));

SELECT c.NAME
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID=O.CUSTID) INNER JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE PUBLISHER ='Pearson';

--------------------------------------------------------------------------------
--11. 주문을 한 모든 고객 정보와 주문정보 출력 
select *
FROM customer c inner JOIN ORDERS O ON(C.CUSTID=O.CUSTID);

--12. 판매된 모든 도서정보와 주문정보 출력
SELECT *
FROM BOOK B JOIN ORDERS O ON(B.BOOKID = O.BOOKID);

select *
from book b, orders o
where b.bookid = o.bookid;

--13. 도서명별 주문액 합계
select b.bookname, sum(saleprice)
FROM BOOK B JOIN ORDERS O ON(B.BOOKID = O.BOOKID)
group by b.bookname;

--14. 고객번호 별 주문액 합계
select c.custid, sum(saleprice) 
FROM customer c inner JOIN ORDERS O ON(C.CUSTID=O.CUSTID)
group by c.custid;

--15.고객명별 주문액 합계, 최소 판매가, 최대판매가 ,주문건수
select c.name, sum(saleprice), min(saleprice), max(saleprice), count(*) as 주문건수 
FROM customer c inner JOIN ORDERS O ON(C.CUSTID=O.CUSTID)
group by c.name;

--16.판매가가 10000원 이상인 도서를 주문한 고객명 판매가 도서명
select c.name, b.bookname, O.SALEPRICE
FROM customer c, orders o, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and saleprice >= 10000;

select name, bookname, SALEPRICE
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID=O.CUSTID) INNER JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE saleprice >= 10000;

--17. 구매하지 않은 고객 포함 고객명 주문번호 판매가
select c.name, O.ORDERID, O.SALEPRICE
FROM customer c left outer JOIN ORDERS O ON(C.CUSTID=O.CUSTID);

select name orderid, saleprice
from CUSTOMER c, orders o
where c.custid = o.custid(+);

--18. 정가가 가장 싼 도서를 구매한 고객번호
SELECT o.custid, price
FROM orders o, book b
WHERE O.BOOKID = B.BOOKID and price = (select min(price) from book);

select custid 
from orders where bookid in(select bookid from book where price = (select min(price) from book);

--19. 정가가 가장 싼 도서를 구매한 고객명
SELECT c.name
FROM orders o, book b, CUSTOMER c
WHERE O.BOOKID = B.BOOKID and o.custid = c.custid and price = (select min(price) from book);

select name
from orders o join customer c on (o.custid = c.custid)
where o.bookid in(select bookid from book where price = (select min(price) from book));

--20. 도서를 구매하지 않은 고객이름
select c.name
FROM customer c left outer JOIN ORDERS O ON(C.CUSTID=O.CUSTID)
where O.ORDERID is null;

select name
from customer
where custid not in (select custid from orders);

--21. 나무수 출판사의 도서를 구매한 고객이름
SELECT NAME
from customer c, orders o, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and b.PUBLISHER ='나무수'; 

SELECT NAME
FROM CUSTOMER C JOIN ORDERS O ON(C.CUSTID=O.CUSTID) JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE  b.PUBLISHER ='나무수'; 

--대한민국 주문한 주문의 개수 
select count(*) as "총 주문건수"
from orders o, customer c
where o.custid = c.custid and c.address like '%대한민국%';

select count(*) as "총 주문건수"
from orders o join customer c on(o.custid = c.custid)
where like '%대한민국%';


select count(*) as "총 주문건수(건)"
from orders
where custid in
(
select custid
from CUSTOMER
where address like '%대한민국%'
);

--22.출판사별로 출판사의 평균 도서 가격보다 비싼 도서 (상관부속질의)
select b1.bookname
from book b1
where b1.price > (select avg(b2.price)
                  from book b2
                  where b2.publisher = b1.publisher);
--23. 고객별로 고객의 평균 주문액 보다 비싼 주문액의 도서번호 출력 (서브쿼리)
select o1.CUSTID, o1.BOOKID
from orders o1 join customer c on o1.custid=c.custid
where o1.saleprice > (select avg(o2.saleprice)
                       from orders o2
                       where o1.custid = o2.custid)
group by o1.CUSTID, o1.BOOKID
order by o1.custid;
                  
--고객별 평균 주문액                
select custid, avg(saleprice)
from orders
group by custid
order by custid;

--28.도서별 평균 판매가보다 더 작은 판매가에 해당되는 도서번호 고객번호 판매가 출력
select bookname, o1.CUSTID, o1.BOOKID, o1.saleprice
from orders o1 join book b on o1.bookid=b.bookid
where o1.saleprice < (select avg(o2.saleprice)
                       from orders o2
                       where o1.bookid = o2.bookid);


--도서별 평균 주문액                
select bookid, avg(saleprice)
from orders
group by bookid
order by bookid;

--29. 주문하지 않은 고객의 이름
select name
from customer
minus
select name
from customer
where custid in (select custid from orders);

--30. 주문이 있는 고객의 이름과 주소를 보이시오
select name, address
from customer cs
where exists (select * from orders od);

select name, address
from customer cs
where exists (select * from orders od
              where cs.custid = od.custid);
              
select name, address
from customer cs
where exists (select * from orders od
              where orderid =1);
              
select name, address
from customer cs
where exists (select * from orders od
              where custid =1);
            
select name, address
from customer cs
where exists (select * from orders od
              where bookid =1);
              
select name, address
from customer cs
where exists (select * from orders od
              where custid = 5);
              
--31. 주문받은 도서정보 출력
select *
from book b
where exists (select * from orders od
              where b.bookid = od.bookid);

--32. 박지성이 구매한 도서의 출판사 수 
select count(distinct publisher) as "박지성 출판사 수"
from orders o, customer c, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and name = '박지성';

--33. 박지성 구매한 도서의 이름, 가격, 정가와 판매가격 차이
select b.bookname, B.PRICE, (b.price - o.saleprice)as 차액
from orders o, customer c, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and name = '박지성';

--34. 박지성이 구매하지 않은 도서의 이름
select b.bookname
FROM customer c, orders o, book b
minus
select b.bookname
FROM customer c, orders o, book b
where c.custid=o.custid and b.bookid= o.bookid and name = '박지성';

--35. 주문하지 않은 고객의 이름
select name
from CUSTOMER
where custid not in (select custid from orders); 

--36. 주문금액 총액과 주문의 평균금액
select sum(saleprice), avg(saleprice)
from orders;

--37. 고객의 이름과 고객별 구매액
select c.name, c.custid, sum(O.SALEPRICE)  
from customer c, orders o
WHERE O.CUSTID = C.CUSTID
group by  c.name, c.custid;

--38.고객의 이름과 고객이 구매한 도서 목록
select DISTINCT c.name, B.BOOKNAME  
from customer c, BOOK B, ORDERS O
WHERE c.custid=o.custid and b.bookid= o.bookid 
GROUP BY C.NAME, B.BOOKNAME
ORDER BY C.NAME;

--39. 도서의 가격(BOOK테이블)과 판매가격(ORDERS테이블)의 차이가 가장 많은 주문
SELECT MAX(PRICE-SALEPRICE)
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID;

--40. 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
select c.name 
from customer c, orders o
where c.custid=o.custid 
group by c.name
having avg(saleprice) > (select avg(saleprice) from orders);





