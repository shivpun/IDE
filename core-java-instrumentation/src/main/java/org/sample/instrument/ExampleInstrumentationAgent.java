package org.sample.instrument;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.sample.instrument.classloader.ExampleClassTransformer;
import org.sample.instrument.classloader.ExampleClassloader;
import org.sample.instrument.model.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleInstrumentationAgent {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleInstrumentationAgent.class);

	public static void premain(final String agentArgs, final Instrumentation inst) throws ClassNotFoundException {
		LOGGER.info("In method [premain] | agentArgs:" + agentArgs);
		ExampleClassTransformer transformer = new ExampleClassTransformer();
		inst.addTransformer(transformer, true);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		LOGGER.info("In method [main] | args:" + args);
		example();
		exampleSample();
	}

	public static void example() {
		Example example = new Example();
		example.test();
	}
	
	public static void exampleSample() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ClassLoader classLoader = new ExampleClassloader();
 		Class clazz = classLoader.loadClass("org.sample.instrument.model.ExampleSample");
		Object obj = clazz.newInstance();
		Method method = obj.getClass().getMethod("test", null);
		method.invoke(obj, null);
	}
}
