//静态代理
interface Factory{
	public void doFactory();
}

//被代理类.实现接口
class MyFactory implements Factory{
	@Override
	public void doFactory() {
		// TODO Auto-generated method stub
		System.out.println("被代理类");
	}
}

class TestFactory implements Factory{
	Factory factory;
	TestFactory(Factory factory){
		this.factory=factory;
	}
	
	@Override
	public void doFactory() {
		// TODO Auto-generated method stub
		System.out.println("这是代理类中的方法.它调用被代理类");
		factory.doFactory();
	}	
}

public class Test03JingTaiDaiLi {
	public static void main(String[] args) {
		MyFactory myFactory=new MyFactory();
		TestFactory testFactory=new TestFactory(myFactory);
		testFactory.doFactory();
	}
}
