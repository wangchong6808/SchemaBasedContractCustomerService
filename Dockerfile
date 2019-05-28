FROM openjdk:8u212-jdk
COPY ./build/libs/app.jar /app/
WORKDIR /app
CMD ["java", "-jar", "app.jar"]