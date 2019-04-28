package org.sample.instrument.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;

public class ExampleClassTransformer implements ClassFileTransformer {

	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) {
		byte[] byteCode = classfileBuffer;
		if (className != null && className.equals("org/sample/instrument/model/Example")) {
			System.out.println("org.sample.instrument.classloader.ExampleClassTransformer | org.sample.instrument.model.Example is Present");
			FileInputStream file;
			try {
				file = new FileInputStream("./src/main/resources/sample/Example.class");
				int k = file.read(), i = 0, j = 0;
				List<Byte> ks = new ArrayList<Byte>();
				while (k != -1) {
					ks.add((byte) k);
					k = file.read();
					i = i + 1;
				}
				byte[] custom = new byte[ks.size()];
				for (Byte b : ks) {
					custom[j] = b.byteValue();
					j = j + 1;
				}
				byteCode = custom;
			} catch (FileNotFoundException e) {
				System.out.println("FileNotFoundException");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
			}

		}
		return byteCode;
	}
}
