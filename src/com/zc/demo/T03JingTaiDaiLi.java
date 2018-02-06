package com.zc.demo;
//静态代理
interface Factory
{
    public void doFactory();
}

//被代理类.实现接口
class MyFactory implements Factory
{
    @Override
    public void doFactory()
    {
        System.out.println("被代理类");
    }
}

/**
 * @author flyingzc
 * 代理类
 */
class FactoryProxy implements Factory
{
    Factory factory;

    FactoryProxy(Factory factory)
    {
        this.factory = factory;
    }

    @Override
    public void doFactory()
    {
        System.out.println("这是代理类中的方法.它调用被代理类");
        factory.doFactory();
    }
}

public class T03JingTaiDaiLi
{
    public static void main(String[] args)
    {
        MyFactory myFactory = new MyFactory();
        FactoryProxy testFactory = new FactoryProxy(myFactory);
        testFactory.doFactory();
    }
}
