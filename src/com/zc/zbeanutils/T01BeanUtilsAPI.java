package com.zc.zbeanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.zc.demo.Person;

/**
 * @author flyingzc
 *
 */
public class T01BeanUtilsAPI
{
    @Test
    public void test01() throws IllegalAccessException, InvocationTargetException
    {
        A obj = new A();
        //BeanUtils.setProperty(Object bean, String name, Object value)
        BeanUtils.setProperty(obj, "age", "1");
        BeanUtils.setProperty(obj, "boyName", "str");
        BeanUtils.setProperty(obj, "person", new Person());
        BeanUtils.setProperty(obj, "e", E.E_1);
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
    E_1,E_2;
}