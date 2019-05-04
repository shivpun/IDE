package org.core.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class SampleLambda {

	private String values;

	public SampleLambda() {
	}

	public SampleLambda(String values) {
		super();
		this.values = values;
	}

	public static void main(String[] args) {
		// Zero parameter
		Sample sample = () -> System.out.println("Zero parameter lambda");
		sample.print();

		// One parameter
		Sample1 sample1 = (p) -> System.out.println("One parameter lambda: " + p);
		sample1.print("First Parameter");

		// Multiple parameters
		Sample2 sample2 = (p, q) -> System.out.println("Multiple parameter lambda: " + p + " | " + q);
		sample2.print("First Parameter", "Second Parameter");

		// Using an anonymous class
		Supplier<List<String>> s = new Supplier() {
			public List<String> get() {
				return new ArrayList<String>();
			}
		};
		List<String> l = s.get();

		// Using a lambda expression
		Supplier<List<String>> s2 = () -> new ArrayList<String>();
		List<String> l2 = s.get();

		// Using a method reference can't use interface without body implementation
		Supplier<List> s3 = ArrayList::new;
		List<String> l3 = s.get();

		Consumer<Integer> display = a -> System.out.println(a);

		Function<String, SampleLambda> sampleLambda = SampleLambda::new;
		SampleLambda sl = sampleLambda.apply("Hello");
		
		Supplier<SampleLambda> supl = ()->sampleLambda.apply("Hello");
		System.out.println(sl);
		
		System.out.println(supl);
		// Implement display using accept()
		display.accept(10);

		// Consumer<? super T> action via Lambda Expression
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		values.forEach(a -> System.out.print(a));
		System.out.println("\n Method Reference");
		// Consumer<? super T> action static method Reference
		values.forEach(System.out::print);
	}

	public interface Sample {
		public void print();
	}

	public interface Sample1 {
		public void print(String a);
	}

	public interface Sample2 {
		public void print(String a, String b);
	}
}
