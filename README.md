# Tutorial
[I'm an inline-style link](https://www.google.com)

## Step to Configure JDK
### A. configure JDK via [maven-compiler-plugin](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin)
#### 1. For JDK 11
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>

#### 2. For JDK 8
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>8</release>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>

#### 3. For JDK 7
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>7</release>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>