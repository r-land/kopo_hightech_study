package Game;

//�������̽� ����
public interface Weapon {
			//�߻�޼ҵ� ����
		   public void fire(int power);
		   public int getRestPower();
		   public int charge(int power);
		
		}


//���� ���α׷����� ��ó�� ���� �������̽��� �̿��Ͽ� �ڽŸ��� ���� Ŭ����(MyWeapon)�� �������϶�. ��, ���� Ŭ�������� int curPower �ʵ尡 �ְ�, fire�� curPower���� power��ŭ �����ϰ�, charge�� power ��ŭ curPower�� ������Ų��. 
//
//���� �־��� �ڵ带 �������� �տ��� ���� MyWeapon�� ����ϴ� GameUnit Ŭ������ �����ڿ� attack�޼��带 �ϼ��϶�. 
//
//GameUnit �ν��Ͻ��� �� �� �����Ѵ�. unitPower�� �� unit�� ���޵Ǵ� �⺻ power�� ���⸦ ����� �� �����ȴ�. 
//bossPower�� Ŭ���� ������ �����Ǵ� ��� GameUnit �ν��Ͻ����� �����Ѵ�. �� ���ֿ����� �������� bossPower�� 0 ���ϰ� �Ǹ� ������ ������. ��, ������ �������� �ڵ�� System.exit(1) �� �̿��ص� �ȴ�. 
//�����ڿ����� �Ķ���ͷ� �� ������ �̸��� �޾� �ʱ�ȭ�ϰ� ���� �ν��Ͻ��� ����� unitPower�� ���⸦ �����Ѵ�. 
