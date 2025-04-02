FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8083

EXPOSE 8083

COPY target/demo-${VERSION}.jar /opt/class/class.jar

CMD ["java", "-jar", "/opt/class/class.jar"]