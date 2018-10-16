FROM gradle:4.10.2-jdk8-slim as builder
COPY --chown=gradle:gradle . /home/gradle/src/app
WORKDIR /home/gradle/src/app
RUN gradle jar --no-daemon

FROM openjdk:8-jre-slim
COPY --from=builder /home/gradle/src/app/build/libs/demo-talk.jar /service/
WORKDIR /service
ENV DEMO_WORD world
CMD ["java", "-jar", "demo-talk.jar"]
