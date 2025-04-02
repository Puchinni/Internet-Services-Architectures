FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8081

ENV CLASS_URL=http://priceless_tesla:8083

EXPOSE 8081

COPY target/teacher-${VERSION}.jar /opt/teacher/teacher.jar

CMD ["java", "-jar", "/opt/teacher/teacher.jar"]