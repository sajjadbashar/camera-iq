FROM gradle:jdk11
RUN git clone https://github.com/sajjadbashar/camera-iq.git
RUN ./camera-iq/gradlew bootJar
USER root
EXPOSE 8080
ENTRYPOINT ["sh","-c","./camera-iq/build/libs/cameraIQ-0.0.1-SNAPSHOT.jar"]

