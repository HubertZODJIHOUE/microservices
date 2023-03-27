#FROM maven:latest
#COPY ./ ./
#RUN mvn clean package
#CMD ["java","-jar","target/eureka.jar"]

FROM openjdk:17
WORKDIR /eureka

COPY target/eureka.jar eureka.jar

CMD ["java", "-jar", "eureka.jar"]