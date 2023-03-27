#FROM maven:latest
#COPY ./ ./
#RUN mvn clean package
#CMD ["java","-jar","target/livraison.jar"]

FROM openjdk:17
WORKDIR /livraison

COPY target/livraison.jar livraison.jar

CMD ["java", "-jar", "livraison.jar"]