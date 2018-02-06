package com.zc.example;

public class Person
{
    private int age;
    private Integer number; 
    private String name;
    private String[] hobbies;
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public Integer getNumber()
    {
        return number;
    }
    public void setNumber(Integer number)
    {
        this.number = number;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String[] getHobbies()
    {
        return hobbies;
    }
    public void setHobbies(String[] hobbies)
    {
        this.hobbies = hobbies;
    }
    
    private String print(int age,Integer number,String[] hobbies)
    {
        return "123hahasdfsd";
    }
    private String print(int age,Integer number,String name,String[] hobbies)
    {
        System.out.println(age+number+name+hobbies);
        return "123haha";
        
    }
}
