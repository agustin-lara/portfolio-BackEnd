FROM amazoncorretto:20
MAINTAINER agustinlara
COPY target/portfolio-BackEnd-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
