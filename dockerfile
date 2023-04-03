FROM openjdk:17-jdk-alpine3.14
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/guitarras-0.0.1-SNAPSHOT.jar guitarras.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar guitarras.jar