--1. 주문된 도서명 
SELECT b.bookname
from orders o, book b
WHERE b.bookid= o.bookid;
--2. 도서별 주문 권수
select bookid, count(*)
from orders
group by bookid;
--3. 고객별 주문액 합계
select custid, sum(saleprice) as 주문액
from ORDERS
group by custid;
--4. 주문되지 않은 도서번호
select b.bookid
from book b left outer JOIN orders o ON(b.bookid=O.bookid)
where o.bookid is null;
--5. 주문되지 않은 도서명
select b.bookname
from book b left outer JOIN orders o ON(b.bookid=O.bookid)
where o.bookid is null;
--6.도서가격과 판매가 차이
SELECT b.price-o.saleprice as 차액
from orders o, book b
WHERE b.bookid= o.bookid;
--7.도서가격과 판매가 차이 중 가장 차이가 많이 나는 도서정보
SELECT max(b.price-o.saleprice) as 최대차액
from orders o, book b
WHERE b.bookid= o.bookid;
