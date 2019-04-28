package org.sample.instrument;

import java.lang.instrument.Instrumentation;

import org.sample.instrument.classloader.ExampleClassTransformer;
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
	
	public static void main(String []args) {
		LOGGER.info("In method [main] | args:"+args);
		Example example = new Example();
		example.test();
	}
}
