package org.sample.instrument.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExampleClassloader extends ClassLoader {
	@Override
	public Class findClass(String name) throws ClassNotFoundException {
		byte[] b = null;
		try {
			b = loadClassFromFile(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassFromFile(String fileName) throws IOException {
		return Files.readAllBytes(Paths.get("./src/main/resources/sample/ExampleSample.class"));
	}
}
