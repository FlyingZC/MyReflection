package com.zc.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Administrator
 * @version  [版本号, 2017年1月10日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class RefTest
{
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Method[] methods = Person.class.getDeclaredMethods();
        int parameterLength = 4;
        for (Method method : methods)
        {   
            method.setAccessible(true);
            int len=method.getParameterTypes()==null?0:method.getParameterTypes().length;
            if (method.getName().equals("print")&&parameterLength==len)
            {
                method.invoke(new Person(), 1,2,"heh",new String[]{"hah","he"});
            }
        }
    }
}
