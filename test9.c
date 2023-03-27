#include<stdio.h>

main()
{	////for문
	//int i, tot;
	//tot = 0;
	//for (i = 0; i <= 10; i++)
	//	tot = tot + i;
	//printf("tot=%d\n", tot);

	//int i, tot, pro;
	//tot = 0;
	//pro = 1;
	//for (i = 1; i <= 10; i++) {
	//	tot = tot + i;
	//	pro = pro * i;
	//}
	//printf("tot=%d, pro=%d\n", tot, pro);


	//다중for문 곱의수행
	int i, j;
	for (i = 2; i < 10; i++) {
		for (j = 1; j <= 9; j++) {
			printf(" %d * %d = %d \n", i, j, i * j);
		}
		printf("\n");
	}



	////별찍기
	//int i, j;
	//for(i = 1; i <= 5; i++) {
	//	for (j = 0; j < i; j++) {
	//		printf("*");
	//	}
	//	printf("\n");
	//	}






}
