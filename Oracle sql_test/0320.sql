--1 �౸�� ���� �� ���ǻ� ����
select publisher, price from book WHERE bookname Like '�౸�� ����';
--2 ���ѹ̵�� ���ǻ� å
SELECT bookname from book where publisher like '���ѹ̵��';
--3 �������� å
select * from book where price <= 10000;
--4 �迬�� �� ��ȭ��ȣ
SELECT phone FROM Customer WHere NAME='�迬��';
--5 �迬�� �� �ּ�
SELECT address FROM Customer WHere NAME='�迬��';
-- 6 �迬�� ������ �Ѵ� 
SELECT address FROM Customer WHere NAME='�迬��' or name='������';
select address from customer where name in('�迬��','������');
--7 �����̻� å�̸� ���ǻ�
select bookname,publisher from book where price>=10000;
--8 ���ǻ� ���
select distinct publisher from book;
--9 all -��������
select all publisher from book;
--10 ���ǻ� ������ ���������˻�
select * from book order by publisher;
--11 ���ǻ�� ���ݼ� ��������
select * from book order by publisher, price; 
--12 ���ǻ�� ���ݼ� ������� ��������
select * from book order by publisher, price, bookname; 
--13 ��� ���� ������ ���
select * from book;
--14 ������� ���� �˻�
SELECT BOOKNAME,PRICE FROM BOOK;
--15 ������ ���ǻ� �˻�
SELECT BOOKNAME, PUBLISHER FROM BOOK;
--16 ���ǻ���� �ѹ����� �˻�
select DISTINCT publisher from book;
--17 ���ѹ̵�� ���ǻ��� ������ �˻�
select bookname from book where publisher like '���ѹ̵��';
--18 ������ 20000�� �̻��� ������ ���ݰ˻�
select bookname, price from book where price >=20000;
--19 ������ ���� �̻� �̸��� ���� ��������
select * from book where price BETWEEN 10000 and 20000;
select * from book where price >= 10000 and price <= 20000;
--20 ������ ���� �̸��� �︸�� ��������
select * from book where price =10000 or price =20000 or price =30000;
select * from book where price In(10000,20000,30000);
--21 ������ null�� ��������
select * from book where price is null;
--22 ������ �̸��� �̸��� ��������
select * from book where price < 20000;
--23 ���������� 20000�̸��̰� �������� �౸�� ������ ���� ����
select * from book where (price <20000) and (BOOKNAME like'�౸�� ����');
--24 �������� 20000�̸��̰ų� �������� �౸�� ���� ��������
select * from book where (price <20000) or (BOOKNAME like'�౸�� ����');
--25 ���ǻ� �½������� �Ｚ�翡�� ���� ������� ���ǻ�
select bookname,publisher from book where PUBLISHER in('�½�����','�Ｚ��');
--26 ���ǻ� �½����� �Ｚ�� �ƴ� ���ǻ翡�� ���� ������� ���ǻ�
select bookname,publisher from book WHERE PUBLISHER not in('�½�����','�Ｚ��');
--27 ���������� ������ ���������˻�
select * from book where price is not null;
select * from book where not price is null;
--28 �������� 10000�̸�, 20000�ʰ� ��������
select * from book where price < 10000 or price >20000;
select * from book where price not between 10000 and 20000;
select * from book where not price between 10000 and 20000;
--29 �������� 20000�� �������� 
select * from book where price =20000;
--30�������� 20000 �ƴ� ��������
select * from book where price not in(20000);
select * from book where NOT price =20000;
select * from book where price not =20000; ---x
--31 '�౸�� ����'�� �Ⱓ�� ���ǻ�
select publisher from book where bookname like '�౸�� ����';
select publisher from book where bookname = '�౸�� ����';
--32 ������ '�౸'�� ���Ե� ���ǻ� %---% zero or more >���ų� ���ų�
select publisher from book where bookname like '%�౸%';
--33 ���� ��¥ ���� Ȯ�� > ��� ���� :1
select sysdate from dual;
--34 ���� ��¥ ����Ȯ�� > ��� ���� : 10
select sysdate from book;
--35 �������� '�౸'�� �����ϴ� ������ ���
select bookname from book where bookname like '�౸%';
--36 ���ǻ�� �������� �����ϴ� ���ǻ翡�� �Ⱓ�� ������� ���ǻ��
select bookname,publisher from book where publisher like '����%';
--37 ������ �ι�° ���� '��'�� ������ �˻�         ���� ����:_
select bookname from book where bookname like '_��%';
--38 �౸�� ���� ���� �� ������ 20000�� �̻��� ��������
select * from book where (bookname like '%�౸%') and (price >=20000);
--39 ������ ������ �������� �˻� (order by)
select * from book order by bookname;
--40 ���ǻ� �� �˻� ���� ���ǻ�� ������ ������ ��������
select * from book order by publisher, bookname;
--41 �������ݼ� �˻� ���� �����̸� ������ ������ �˻�
select * from book order by PRICE, BOOKNAME;
--42 ������ ������ �������� �˻�
SELECT * FROM BOOK ORDER BY PRICE DESC;
--43 ������ ������ �������� �˻��ϵ� ���������� ������ ���ǻ�� ������ ��������
SELECT * FROM BOOK ORDER BY PRICE DESC, PUBLISHER;
--44 ���� �ֹ��� ������ �Ǹž��� ���ϼ���
SELECT SALEPRICE FROM ORDERS;
--45 ���� �ֹ��� ������ �� �Ǹž��� ���ϼ���
SELECT SUM(SALEPRICE) FROM ORDERS;
--46 �ֹ������� ��� �Ǹž�
SELECT AVG(SALEPRICE) FROM ORDERS;
--47 �ֹ������� �ְ� �Ǹž� 
SELECT max(SALEPRICE) FROM ORDERS;
--48 �ֹ������� ���� �Ǹž� 
SELECT min(SALEPRICE) FROM ORDERS;
--49 2�� �迬�� ���� �ֹ��� ������ �� �Ǹž��� ���Ͻÿ� --��Ī:ALIAS AS "���Ⱑ��"
select sum(saleprice) �Ѹ��� from orders where custid=2;
select sum(saleprice) as �Ѹ��� from orders where custid=2;
select sum(saleprice) as "�� ����" from orders where custid=2;
--50 ���� �ֹ��� ������ �� �Ǹž�, ��հ�, ������, �ְ�
SELECT SUM(saleprice) AS TOTAL, AVG(saleprice) AS AVERAGE, MAX(saleprice) AS MAXIMUM, MIN(saleprice) AS MiNIMUM FROM ORDERS;
--51 ���� �ֹ� �Ǽ�
SELECT COUNT(*) FROM ORDERS;
--52 ���� ��
SELECT COUNT(*) FROM CUSTOMER;
--53 ������ ��
SELECT COUNT(*) FROM BOOK;
--54 ���ǻ��� ��
SELECT COUNT(DISTINCT publisher) FROM BOOK;
--55 ���������� 13000�� ������ ��
SELECT COUNT(*) �Ǽ� FROM BOOK WHERE PRICE = 13000;
SELECT COUNT(*) AS �Ǽ� FROM BOOK WHERE PRICE = 13000;
SELECT COUNT(*) AS "�Ǽ�" FROM BOOK WHERE PRICE = 13000;