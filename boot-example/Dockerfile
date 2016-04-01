FROM java:8
ADD target/platform-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx768m", "-jar","/app.jar"]
