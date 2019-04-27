# IDE
SET CLASSPATH=core-java-1.0.0-SNAPSHOT.jar

java -javaagent:core-java-1.0.0-SNAPSHOT.jar org.sample.instrument.InstrumentationAgent

java -javaagent:target\core-java-1.0.0-SNAPSHOT.jar=testAgent org.sample.instrument.InstrumentationAgent

java -javaagent:target\core-java-1.0.0-SNAPSHOT.jar=testAgent org.sample.instrument.InstrumentationAgent p=o

-javaagent:D:/VM_SHARED/build-repo/maven_repo/org/sample/core-java/1.0.0-SNAPSHOT/core-java-1.0.0-SNAPSHOT.jar