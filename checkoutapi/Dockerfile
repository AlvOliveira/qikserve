# Usar uma imagem base com Maven e JDK 23 para a fase de build
FROM maven:3.9.9-eclipse-temurin-23 AS build

# Define o diretório de trabalho para a fase de build
WORKDIR /app

# Copiar os arquivos do projeto para o container
COPY pom.xml .
COPY src ./src

# Compilar o projeto
RUN mvn clean package -DskipTests

# Segunda fase: criar a imagem final
FROM eclipse-temurin:23-jre-alpine

# Define o diretório de trabalho para a execução
WORKDIR /app

# Copiar o JAR gerado na fase de build
COPY --from=build /app/target/checkoutapi-*.jar app.jar

# Expõe a porta 8080 para acesso externo
EXPOSE 8080

# Comando para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
