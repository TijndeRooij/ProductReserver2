FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

COPY src ./src

RUN chown -R node /app/node_modules

EXPOSE 6000

CMD ["./mvnw", "spring-boot:run"]
