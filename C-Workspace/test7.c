#include<stdio.h>
#define _CRT_SECURE_NO_WARNINGS
main()
{
	//switch��

	//int num;
	//printf("1���� 5������ ���� �Է��Ͻÿ�.\n");
	//scanf("%d", &num);
	//switch (num)
	//{
	//case 1:printf("1 �Դϴ�");
	//	break;
	//case 2:printf("2 �Դϴ�");
	//	break;
	//case 3:printf("3 �Դϴ�");
	//	break;
	//case 4:printf("4 �Դϴ�");
	//	break;
	//case 5:printf("5 �Դϴ�");
	//	break;
	//default:
	//	printf("1���� 5������ ���� �ƴմϴ�.");


	//��������1
	//int x, y, z, large;
	//printf("���� �� ���� �Է��Ͻÿ�\n");
	//scanf("%d %d %d",&x,&y,&z);
	//large = x;
	//if (large < y)
	//	large = y;
	//if (large < z)
	//	large = z;
	//printf("���� ū���� %d �Դϴ�.", large);

	//��������2
	int num;
	printf("���� ��� ���α׷��Դϴ� ������ �Է��ϼ���\n");
		scanf("%d", &num);
		//if (num >= 90) printf("A");
		//else if (num >= 80) printf("B");
		//else if (num >= 70) printf("C");
		//else if (num >= 60) printf("D");
		//else printf("F");   

		//if �� ���� ����

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
		//switch�� ��������


}







