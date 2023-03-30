#include<stdio.h>
#define _CRT_SECURE_NO_WARNINGS
main()
{
	//switch문

	//int num;
	//printf("1에서 5사이의 값을 입력하시오.\n");
	//scanf("%d", &num);
	//switch (num)
	//{
	//case 1:printf("1 입니다");
	//	break;
	//case 2:printf("2 입니다");
	//	break;
	//case 3:printf("3 입니다");
	//	break;
	//case 4:printf("4 입니다");
	//	break;
	//case 5:printf("5 입니다");
	//	break;
	//default:
	//	printf("1에서 5사이의 값이 아닙니다.");


	//연습문제1
	//int x, y, z, large;
	//printf("정수 세 개를 입력하시오\n");
	//scanf("%d %d %d",&x,&y,&z);
	//large = x;
	//if (large < y)
	//	large = y;
	//if (large < z)
	//	large = z;
	//printf("제일 큰수는 %d 입니다.", large);

	//연습문제2
	int num;
	printf("학점 계산 프로그램입니다 점수를 입력하세요\n");
		scanf("%d", &num);
		//if (num >= 90) printf("A");
		//else if (num >= 80) printf("B");
		//else if (num >= 70) printf("C");
		//else if (num >= 60) printf("D");
		//else printf("F");   

		//if 문 학점 계산기

		switch (num/10)
		{
		case 9:printf("A");
			break;
		case 8:printf("B");
			break;
		case 7:printf("C");
			break;
		case 6:printf("D");
			break;
		default:
			printf("F");
		}
		//switch문 학점계산기


}







