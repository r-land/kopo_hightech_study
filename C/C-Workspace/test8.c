#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>


main()
{   //사칙연산계산기 

	double num1, num2 =0;
	double result = 0;
	char op;
	double fmod(num1, num2);

	printf("사칙연산계산기 입니다 숫자와 연산자를 입력하세요\n");
	scanf("%f %c %f", &num1, &op, &num2);
	switch (op)
	{
	case '+':result = num1 + num2;
		break;
	case '-':result = num1 - num2;
		break;
	case '*':result = num1 * num2;
		break;
	case '%':result = fmod(num1,num2);
		break;
	default: printf("잘못입력 다시입력");
		
	}
	printf("%f %c %f = %f", num1, op, num2, result);


	// 달력 출력기 
	//int num;
	//printf("1~12 사이의 수를 입력하세요\n");
	//scanf("%d", &num);
	//switch (num)
	//{
	//case 1: printf("1월은 Jan");
	//	break;
	//case 2: printf("2월은 Feb");
	//	break;
	//case 3: printf("3월은 Mar");
	//	break;
	//case 4: printf("4월은 Apr");
	//	break;
	//case 5: printf("5월은 May");
	//	break;
	//case 6: printf("6월은 Jun");
	//	break;
	//case 7: printf("7월은 Jul");
	//	break;
	//case 8: printf("8월은 Aug");
	//	break;
	//case 9: printf("9월은 Sep");
	//	break;
	//case 10: printf("10월은 Oct");
	//	break;
	//case 11: printf("11월은 Nov");
	//	break;
	//case 12: printf("12월은 Dec");
	//	break;
	//
	//default: printf("잘못입력 다시입력");

	//윤년계산기
	//int year;
	//printf("윤년확인 프로그램 년도를 입력하세요\n");
	//scanf("%d", &year);
	// 
	// 
	//if (year % 4 == 0)
	//{
	//	printf("윤년");
	//	if (year % 100 == 0) printf("평년");
	//	else if (year % 400 == 0) printf("윤년");
	//}
	//else printf("평년");


	/*if((year%4==0 && year%100 !=0)||year%400==0)*/

	}

