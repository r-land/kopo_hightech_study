package Game;

//인터페이스 정의
public interface Weapon {
			//추상메소드 정의
		   public void fire(int power);
		   public int getRestPower();
		   public int charge(int power);
		
		}


//게임 프로그램에서 이처럼 무기 인터페이스를 이용하여 자신만의 무기 클래스(MyWeapon)을 디자인하라. 단, 무기 클래스에는 int curPower 필드가 있고, fire는 curPower에서 power만큼 차감하고, charge는 power 만큼 curPower를 증가시킨다. 
//
//다음 주어진 코드를 바탕으로 앞에서 만든 MyWeapon을 사용하는 GameUnit 클래스의 생성자와 attack메서드를 완성하라. 
//
//GameUnit 인스턴스는 두 개 생성한다. unitPower는 각 unit에 공급되는 기본 power로 무기를 사용할 때 차감된다. 
//bossPower는 클래스 변수로 생성되는 모든 GameUnit 인스턴스에서 공유한다. 두 유닛에서의 공격으로 bossPower가 0 이하가 되면 게임이 끝난다. 단, 게임이 끝날때의 코드는 System.exit(1) 을 이용해도 된다. 
//생성자에서는 파라미터로 각 유닛의 이름을 받아 초기화하고 무기 인스턴스를 만들어 unitPower로 무기를 충전한다. 
