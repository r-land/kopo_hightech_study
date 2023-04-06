package chap04;

public class Book {
	
	//멤버변수
	String title; 	
	String author; 	
	String name ="조아름";
	//메소드
	//생성자메소드
	Book(){
		System.out.println(name);
	} //기본생성자 Default
	Book(String title){
		this("", ""); //(생성자중에서 파리미터 아무겂도 없는 값)
		this.title = title; //this는 멤버변수,멤버함수에만
		this.author = "작자미상";
			}
	Book(String title, String author){
		this.title =title;
		this.author = author;
	}
	//일반메소드
	void printBook() {
		System.out.println(this.title + " : " + this.author);
	}
	
	public static void main(String[] args) {
		Book book = new Book();
		Book littlePrince = new Book("어린왕자", "생택쥐페리");
		Book loveStory = new Book("춘향전");
		littlePrince.printBook();
		loveStory.printBook();	
		book.title ="북이예요";
		System.out.println(book.title);

	}

}
