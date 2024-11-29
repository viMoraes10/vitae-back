# Utilizar uma imagem base que suporta Java 17
FROM openjdk:17-slim

# Definir a pasta onde a aplicação será colocada
WORKDIR /app

# Copiar o arquivo jar executável para o diretório de trabalho (/app)
COPY build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar

# Explicar a porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "demo.jar"]
