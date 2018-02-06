package com.zc.demo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
interface DFactory
{
    public void doFactory();
}

//被代理类.实现接口
class MyDFactory implements DFactory
{
    @Override
    public void doFactory()
    {
        System.out.println("被代理类");
    }
}

//动态代理类.实现InvocationHandler
class MyInvocationHandler implements InvocationHandler
{
    //实现了接口的被代理类的对象的声明
    Object obj;

    public Object blind(Object obj)
    {
        //实例化被代理类
        this.obj = obj;
        //返回一个代理类的对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    //当通过代理类的对象发起对实现被重写的方法的调用时.都会转化为如下的invoke()方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object returnVal = method.invoke(obj, args);
        return returnVal;
    }

}

public class T04DongTaiDaiLi
{
    //1.被代理类的对象
    MyDFactory myDFactory = new MyDFactory();

    //创建代理类的对象
    MyInvocationHandler handler = new MyInvocationHandler();

    //调用
    Object obj = handler.blind(myDFactory);

    DFactory dFactory = (DFactory) obj;
}
