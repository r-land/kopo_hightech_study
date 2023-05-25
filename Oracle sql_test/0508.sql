--abs함수 절대값 구하는 함수 
select abs(-78), abs(+78)
from dual;

--round 함수 반올림한 값
select round(4.875,1)
from dual;

select round(5678.875,-1)
from dual;

select round(5678.567,-2)
from dual;

--숫자 함수의 연산
select custid "고객번호", round(sum(saleprice)/count(*),-2) "평균금액"
from Orders
group by custid;

-- REPLACE 문자열을 치환하는 함수
select bookid, replace(bookname, '야구', '농구') bookname,publisher, price
from book; 

update book set bookname = replace(bookname, '야구', '농구'); 

select * from book;

rollback;

--length 글자 수 세어주는 함수 (단위가 바이트가 아닌 문자단위)
--한글 한자 3바이트 띄어쓰기 1바이트
select bookname "제목", lenth(bookname)"글자수",
lengthb(bookname)"바이트수"
from book
where publisher='굿스포츠';

--substr 지정한 길이만큼의 문자열을 반환하는 함수
select name, substr(name, length(name), 1) as "끝자"
from customer;


select substr(name, 1, 1) "성", count(*) "인원"
from customer
group by substr(name, 1, 1);

select substr(name, length(name), 1) as "끝자", count(*) as "인원수"
from customer
group by substr(name, length(name), 1);

--1. 고객의 이름 중 두번째 세번째 글자를 출력
select name, substr(name, 2, 2) as "두번째 세번째"
from customer;

--마당서점 주문일부터 10일 후 매출확정한다 각 주문의 확정일자를 구하시오
select orderid "주문번호", orderdate "주문일", orderdate+10 "확정", orderdate-1 "주문전날", sysdate "오늘", add_months(ORDERDATE,12) as "12개월 뒤", orderdate+365 "1년 뒤"
from orders;

select last_day(to_date('1989-08-12','yyyy-mm-dd'))
from dual;

select last_day(SYSDATE + 1)
from dual;

--to date
select TO_CHAR(orderdate,'mm-dd')
from orders;

select to_char(orderdate,'dy-dd-mm-yyyy') as 주문일
from orders;

select to_char(orderdate, 'day dy d')
from orders;

select to_char(sysdate,'yyyy"년"mm"월"dd"일" day am hh24:mi:ss') as "today"
from dual;

--7월 주문 
select *
from orders
where ORDERDATE like '14/07%'
order by orderdate;
--형식을 알아야 하므로 비추

select *
from ORDERS
where to_char(orderdate, 'yyyy-mm')='2014-07'
order by orderdate;

select *
from ORDERS
where orderdate between '20140701' and '20140731'
order by orderdate;

--
select sysdate,
      to_char(sysdate,'yyyy/mm/dd dy hh24:mi:ss') "sysdate_1"
from dual;

--내장함수 연습문제
--절대값 
--15
select abs(-15)
from dual;

--올림 주어진 숫자보다 크거나 같은 정수 중 최소값
-- 16
select CEIL(7.2)
from dual;

--코사인값
-- -0.99999999999647923060461239250850048324
select cos(3.14159)
from dual;

--버림  주어진 숫자보다 작거나 같은 정수 중 최대값
-- 15
select FLOOR(8.9)
from dual;

--LOG
-- 2
select LOG(10,100)
from dual;

-- 나머지 
-- 3
select MOD(11,4)
from dual;

--제곱값
-- 9
select POWER(3,2)
from dual;

-- 반올림 
--16
select ROUND(15.7)
from dual;

--주어진 값의 음수 정수 0 여부를 반환
-- -1
select SIGN(-3.5)
from dual;

--버림
-- 15
select TRUNC(15.7)
from dual;

--아스키코드
--C
select CHR(67)
from dual;

-- 문자열 연결
--HAPPY Birthday
select CONCAT('HAPPY ', 'Birthday')
from dual;

--소문자
--birthday
select LOWER('Birthday')
from dual;

--lpad(char1,n,char2) 함수는 지정된 길이 n에서 문자 char1으로 채우고 남은 공간은 왼쪽부터 char2로 채워서 출력한다.
--*.*.*.*.*Page 1
select LPAD('Page 1', 15, '*.')
from dual;

--LTRIM (문자열, 문자) 좌측부터 특정문자와 일치하는 문자를 제거하고 출력
--ge 1
select LTRIM('Page 1', 'Pa')
from dual;

--첫번째 지정한 문자를 두번째 지정한 문자로 바꿔준다
--BLACK
select REPLACE('JACK', 'J', 'BL')
from dual;

--왼쪽 정렬 후 오른쪽 생긴 빈 공백에 특정 문자를 채워 반환
--Page 1*.*.*.*.*
select RPAD('Page 1', 15, '*.')
from dual;

--오른쪽의 공백 문자 삭제
--Page 1
select RTRIM('Page 1', 'ae')
from dual;

--시작위치부터 선택개수만큼 문자반환
--CDEF
select SUBSTR('ABCDEFG', 3, 4)
from dual;

--문자열 공백 문자 삭제
--AA00
--leading 0 왼쪽 0 trailing 0 오른쪽 0 제거
select TRIM(LEADING 0 FROM '00AA00')
from dual;

--대문자
--BIRTHDAY
select UPPER('Birthday')
from dual;

--지정된 문자 ASCII값을 반환
--65
select ASCII('A')
from dual;

--특정문자 위치 반환
--14
select INSTR('CORPORATE FLOOR','OR', 3, 2)
from dual;

--문자열 길이 반환
--8
select LENGTH('Birthday')
from dual;

--주어진 일자에 개월 단위의 가감을 하여 반환한다.
--14/06/21
select ADD_MONTHS('14/05/21', 1)
from dual;

--주어진 일자가 포함된 월의 말을을 반환
--23/05/31
select LAST_DAY(SYSDATE)
from dual;

--주어진 일자가 다음에 나타나는 지정요일의 날짜를 반환??
select NEXT_DAY(SYSDATE, '화')
from dual;

--오전 12 넘으면 다음날
--23/05/08
select ROUND(SYSDATE)
from dual;

--today 날짜를 문자로
--23/05/08
select SYSDATE
from dual;

--숫자를 문자로 추출가능
--23/05/08
select TO_CHAR(SYSDATE)
from dual;

--123
select TO_CHAR(123)
from dual;

--14/05/12
select TO_DATE('12 05 2014', 'DD MM YYYY')
from dual;

--문자를 숫자로 연산가능
--12.3
select TO_NUMBER('12.3')
from dual;

--(컬럼, 조건1, 결과1, 조건2, 결과2, default_result)
--aa
select DECODE(1,1,'aa','bb')
from dual;

--2개 값 같으면 null, 다르면 첫번째 값
--123
select NULLIF(123, 345)
from dual;

--null이면 지정값
select NVL(NULL, 123)
from dual;

--도서정가 10%인상
select bookname, price, price*1.1
from book;

update book set PRICE = price*1.1;

--도서정가 20%인상 출판사 대한미디어 변경하되 도서번호가 5번 이상인 도서에 대해서 수행하기
update book set price = price*1.2, PUBLISHER = '대한미디어'
where BOOKID >= 5;

select * from book;

ROLLBACK;

select name "이름", nvl(phone, '연락처없음') "전화번호"
from customer;

select rownum"순번", custid, name, phone
from customer;

select rownum"순번", custid, name, phone
from customer
where rownum<=2;

--전체
select * from book;
--1~5 차례로 자르기
select * from book where rownum <=5;
--자르고 정렬
select * from book where rownum <=5 order by price;
--정렬후 자르기
select * from (select * from book order by price)b where rownum <=5;
--자르고 정렬
select * from (select * from book where rownum <=5)b order by price;
--자르고 정렬
select * from (select * from book where rownum <=5 order by price)b ;

select * from book where rownum <=5 order by price desc;

select * from (select * from orders order by orders.SALEPRICE)book  where rownum <=3;

select * from (select * from orders order by orderdate desc) where rownum <=4;

select * from (select * from book where publisher = '대한미디어' order by price desc) where rownum <=2;

select * from (select * from book order by price desc)
where publicher ='대한미디어' and rownum <=2;

select sum(saleprice)
from orders
where custid = (select custid from customer where name='박지성');

select orderid, saleprice
from orders
where saleprice <=(select avg(SALEPRICE) from orders);

select orderid, custid, saleprice
from orders md 
where saleprice >(select avg(saleprice) from ordres so where md.custid=so.custid);

select sum(saleprice) "total"
from orders
where custid in(select custid from customer where address like '%대한민국%');

select sum(o.saleprice) "total"
from orders o, customer c
where o.custid = c.custid and c.ADDRESS like '%대한민국%';

select sum(saleprice)
from customer natural join orders
where address like '%대한민국%';

select sum(saleprice)
from customer join orders using(custid)
where address like '%대한민국%';
--using은 소속 안밝히고 공통된것 써준다

select sum(saleprice) 
from customer c join orders o on(c.custid=o.custid)
where address like '%대한민국%';
--23-1 join using
select *
from customer join orders using(custid) join book using(bookid)
where publisher like '%대한미디어%';
--23-2 natural join
select *
from customer natural join orders NATURAL join book
where publisher like '%대한미디어%';
--23-3 join on
select *
from customer c join orders o on(c.custid=o.custid) join book b on(b.bookid=o.bookid)
where publisher like '%대한미디어%';

--24 중첩질의문
SELECT *
FROM customer 
WHERE custid in
    (select custid 
    from orders 
    where bookid in( select bookid
                       FROM book
                        WHERE publisher LIKE '%대한미디어%'));
                        
--25.
select orderid, saleprice 
from orders
where saleprice > all(select saleprice
                  from orders
                  where custid='3');
                  
select orderid, saleprice 
from orders
where saleprice > (select max(saleprice)
                  from orders
                  where custid='3');
                  
select sum(saleprice) "total"
from orders od
where exists (select *
              from customer cs
              where address like '%대한민국%' and cs.custid = od.custid);

select saleprice
from orders
where custid=3;

select sum(saleprice) "total"
from orders od
where exists (select *
              from customer cs
              where cs.ADDRESS like '%대한민국%' and cs.custid=od.custid);
              
select sum(saleprice) "total"
from orders od
where exists (select *
              from customer cs
              where cs.ADDRESS like '%대한민국%');

select (select name
        from customer cs
        where cs.custid=od.custid) "name",sum(saleprice) "total"
from orders od
group by od.custid;

select (select b.bookname
        from book b
        where b.bookid=o.bookid) "name",
        (select publisher from book b where b.bookid=o.bookid) publisher,
        sum(saleprice) "total"
from orders o
group by bookid;
