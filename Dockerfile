# 빌드 스테이지
FROM gradle:jdk19 AS build
WORKDIR /app
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY .env ./
COPY src ./src
RUN gradle build -x test --no-daemon

# 실행 스테이지
FROM openjdk:19-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
COPY .env .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]