#include<stdio.h>
int count;
main() {
	count = 10;
	printf("��������count=%d", count);
	{int count = 20;
	printf("��������count=%d", count); }
	printf("��������count=%d\n" ,count);
}
//�������� ��������