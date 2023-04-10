--1.������ȣ 1���� �ƴ� ������ �̸�
select bookid, bookname from book where bookid != 1;
--2. ������ 10000�� �̸��� ������,���ǻ�
select bookname, publisher from book where PRICE < 10000;
--3. �迬��(����ȣ2��)�� ���ž� / ���̺�1���̿�(����ȣ��)/ ���̺�2���̿�(�̸�����)
select sum(saleprice) as "�迬�� ���ž�" from orders where custid =2;
select c.name, sum(o.SALEPRICE)
from customer c, orders o
where o.custid=c.custid and c.name = '�迬��'
group by name;
--4. �迬�ư� ������ ������ ���� �ֹ��� �հ�
select count(*) as "�迬�� ������", sum(saleprice) as "�ֹ���" from orders where custid =2;
select c.name, sum(o.SALEPRICE), count(*)
from customer c, orders o
where o.custid=c.custid and c.name = '�迬��'
group by name;
--5. ���缭�� ���� �� ���� 
select count(*) as "���� �� ��" from book;
--6. ���缭�� ���ǻ� �� ����
select count(distinct publisher) as "���ǻ� ��" from book;
--7. �ֹ��Ǽ�
select count(*) as "�ֹ��Ǽ�" from orders;
--8. �ֹ��� �� �� 
select count(distinct custid) as "�ֹ� ����" from orders;
--9. 2014�� 7�� 1�Ϻ��� 3�� ���� �ֹ��� �հ�
select sum(saleprice) from orders where orderdate between '14/07/01' and '14/07/03';
--10.���� �达�� ���� �̸��� �ּ�
select name, address from CUSTOMER where NAME like '��%';
--------------------------------------------------------------------------------

--1. �迬�� �ֹ� ���ڴ�
select o.orderdate as "�迬�� �ֹ���"
FROM orders o, customer c
where o.custid = c.custid and c.name = '�迬��';

--2. ��� ���� �ֹ� ���� ���ȸ� �������� 
SELECT *
FROM BOOK B LEFT OUTER JOIN ORDERS O ON(B.BOOKID = O.BOOKID);

--3.Olympic Champions��� ���� �� �ֹ� �Ǽ��� �Ǹűݾ� �Ѿ� �ֹ����� �˻�
select count(*) as �ֹ��Ǽ�, SUM(o.SALEPRICE) as �Ǹ��Ѿ�, o.orderdate
FROM ORDERS O, CUSTOMER C, BOOK B
WHERE B.BOOKID = O.BOOKID AND O.CUSTID =C.CUSTID AND B.BOOKNAME = 'Olympic Champions'
group by o.orderdate;

SELECT count(*) as �ֹ��Ǽ�, SUM(o.SALEPRICE) as �Ǹ��Ѿ�, o.orderdate
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID=O.CUSTID) INNER JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE BOOKNAME = 'Olympic Champions'
group by o.orderdate;

--4. ���� ������ ���̸�
select distinct c.name
from orders o, customer c
where O.custid = c.custid;

SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);

--5. Pearson ���ǻ��� ���� ������ ���̸�
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
--11. �ֹ��� �� ��� �� ������ �ֹ����� ��� 
select *
FROM customer c inner JOIN ORDERS O ON(C.CUSTID=O.CUSTID);

--12. �Ǹŵ� ��� ���������� �ֹ����� ���
SELECT *
FROM BOOK B JOIN ORDERS O ON(B.BOOKID = O.BOOKID);

select *
from book b, orders o
where b.bookid = o.bookid;

--13. ������ �ֹ��� �հ�
select b.bookname, sum(saleprice)
FROM BOOK B JOIN ORDERS O ON(B.BOOKID = O.BOOKID)
group by b.bookname;

--14. ����ȣ �� �ֹ��� �հ�
select c.custid, sum(saleprice) 
FROM customer c inner JOIN ORDERS O ON(C.CUSTID=O.CUSTID)
group by c.custid;

--15.���� �ֹ��� �հ�, �ּ� �ǸŰ�, �ִ��ǸŰ� ,�ֹ��Ǽ�
select c.name, sum(saleprice), min(saleprice), max(saleprice), count(*) as �ֹ��Ǽ� 
FROM customer c inner JOIN ORDERS O ON(C.CUSTID=O.CUSTID)
group by c.name;

--16.�ǸŰ��� 10000�� �̻��� ������ �ֹ��� ���� �ǸŰ� ������
select c.name, b.bookname, O.SALEPRICE
FROM customer c, orders o, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and saleprice >= 10000;

select name, bookname, SALEPRICE
FROM CUSTOMER C INNER JOIN ORDERS O ON(C.CUSTID=O.CUSTID) INNER JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE saleprice >= 10000;

--17. �������� ���� �� ���� ���� �ֹ���ȣ �ǸŰ�
select c.name, O.ORDERID, O.SALEPRICE
FROM customer c left outer JOIN ORDERS O ON(C.CUSTID=O.CUSTID);

select name orderid, saleprice
from CUSTOMER c, orders o
where c.custid = o.custid(+);

--18. ������ ���� �� ������ ������ ����ȣ
SELECT o.custid, price
FROM orders o, book b
WHERE O.BOOKID = B.BOOKID and price = (select min(price) from book);

select custid 
from orders where bookid in(select bookid from book where price = (select min(price) from book);

--19. ������ ���� �� ������ ������ ����
SELECT c.name
FROM orders o, book b, CUSTOMER c
WHERE O.BOOKID = B.BOOKID and o.custid = c.custid and price = (select min(price) from book);

select name
from orders o join customer c on (o.custid = c.custid)
where o.bookid in(select bookid from book where price = (select min(price) from book));

--20. ������ �������� ���� ���̸�
select c.name
FROM customer c left outer JOIN ORDERS O ON(C.CUSTID=O.CUSTID)
where O.ORDERID is null;

select name
from customer
where custid not in (select custid from orders);

--21. ������ ���ǻ��� ������ ������ ���̸�
SELECT NAME
from customer c, orders o, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and b.PUBLISHER ='������'; 

SELECT NAME
FROM CUSTOMER C JOIN ORDERS O ON(C.CUSTID=O.CUSTID) JOIN BOOK B ON (B.BOOKID=O.BOOKID)
WHERE  b.PUBLISHER ='������'; 

--���ѹα� �ֹ��� �ֹ��� ���� 
select count(*) as "�� �ֹ��Ǽ�"
from orders o, customer c
where o.custid = c.custid and c.address like '%���ѹα�%';

select count(*) as "�� �ֹ��Ǽ�"
from orders o join customer c on(o.custid = c.custid)
where like '%���ѹα�%';


select count(*) as "�� �ֹ��Ǽ�(��)"
from orders
where custid in
(
select custid
from CUSTOMER
where address like '%���ѹα�%'
);

--22.���ǻ纰�� ���ǻ��� ��� ���� ���ݺ��� ��� ���� (����μ�����)
select b1.bookname
from book b1
where b1.price > (select avg(b2.price)
                  from book b2
                  where b2.publisher = b1.publisher);
--23. ������ ���� ��� �ֹ��� ���� ��� �ֹ����� ������ȣ ��� (��������)
select o1.CUSTID, o1.BOOKID
from orders o1 join customer c on o1.custid=c.custid
where o1.saleprice > (select avg(o2.saleprice)
                       from orders o2
                       where o1.custid = o2.custid)
group by o1.CUSTID, o1.BOOKID
order by o1.custid;
                  
--���� ��� �ֹ���                
select custid, avg(saleprice)
from orders
group by custid
order by custid;

--28.������ ��� �ǸŰ����� �� ���� �ǸŰ��� �ش�Ǵ� ������ȣ ����ȣ �ǸŰ� ���
select bookname, o1.CUSTID, o1.BOOKID, o1.saleprice
from orders o1 join book b on o1.bookid=b.bookid
where o1.saleprice < (select avg(o2.saleprice)
                       from orders o2
                       where o1.bookid = o2.bookid);


--������ ��� �ֹ���                
select bookid, avg(saleprice)
from orders
group by bookid
order by bookid;

--29. �ֹ����� ���� ���� �̸�
select name
from customer
minus
select name
from customer
where custid in (select custid from orders);

--30. �ֹ��� �ִ� ���� �̸��� �ּҸ� ���̽ÿ�
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
              
--31. �ֹ����� �������� ���
select *
from book b
where exists (select * from orders od
              where b.bookid = od.bookid);

--32. �������� ������ ������ ���ǻ� �� 
select count(distinct publisher) as "������ ���ǻ� ��"
from orders o, customer c, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and name = '������';

--33. ������ ������ ������ �̸�, ����, ������ �ǸŰ��� ����
select b.bookname, B.PRICE, (b.price - o.saleprice)as ����
from orders o, customer c, book b
WHERE c.custid=o.custid and b.bookid= o.bookid and name = '������';

--34. �������� �������� ���� ������ �̸�
select b.bookname
FROM customer c, orders o, book b
minus
select b.bookname
FROM customer c, orders o, book b
where c.custid=o.custid and b.bookid= o.bookid and name = '������';

--35. �ֹ����� ���� ���� �̸�
select name
from CUSTOMER
where custid not in (select custid from orders); 

--36. �ֹ��ݾ� �Ѿװ� �ֹ��� ��ձݾ�
select sum(saleprice), avg(saleprice)
from orders;

--37. ���� �̸��� ���� ���ž�
select c.name, c.custid, sum(O.SALEPRICE)  
from customer c, orders o
WHERE O.CUSTID = C.CUSTID
group by  c.name, c.custid;

--38.���� �̸��� ���� ������ ���� ���
select DISTINCT c.name, B.BOOKNAME  
from customer c, BOOK B, ORDERS O
WHERE c.custid=o.custid and b.bookid= o.bookid 
GROUP BY C.NAME, B.BOOKNAME
ORDER BY C.NAME;

--39. ������ ����(BOOK���̺�)�� �ǸŰ���(ORDERS���̺�)�� ���̰� ���� ���� �ֹ�
SELECT MAX(PRICE-SALEPRICE)
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID;

--40. ������ �Ǹž� ��պ��� �ڽ��� ���ž� ����� �� ���� ���� �̸�
select c.name 
from customer c, orders o
where c.custid=o.custid 
group by c.name
having avg(saleprice) > (select avg(saleprice) from orders);





