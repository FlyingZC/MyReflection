package com.zc.ref;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class T07Prop {
	public static void main(String[] args) throws Exception {
		//尽量面向父类或接口编程
		InputStream ips=new FileInputStream("config.properties");
		Properties props=new Properties();
		props.load(ips);
		String className=props.getProperty("className");
		Collection collection=(Collection) Class.forName(className).newInstance();
		//释放对象关联的系统资源.即ips对象仍然会由垃圾回收期回收,但是之前关闭与之关联的系统资源
		try {
			ips.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
