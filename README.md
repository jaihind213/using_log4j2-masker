# using_log4j2-masker
Demonstrating use of log4j2-masker library. how to censor sensitive words in logs.

i.e. how to use https://github.com/jaihind213/using_log4j2-masker

### Prerequisites

java 17, maven3

### Build

```bash
mvn clean package
```

### Run demo

refer to log4j2.properties in resources folder  for configuration.
```bash
cd target
java -cp .:fat-using_log4j2-masker-1.0-SNAPSHOT.jar io.github.jaihind213.Demo
# u can pass path to log4j2.properties using -Dlog4j.configurationFile=/tmp/log4j2.properties
```

### Output:
```text
LogCensor for logger created. enabled: true .options are: [enabled=true]
25/04/13 15:03:47 INFO Demo: Trying to log the db passwd: ******
25/04/13 15:03:47 INFO Demo: Connecting to database with user: ****** and password: ******
25/04/13 15:03:47 INFO Demo: Connecting to AWS with access key: ****** and client id: ******
25/04/13 15:03:47 INFO Demo: logging (non-sensitive config) Threshold days: 10
```

### Notes:

- For this demo, we are using **Log4j2 version 2.24.3**.
- For **Log4j2 versions > 2.20.0**, please refer to the [`pom.xml`](./pom.xml) for instructions on how to shade the JAR correctly.
- For the following Log4j2 versions,
    - `2.20.0`
    - `2.19.0`
    - `2.18.0`
    - `2.17.2`
    - `2.17.1`
    - `2.8.1`
    - `2.8`
    - `2.7`
    - `2.6.2`
    - `2.6.1`
    - `2.1`
      - refer to the [`pom_legacy.xml`](./pom_legacy.xml)  on how to shade the JAR correctly.
