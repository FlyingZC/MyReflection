package com.zc.exer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class T03DongTaiDaiLi {

}
interface Computer{
	public void play();
}
class DellComputer implements Computer{
	@Override
	public void play() {
		System.out.println("DellComputer类中的play方法");
	}
}
class ComputerProxy implements InvocationHandler{
	private Object target;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return null;
	}
	
}
