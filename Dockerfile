FROM openjdk:18
WORKDIR /app
COPY ./target/Cart-0.0.1-SNAPSHOT.jar /app
EXPOSE 8086
CMD ["java", "-jar", "Cart-0.0.1-SNAPSHOT.jar"]
