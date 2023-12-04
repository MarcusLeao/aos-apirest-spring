FROM maven:3.9.5-amazoncorretto-17 AS build
COPY . .
RUN mvn clean package

FROM amazoncorretto:17
COPY --from=build /target/aos-0.0.1-SNAPSHOT.jar aos-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "aos-0.0.1-SNAPSHOT.jar"]