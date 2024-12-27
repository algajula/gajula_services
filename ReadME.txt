Swagger UI:  http://localhost:8080/gajula/swagger-ui/index.html
contectpath: /gajula

Tech Stack:
JDK Version == 17
Spring Boot == 3.3.4
Tomcat == 10x
Maven == 3.x
kafka  == kafka_2.13-2.8.0

classpath:
SET PATH=C:\ALLABAKASH\setups\jdk-17.0.11\bin;%PATH%
SET JRE_HOME=C:\ALLABAKASH\setups\jdk-17.0.11

ENV:
SET PATH=C:\ALLABAKASH\setups\jdk-17.0.11\bin;%PATH%
SET JAVA_HOME=C:\ALLABAKASH\setups\jdk-17.0.11
SET JRE_HOME=C:\ALLABAKASH\setups\jdk-17.0.11
SET JBOSS_HOME=C:\ALLABAKASH\setups\wildfly27
SET PATH=C:\Windows\System32;%PATH%
SET PATH=C:\winutils\bin;%PATH%
Modules: C:\ALLABAKASH\setups\jboss\modules\javax\servlet

Modules:
Database: H2 database
Schedular: cron jobs
static resources: bydefault  ==  classpath:/resources/static/css ( |js|images|txt/sql|docs )
ViewResolver: Jstl view  == gajula/views/.jsp

db tables:
SELECT * FROM GAJULA_SERVICES.BOOK;
SELECT * FROM GAJULA_SERVICES.AUTHOR;

kafka:
SET PATH=C:\ALLABAKASH\setups\kafka\bin\windows;%PATH%
zookeeper.properties:
dataDir=C:/kafkalogs/zookeeper
server.properties:
log.dirs=C:/kafkalogs/server

if required set path
SET PATH=C:\Windows\System32;%PATH%
SET PATH=C:\Windows\System32\wbem;%PATH%

launch:
cmd> zookeeper-server-start.bat C:\ALLABAKASH\setups\kafka\config\zookeeper.properties
cmd> kafka-server-start.bat C:\ALLABAKASH\setups\kafka\config\server.properties

kafka-topics.bat --list --bootstrap-server localhost:9092
kafka-topics.bat --create --topic CUSTOMER_TOPIC --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4
kafka-topics.bat --create --topic CUSTOMER_TOPIC_ERROR --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4
kafka-topics.bat --create --topic BOOK_TOPIC --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4
kafka-topics.bat --create --topic BOOK_TOPIC_ERROR --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4
kafka-topics.bat --list --bootstrap-server localhost:9092

kafka-topics.bat --describe --bootstrap-server localhost:9092 --topic CUSTOMER_TOPIC
kafka-consumer-groups --bootstrap-server localhost:9092 --all-groups --describe
kafka-console-producer.bat --bootstrap-server localhost:9092 --topic CUSTOMER_TOPIC
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic CUSTOMER_TOPIC  --from-beginning
message:
{"custNumber":1103,"custName":"test3","emailAddress":"test3@GMAIL.COM","phone":1112223331,"createdDate":"2021-08-13 08:20:03","modifiedDate":"2021-08-13 08:20:03","vehicleList":[{"vin":"vin1103","vrn":"vrn1003"}]}
