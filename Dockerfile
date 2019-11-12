FROM gradle:jdk11 AS base
COPY . .
RUN ./gradlew bootJar
EXPOSE 8080
ENTRYPOINT ["sh","-c","./build/libs/camera-iq.jar"]