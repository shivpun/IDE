package org.sample.instrument;

import java.io.IOException;

import org.sample.instrument.util.AgentLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.tools.attach.AttachNotSupportedException;

public class MyInstrumentationAgent {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyInstrumentationAgent.class);
	
	public static void main(String []args) throws AttachNotSupportedException, IOException {
		LOGGER.info(" In method [main] ");
		new AgentLoader().run(args);
	}
}
