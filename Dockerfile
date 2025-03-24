# Tomcat 기반 Spring 실행
FROM tomcat:9-jdk17
COPY build/libs/backend-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]