FROM openjdk:17-jdk-alpine

	WORKDIR /app

	COPY pom.xml . --> faz o java compilar
	COPY mvnw . 
	COPY .mvn .mvn
	COPY src ./src --> seu projeto 
	RUN chmod 777 mvnw --> Ou +x (mais seguro)

	RUN ./mvnw package --> Compila o projeto

	CMD ['java', '-jar', 'target/sitebd.war'] --> executa

