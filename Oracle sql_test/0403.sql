--1. book ���̺� ����˻�
select * from book;
--2. book���̺� ���� ������ �� �˻�
select * from book order by bookname;
--3. book ���̺� ���� ���� ���� �˻�
select * from book order by price DESC;
--4. ���� 13000�� �̰ų� 8000�� 
select * from book where price in(13000, 8000);
select * from book where price = 13000 or price = 8000;
--5. ���������� 8000,13000 ���� �˻� ;
select * from book where price not in(13000, 8000);
select * from book where not price = 13000 or price = 8000; 
select * from book where price = 13000 or not price = 8000; 
--6. ������ ���ڶ�� ���ڰ� �� ��������
select * from book where bookname like '%����%';
--7.������ ���ڶ�� ���ڰ� ���� ���� ��������
select * from book where bookname not like '%����%';
--8. ���ǻ���� ������ �����ϴ� ���ǻ翡�� �Ⱓ�� ������� ���ǻ�
select bookname, publisher from book where publisher like '��%' ;
--9.���ǻ� ����
select publisher from book;
select distinct publisher FROM book;
select count(distinct publisher) from book; 
--10. ��������
select count(publisher) from book;
select count(*) from book;
--11. ���� ��
select count(*) from customer;
--12.���ǻ������� �˻��ϵ� ���ǻ簡 ������ ���ݿ������� ��������
select * from book order by publisher, price desc;
--13. ������ ���ݿ������� �˻��ϵ� ���� �����̸� ������ ������ �˻�
select * from book order by price desc, bookname;
--14. �ֹ��� ������ �Ǹ� �ݾ� �Ѱ�
select sum(saleprice) from orders;
--15 ���� ���̺� ���� �Ѱ� 
select sum(price) from book;
--16 �ֹ���¥ �ֱ� �ͺ��� �˻��ϵ� ��¥�� ������ ���� �������� �ֹ������˻�
select * from orders order by orderdate desc, saleprice desc;
--17. �ֹ����̺��� 2�� ���� �ֹ��� ���� �� �ݾ�
select sum(saleprice) from orders where custid = 2; 
--18. 1�� ���� �� �ֹ� �ݾװ� �Ǽ�, �ּ� �ǸŰ� �ִ� �ǸŰ� �� �ݾ� ;
select sum(saleprice), count(*), max(saleprice), min(saleprice) from orders where bookid=1;
select bookid, sum(saleprice), count(*), max(saleprice), min(saleprice) 
from orders where bookid=1 group by bookid;
-- �׷��Լ��� �Բ� �Ӽ��� �������� group by ��� 
--19. ���� �ֹ� �Ǽ� 
SELECT CUSTID, count(*) AS �����հ� FROM ORDERS GROUP BY CUSTID; 
--20. ������ �ֹ��Ǽ� 
select bookid, count(*) as �������Ǽ� from orders group by bookid;
--21. ������ �ֹ��ݾ� �հ踦 ���ϵ� ���� ������ 8000�� �̻��� ������ 2���̻� �Ǹŵ� ����
select bookid, sum(saleprice), count(*)
from orders 
where saleprice >= 8000
group by  bookid
having count(*) >=2
order by bookid;
--22. ���� ���� �ֹ��� ���� �����͸� ��� ���̽ÿ�.
select * from customer, orders;
select * from customer c, orders o where c.custid=o.custid;
--23 ������ �ֹ� ���̺� ������ ������ȣ ������ �˻�
select * from book b, orders o where b.bookid=o.bookid order by b.bookid;
--24. ������ �ֹ� ���̺� ������ ������ȣ,������,�ǸŰ�,�ֹ����� �˻��ϵ� ������ȣ ������ �˻�
select b.bookid, b.bookname, saleprice, orderdate from book b, orders o 
where b.bookid=o.bookid order by b.bookid;
--25. ���� �̸��� �� ���� �ֹ��� ������ȣ,�����ǸŰ���,�ֹ����� �˻��ϵ� �ֹ��� �ֱٰ� ���� ������!
select c.name, o.bookid, saleprice, orderdate 
from orders o, customer c
where o.custid = c.custid
order by orderdate desc;
--26. ������ ���ǻ� ���� �ǸŰ� �ֹ��� ����ȣ �˻��ϵ� �ǸŰ���
select o.CUSTID, bookname, publisher, price, o.SALEPRICE
from book b, orders o
where b.bookid = o.bookid
order by o.saleprice; 
--27. ���� �ֹ��ݾ� �հ�, �ֹ��Ǽ��� ���ϵ� ����� �Բ� ����ϰ� ���������
select c.custid, c.name, sum(o.saleprice), count(*) as �ֹ��Ǽ�
from orders o, customer c 
where o.custid = c.custid
group by c.custid, name
order by c.name;
--28 ������ �ֹ��ݾ� �հ�, �ֹ��Ǽ��� ���ϵ� ������� �Բ� ����ϰ� �����������
select b.BOOKID, bookname, sum(o.saleprice), COUNT(*) AS �ֹ��Ǽ�
from orders o, book b
where o.bookid = b.bookid
group by b.bookid, b.bookname
order by b.BOOKNAME;
--29. book, customer, orders ���̺� �� ���
select *
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid;
--30. ���� ���ּ� ������ ������ȣ �ֹ��� �ǸŰ��� �˻��ϵ� ����ȣ������
select c.CUSTID, c.name, c.address, b.bookid, b.bookname, o.orderdate, o.saleprice
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid
order by c.CUSTID;
--31. ���ѹ̵�� �Ⱓ ���� ���� ���� �̸� �ּ� ��ȭ��ȣ / ������ �ֹ��� �ǸŰ��� ���ǻ� ����ϵ� ��������� 
select c.name, c.address, c.PHONE, b.bookid, b.bookname, b.publisher, b.price, o.orderdate
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid and b.publisher = '���ѹ̵��'
order by c.NAME;
--32 ������ ���� �ֹ��� ������ �Ǽ�, �� �ֹ��ݾ�
select c.name, sum(o.SALEPRICE), count(*)
from customer c, orders o
where o.custid=c.custid and c.name = '������'
group by name;
--33. �߱��� ��Ź�� ��� ������ �ֹ��� ���� ����
select c.*, BOOKNAME
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid and b.bookname = '�߱��� ��Ź��';

SELECT C.*, BOOKNAME
FROM BOOK B INNER JOIN ORDERS O ON(B.BOOKID=O.BOOKID) 
INNER JOIN CUSTOMER C ON(C.CUSTID=O.CUSTID)
WHERE B.BOOKNAME = '�߱��� ��Ź��';

--34.(��������) �߱��� ��Ź�ض�� ������ �� �ֹ� �Ǽ��� �Ǹűݾ� �Ѿ� �˻�
select sum(o.saleprice) as �߱���Ź�Ѿ�, count(*) as �߱���Ź�Ǽ�
from book b, customer c, orders o
where b.bookid=o.BOOKID and o.custid=c.custid and b.bookname = '�߱��� ��Ź��';

select sum(o.saleprice) as �߱���Ź�Ѿ�, count(*) as �߱���Ź�Ǽ�
from book b INNER JOIN orders o ON(b.BOOKID=O.BOOKID)
where b.bookname = '�߱��� ��Ź��';

--from ���� customer c ��� ������ select ������ c.custid ��� �ؾ��� customer.custid �ȵ�
--select�� ó�� ���� : from > where> group by > having> select > order by
--select ����� �Ӽ����� order by�� ����Ҷ� �� ������ ���� ���� ��� ����

--35. ��� �������� �ֹ� ������ �˻� (��,���ȸ� ������ ����)
SELECT *
FROM BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID);

SELECT *
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID(+);

--36. ��� �ֹ������� �ش���� ������ �˻��ϵ� ���������� ���� (�� ���� ������ ���)
-- �ش� �������� ������ ���, NULL�� ä�� ���� (+) ���
SELECT *
FROM CUSTOMER C RIGHT OUTER JOIN ORDERS O ON(C.CUSTID = O.CUSTID);

--37. �̻�̵�� ���ǻ翡�� �Ⱓ�� ������ �������� �� �ֹ� ������ �˻��ϵ� �ֹ����� ���� ���������� �����ؼ� ���
SELECT *
FROM  BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID)
WHERE B.PUBLISHER = '�̻�̵��';

SELECT * FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID(+) AND PUBLISHER = '�̻�̵��';


--38. �迬�� ���� �������� �� �ֹ������� �˻�
SELECT *
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID = O.CUSTID)
WHERE C.NAME = '�迬��';

--39. ������ 13000�� ���������� �� ������ �ֹ������� �˻��ϵ� �ֹ� ���� ���� ������ ���� ������ �����Ͽ� ���
SELECT *
FROM BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID)
WHERE B.PRICE = 13000;
--40. ���� ���� �� �ְ� �ݾ� : 35000
SELECT MAX(PRICE)
FROM BOOK;

--41. ���� ���� �� �ְ� ���� �̸�  : �������̺�
SELECT BOOKNAME
FROM BOOK 
WHERE PRICE = 35000;

SELECT BOOKNAME, MAX(PRICE) FROM BOOK WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK)
GROUP BY BOOKNAME;

--42. ���ѹ̵�� ���ǻ翡�� �Ⱓ�� ������ ������ȣ : 3,4
SELECT BOOKID FROM BOOK 
WHERE PUBLISHER = '���ѹ̵��';

--43. ���ѹ̵�� ���ǻ翡 �Ⱓ�� ������ �ֹ���ȣ �˻� 
SELECT ORDERID FROM BOOK B, ORDERS O WHERE B.BOOKID=O.BOOKID AND B.PUBLISHER = '���ѹ̵��';
SELECT ORDERID FROM ORDERS WHERE BOOKID IN(3,4);
SELECT ORDERID FROM ORDERS WHERE BOOKID IN (SELECT BOOKID FROM BOOK WHERE PUBLISHER ='���ѹ̵��');

--44. ������ ������ ���� ��ȣ ; 1,1,2,3,4,1,4,3,2,3
SELECT CUSTID
FROM ORDERS; 

--45. ������ ������ ���� �̸��� ��� 
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);

SELECT DISTINCT NAME FROM CUSTOMER C, ORDERS O WHERE C.CUSTID=O.CUSTID;
SELECT DISTINCT NAME FROM CUSTOMER C INNER JOIN ORDERS O ON (C.CUSTID=O.CUSTID);

--46. ���ѹ̵�� ���� ���� ������ ���� �̸�
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE BOOKID IN (SELECT BOOKID FROM BOOK WHERE PUBLISHER = '���ѹ̵��'));

SELECT NAME
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID=O.CUSTID) INNER JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE PUBLISHER ='���ѹ̵��';






















