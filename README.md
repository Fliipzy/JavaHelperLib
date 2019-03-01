# freds.helperlib :books:

## The purpose for creating this code library:
The initial idea was to create a library of code that would help ease future development in java. This will hopefully be updated regulary, as I encounter repetitive, tedious, patterns that could be implemented in the library. So I was not to reinvent the wheel for each new project.

## How to use the library
To use the it you need to add the <b>Freds-helperlib-\<version>.jar</b> to your java project.
There are numerous ways to accomplish this task:

### 1. With a Maven project:
This method installs the .jar file into you local Maven repository:

    mvn install:install-file -Dfile=<path-to-file> -DgroupId=<group-id> \
    -DartifactId=<artifact-id> -Dversion=<version> -Dpackaging=<packaging> \
    -DgeneratePom=true

Where each refers to:

< path-to-file >: the path to the file to load e.g -> c:\kaptcha-2.3.jar

< group-id >: the group that the file should be registered under e.g -> com.google.code

< artifact-id >: the artifact name for the file e.g -> kaptcha

< version >: the version of the file e.g -> 2.3

< packaging >: the packaging of the file e.g. -> jar

[Reference]("http://maven.apache.org/general.html#importing-jars")