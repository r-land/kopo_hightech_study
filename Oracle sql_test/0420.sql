--1. �ֹ��� ������ 
SELECT b.bookname
from orders o, book b
WHERE b.bookid= o.bookid;
--2. ������ �ֹ� �Ǽ�
select bookid, count(*)
from orders
group by bookid;
--3. ���� �ֹ��� �հ�
select custid, sum(saleprice) as �ֹ���
from ORDERS
group by custid;
--4. �ֹ����� ���� ������ȣ
select b.bookid
from book b left outer JOIN orders o ON(b.bookid=O.bookid)
where o.bookid is null;
--5. �ֹ����� ���� ������
select b.bookname
from book b left outer JOIN orders o ON(b.bookid=O.bookid)
where o.bookid is null;
--6.�������ݰ� �ǸŰ� ����
SELECT b.price-o.saleprice as ����
from orders o, book b
WHERE b.bookid= o.bookid;
--7.�������ݰ� �ǸŰ� ���� �� ���� ���̰� ���� ���� ��������
SELECT max(b.price-o.saleprice) as �ִ�����
from orders o, book b
WHERE b.bookid= o.bookid;
