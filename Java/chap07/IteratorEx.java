package chap07;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {

	public static void main(String[] args) {
	Vector<Integer> v = new Vector<Integer>();
	v.add(10);
	v.add(20);
	v.add(30);
	v.add(40);
	v.add(50);
	
	Iterator<Integer> it = v.iterator();
	while(it.hasNext())
	System.out.println(it.next());
	

	}

}
