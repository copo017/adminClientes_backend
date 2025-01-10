# Usa una imagen base con Java 21
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . /app

# Da permisos al archivo mvnw (si usas Maven Wrapper)
RUN chmod +x mvnw

# Construye el proyecto usando Maven
RUN ./mvnw clean package

# Expone el puerto configurado en application.properties
EXPOSE 8079

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/admclientes-0.0.1-SNAPSHOT.jar"]
