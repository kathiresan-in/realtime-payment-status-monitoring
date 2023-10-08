FROM openjdk:18-jdk-alpine
MAINTAINER kathiresan.in@gmail.com
COPY target/realtime-payment-status-monitoring-0.0.1-SNAPSHOT.jar realtime-payment-status-monitoring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "realtime-payment-status-monitoring-0.0.1-SNAPSHOT.jar"]