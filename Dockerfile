FROM tomcat:jdk8-openjdk
RUN curl -s https://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.39/mysql-connector-java-5.1.39.jar -o /usr/local/tomcat/lib/mysql-connector-java.jar
COPY src /usr/local/tomcat/src
RUN mkdir -p /usr/local/tomcat/webapps/myApp/WEB-INF/classes
RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar:/usr/local/tomcat/lib/mysql-connector-java.jar", "-d", "/usr/local/tomcat/webapps/myApp/WEB-INF/classes/", "/usr/local/tomcat/src/Books.java"]