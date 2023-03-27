#FROM maven:latest
#COPY ./ ./
#RUN mvn clean package
#CMD ["java","-jar","target/livraison.jar"]

FROM openjdk:17
WORKDIR /produit

COPY target/produit.jar produit.jar

CMD ["java", "-jar", "produit.jar"]