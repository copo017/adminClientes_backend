# Usa una imagen base con Java 21
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos al contenedor
COPY . /app

# Configura JAVA_HOME explícitamente (opcional)
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk

# Da permisos al archivo mvnw
RUN chmod +x mvnw

# Construye el proyecto usando Maven
RUN ./mvnw clean package

# Expone el puerto configurado en application.properties
EXPOSE 8079

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/admclientes-0.0.1-SNAPSHOT.jar"]
