--1 축구의 역사 의 출판사 가격
select publisher, price from book WHERE bookname Like '축구의 역사';
--2 대한미디어 출판사 책
SELECT bookname from book where publisher like '대한미디어';
--3 만원이하 책
select * from book where price <= 10000;
--4 김연아 고객 전화번호
SELECT phone FROM Customer WHere NAME='김연아';
--5 김연아 고객 주소
SELECT address FROM Customer WHere NAME='김연아';
-- 6 김연아 박지성 둘다 
SELECT address FROM Customer WHere NAME='김연아' or name='박지성';
select address from customer where name in('김연아','박지성');
--7 만원이상 책이름 출판사
select bookname,publisher from book where price>=10000;
--8 출판사 출력
select distinct publisher from book;
--9 all -생략가능
select all publisher from book;
--10 출판사 순으로 도서정보검색
select * from book order by publisher;
--11 출판사순 가격순 도서정보
select * from book order by publisher, price; 
--12 출판사순 가격순 도서명순 도서정보
select * from book order by publisher, price, bookname; 
--13 모든 도서 정보를 출력
select * from book;
--14 도서명과 가격 검색
SELECT BOOKNAME,PRICE FROM BOOK;
--15 도서명 출판사 검색
SELECT BOOKNAME, PUBLISHER FROM BOOK;
--16 출판사명을 한번씩만 검색
select DISTINCT publisher from book;
--17 대한미디어 출판사의 도서명 검색
select bookname from book where publisher like '대한미디어';
--18 가격이 20000원 이상인 도서명 가격검색
select bookname, price from book where price >=20000;
--19 가격이 만원 이상 이만원 이하 도서정보
select * from book where price BETWEEN 10000 and 20000;
select * from book where price >= 10000 and price <= 20000;
--20 가격이 만원 이만원 삼만원 도서정보
select * from book where price =10000 or price =20000 or price =30000;
select * from book where price In(10000,20000,30000);
--21 가격이 null인 도서정보
select * from book where price is null;
--22 가격이 이만원 미만인 도서정보
select * from book where price < 20000;
--23 도서가격이 20000미만이고 도서명이 축구의 역사인 도서 정보
select * from book where (price <20000) and (BOOKNAME like'축구의 역사');
--24 도서가격 20000미만이거나 도서명이 축구의 역사 도서정보
select * from book where (price <20000) or (BOOKNAME like'축구의 역사');
--25 출판사 굿스포츠와 삼성당에서 나온 도서명과 출판사
select bookname,publisher from book where PUBLISHER in('굿스포츠','삼성당');
--26 출판사 굿스포츠 삼성당 아닌 출판사에서 나온 도서명과 출판사
select bookname,publisher from book WHERE PUBLISHER not in('굿스포츠','삼성당');
--27 도서가격이 정해진 도서정보검색
select * from book where price is not null;
select * from book where not price is null;
--28 도서가격 10000미만, 20000초과 도서정보
select * from book where price < 10000 or price >20000;
select * from book where price not between 10000 and 20000;
select * from book where not price between 10000 and 20000;
--29 도서가격 20000인 도서정보 
select * from book where price =20000;
--30도서가격 20000 아닌 도서정보
select * from book where price not in(20000);
select * from book where NOT price =20000;
select * from book where price not =20000; ---x
--31 '축구의 역사'를 출간한 출판사
select publisher from book where bookname like '축구의 역사';
select publisher from book where bookname = '축구의 역사';
--32 도서명에 '축구'가 포함된 출판사 %---% zero or more >없거나 많거나
select publisher from book where bookname like '%축구%';
--33 오늘 날짜 정보 확인 > 결과 개수 :1
select sysdate from dual;
--34 오늘 날짜 정보확인 > 결과 개수 : 10
select sysdate from book;
--35 도서명이 '축구'로 시작하는 도서명 출력
select bookname from book where bookname like '축구%';
--36 출판사명 대한으로 시작하는 출판사에서 출간한 도서명과 출판사명
select bookname,publisher from book where publisher like '대한%';
--37 도서명 두번째 글자 '구'인 도서명 검색         글자 한자:_
select bookname from book where bookname like '_구%';
--38 축구에 관한 도서 중 가격이 20000원 이상인 도서정보
select * from book where (bookname like '%축구%') and (price >=20000);
--39 도서명 순으로 도서정보 검색 (order by)
select * from book order by bookname;
--40 출판사 순 검색 같은 출판사면 도서명 순으로 도서정보
select * from book order by publisher, bookname;
--41 도서가격순 검색 같은 가격이면 도서명 순으로 검색
select * from book order by PRICE, BOOKNAME;
--42 도서를 가격의 내림차순 검색
SELECT * FROM BOOK ORDER BY PRICE DESC;
--43 도서를 가격의 내림차순 검색하되 같은가격인 도서는 출판사명 순으로 도서정보
SELECT * FROM BOOK ORDER BY PRICE DESC, PUBLISHER;
--44 고객이 주문한 도서의 판매액을 구하세요
SELECT SALEPRICE FROM ORDERS;
--45 고객이 주문한 도서의 총 판매액을 구하세요
SELECT SUM(SALEPRICE) FROM ORDERS;
--46 주문도서의 평균 판매액
SELECT AVG(SALEPRICE) FROM ORDERS;
--47 주문도서의 최고 판매액 
SELECT max(SALEPRICE) FROM ORDERS;
--48 주문도서의 최저 판매액 
SELECT min(SALEPRICE) FROM ORDERS;
--49 2번 김연아 고객이 주문한 도서의 총 판매액을 구하시오 --별칭:ALIAS AS "띄어쓰기가능"
select sum(saleprice) 총매출 from orders where custid=2;
select sum(saleprice) as 총매출 from orders where custid=2;
select sum(saleprice) as "총 매출" from orders where custid=2;
--50 고객이 주문한 도서의 총 판매액, 평균값, 최저값, 최고값
SELECT SUM(saleprice) AS TOTAL, AVG(saleprice) AS AVERAGE, MAX(saleprice) AS MAXIMUM, MIN(saleprice) AS MiNIMUM FROM ORDERS;
--51 도서 주문 건수
SELECT COUNT(*) FROM ORDERS;
--52 고객의 수
SELECT COUNT(*) FROM CUSTOMER;
--53 도서의 수
SELECT COUNT(*) FROM BOOK;
--54 출판사의 수
SELECT COUNT(DISTINCT publisher) FROM BOOK;
--55 도서정가가 13000인 도서의 수
SELECT COUNT(*) 권수 FROM BOOK WHERE PRICE = 13000;
SELECT COUNT(*) AS 권수 FROM BOOK WHERE PRICE = 13000;
SELECT COUNT(*) AS "권수" FROM BOOK WHERE PRICE = 13000;