
public class Person {
	public String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void show(){
		
		System.out.println("我是一个人");
	}
	
	public void display(String gj){
		System.out.println("我是一个"+gj);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person--name:"+" "+getName()+" "+"age:"+getAge();
	}
}
