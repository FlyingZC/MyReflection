import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Test07DongTaiDaiLi {
	public static void main(String[] args) {
		ComputerHandler handler=new ComputerHandler();
		//返回一个代理类
		Computer computerProxy=(Computer) handler.bind(new Dell());
		computerProxy.play();
		
		//动态代理复用
		ComputerHandler handler2=new ComputerHandler();
		Animal animalProxy=(Animal) handler2.bind(new Dog());
		animalProxy.swim();
	}
}

interface Computer{
	public void play();
}

//委托类.实现类.包含具体业务逻辑
class Dell implements Computer{
	@Override
	public void play() {
		System.out.println("Computer实现类Dell里的具体业务逻辑");
	}
}

//动态代理类.实现InvocationHandler接口.重写invoke方法
class ComputerHandler implements InvocationHandler{

	private Object target;
	
	//绑定委托对象.并返回一个代理类
	Object bind(Object target){
		this.target=target;
		//获得代理对象
		//使用import java.lang.reflect.Proxy;类的newProxyInstance(ClassLoader classLoader,class<?>[] interfaces,InvocationHandler h)方法
		//target.getClass().getInterfaces()返回当前类的所有接口组成的数组
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("play方法调用之前");
		//添加这句
		method.invoke(target, args);
		System.out.println("play方法调用之后");
		return null;
	}
	
	
	
}


interface Animal{
	public void swim();
}

class Dog implements Animal{

	@Override
	public void swim() {
		System.out.println("dog游泳");
		
	}
}



