#FROM maven:latest
#COPY ./ ./
#RUN mvn clean package
#CMD ["java","-jar","target/livraison.jar"]

FROM openjdk:17
WORKDIR /gateway

COPY target/gateway.jar gateway.jar

CMD ["java", "-jar", "gateway.jar"]