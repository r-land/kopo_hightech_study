package chap06;

public class StringEx {
	public static void main(String[] args) {
		
	
	String a = new String(" C#");
	String b = new String(",C++");
	
	System.out.println(a.length());
	System.out.println(a.contains("#"));
	System.out.println(a.concat(b));
	System.out.println(a);
	System.out.println(a.trim());
	System.out.println();
	
	String c = a.concat(b);
	System.out.println(c);
	System.out.println(c.replace("C#", "java"));
	
	String s[] = c.split(",");
	for(String n:s)
		System.out.println(n);
	
	String sub = c.substring(4);
	System.out.println(sub);
	
	System.out.println(c.charAt(3));
	
	}
}
