package com.zc.exer;

public class T01JingTaiDaiLi {
	public static void main(String[] args) {
		new ProxyFactory(new CommonFactoryImpl()).doFactory();;
	}
}

interface Factory{
	void doFactory();
}

class CommonFactoryImpl implements Factory{

	@Override
	public void doFactory() {
		System.out.println("commonFactoryImpl类中的doFactory方法");
	}
	
}

class ProxyFactory implements Factory{
	private Factory factory;
	public ProxyFactory(Factory factory){
		this.factory=factory;
	}
	@Override
	public void doFactory() {
		System.out.println("Proxy中的doFactory方法");
		factory.doFactory();
		System.out.println("Proxy中doFactory方法最后");
	}
	
}

