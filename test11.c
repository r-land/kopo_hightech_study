#include<stdio.h>
main()
{ 
	////��������1
	//int i, tot, num;
	//tot = 0;
	//num = 1;
	//for (i = 0; i < 10; i++) {
	//	tot = tot + num;
	//	num = num + i;
	// printf("num=%d\n", num);
	//}
	//printf("%d", tot); }

	
	////��������2
	//int i, sum;
	//sum = 0;
	//for (i = 1; i < 10; i= i+ 2) {
	//	sum = sum + i;
	//}
	//	printf("%d", sum);

	//int i, sum, total;
	//sum = 0;
	//total = 0;
	//for (i = 1; i <= 10; i++) {
	//	sum = sum + i;
	//	total = total + sum;		
	//}
	//printf("������ %d", total);

	//�����
	int i, j;
	for (i = 1; i <= 5; i++) {
		for (j = 0; j < i; j++){
			printf("*");
		}
		printf("\n");
	}
}