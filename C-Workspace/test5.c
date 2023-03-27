#include<stdio.h>
int count;
main() {
	count = 10;
	printf("전역변수count=%d", count);
	{int count = 20;
	printf("지역변수count=%d", count); }
	printf("전역변수count=%d\n" ,count);
}
//지역변수 전역변수