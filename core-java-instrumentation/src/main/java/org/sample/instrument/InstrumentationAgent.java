package org.sample.instrument;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstrumentationAgent {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InstrumentationAgent.class);

	{
		LOGGER.info("In Instance Initialization Block 1");
	}

	{
		LOGGER.info("In Instance Initialization Block 2");
	}

	{
		LOGGER.info("In Instance Initialization Block 3");
	}

	static {
		LOGGER.info("In Static Initialization Blocks 1");
	}

	static {
		LOGGER.info("In Static Initialization Blocks 2");
	}

	static {
		LOGGER.info("In Static Initialization Blocks 3");
	}

	public static void premain(final String agentArgs, final Instrumentation inst) throws ClassNotFoundException {
		LOGGER.info("In method [premain] | agentArgs:" + agentArgs);
	}

	public static void agentmain(String agentArgs, Instrumentation inst) {
		System.out.println("In method [agentmain] | agentArgs:" + agentArgs);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			sb.append(arg + " | "); 
		}
		LOGGER.info("In method [main] | args:" + sb.toString());
	}
}
