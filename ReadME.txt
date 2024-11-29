Swagger UI:  http://localhost:8080/gajula/swagger-ui/index.html
contectpath: /gajula

Tech Stack:
JDK Version == 17
Spring Boot == 3.3.4
Tomcat == 10x
Maven == 3.x

classpath:
SET PATH=C:\ALLABAKASH\setups\jdk-17.0.11\bin;%PATH%
SET JRE_HOME=C:\ALLABAKASH\setups\jdk-17.0.11

Modules:
Database: H2 database
Schedular: cron jobs
static resources: bydefault  ==  classpath:/resources/static/css ( |js|images|txt/sql|docs )
ViewResolver: Jstl view  == gajula/views/.jsp

db tables:
SELECT * FROM BOOK_SERVICES.BOOK;
SELECT * FROM BOOK_SERVICES.AUTHOR;
