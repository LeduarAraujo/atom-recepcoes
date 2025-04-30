# Usar uma imagem base do Maven para construir o projeto
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Definir o diretório de trabalho para o build
WORKDIR /app

# Copiar os arquivos do projeto para o container
COPY . .

# Executar o comando Maven para construir o projeto
RUN mvn clean package -DskipTests

# Usar uma imagem base do Java para rodar o aplicativo
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado na etapa anterior
COPY --from=builder /app/target/atom-recepcoes-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o Spring Boot usa (por padrão, 8080)
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]