package com.zc.demo;

import org.junit.Test;

/**
 * @author Flyingzc
 * 使用 类字面常量 创建Class对象
 */
public class T02ZiMianLiang
{
    @Test
    public void test01()
    {
        //方式1 字面量方式,安全,编译期检查,所以不需要try..catch,类字面量方式 可用于 接口,数组,基本数据类型
        //对于 基本数据类型的包装类型,还有一个标准字段TYPE,TYPE字段是一个引用,指向该基本数据类型的Class对象
        System.out.println(boolean.class==Boolean.TYPE);//true
        System.out.println(char.class==Character.TYPE);//true
        System.out.println(byte.class==Byte.TYPE);//true
        System.out.println(short.class==Short.TYPE);//true
        System.out.println(int.class==Integer.TYPE);//true
        System.out.println(long.class==Long.TYPE);//true
        System.out.println(float.class==Float.TYPE);//true
        System.out.println(double.class==Double.TYPE);//true

        //!!!包装类.TYPE 返回的是该包装类对应的 基本数据类型的Class对象
        System.out.println(Boolean.class==Boolean.TYPE);//false
        
    }
}
