package org.sample.instrument.tools;

import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleJavaCompiler {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleJavaCompiler.class);

	public static void main(String[] args) throws Exception {
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		String code = "public class CustomProcessor { /*custom stuff*/ }";
		JavaSourceFromString jsfs = new JavaSourceFromString("CustomProcessor", code);

		Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(jsfs);

		List<String> options = new ArrayList<String>();
		options.add("-d");
		// options.add( compilationPath);
		options.add("-classpath");
		URLClassLoader urlClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
		StringBuilder sb = new StringBuilder();
		for (URL url : urlClassLoader.getURLs()) {
			sb.append(url.getFile()).append(File.pathSeparator);
		}
		// sb.append( compilationPath);
		options.add(sb.toString());

		StringWriter output = new StringWriter();
		boolean success = jc.getTask(output, null, null, options, null, fileObjects).call();
		if (success) {
			LOGGER.info("Class has been successfully compiled");
		} else {
			throw new Exception("Compilation failed :" + output);
		}
	}
}
