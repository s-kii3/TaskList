FROM eclipse-temurin:17-jdk-alpine
ENTRYPOINT ["java","-jar","/app/build/libs/TaskList-0.0.1-SNAPSHOT.jar"]
