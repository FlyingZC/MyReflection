package com.zc.ref;

import java.io.Serializable;

import org.junit.Test;

public class T08ClassMethod
{
    @Test
    public void test01()
    {
        //前面是 后面 的 超类型或超接口,或就是该类型 返回true
        System.out.println(Object.class.isAssignableFrom(A.class));//true
        System.out.println(A.class.isAssignableFrom(Object.class));//false
        System.out.println(A.class.isAssignableFrom(A.class));//true
        System.out.println(B.class.isAssignableFrom(A.class));//false
        
        System.out.println(Serializable.class.isAssignableFrom(C.class));//true
    }
}

class A
{
    
}
class B extends A
{
    
}

class C implements Serializable
{
    
}