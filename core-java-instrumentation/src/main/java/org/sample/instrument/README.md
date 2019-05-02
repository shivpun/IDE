# Different type of ClassLoader
## 1. Bootstrap ClassLoader
`Bootstrap class loader serves as a parent of all the other ClassLoader instances.`
`It’s mainly responsible for loading JDK internal classes, typically rt.jar and other core libraries located in $JAVA_HOME/jre/lib directory. `

## 2. Extension ClassLoader
`Extension class loader is a child of the bootstrap class loader and takes care of loading the extensions of the standard core Java classes`

`Extension class loader loads from the JDK extensions directory, usually $JAVA_HOME/lib/ext directory or any other directory mentioned in the java.ext.dirs system property.`

## 3. System ClassLoader or Application Classloader
`The system or application class loader, on the other hand, takes care of loading all the application level classes into the JVM. `
`It loads files found in the classpath environment variable, -classpath or -cp command line option.`

SET CLASSPATH=core-java-1.0.0-SNAPSHOT.jar

java -javaagent:core-java-1.0.0-SNAPSHOT.jar org.sample.instrument.InstrumentationAgent

java -javaagent:target\core-java-1.0.0-SNAPSHOT.jar=testAgent org.sample.instrument.InstrumentationAgent

java -javaagent:target\core-java-1.0.0-SNAPSHOT.jar=testAgent org.sample.instrument.InstrumentationAgent p=o

-javaagent:D:/VM_SHARED/build-repo/maven_repo/org/sample/core-java/1.0.0-SNAPSHOT/core-java-1.0.0-SNAPSHOT.jar

For InstrumentationAgent:
-javaagent:./src/main/resources/sample/instrumentAgent.jar

For ExampleInstrumentationAgent:
-javaagent:./src/main/resources/sample/exampleInstrumentAgent.jar

Change the below According to example running:
<Main-Class>org.sample.instrument.ExampleInstrumentationAgent</Main-Class>
<Agent-Class>org.sample.instrument.ExampleInstrumentationAgent</Agent-Class>
<Premain-Class>org.sample.instrument.ExampleInstrumentationAgent</Premain-Class>
