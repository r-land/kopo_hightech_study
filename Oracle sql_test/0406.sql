--1. 도서정보
select * from book;
--2. 고객정보
select * from CUSTOMER;
--3. 주문정보
select * from ORDERS;
--4. 도서명, 출판사, 정가
select bookname, publisher, price from book;
--5. 고객명 전화 주소
select name, address, phone from customer;
--6. 주문번호 고객번호 도서번호 판매가
select orderid, custid, bookid, saleprice from orders;
--7. 이름이 장미란인 고객의 이름과 주소
select name, ADDRESS from customer where name = '장미란';
--8. 대한미디어 출판사에서 출간한 도서의 정보
select * from book where PUBLISHER ='대한미디어';
--9. 대한민국에 살고있는 고객의 이름,주소,전화번호
select name, ADDRESS, PHONE from CUSTOMER where address like '대한민국%';
--10. 가격이 10000원 미만이 도서명 정가 출판사 
select bookname, PRICE, PUBLISHER from book where price < 10000;
--11. 도서명에 피겨가 들어있는 도서명
select bookname from book where bookname like '%피겨%';
--12. 도서명에 축가가 들어있거나 야구가 들어있는 도서명
select bookname from book where bookname like '%축구%' or bookname like '%야구%';
--13. 주문한 고객들의 고객번호 출력 단 한번만
select DISTINCT custid from ORDERS;
--14 출판사명 출력
select publisher from book;
--15.출판사를 한번씩만 출력
select DISTINCT publisher from book;
--16. 주문받은 도서번호를 한번씩
select DISTINCT bookid from ORDERS;
--17.도서명이 축구의 역사이거나 정가가 20000원 미만인 도서정보
select * from book where (BOOKNAME = '축구의 역사') or (price < 20000) order by price;
--18. 출판사명이 스포츠로 끝나는 출판사명
select DISTINCT publisher from book where PUBLISHER like '%스포츠';
--19 판매가가 10000원에서 20000원 사이(포함) 주문정보
select * from orders where price >= 10000 and price <= 20000;
select * from orders where price between 10000 and 20000;
--20. 출판사가 삼성당,나무수가 아닌 출판사에서 출간된 도서명과 출판사
select bookname, publisher from book where publisher not in('삼성당','나무수');
select bookname, publisher from book where not publisher in ('삼성당','나무수');
select bookname, publisher from book where publisher != '삼성당' and publisher != '나무수';
--21. 고객의 성이 김씨인 고객정보
select * from CUSTOMER where NAME like '김%';
--22. 출판사 이름 중 두번째 글자가 상 인 출판사명과 도서명 
select publisher, bookname from BOOK where PUBLISHER like '_상%';
--23. 주문일이 14년07월05일부터 8일까지의 주문정보
select * from ORDERS where ORDERDATE BETWEEN '14/07/05' AND '14/07/08';
--24. 주문정보를 주문한 날짜순으로 정렬 
select * from ORDERS order by ORDERDATE;
--25. 주문정보를 판매가순 정렬 같은 가격이면 최근 주문한 날짜순
select * from ORDERS order by saleprice, ORDERDATE DESC;
--26 도서정보 검색 가격순 같은 가격이면 도서명순
select * from book order by price, bookname; 
--27. 도서정보 검색하되 출판사순 가격역순
select * from book order by publisher, price DESC;
--28. 모든 도서의 정가 총계
select sum(price) as "정가 총계" from book;
--29. 도서 주문 총 판매가 
select sum(saleprice) as "총 주문액" from orders;
--30.1번 고객이 주문한 도서의 총 주문액
select sum(saleprice) as "1번 고객 총액" from orders where CUSTID =1;
--31. 1번 도서 주문 금액 합계
select bookid, sum(saleprice) as "1번 도서 총액" from orders where bookid =1
group by BOOKID;
--32 모든 도서의 수
select COUNT(*) as 도서수 from book;
--33 모든 출판사수 
select count (DISTINCT publisher) as "출판사 수" from book;
--34. 모든 주문의 수
select COUNT(*) as 주문수 from orders;
--35. 모든 고객의 수 
select COUNT(*) as 고객수 from CUSTOMER;
--36. 주문액 평균 최고판매가 최소판매가 
select avg(saleprice) as 평균, max(saleprice) as 최고가, min(saleprice) as 최저가 from orders;
--37. 주문한 고객의 수 
select COUNT(distinct custid) as 주문고객수 
from orders;
--38. 고객별 주문건수, 주문액 합계
select custid, count(*), sum(saleprice)
from orders
group by CUSTID;
--39. 도서별 주문건수 주문액 합계 최고가 최저가
select bookid, count(*) as 주문수 , sum(saleprice) as 주문총액, max(saleprice) as 최고가, min(saleprice) as 최저가
from ORDERS
group by bookiD;
--40. 고객별 주문건수 주문액 합계 검색하되 주문건수 2건이상만 출력하고 주문건수 많은것부터
select custid, count(*) as 주문건수, sum(saleprice) as 주문액
from orders 
group by CUSTID
having count(*) >=2
order by 2 DESC;
--where 일반조건 having group의 집계함수조건 
--41. 도서별 주문건수 주문액 합계 검색하되 판매가가 10000원이상이고 주문건수 2건이상인것만 출력하되 주문액 합계적은것부터
select bookid, count(*) as 주문수 , sum(SALEPRICE) as 주문총액
from orders 
where saleprice >= 10000
group by bookiD
having  count(*) >=2
order by 3;



