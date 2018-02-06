package com.zc.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.zc.demo.Person;

/**
 * @author flyingzc
 *
 */
public class T07EnumReflection
{
    @Test
    public void test01() throws IllegalAccessException, InvocationTargetException
    {
        A obj = new A();
        Class<A> clazz = A.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
        {
            field.setAccessible(true);
            //以下三种判断Class对象是否是枚举实例的,其中field.getType().getSuperclass().equals(Enum.class)
            //在field为基本数据类型的Class对象时,会报空指针,因为它没有superclass
            if (java.lang.Enum.class.isAssignableFrom(field.getType()) || field.getType().isEnum())
            {
                String enumStr = "E_1";
                Class<Enum> enumClazz = (Class<Enum>) field.getType();
                field.set(obj, Enum.valueOf(enumClazz, enumStr));
                
                Enum<? extends Enum> fieldValue = (Enum<? extends Enum>) field.get(obj);
            }
        }
    }
}

class A
{
    private int age;

    private String boyName;

    private Person person;

    private E en;

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getBoyName()
    {
        return boyName;
    }

    public void setBoyName(String boyName)
    {
        this.boyName = boyName;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public E getEn()
    {
        return en;
    }

    public void setEn(E en)
    {
        this.en = en;
    }

}

enum E
{
    E_1, E_2;
}
