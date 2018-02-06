package com.zc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 利用反射实现工厂类
 * @author zc
 */
public class T04FactoryRef {
	public static void main(String[] args) {
		//配置文件中配置了名字和全类名的关系
		FileInputStream fis=null;
		Properties pros=new Properties();
		try {
			fis = new FileInputStream("factory.properties");
			pros.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ShuCaiFactory s=new ShuCaiFactory();
		s.getInstance(pros.getProperty("BaiCai"));
	}
}

interface ShuCai{
	
}

class BaiCai implements ShuCai{
	public BaiCai(){
		System.out.println("白菜");
	}
}

class LaJiao implements ShuCai{
	public LaJiao(){
		System.out.println("辣椒");
	}
}

class ShuCaiFactory{
	public ShuCai getInstance(String className){
		ShuCai s=null;
		try {
			s=(ShuCai) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
}