FROM openjdk:17
WORKDIR /app

COPY target/com.kinective.atm-0.0.1-SNAPSHOT.jar /app/com.kinective.atm-0.0.1-SNAPSHOT.jar

EXPOSE 9999

ENTRYPOINT ["java","-jar","com.kinective.atm-0.0.1-SNAPSHOT.jar"]