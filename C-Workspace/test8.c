#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>


main()
{   //��Ģ������� 

	double num1, num2 =0;
	double result = 0;
	char op;
	double fmod(num1, num2);

	printf("��Ģ������� �Դϴ� ���ڿ� �����ڸ� �Է��ϼ���\n");
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
	default: printf("�߸��Է� �ٽ��Է�");
		
	}
	printf("%f %c %f = %f", num1, op, num2, result);


	// �޷� ��±� 
	//int num;
	//printf("1~12 ������ ���� �Է��ϼ���\n");
	//scanf("%d", &num);
	//switch (num)
	//{
	//case 1: printf("1���� Jan");
	//	break;
	//case 2: printf("2���� Feb");
	//	break;
	//case 3: printf("3���� Mar");
	//	break;
	//case 4: printf("4���� Apr");
	//	break;
	//case 5: printf("5���� May");
	//	break;
	//case 6: printf("6���� Jun");
	//	break;
	//case 7: printf("7���� Jul");
	//	break;
	//case 8: printf("8���� Aug");
	//	break;
	//case 9: printf("9���� Sep");
	//	break;
	//case 10: printf("10���� Oct");
	//	break;
	//case 11: printf("11���� Nov");
	//	break;
	//case 12: printf("12���� Dec");
	//	break;
	//
	//default: printf("�߸��Է� �ٽ��Է�");

	//�������
	//int year;
	//printf("����Ȯ�� ���α׷� �⵵�� �Է��ϼ���\n");
	//scanf("%d", &year);
	// 
	// 
	//if (year % 4 == 0)
	//{
	//	printf("����");
	//	if (year % 100 == 0) printf("���");
	//	else if (year % 400 == 0) printf("����");
	//}
	//else printf("���");


	/*if((year%4==0 && year%100 !=0)||year%400==0)*/

	}

