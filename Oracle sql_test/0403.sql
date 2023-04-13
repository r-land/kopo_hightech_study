--1. book 테이블 내용검색
select * from book;
--2. book테이블 내용 도서명 순 검색
select * from book order by bookname;
--3. book 테이블 내용 가격 역순 검색
select * from book order by price DESC;
--4. 가격 13000원 이거나 8000원 
select * from book where price in(13000, 8000);
select * from book where price = 13000 or price = 8000;
--5. 도서가격이 8000,13000 빼고 검색 ;
select * from book where price not in(13000, 8000);
select * from book where not price = 13000 or price = 8000; 
select * from book where price = 13000 or not price = 8000; 
--6. 도서명에 여자라는 글자가 들어간 도서정보
select * from book where bookname like '%여자%';
--7.도서명에 여자라는 글자가 들어가지 않은 도서정보
select * from book where bookname not like '%여자%';
--8. 출판사명이 굿으로 시작하는 출판사에서 출간한 도서명과 출판사
select bookname, publisher from book where publisher like '굿%' ;
--9.출판사 개수
select publisher from book;
select distinct publisher FROM book;
select count(distinct publisher) from book; 
--10. 도서개수
select count(publisher) from book;
select count(*) from book;
--11. 고객의 수
select count(*) from customer;
--12.출판사명순으로 검색하되 출판사가 같으면 가격역순으로 도서정보
select * from book order by publisher, price desc;
--13. 도서의 가격역순으로 검색하되 같은 가격이면 도서명 순으로 검색
select * from book order by price desc, bookname;
--14. 주문한 도서의 판매 금액 총계
select sum(saleprice) from orders;
--15 도서 테이블 정가 총계 
select sum(price) from book;
--16 주문날짜 최근 것부터 검색하되 날짜가 같으면 가격 역순으로 주문정보검색
select * from orders order by orderdate desc, saleprice desc;
--17. 주문테이블에서 2번 고객이 주문한 건의 총 금액
select sum(saleprice) from orders where custid = 2; 
--18. 1번 도서 총 주문 금액과 건수, 최소 판매가 최대 판매가 총 금액 ;
select sum(saleprice), count(*), max(saleprice), min(saleprice) from orders where bookid=1;
select bookid, sum(saleprice), count(*), max(saleprice), min(saleprice) 
from orders where bookid=1 group by bookid;
-- 그룹함수와 함께 속성을 찍으려면 group by 사용 
--19. 고객별 주문 건수 
SELECT CUSTID, count(*) AS 고객별합계 FROM ORDERS GROUP BY CUSTID; 
--20. 도서별 주문건수 
select bookid, count(*) as 도서별건수 from orders group by bookid;
--21. 도서별 주문금액 합계를 구하되 도서 가격이 8000원 이상인 도서중 2건이상 판매된 도서
select bookid, sum(saleprice), count(*)
from orders 
where saleprice >= 8000
group by  bookid
having count(*) >=2
order by bookid;
--22. 고객과 고객의 주문에 관한 데이터를 모두 보이시오.
select * from customer, orders;
select * from customer c, orders o where c.custid=o.custid;
--23 도서와 주문 테이블 정보를 도서번호 순으로 검색
select * from book b, orders o where b.bookid=o.bookid order by b.bookid;
--24. 도서와 주문 테이블 정보중 도서번호,도서명,판매가,주문일을 검색하되 도서번호 순으로 검색
select b.bookid, b.bookname, saleprice, orderdate from book b, orders o 
where b.bookid=o.bookid order by b.bookid;
--25. 고객의 이름과 그 고객이 주문한 도서번호,도서판매가격,주문일을 검색하되 주문일 최근것 부터 나오게!
select c.name, o.bookid, saleprice, orderdate 
from orders o, customer c
where o.custid = c.custid
order by orderdate desc;
--26. 도서명 출판사 정가 판매가 주문한 고객번호 검색하되 판매가순
select o.CUSTID, bookname, publisher, price, o.SALEPRICE
from book b, orders o
where b.bookid = o.bookid
order by o.saleprice; 
--27. 고객별 주문금액 합계, 주문건수를 구하되 고객명과 함께 출력하고 고객명순으로
select c.custid, c.name, sum(o.saleprice), count(*) as 주문건수
from orders o, customer c 
where o.custid = c.custid
group by c.custid, name
order by c.name;
--28 도서별 주문금액 합계, 주문건수를 구하되 도서명과 함께 출력하고 도서명순으로
select b.BOOKID, bookname, sum(o.saleprice), COUNT(*) AS 주문건수
from orders o, book b
where o.bookid = b.bookid
group by b.bookid, b.bookname
order by b.BOOKNAME;
--29. book, customer, orders 테이블 다 출력
select *
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid;
--30. 고객명 고객주소 도서명 도서번호 주문일 판매가격 검색하되 고객번호순으로
select c.CUSTID, c.name, c.address, b.bookid, b.bookname, o.orderdate, o.saleprice
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid
order by c.CUSTID;
--31. 대한미디어 출간 도서 구매 고객의 이름 주소 전화번호 / 도서명 주문일 판매가격 출판사 출력하되 고객명순으로 
select c.name, c.address, c.PHONE, b.bookid, b.bookname, b.publisher, b.price, o.orderdate
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid and b.publisher = '대한미디어'
order by c.NAME;
--32 박지성 고객이 주문한 도서의 건수, 총 주문금액
select c.name, sum(o.SALEPRICE), count(*)
from customer c, orders o
where o.custid=c.custid and c.name = '박지성'
group by name;
--33. 야구를 부탁해 라는 도서를 주문한 고객의 정보
select c.*, BOOKNAME
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid and b.bookname = '야구를 부탁해';

SELECT C.*, BOOKNAME
FROM BOOK B INNER JOIN ORDERS O ON(B.BOOKID=O.BOOKID) 
INNER JOIN CUSTOMER C ON(C.CUSTID=O.CUSTID)
WHERE B.BOOKNAME = '야구를 부탁해';

--34.(내부조인) 야구를 부탁해라는 도서를 총 주문 건수와 판매금액 총액 검색
select sum(o.saleprice) as 야구부탁총액, count(*) as 야구부탁건수
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid and b.bookname = '야구를 부탁해';

select sum(o.saleprice) as 야구부탁총액, count(*) as 야구부탁건수
from book b INNER JOIN orders o ON(b.BOOKID=O.BOOKID)
where b.bookname = '야구를 부탁해';

--from 절에 customer c 라고 썼으면 select 에서도 c.custid 라고 해야지 customer.custid 안됨
--select문 처리 순서 : from > where> group by > having> select > order by
--select 사용한 속성명을 order by에 사용할때 그 순서에 따른 순서 사용 가능

--35. 모든 도서들의 주문 정보를 검색 (단,안팔린 도서도 포함)
SELECT *
FROM BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID);

SELECT *
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID(+);

--36. 모든 주문정보와 해당고객의 정보를 검색하되 도서정보도 포함 (고객 정보 없더라도 출력)
-- 해당 고객정보가 없더라도 출력, NULL로 채울 곳을 (+) 사용
SELECT *
FROM CUSTOMER C RIGHT OUTER JOIN ORDERS O ON(C.CUSTID = O.CUSTID);

--37. 이상미디어 출판사에서 출간한 도서의 도서정보 및 주문 정보를 검색하되 주문받지 못한 도서정보도 포함해서 출력
SELECT *
FROM  BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID)
WHERE B.PUBLISHER = '이상미디어';

SELECT * FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID(+) AND PUBLISHER = '이상미디어';


--38. 김연아 고객의 고객정보와 그 주문정보를 검색
SELECT *
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID = O.CUSTID)
WHERE C.NAME = '김연아';

--39. 가격이 13000원 도서정보와 그 도서의 주문정보를 검색하되 주문 받지 못한 도서에 대한 도서도 포함하여 출력
SELECT *
FROM BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID)
WHERE B.PRICE = 13000;
--40. 도서 정가 중 최고가 금액 : 35000
SELECT MAX(PRICE)
FROM BOOK;

--41. 도서 정가 중 최고가 도서 이름  : 골프바이블
SELECT BOOKNAME
FROM BOOK 
WHERE PRICE = 35000;

SELECT BOOKNAME, MAX(PRICE) FROM BOOK WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK)
GROUP BY BOOKNAME;

--42. 대한미디어 출판사에서 출간한 도서의 도서번호 : 3,4
SELECT BOOKID FROM BOOK 
WHERE PUBLISHER = '대한미디어';

--43. 대한미디어 출판사에 출간한 도서의 주문번호 검색 
SELECT ORDERID FROM BOOK B, ORDERS O WHERE B.BOOKID=O.BOOKID AND B.PUBLISHER = '대한미디어';
SELECT ORDERID FROM ORDERS WHERE BOOKID IN(3,4);
SELECT ORDERID FROM ORDERS WHERE BOOKID IN (SELECT BOOKID FROM BOOK WHERE PUBLISHER ='대한미디어');

--44. 도서를 구매한 고객의 번호 ; 1,1,2,3,4,1,4,3,2,3
SELECT CUSTID
FROM ORDERS; 

--45. 도서를 구매한 고객의 이름을 출력 
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);

SELECT DISTINCT NAME FROM CUSTOMER C, ORDERS O WHERE C.CUSTID=O.CUSTID;
SELECT DISTINCT NAME FROM CUSTOMER C INNER JOIN ORDERS O ON (C.CUSTID=O.CUSTID);

--46. 대한미디어 출판 도서 구매한 고객의 이름
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE BOOKID IN (SELECT BOOKID FROM BOOK WHERE PUBLISHER = '대한미디어'));

SELECT NAME
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID=O.CUSTID) INNER JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE PUBLISHER ='대한미디어';






















