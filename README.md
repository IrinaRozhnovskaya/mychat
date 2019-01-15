# mychat

Struts2/CDI/CQRS/JPA/PostgreSQL/Docker/JBoss EAP

build and run using docker-compose-maven-plugin (see pom.xml)
```bash
./mvnw ; ./mvnw -Pdocker docker-compose:up

open http://127.0.0.1:8080/my-chat

./mvnw -Pdocker docker-compose:down
```
