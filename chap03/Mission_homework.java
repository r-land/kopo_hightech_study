package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission_homework {

public static void main(String args[]) {
    Random r = new Random();
    Scanner scan = new Scanner(System.in);


    while(true){
        int com = r.nextInt(100); //���������� 0~99
        System.out.println("���� �����Ͽ����ϴ�. ���߾� ������");
        int count = 1;
        int max = 99;
        int min = 0;
        String re = null;

        while(true){  //���� �ݺ��� 
            System.out.println(min+"-"+max);
            System.out.print(count+">>");
            int user = scan.nextInt();

            if(user==com){ // ���� if-else 
                System.out.print("�¾ҽ��ϴ�.\n �ٽ��Ͻðڽ��ϱ�?(y/n)>>");
                re = scan.next();
                if(re.equals("y")) //��ø if-else
                    continue;
                else  break; }   //Ż������

            else if(user>com){
                System.out.println("�� ����");
                if(user < max) //���䵵 �ݿ��ϴ� ���ǹ� 
                max = user; }

            else {
                System.out.println("�� ����");
                if(user>min)
                min = user;}

                count++;   
        }

        System.out.print("���α׷��� �����մϴ�.");
        scan.close();

    }




}

}