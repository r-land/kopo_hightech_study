package Game;

public class MyWeapon implements Weapon {
	//�Ӽ�(�ʵ�)
	 private int curPower;
	 
	@Override
	public void fire(int power) {
		this.curPower = curPower-power;
	}

	@Override
	public int getRestPower() {
		return this.curPower;
	}

	@Override
	public int charge(int power) {
		return this.curPower = curPower+power;
	}

	public static void fire() {
		// TODO Auto-generated method stub
		
	}
	


}
