package org.sample.instrument.model;

public class SampleLoop {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			Example example = new Example();
			example.test();
			//Thread.sleep(1000);
		}
	}
}
