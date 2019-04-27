package org.sample.instrument;

import java.lang.instrument.Instrumentation;

public class InstrumentationAgent {
	
	{
		System.out.println("In Instance Initialization Block 1");
	}
	
	{
		System.out.println("In Instance Initialization Block 2");
	}
	
	{
		System.out.println("In Instance Initialization Block 3");
	}
	
	static {
		System.out.println("In Static Initialization Blocks 1");
	}
	
	static {
		System.out.println("In Static Initialization Blocks 2");
	}
	
	static {
		System.out.println("In Static Initialization Blocks 3");
	}

	public static void premain(final String agentArgs, final Instrumentation inst) {
		System.out.println("In method [premain] | agentArgs:"+agentArgs);
	}
	
	public static void main(String []args) {
		StringBuilder sb = new StringBuilder();
		for(String arg:args) {
			sb.append(arg+" | ");
		}
		System.out.println("In method [main] | args:"+sb.toString());
	}
}
