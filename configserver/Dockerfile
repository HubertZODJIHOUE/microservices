FROM maven:latest

COPY ./ ./

RUN mvn clean package

CMD ["java", "-jar", "target/configserver"]


#FROM openjdk:17
#WORKDIR /congiserver
#
#COPY target/congiserver.jar congiserver.jar
#
#CMD ["java", "-jar", "congiserver.jar"]