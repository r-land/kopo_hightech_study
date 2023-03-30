package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission_homework {

public static void main(String args[]) {
    Random r = new Random();
    Scanner scan = new Scanner(System.in);


    while(true){
        int com = r.nextInt(100); //랜덤수생성 0~99
        System.out.println("수를 결정하였습니다. 맞추어 보세요");
        int count = 1;
        int max = 99;
        int min = 0;
        String re = null;

        while(true){  //이중 반복문 
            System.out.println(min+"-"+max);
            System.out.print(count+">>");
            int user = scan.nextInt();

            if(user==com){ // 다중 if-else 
                System.out.print("맞았습니다.\n 다시하시겠습니까?(y/n)>>");
                re = scan.next();
                if(re.equals("y")) //중첩 if-else
                    continue;
                else  break; }   //탈출조건

            else if(user>com){
                System.out.println("더 낮게");
                if(user < max) //오답도 반영하는 조건문 
                max = user; }

            else {
                System.out.println("더 높게");
                if(user>min)
                min = user;}

                count++;   
        }

        System.out.print("프로그램을 종료합니다.");
        scan.close();

    }




}

}