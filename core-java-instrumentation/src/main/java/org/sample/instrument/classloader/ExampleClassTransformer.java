package org.sample.instrument.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleClassTransformer implements ClassFileTransformer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleClassTransformer.class);

	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) {
		byte[] byteCode = classfileBuffer;
		if (className != null && className.equals("org/sample/instrument/model/Example")) {
			LOGGER.info("org.sample.instrument.model.Example is Present");
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
				LOGGER.error("Found FileNotFoundException: ", e);
				e.printStackTrace();
			} catch (IOException e) {
				LOGGER.error("Found IOException: ", e);
				e.printStackTrace();
			}

		} else if (className != null && className.equals("org/sample/instrument/model/ExampleSample")) {
			LOGGER.info("org.sample.instrument.model.Example is Present");
			FileInputStream file;
			try {
				file = new FileInputStream("./src/main/resources/sample/ExampleSample.class");
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
				LOGGER.error("Found FileNotFoundException: ", e);
				e.printStackTrace();
			} catch (IOException e) {
				LOGGER.error("Found IOException: ", e);
				e.printStackTrace();
			}

		}
		return byteCode;
	}
}
