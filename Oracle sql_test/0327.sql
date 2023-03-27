--1. �౸�ǿ����� ���ǻ�� ����
select publisher, price from book where bookname like '�౸�� ����';
--2. ���ǻ� ���� �� ���� å�� �Ⱓ�߳� 
select publisher, count(*) from book GROUP BY publisher;
--3. ���ǻ� ���� �� ���� å�� �Ⱓ�߳�(�� 2���̻� �Ⱓ�� ������) 
select publisher, count(*) from book group by PUBLISHER HAVING COUNT(*) >=2;
--4. 3�� ������ ���ǻ� �̸� ������  !
select publisher, COUNT(*) from book GROUP BY PUBLISHER HAVING COUNT(*) >=2 
ORDER BY PUBLISHER;
--5 4�� ���� �������� 10000���̻��ΰ͸�!
select publisher, COUNT(*) from book WHERE price >=10000 GROUP BY PUBLISHER 
HAVING COUNT(*) >=2 ORDER BY PUBLISHER;
--6 ���� �̸��� �ּ� ���
select name, address from customer;
--7 ���� �̸��� �ּҿ� ��ȭ��ȣ ���
select name, address, phone from customer;
--8.�ֹ���ȣ ����ȣ ������ȣ ���
select orderid, custid, bookid from orders;
--9.������ ���� ���ǻ�
select bookname, price, PUBLISHER from book;
--10.����ȣ,������ȣ,�ǸŰ�,�ֹ���
select custid, bookid, saleprice, orderdate from orders;
--11. ���ǻ�,������
SELECT publisher, bookname from book;
--12. �ֹ��� ������ȣ
SELECT bookid from orders;
--13. �ֹ��� ������ȣ �ߺ����� 
SELECT DISTINCT bookid from orders;
--14. ������ȣ�� 5������ 8�������� ��������(*)
SELECT * FROM BOOK WHERE BOOKID BETWEEN 5 AND 8;
--15. ������ȣ�� 1~4������ , 7~10������ ��������
SELECT * FROM BOOK WHERE (BOOKID BETWEEN 1 AND 4) OR (BOOKID BETWEEN 7 AND 10);
SELECT * FROM BOOK WHERE BOOKID IN (1,2,3,4,7,8,9,10);
SELECT * FROM BOOK WHERE BOOKID NOT IN (5,6);
SELECT * FROM BOOK WHERE NOT BOOKID IN (5,6);
SELECT * FROM BOOK WHERE (BOOKID >=1 AND BOOKID <=4) OR  (BOOKID >=7 AND BOOKID <=10);
--16. ������ 8000�̻��� ������� ���ǻ�
SELECT bookname, publisher from book where price >=8000;
--17. ����ȣ�� 3,4�� ����� ����ȣ,��ȭ��ȣ
select name, custid, phone from customer where custid in (3,4);
--18. �ǸŰ��� 10000�� �̻��� ������ȣ, �ǸŰ�, �ֹ���
select BOOKID, saleprice, orderdate from orders where price >=10000;
--19. ���ǻ� �� ��������� �ܾ �� ��������
select * from book where PUBLISHER like '%������%';
--20. ���ǻ�� �ι�° ���ڰ� '��'�̶�� ���ڰ� �� ������,���ǻ��, ����
select bookname, publisher, price from book where PUBLISHER like '_��%';
--21. ������ �߱��� �����ϴ� ��������
select * from book where bookname like '�߱�%';
--22.�½����� �� ���ѹ̵�� ���ǻ翡�� �Ⱓ�� ��������
select * from book where PUBLISHER in('�½�����', '���ѹ̵��');
select * from book where PUBLISHER = '�½�����' OR PUBLISHER = '���ѹ̵��';
--23. �½��������� �Ⱓ�߰� ���������� 10000�� �̸��� ��������
select * from book where PUBLISHER like '�½�����' AND price < 10000;
--24. ���ǻ�� ������ �������� �˻�
select * from book order by PUBLISHER;
--25. ���ݼ����� �ϵ� ���� �����̸� ������ ������ �������� �˻�
SELECT * FROM BOOK ORDER BY PRICE, BOOKNAME;
--26. ���ݿ���(DESC) �����ϵ� ���������̸� ���ǻ������ ��������
SELECT * FROM BOOK ORDER BY PRICE DESC, PUBLISHER ASC;
--27. �ֹ����� ��� ������ �ǸŰ��� �հ踦 ����ϵ� ��Ī�� �Ἥ [�Ѹ���]
SELECT SUM(SALEPRICE) AS �Ѹ��� FROM ORDERS;
--28. ������ ��
SELECT COUNT(*) AS ������ FROM BOOK;
--29. ���� ��
SELECT COUNT(*) AS ���� FROM CUSTOMER;
--30. �ֹ����� �Ǽ�
SELECT COUNT(*) AS �ֹ��� FROM ORDERS;
--31. �ֹ����� ������ȣ
SELECT BOOKID FROM ORDERS;
--32. �ֹ����� ������ȣ�� �ߺ� �����ϰ�
SELECT DISTINCT BOOKID FROM ORDERS;
--33. 1�� å�� �ֹ��� ����ȣ
SELECT CUSTID FROM ORDERS WHERE BOOKID = 1;
--34.�� �Ǹž�, �� �Ǹ� �Ǽ�, ���� �ǸŰ�, �ְ� �ǸŰ�
SELECT SUM(SALEPRICE) AS ���Ǹž�, COUNT(*) AS �ѰǼ�, MIN(SALEPRICE) AS ������, 
MAX(SALEPRICE) AS �ְ� FROM ORDERS;
--35. ���� �ֹ��ݾ� �հ�
SELECT CUSTID, SUM(SALEPRICE) AS �����հ� FROM ORDERS GROUP BY CUSTID; 
--36. �ֹ���¥�� �ֹ��ݾ� �հ� �ֹ��Ǽ�
SELECT orderdate, SUM(saleprice), count(*) from orders group by orderdate;
--37. �ǸŰ����� 5000�� �̻��� ������ ������ ���� ���� ���� �ֹ����� ��
select custid, count(*) as �ֹ��� from orders where SALEPRICE >=5000 GROUP BY custid;
--38. 37�� ������ �߰��� �α��̻� ������ ����!
select custid, count(*) as �ֹ��� from orders where SALEPRICE >=5000 GROUP BY custid HAVING COUNT(*) >=2;
--39.���ǻ纰 �Ⱓ�� ������
select publisher, count(*) as ������ from book group by publisher;
--40. ���� ���ŰǼ� 
select custid, count(*) as ���ż� from orders group by custid;
--41. ������ �ֹ��Ǽ�
select bookid, count(*) as �ֹ��� from orders GROUP BY bookid;
--42. �ֹ���¥�� 14�� 7�� 1�� �ֹ�����
select * from orders where orderdate = '14/07/01';
--43. �ֹ���¥�� 14�� 7�� 1��~3�� �ֹ�����
select * from orders where orderdate between '14/07/01' and '14/07/03';
--44. ������ȣ�� 1�� ������ �̸�
select bookname from book where bookid =1;
--45. ������ 20,000�� �̻��� ������ �̸�
select bookname from book where price >= 20000;
--46. �������� �� ���ž�(�������� ����ȣ�� 1������ ���� �ۼ�)
select sum(saleprice) as "������ �Ѿ�" from ORDERS where custid = 1;
--47. �������� ������ ������ ��(�������� ����ȣ�� 1������ ���� �ۼ�)
select count(*) as "������ ������" from ORDERS where custid = 1;
--49. ���缭�� ������ �� ����
select count(*) from book;
--50. ���缭���� ������ ����ϴ� ���ǻ��� �� ����
select DISTINCT count(PUBLISHER) from book;
--51. ��� ���� �̸�, �ּ�
select name, address from CUSTOMER;
--52. 2014�� 7�� 4��~7�� 7�� ���̿� �ֹ� ���� ������ �ֹ���ȣ
select orderid from orders where orderdate between '14/07/04' and '14/07/07';
--53. 2014�� 7�� 4��~7�� 7�� ���̿� �ֹ� ���� ������ ������ ������ �ֹ���ȣ
select orderid from orders where orderdate not between '14/07/04' and '14/07/07';
select orderid from orders where not orderdate between '14/07/04' and '14/07/07';
--54. ���� ���衯 ���� ���� �̸��� �ּ�
select name, address from customer where name like '��%';
--55. ���� ���衯 ���̰� �̸��� ���ơ��� ������ ���� �̸��� �ּ�
select name, address from customer where name like '��_��';




