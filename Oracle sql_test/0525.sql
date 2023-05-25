--1 사용자가 만든 뷰들 
select * from user_views;

--2 인덱스 생성
create index ix_book on book(bookname);

--3.
create index ix_book2 on book(publisher, price);

--4 리빌드 재구성  수정 변경 삭제 될때 적용할때 
alter index ix_book rebuild;

--5 인덱스 삭제
drop index ix_book;
drop index ix_book2;

--16(1)
select name from customer where name like '박세리';

--16(3)
create index ix_cust on customer(name);

--16(5)
drop index ix_cust;
