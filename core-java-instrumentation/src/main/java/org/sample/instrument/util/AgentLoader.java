package org.sample.instrument.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

public class AgentLoader {
	private static Logger LOGGER = LoggerFactory.getLogger(AgentLoader.class);

	public static void run(String[] args) throws AttachNotSupportedException, IOException {
		String agentFilePath = "src/main/resources/sample/instrumentAgent.jar";
		String applicationName = "org.sample.instrument.MyInstrumentationAgent";
		File agentFile = new File(agentFilePath);
		System.setProperty( "java.library.path", agentFile.getAbsolutePath() );
		// iterate all jvms and get the first one that matches our application name
		java.util.List<VirtualMachineDescriptor> descriptors = VirtualMachine.list();
		for(VirtualMachineDescriptor smd:descriptors) {
			System.out.println(smd.id()+" | "+smd.displayName());
			VirtualMachine jvm = VirtualMachine.attach(smd.id());
			System.out.println("JVM:  ==>"+jvm);
		}
		Optional<String> jvmProcessOpt = null;
		/*
		 * Optional<String> jvmProcessOpt =
		 * Optional.ofNullable(VirtualMachine.list().stream().filter(jvm -> {
		 * LOGGER.info("jvm:{}", jvm.displayName()); return
		 * jvm.displayName().contains(applicationName); }).findFirst().get().id());
		 */
		if (!jvmProcessOpt.isPresent()) {
			LOGGER.error("Target Application not found");
			return;
		}
		
		try {
	       // System.setProperty( "sun.boot.library.path", agentFile.getAbsolutePath() );
	        //set sys_paths to null
			String jvmPid = jvmProcessOpt.get();
			LOGGER.info("Attaching to target JVM with PID: " + jvmPid);
			LOGGER.info("Agent Loader Path: " + agentFile.getAbsolutePath());
			VirtualMachine jvm = VirtualMachine.attach(jvmPid);
			LOGGER.info("VirtualMachine Attached successfully");
			jvm.loadAgent(agentFile.getAbsolutePath());
			//jvm.detach();
			LOGGER.info("Attached to target JVM and loaded Java agent successfully");
		} catch (Exception e) {
			LOGGER.error("Exception: ", e);
			throw new RuntimeException(e);
		}
	}

}
