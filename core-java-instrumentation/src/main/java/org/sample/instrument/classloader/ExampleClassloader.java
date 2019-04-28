package org.sample.instrument.classloader;

import java.io.InputStream;
import java.net.URL;

public class ExampleClassloader {
	
	public static void main(String []args) throws ClassNotFoundException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> clazz = classLoader.loadClass("org.sample.instrument.model.Example");
		URL url = ClassLoader.getSystemClassLoader().getResource(clazz.getName());
		System.out.println(url);
	}
}
