package miniproject_db;

public interface IShop {
	
//	setTitle : ���θ� ���� �ޱ�
//===========================================
	public abstract void setTitle(String title);
	
//	genUser : ����� ���� ����ϱ�
//===========================================

	public abstract void genUser();
	
//	genProduct : ��ǰ���� ����ϱ�
//===========================================
	public abstract void genProduct();
	
//	start : ���θ� ��ü����� ���� �ó����� �ֱ� 
//===========================================
	public abstract void start();
}
