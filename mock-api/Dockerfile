# Use a imagem oficial do OpenJDK 23 como base
FROM openjdk:23-jdk

# Defina o diretório de trabalho no contêiner
WORKDIR /app

ADD https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.25/slf4j-simple-1.7.25.jar  /app/slf4j-simple-1.7.25.jar

# Copie os arquivos do diretório local para o contêiner
COPY . /app

# Conceda permissão de execução ao script start.sh
RUN chmod +x start.sh

# Exponha a porta 8081
EXPOSE 8081

# Defina o script start.sh como o comando de entrada
#CMD ["./start.sh"]
CMD ["java", "-jar", "wiremock-standalone-2.14.0.jar", "--port", "8081", "--verbose"]
