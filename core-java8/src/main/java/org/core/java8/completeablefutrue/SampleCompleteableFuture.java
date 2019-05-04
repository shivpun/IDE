package org.core.java8.completeablefutrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SampleCompleteableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
		System.out.println("Before [thenApply]:"+completableFuture.get());
		CompletableFuture<String> afterThenApply = completableFuture.thenApply(a -> a + " World");
		System.out.println("After [thenApply]:"+afterThenApply.get());
	}

}
