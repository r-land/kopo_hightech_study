package Game;

import java.util.Random;

public class GameUnit  {
	static Random rand = new Random();
	static int bossPower = 10000;
    private int unitPower = 5000;
 
    private MyWeapon weapon; 
    private String name;

    	//�����ڸ޼ҵ� ����
    public GameUnit(String name) {
    	this.name = name;
    	weapon = new MyWeapon();
    	weapon.charge(unitPower);
    }  
    //attack() ����
	void attack(int power) {
		GameUnit.bossPower = bossPower - power;	
}   	 

	
	
	
    public static void main(String[] args){ 

        GameUnit unit1 = new GameUnit("unit1");
        GameUnit unit2 = new GameUnit("unit2");
        while(true){ 
        
        			unit1.attack(500);
        			unit2.attack(500);
        	
        			
        if(GameUnit.bossPower <=0) {
        	System.out.println("���ӽ¸�! - ���� �����մϴ�.");
        	System.exit(0);
        }
        else
        	System.out.println("������ BOSSPOWER :" + GameUnit.bossPower);
        }

		
	}
   
}
