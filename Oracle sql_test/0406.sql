--1. ��������
select * from book;
--2. ������
select * from CUSTOMER;
--3. �ֹ�����
select * from ORDERS;
--4. ������, ���ǻ�, ����
select bookname, publisher, price from book;
--5. ���� ��ȭ �ּ�
select name, address, phone from customer;
--6. �ֹ���ȣ ����ȣ ������ȣ �ǸŰ�
select orderid, custid, bookid, saleprice from orders;
--7. �̸��� ��̶��� ���� �̸��� �ּ�
select name, ADDRESS from customer where name = '��̶�';
--8. ���ѹ̵�� ���ǻ翡�� �Ⱓ�� ������ ����
select * from book where PUBLISHER ='���ѹ̵��';
--9. ���ѹα��� ����ִ� ���� �̸�,�ּ�,��ȭ��ȣ
select name, ADDRESS, PHONE from CUSTOMER where address like '���ѹα�%';
--10. ������ 10000�� �̸��� ������ ���� ���ǻ� 
select bookname, PRICE, PUBLISHER from book where price < 10000;
--11. ������ �ǰܰ� ����ִ� ������
select bookname from book where bookname like '%�ǰ�%';
--12. ������ �డ�� ����ְų� �߱��� ����ִ� ������
select bookname from book where bookname like '%�౸%' or bookname like '%�߱�%';
--13. �ֹ��� ������ ����ȣ ��� �� �ѹ���
select DISTINCT custid from ORDERS;
--14 ���ǻ�� ���
select publisher from book;
--15.���ǻ縦 �ѹ����� ���
select DISTINCT publisher from book;
--16. �ֹ����� ������ȣ�� �ѹ���
select DISTINCT bookid from ORDERS;
--17.�������� �౸�� �����̰ų� ������ 20000�� �̸��� ��������
select * from book where (BOOKNAME = '�౸�� ����') or (price < 20000) order by price;
--18. ���ǻ���� �������� ������ ���ǻ��
select DISTINCT publisher from book where PUBLISHER like '%������';
--19 �ǸŰ��� 10000������ 20000�� ����(����) �ֹ�����
select * from orders where price >= 10000 and price <= 20000;
select * from orders where price between 10000 and 20000;
--20. ���ǻ簡 �Ｚ��,�������� �ƴ� ���ǻ翡�� �Ⱓ�� ������� ���ǻ�
select bookname, publisher from book where publisher not in('�Ｚ��','������');
select bookname, publisher from book where not publisher in ('�Ｚ��','������');
select bookname, publisher from book where publisher != '�Ｚ��' and publisher != '������';
--21. ���� ���� �达�� ������
select * from CUSTOMER where NAME like '��%';
--22. ���ǻ� �̸� �� �ι�° ���ڰ� �� �� ���ǻ��� ������ 
select publisher, bookname from BOOK where PUBLISHER like '_��%';
--23. �ֹ����� 14��07��05�Ϻ��� 8�ϱ����� �ֹ�����
select * from ORDERS where ORDERDATE BETWEEN '14/07/05' AND '14/07/08';
--24. �ֹ������� �ֹ��� ��¥������ ���� 
select * from ORDERS order by ORDERDATE;
--25. �ֹ������� �ǸŰ��� ���� ���� �����̸� �ֱ� �ֹ��� ��¥��
select * from ORDERS order by saleprice, ORDERDATE DESC;
--26 �������� �˻� ���ݼ� ���� �����̸� �������
select * from book order by price, bookname; 
--27. �������� �˻��ϵ� ���ǻ�� ���ݿ���
select * from book order by publisher, price DESC;
--28. ��� ������ ���� �Ѱ�
select sum(price) as "���� �Ѱ�" from book;
--29. ���� �ֹ� �� �ǸŰ� 
select sum(saleprice) as "�� �ֹ���" from orders;
--30.1�� ���� �ֹ��� ������ �� �ֹ���
select sum(saleprice) as "1�� �� �Ѿ�" from orders where CUSTID =1;
--31. 1�� ���� �ֹ� �ݾ� �հ�
select bookid, sum(saleprice) as "1�� ���� �Ѿ�" from orders where bookid =1
group by BOOKID;
--32 ��� ������ ��
select COUNT(*) as ������ from book;
--33 ��� ���ǻ�� 
select count (DISTINCT publisher) as "���ǻ� ��" from book;
--34. ��� �ֹ��� ��
select COUNT(*) as �ֹ��� from orders;
--35. ��� ���� �� 
select COUNT(*) as ���� from CUSTOMER;
--36. �ֹ��� ��� �ְ��ǸŰ� �ּ��ǸŰ� 
select avg(saleprice) as ���, max(saleprice) as �ְ�, min(saleprice) as ������ from orders;
--37. �ֹ��� ���� �� 
select COUNT(distinct custid) as �ֹ����� 
from orders;
--38. ���� �ֹ��Ǽ�, �ֹ��� �հ�
select custid, count(*), sum(saleprice)
from orders
group by CUSTID;
--39. ������ �ֹ��Ǽ� �ֹ��� �հ� �ְ� ������
select bookid, count(*) as �ֹ��� , sum(saleprice) as �ֹ��Ѿ�, max(saleprice) as �ְ�, min(saleprice) as ������
from ORDERS
group by bookiD;
--40. ���� �ֹ��Ǽ� �ֹ��� �հ� �˻��ϵ� �ֹ��Ǽ� 2���̻� ����ϰ� �ֹ��Ǽ� �����ͺ���
select custid, count(*) as �ֹ��Ǽ�, sum(saleprice) as �ֹ���
from orders 
group by CUSTID
having count(*) >=2
order by 2 DESC;
--where �Ϲ����� having group�� �����Լ����� 
--41. ������ �ֹ��Ǽ� �ֹ��� �հ� �˻��ϵ� �ǸŰ��� 10000���̻��̰� �ֹ��Ǽ� 2���̻��ΰ͸� ����ϵ� �ֹ��� �հ������ͺ���
select bookid, count(*) as �ֹ��� , sum(SALEPRICE) as �ֹ��Ѿ�
from orders 
where saleprice >= 10000
group by bookiD
having  count(*) >=2
order by 3;



