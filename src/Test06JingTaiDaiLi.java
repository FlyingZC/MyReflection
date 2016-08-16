//静态代理:给某个对象提供一个代理对象，并由代理对象控制对于原对象的访问，
//即客户不直接操控原对象，而是通过代理对象间接地操控原对象
//定义接口Book,具体实现类EnglishBook,代理类BookProxy用来调用接口中的方法.实现类具体实现接口中的方法
public class Test06JingTaiDaiLi {
	public static void main(String[] args) {
		BookProxy bookProxy=new BookProxy(new EnglishBook());
		bookProxy.read();
	}
}

//接口
interface Book{
	public void read();
}
//接口的具体实现类
class EnglishBook implements Book{
	@Override
	public void read() {
		System.out.println("接口具体实现类中的read方法");		
	}
}

//代理类
class BookProxy	implements Book{
	private Book book;
	public BookProxy(Book book){
		this.book=book;
	}
	
	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println("代理类调用之前");
		book.read();
		System.out.println("代理类调用之后");
	}
}



