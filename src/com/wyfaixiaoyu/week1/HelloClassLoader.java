package com.wyfaixiaoyu.week1;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader{
	public static void main(String[] args) {
		try {
			HelloClassLoader helloClassLoader = new HelloClassLoader();
			Class<?> helloClass = helloClassLoader.findClass("Hello");
			Method mtd = helloClass.getMethod("hello");
			Object hello = helloClass.newInstance();
			mtd.invoke(hello, null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String byteCodeFilePath = Thread.currentThread()
				.getContextClassLoader()
				.getResource("Hello.xlass").getPath();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(byteCodeFilePath);
			byte [] buffer = new byte [fileInputStream.available()];
			fileInputStream.read(buffer);
			for (int i = 0; i< buffer.length; i++) {
				buffer[i] = (byte) (255 - buffer[i]);
			}
			return defineClass(name, buffer, 0, buffer.length);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		throw new ClassNotFoundException(name);
	}

}
