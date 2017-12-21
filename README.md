# MapStruct builder accessor

This project supports an alternative `AccessorNamingStrategy` which supports different builder styles.

**IMPORTANT**: This is not a support for using builders for mappings, but just the discovery of the properties within a builder type.

**IMPORANT2**: This is not yet published on maven central. If you want to use it as a dependency you can use [jitpack.io](https://jitpack.io/#filiphr/mapstruct-builder-accessor/)  

## Using

In order to use this accessor strategy one just needs to add the following dependencies:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>${mapstruct.version}</version>
            </path>
            <path>
                <groupId>com.github.filiphr</groupId>
                <artifactId>mapstruct-builder-accessor</artifactId>
                <version>${mapstruct-builder-accessor.version}</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

In order this to work nicely with IntelliJ (due to [IDEA-150621](https://youtrack.jetbrains.com/issue/IDEA-150621)) one needs
to add the the mapstruct processor and the builder accessor to their main pom dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>${mapstruct.version}</version>
        <!-- IntelliJ does not pick up the processor if it is not in the dependencies.
         There is already an open issue for IntelliJ see https://youtrack.jetbrains.com/issue/IDEA-150621
        -->
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.github.filiphr</groupId>
        <artifactId>mapstruct-builder-accessor</artifactId>
        <version>${project.version}</version>
        <!-- IntelliJ does not pick up the processor if it is not in the dependencies.
         There is already an open issue for IntelliJ see https://youtrack.jetbrains.com/issue/IDEA-150621
        -->
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## Building from source

In order to build this project to source you need to run `./mvnw clean install`
