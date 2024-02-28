FROM openjdk:17-jdk as builder
WORKDIR jv-bot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bot.jar
RUN java -Djarmode=layertools -jar bot.jar extract

FROM openjdk:17-jdk
WORKDIR jv-bot
COPY --from=builder jv-bot/dependencies/ ./
COPY --from=builder jv-bot/spring-boot-loader/ ./
COPY --from=builder jv-bot/snapshot-dependencies/ ./
COPY --from=builder jv-bot/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
EXPOSE 8080
