package org.sample.instrument.model;

public class Example {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void test() {
		System.out.println("Hello, This is ExampleClassTransformer Example");
	}
}
