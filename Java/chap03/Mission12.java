package chap03;

public class Mission12 {

	public static void main(String[] args) {
 
//�ζ� ��ȣ ������ �迭
 int lotto_num[] = new int [7];
 String names[] = {"��", "��", "��"};
 

 for(int i=0; i<7; i++) {
	 lotto_num[i] = 1+(int)(Math.random()*45);
//�迭�� �Է�
 for(int j =0; j<i; j++)
	  if(lotto_num[i] == lotto_num[j]) i--;}
//�ߺ��� ���� 
 

	System.out.println("�迭�� : " + lotto_num.length);
	
for(int i =0;i<lotto_num.length; i++)
System.out.print(lotto_num[i] +" "); 
System.out.println();
 //�迭�����
 
 for(int i=0; i<7; i++)
 System.out.printf("%5d", lotto_num[i]);	
 System.out.println();
 //�迭�� ���
 
 for(int num : lotto_num)
 System.out.printf("%3d", num);
//foreach���� �̿��� �����
 
 System.out.println();
 
 for(String name :names)
	 System.out.print(name + " ");

	}
	}

//1.�迭 ����
//2.�迭�ʱ�ȭ
//3.�迭�Է�
//4.�迭���
//5.for- each Ȱ��
