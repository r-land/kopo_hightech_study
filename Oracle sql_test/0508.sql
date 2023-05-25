--abs�Լ� ���밪 ���ϴ� �Լ� 
select abs(-78), abs(+78)
from dual;

--round �Լ� �ݿø��� ��
select round(4.875,1)
from dual;

select round(5678.875,-1)
from dual;

select round(5678.567,-2)
from dual;

--���� �Լ��� ����
select custid "����ȣ", round(sum(saleprice)/count(*),-2) "��ձݾ�"
from Orders
group by custid;

-- REPLACE ���ڿ��� ġȯ�ϴ� �Լ�
select bookid, replace(bookname, '�߱�', '��') bookname,publisher, price
from book; 

update book set bookname = replace(bookname, '�߱�', '��'); 

select * from book;

rollback;

--length ���� �� �����ִ� �Լ� (������ ����Ʈ�� �ƴ� ���ڴ���)
--�ѱ� ���� 3����Ʈ ���� 1����Ʈ
select bookname "����", lenth(bookname)"���ڼ�",
lengthb(bookname)"����Ʈ��"
from book
where publisher='�½�����';

--substr ������ ���̸�ŭ�� ���ڿ��� ��ȯ�ϴ� �Լ�
select name, substr(name, length(name), 1) as "����"
from customer;


select substr(name, 1, 1) "��", count(*) "�ο�"
from customer
group by substr(name, 1, 1);

select substr(name, length(name), 1) as "����", count(*) as "�ο���"
from customer
group by substr(name, length(name), 1);

--1. ���� �̸� �� �ι�° ����° ���ڸ� ���
select name, substr(name, 2, 2) as "�ι�° ����°"
from customer;

--���缭�� �ֹ��Ϻ��� 10�� �� ����Ȯ���Ѵ� �� �ֹ��� Ȯ�����ڸ� ���Ͻÿ�
select orderid "�ֹ���ȣ", orderdate "�ֹ���", orderdate+10 "Ȯ��", orderdate-1 "�ֹ�����", sysdate "����", add_months(ORDERDATE,12) as "12���� ��", orderdate+365 "1�� ��"
from orders;

select last_day(to_date('1989-08-12','yyyy-mm-dd'))
from dual;

select last_day(SYSDATE + 1)
from dual;

--to date
select TO_CHAR(orderdate,'mm-dd')
from orders;

select to_char(orderdate,'dy-dd-mm-yyyy') as �ֹ���
from orders;

select to_char(orderdate, 'day dy d')
from orders;

select to_char(sysdate,'yyyy"��"mm"��"dd"��" day am hh24:mi:ss') as "today"
from dual;

--7�� �ֹ� 
select *
from orders
where ORDERDATE like '14/07%'
order by orderdate;
--������ �˾ƾ� �ϹǷ� ����

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

--�����Լ� ��������
--���밪 
--15
select abs(-15)
from dual;

--�ø� �־��� ���ں��� ũ�ų� ���� ���� �� �ּҰ�
-- 16
select CEIL(7.2)
from dual;

--�ڻ��ΰ�
-- -0.99999999999647923060461239250850048324
select cos(3.14159)
from dual;

--����  �־��� ���ں��� �۰ų� ���� ���� �� �ִ밪
-- 15
select FLOOR(8.9)
from dual;

--LOG
-- 2
select LOG(10,100)
from dual;

-- ������ 
-- 3
select MOD(11,4)
from dual;

--������
-- 9
select POWER(3,2)
from dual;

-- �ݿø� 
--16
select ROUND(15.7)
from dual;

--�־��� ���� ���� ���� 0 ���θ� ��ȯ
-- -1
select SIGN(-3.5)
from dual;

--����
-- 15
select TRUNC(15.7)
from dual;

--�ƽ�Ű�ڵ�
--C
select CHR(67)
from dual;

-- ���ڿ� ����
--HAPPY Birthday
select CONCAT('HAPPY ', 'Birthday')
from dual;

--�ҹ���
--birthday
select LOWER('Birthday')
from dual;

--lpad(char1,n,char2) �Լ��� ������ ���� n���� ���� char1���� ä��� ���� ������ ���ʺ��� char2�� ä���� ����Ѵ�.
--*.*.*.*.*Page 1
select LPAD('Page 1', 15, '*.')
from dual;

--LTRIM (���ڿ�, ����) �������� Ư�����ڿ� ��ġ�ϴ� ���ڸ� �����ϰ� ���
--ge 1
select LTRIM('Page 1', 'Pa')
from dual;

--ù��° ������ ���ڸ� �ι�° ������ ���ڷ� �ٲ��ش�
--BLACK
select REPLACE('JACK', 'J', 'BL')
from dual;

--���� ���� �� ������ ���� �� ���鿡 Ư�� ���ڸ� ä�� ��ȯ
--Page 1*.*.*.*.*
select RPAD('Page 1', 15, '*.')
from dual;

--�������� ���� ���� ����
--Page 1
select RTRIM('Page 1', 'ae')
from dual;

--������ġ���� ���ð�����ŭ ���ڹ�ȯ
--CDEF
select SUBSTR('ABCDEFG', 3, 4)
from dual;

--���ڿ� ���� ���� ����
--AA00
--leading 0 ���� 0 trailing 0 ������ 0 ����
select TRIM(LEADING 0 FROM '00AA00')
from dual;

--�빮��
--BIRTHDAY
select UPPER('Birthday')
from dual;

--������ ���� ASCII���� ��ȯ
--65
select ASCII('A')
from dual;

--Ư������ ��ġ ��ȯ
--14
select INSTR('CORPORATE FLOOR','OR', 3, 2)
from dual;

--���ڿ� ���� ��ȯ
--8
select LENGTH('Birthday')
from dual;

--�־��� ���ڿ� ���� ������ ������ �Ͽ� ��ȯ�Ѵ�.
--14/06/21
select ADD_MONTHS('14/05/21', 1)
from dual;

--�־��� ���ڰ� ���Ե� ���� ������ ��ȯ
--23/05/31
select LAST_DAY(SYSDATE)
from dual;

--�־��� ���ڰ� ������ ��Ÿ���� ���������� ��¥�� ��ȯ??
select NEXT_DAY(SYSDATE, 'ȭ')
from dual;

--���� 12 ������ ������
--23/05/08
select ROUND(SYSDATE)
from dual;

--today ��¥�� ���ڷ�
--23/05/08
select SYSDATE
from dual;

--���ڸ� ���ڷ� ���Ⱑ��
--23/05/08
select TO_CHAR(SYSDATE)
from dual;

--123
select TO_CHAR(123)
from dual;

--14/05/12
select TO_DATE('12 05 2014', 'DD MM YYYY')
from dual;

--���ڸ� ���ڷ� ���갡��
--12.3
select TO_NUMBER('12.3')
from dual;

--(�÷�, ����1, ���1, ����2, ���2, default_result)
--aa
select DECODE(1,1,'aa','bb')
from dual;

--2�� �� ������ null, �ٸ��� ù��° ��
--123
select NULLIF(123, 345)
from dual;

--null�̸� ������
select NVL(NULL, 123)
from dual;

--�������� 10%�λ�
select bookname, price, price*1.1
from book;

update book set PRICE = price*1.1;

--�������� 20%�λ� ���ǻ� ���ѹ̵�� �����ϵ� ������ȣ�� 5�� �̻��� ������ ���ؼ� �����ϱ�
update book set price = price*1.2, PUBLISHER = '���ѹ̵��'
where BOOKID >= 5;

select * from book;

ROLLBACK;

select name "�̸�", nvl(phone, '����ó����') "��ȭ��ȣ"
from customer;

select rownum"����", custid, name, phone
from customer;

select rownum"����", custid, name, phone
from customer
where rownum<=2;

--��ü
select * from book;
--1~5 ���ʷ� �ڸ���
select * from book where rownum <=5;
--�ڸ��� ����
select * from book where rownum <=5 order by price;
--������ �ڸ���
select * from (select * from book order by price)b where rownum <=5;
--�ڸ��� ����
select * from (select * from book where rownum <=5)b order by price;
--�ڸ��� ����
select * from (select * from book where rownum <=5 order by price)b ;

select * from book where rownum <=5 order by price desc;

select * from (select * from orders order by orders.SALEPRICE)book  where rownum <=3;

select * from (select * from orders order by orderdate desc) where rownum <=4;

select * from (select * from book where publisher = '���ѹ̵��' order by price desc) where rownum <=2;

select * from (select * from book order by price desc)
where publicher ='���ѹ̵��' and rownum <=2;

select sum(saleprice)
from orders
where custid = (select custid from customer where name='������');

select orderid, saleprice
from orders
where saleprice <=(select avg(SALEPRICE) from orders);

select orderid, custid, saleprice
from orders md 
where saleprice >(select avg(saleprice) from ordres so where md.custid=so.custid);

select sum(saleprice) "total"
from orders
where custid in(select custid from customer where address like '%���ѹα�%');

select sum(o.saleprice) "total"
from orders o, customer c
where o.custid = c.custid and c.ADDRESS like '%���ѹα�%';

select sum(saleprice)
from customer natural join orders
where address like '%���ѹα�%';

select sum(saleprice)
from customer join orders using(custid)
where address like '%���ѹα�%';
--using�� �Ҽ� �ȹ����� ����Ȱ� ���ش�

select sum(saleprice) 
from customer c join orders o on(c.custid=o.custid)
where address like '%���ѹα�%';
--23-1 join using
select *
from customer join orders using(custid) join book using(bookid)
where publisher like '%���ѹ̵��%';
--23-2 natural join
select *
from customer natural join orders NATURAL join book
where publisher like '%���ѹ̵��%';
--23-3 join on
select *
from customer c join orders o on(c.custid=o.custid) join book b on(b.bookid=o.bookid)
where publisher like '%���ѹ̵��%';

--24 ��ø���ǹ�
SELECT *
FROM customer 
WHERE custid in
    (select custid 
    from orders 
    where bookid in( select bookid
                       FROM book
                        WHERE publisher LIKE '%���ѹ̵��%'));
                        
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
              where address like '%���ѹα�%' and cs.custid = od.custid);

select saleprice
from orders
where custid=3;

select sum(saleprice) "total"
from orders od
where exists (select *
              from customer cs
              where cs.ADDRESS like '%���ѹα�%' and cs.custid=od.custid);
              
select sum(saleprice) "total"
from orders od
where exists (select *
              from customer cs
              where cs.ADDRESS like '%���ѹα�%');

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
