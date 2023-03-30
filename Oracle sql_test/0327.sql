--1. 축구의역사의 출판사와 가격
select publisher, price from book where bookname like '축구의 역사';
--2. 출판사 별로 몇 권의 책을 출간했나 
select publisher, count(*) from book GROUP BY publisher;
--3. 출판사 별로 몇 권의 책을 출간했나(단 2권이상 출간한 정보만) 
select publisher, count(*) from book group by PUBLISHER HAVING COUNT(*) >=2;
--4. 3번 내용을 출판사 이름 순으로  !
select publisher, COUNT(*) from book GROUP BY PUBLISHER HAVING COUNT(*) >=2 
ORDER BY PUBLISHER;
--5 4번 내용 도서가격 10000원이상인것만!
select publisher, COUNT(*) from book WHERE price >=10000 GROUP BY PUBLISHER 
HAVING COUNT(*) >=2 ORDER BY PUBLISHER;
--6 고객의 이름과 주소 출력
select name, address from customer;
--7 고객의 이름과 주소와 전화번호 출력
select name, address, phone from customer;
--8.주문번호 고객번호 도서번호 출력
select orderid, custid, bookid from orders;
--9.도서명 정가 출판사
select bookname, price, PUBLISHER from book;
--10.고객번호,도서번호,판매가,주문일
select custid, bookid, saleprice, orderdate from orders;
--11. 출판사,도서명
SELECT publisher, bookname from book;
--12. 주문된 도서번호
SELECT bookid from orders;
--13. 주문된 도서번호 중복없이 
SELECT DISTINCT bookid from orders;
--14. 도서번호가 5번에서 8번까지의 도서정보(*)
SELECT * FROM BOOK WHERE BOOKID BETWEEN 5 AND 8;
--15. 도서번호가 1~4번까지 , 7~10까지의 도서정보
SELECT * FROM BOOK WHERE (BOOKID BETWEEN 1 AND 4) OR (BOOKID BETWEEN 7 AND 10);
SELECT * FROM BOOK WHERE BOOKID IN (1,2,3,4,7,8,9,10);
SELECT * FROM BOOK WHERE BOOKID NOT IN (5,6);
SELECT * FROM BOOK WHERE NOT BOOKID IN (5,6);
SELECT * FROM BOOK WHERE (BOOKID >=1 AND BOOKID <=4) OR  (BOOKID >=7 AND BOOKID <=10);
--16. 가격이 8000이상인 도서명과 출판사
SELECT bookname, publisher from book where price >=8000;
--17. 고객번호가 3,4인 고객명과 고객번호,전화번호
select name, custid, phone from customer where custid in (3,4);
--18. 판매가가 10000원 이상인 도서번호, 판매가, 주문일
select BOOKID, saleprice, orderdate from orders where price >=10000;
--19. 출판사 명에 스포츠라는 단어가 들어간 도서정보
select * from book where PUBLISHER like '%스포츠%';
--20. 출판사명에 두번째 글자가 '한'이라는 글자가 들어가 도서명,출판사명, 정가
select bookname, publisher, price from book where PUBLISHER like '_한%';
--21. 도서명에 야구로 시작하는 도서정보
select * from book where bookname like '야구%';
--22.굿스포츠 와 대한미디어 출판사에서 출간한 도서정보
select * from book where PUBLISHER in('굿스포츠', '대한미디어');
select * from book where PUBLISHER = '굿스포츠' OR PUBLISHER = '대한미디어';
--23. 굿스포츠에서 출간했고 도서정가가 10000원 미만인 도서정보
select * from book where PUBLISHER like '굿스포츠' AND price < 10000;
--24. 출판사명 순으로 도서정보 검색
select * from book order by PUBLISHER;
--25. 가격순으로 하되 같은 가격이면 도서명 순으로 도서정보 검색
SELECT * FROM BOOK ORDER BY PRICE, BOOKNAME;
--26. 가격역순(DESC) 정렬하되 같은가격이면 출판사순으로 도서정보
SELECT * FROM BOOK ORDER BY PRICE DESC, PUBLISHER ASC;
--27. 주문받은 모든 도서의 판매가격 합계를 출력하되 별칭을 써서 [총매출]
SELECT SUM(SALEPRICE) AS 총매출 FROM ORDERS;
--28. 도서의 수
SELECT COUNT(*) AS 도서수 FROM BOOK;
--29. 고객의 수
SELECT COUNT(*) AS 고객수 FROM CUSTOMER;
--30. 주문받은 건수
SELECT COUNT(*) AS 주문수 FROM ORDERS;
--31. 주문받은 도서번호
SELECT BOOKID FROM ORDERS;
--32. 주문받은 도서번호를 중복 제거하고
SELECT DISTINCT BOOKID FROM ORDERS;
--33. 1번 책을 주문한 고객번호
SELECT CUSTID FROM ORDERS WHERE BOOKID = 1;
--34.총 판매액, 총 판매 건수, 최저 판매가, 최고 판매가
SELECT SUM(SALEPRICE) AS 총판매액, COUNT(*) AS 총건수, MIN(SALEPRICE) AS 최저가, 
MAX(SALEPRICE) AS 최고가 FROM ORDERS;
--35. 고객별 주문금액 합계
SELECT CUSTID, SUM(SALEPRICE) AS 고객별합계 FROM ORDERS GROUP BY CUSTID; 
--36. 주문날짜별 주문금액 합계 주문건수
SELECT orderdate, SUM(saleprice), count(*) from orders group by orderdate;
--37. 판매가격이 5000원 이상인 도서를 구매한 고객에 대해 고객별 주문도서 수
select custid, count(*) as 주문수 from orders where SALEPRICE >=5000 GROUP BY custid;
--38. 37번 문제에 추가로 두권이상 구매한 고객만!
select custid, count(*) as 주문수 from orders where SALEPRICE >=5000 GROUP BY custid HAVING COUNT(*) >=2;
--39.출판사별 출간한 도서수
select publisher, count(*) as 도서수 from book group by publisher;
--40. 고객별 구매건수 
select custid, count(*) as 구매수 from orders group by custid;
--41. 도서별 주문건수
select bookid, count(*) as 주문수 from orders GROUP BY bookid;
--42. 주문날짜가 14년 7월 1일 주문정보
select * from orders where orderdate = '14/07/01';
--43. 주문날짜가 14년 7월 1일~3일 주문정보
select * from orders where orderdate between '14/07/01' and '14/07/03';
--44. 도서번호가 1인 도서의 이름
select bookname from book where bookid =1;
--45. 가격이 20,000원 이상인 도서의 이름
select bookname from book where price >= 20000;
--46. 박지성의 총 구매액(박지성의 고객번호는 1번으로 놓고 작성)
select sum(saleprice) as "박지성 총액" from ORDERS where custid = 1;
--47. 박지성이 구매한 도서의 수(박지성의 고객번호는 1번으로 놓고 작성)
select count(*) as "박지성 도서수" from ORDERS where custid = 1;
--49. 마당서점 도서의 총 개수
select count(*) from book;
--50. 마당서점에 도서를 출고하는 출판사의 총 개수
select DISTINCT count(PUBLISHER) from book;
--51. 모든 고객의 이름, 주소
select name, address from CUSTOMER;
--52. 2014년 7월 4일~7월 7일 사이에 주문 받은 도서의 주문번호
select orderid from orders where orderdate between '14/07/04' and '14/07/07';
--53. 2014년 7월 4일~7월 7일 사이에 주문 받은 도서를 제외한 도서의 주문번호
select orderid from orders where orderdate not between '14/07/04' and '14/07/07';
select orderid from orders where not orderdate between '14/07/04' and '14/07/07';
--54. 성이 ‘김’ 씨인 고객의 이름과 주소
select name, address from customer where name like '김%';
--55. 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
select name, address from customer where name like '김_아';




