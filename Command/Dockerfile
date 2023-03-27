#FROM maven:latest
#COPY ./ ./
#RUN mvn clean package
#CMD ["java","-jar","target/commande.jar"]

FROM openjdk:17
WORKDIR /commande

COPY target/commande.jar commande.jar

CMD ["java", "-jar", "commande.jar"]