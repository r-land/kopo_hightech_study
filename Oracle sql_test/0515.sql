--1 �ǸŰ��� ���� ���� 3�� �ֹ�����
select * from (select * from orders order by saleprice desc ) where rownum <=3;

select * from orders order by saleprice desc;
--2 ���� ������ ���� �� 5�� ��������
select * from( select * from book order by price ) where rownum <= 5;
--3 ���� �ֹ��� �հ谡 ���� ���� 3�� �ֹ����� ��� 
select * from orders where custid in(select custid from(select custid from orders group by custid order by sum(saleprice) desc) where rownum <=3);
--4 ���� �ֹ��� �հ谡 ���� ���� 3�� ������ ���
select * from customer where custid in(select custid from(select custid from orders group by custid order by sum(saleprice)) where rownum <=3);

--1�ܰ� ���� �Ǹž� �հ� �����ͺ��� ���� ����ȣ�� �Ǹž� �հ� ���
select custid, sum(saleprice) from orders group by custid order by sum(saleprice);

--2�ܰ� ���� �Ǹž� �հ� ������ ���� ���� �Ͽ� ����ȣ ���
select custid from orders group by custid order by sum(saleprice);

--3�ܰ� ���� �Ǹž� �հ� ������ ���� ���� �Ͽ� ����ȣ �ֻ��� 3�� ����ȣ ���
select custid from(select custid from orders group by custid order by sum(saleprice)) where rownum <=3;

--4�ܰ� �ֻ��� 3���� ������
select * from customer where custid in(select custid from(select custid from orders group by custid order by sum(saleprice)) where rownum <=3);

--5 ���ѹ̵�� ���ǻ翡�� ���ǵ� ���� �� ���� ���� �Ǹŵ� ����2�� ���
select * from(select bookid from orders where publisher = '���ѹ̵��') where bookid in(select bookid from orders group by bookid order by sum(saleprice) desc) where rownum <=2; 

-- ���ѹ̵�� ���ǻ翡�� ���ǵ� �������� ����� �ֹ��Ǿ����� Ȯ��
select b.bookid, count(*)
from book b, orders o
where b.bookid=o.bookid and publisher = '���ѹ̵��'
group by b.bookid;
--������ ����
INSERT INTO orders VALUES (11, 4, 3, 21000, '14/07/05');

INSERT INTO orders VALUES (12, 3, 3, 21000, '14/07/01');

INSERT INTO orders VALUES (13, 1, 4, 21000, '14/07/02');

--6 ���ѹ̵�� ���ǻ翡�� ���ǵ� ���� �� ���� ���� �Ǹŵ� ����2���� ������ ������ ���
--6-1 ���ѹ̵�� ���ǻ翡�� ���ǵ� ���� �� �Ǹ� Ƚ��
select b.bookid, COUNT(*) from book b, orders o where b.bookid = o.bookid and b.publisher = '���ѹ̵��' group by b.bookid;
--6-2 ���ѹ̵�� ���ǻ翡�� ���ǵ� ���� �� �Ǹŵ� ������ ������ȣ�� �Ǹ� Ƚ��
select b.bookid, COUNT(*) from book b, orders o where b.bookid = o.bookid and b.publisher = '���ѹ̵��' group by b.bookid  order by count(*) desc;
--6-3 ���ѹ̵�� ���ǻ翡�� ���ǵ� ���� �� �Ǹŵ� ������ �Ǹ�Ƚ���� ���������� ����
select * from(select b.bookid, COUNT(o.orderid) from book b, orders o where b.bookid = o.bookid and b.publisher = '���ѹ̵��' group by b.bookid order by count(*) desc) where rownum <=2;
--6-4 �� ������ ������ ������

select * from customer where custid in(
select o.custid from book b, CUSTOMER c, orders o
WHERE b.bookid = o.bookid and c.custid = o.custid and  b.bookid in(
select bookid from (select b.bookid from book b, orders o where b.bookid = o.bookid and b.publisher = '���ѹ̵��' group by b.bookid order by count(*) desc) where rownum <=2));


select distinct c.* 
from CUSTOMER c, orders o
WHERE c.custid = o.custid 
and bookid in(
select bookid from (select b.bookid from book b, orders o where b.bookid = o.bookid and b.publisher = '���ѹ̵��' group by b.bookid order by count(*) desc) where rownum <=2);

--7 �ֹ���¥�� �Ǹ� �Ǽ� ���
select orderdate, count(*) from ORDERS group by ORDERDATE;

insert into orders values(14, 1, 10, 8000, '2014/07/07');

--9.��¥�� �Ǹ� �Ǽ��� ���� ���� ��¥�� �ֹ����� ���
select * from(select orderdate, count(*) from ORDERS group by ORDERDATE order by count(*) desc)where rownum <=1;

select * from orders where orderdate in(select orderdate from (select orderdate from ORDERS group by ORDERDATE order by count(*) desc)where rownum <=1);

--10 ��ü������ �ǸŰ� ��պ��� ��ΰ� �ȸ� ��������
select avg(saleprice) from orders; 

select * 
from orders 
where SALEPRICE > (select avg(saleprice) from orders);  

select * from book where bookid in(select bookid
                                   from orders
                                  where SALEPRICE>(select avg(saleprice) from orders));

--11 ������ �ֹ��Ǽ�
select bookid, count(*) from orders group by bookid;
--12 ������ �ǸŰ� ��� �̻� �ȸ� ��������
select * 
from book 
where bookid in(
                select bookid 
                from orders o1
                where SALEPRICE > (select avg(saleprice) 
                                    from orders o2 
                                    where o1.BOOKID = o2.BOOKID 
                                    group by bookid
                                  ));

select bookid, avg(saleprice) from orders group by bookid;

select saleprice from orders where bookid = 7;


--13 ���� �ǸŰ� ��� �̸� �ȸ� �ֹ�����
select * 
from orders o1 
where SALEPRICE < (select avg(saleprice) 
                    from orders o2 
                    where o1.custid = o2.custid
                    );
                    
select custid, avg(saleprice) from orders group by custid;                    

--14 ���� ������ 10000�� ������ �������� �Ǹž� �հ�,�ֹ��Ǽ�
select count(*), sum(o.SALEPRICE) from orders o, book b where b.bookid = o.bookid and b.price <= 10000 ;
select o.bookid, sum(o.SALEPRICE) from orders o, book b where b.bookid = o.bookid and b.price <= 10000 group by o.bookid;
--15 ���ѹα� ���� ������ �Ǹ��� ������ �� �Ǹž� 
select sum(sALEPRICE) from orders o, customer c where o.custid = c.custid and c.address like '%���ѹα�%';

select sum(saleprice) from orders o where EXISTS (select * from customer c where address like '%���ѹα�%' and c.custid = o.custid);

--16 ���缭�� ���� �Ǹž�  (���̸� ���� �Ǹž�)
select (select name from customer c where c.custid = o.custid)name, sum(saleprice) from orders o group by o.custid;

------
alter table orders add bookname varchar2(40);

update orders
set bookname=(select bookname from book where book.bookid=orders.bookid);

--15.
alter table orders add name varchar2(40);

update orders
set name =(select name from customer where orders.custid=customer.custid);

--16. ����ȣ�� 2������ ���� �Ǹž� (���̸� ���� �Ǹž� ���)
select o.custid, c.name, sum(o.saleprice) from orders o, customer c where c.custid = o.custid and c.custid<=2 group by o.custid, c.NAME;

select c.name, sum(o.saleprice) 
from (select custid, name from customer where custid <=2) c, orders o 
where c.custid = o.custid 
group by c.name;

--17. 3,4,5�� ������ �Ǹž� �հ踦 ������� ���ǻ�� �Բ� ���
select b.bookname, b.publisher, sum(o.saleprice) from orders o, book b where o.bookid = b.bookid and b.bookid in(3, 4, 5) group by b.bookname, b.PUBLISHER;


alter table orders drop column name;
alter table orders drop column bookname;

--18.  ���� �ּҿ� �ֹ��� �հ� ��Į��
select custid, (select address from customer c where c.custid = o.custid) "address", sum(saleprice) "total" from orders o group by o.custid;

-- ���� �ֹ��� ��� ���̸� �ζ��κ�
select c.name, s
from (select custid, avg(saleprice)s from orders group by custid)o, customer c where c.custid=o.custid;

-- ����ȣ 3������ ���� �ֹ��� �հ� ��ø����
select sum(saleprice)"total" from orders o where exists (select * from customer c where custid <=3 and c.custid =o.custid);

--
CREATE view vw_Book
as select * from Book where bookname like '%�౸%';

--���ѹ̵�� ���ǻ翡�� ������ ������ ������ ���� �̸� �ּ� ��ȭ��ȣ ���������� vw _pub�̶�� �並 �����Ͻÿ�
CREATE view vw_pub
as select c.name, c.address, c.phone, b.BOOKNAME from Book b, customer c, orders o where b.bookid=o.bookid and o.custid = c.custid and  publisher like '���ѹ̵��';

select * from VW_CUSTOMER;

--
CREATE view vw_Orders(orderid, custid, name, bookid, bookname, saleprice, orderdate)
as select o.orderid, o.custid, c.name, o.bookid, b.BOOKNAME, o.saleprice, o.ORDERDATE from Book b, customer c, orders o where b.bookid=o.bookid and o.custid = c.custid;

--
create or replace view vw_customer(custid, name, address)
as select custid, name, address 
from customer 
where address like '%����%';

drop view vw_pub;

select * from user_views;

--�������� 8 -1 �ǸŰ��� 20000�� �̻��� ������ ������ȣ �����̸� ���ǻ� �ǸŰ����� �����ִ� highorders �� ����
create view vw_highorders(bookid, bookname, publisher, saleprice)
as select b.BOOKID, b.bookname, b.PUBLISHER, o.saleprice 
from book b, orders o
where b.bookid = o.bookid and o.SALEPRICE <= 20000;

--8-2
select bookname, name
from VW_highorders;
--8-3
create or replace view vw_highorders(bookid, bookname, name, publisher, saleprice)
as select b.BOOKID, b.bookname, c. name, b.PUBLISHER, o.saleprice 
from book b, orders o, customer c
where b.bookid = o.bookid and c.custid = o.custid and o.SALEPRICE >= 20000;

--�ε���
create  