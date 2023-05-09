package chap07;

public class GStack<T> {
	int tos=0;
	Object stck[];
	
	public GStack() {
		tos = 0;
		stck = new Object[10];
	}
	
	public void push(T item) {
		if(tos==10)
			return;
		stck[tos] = item; //업캐스팅 
		tos++;
	}
	
	public T pop() {
		if(tos==0)
			return null;
		tos--;
		return (T)stck[tos]; //다운캐스팅
	}

}
