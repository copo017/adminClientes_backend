# Usa una imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Configura la variable JAVA_HOME (esto asegura que Render lo reconozca)
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos al contenedor
COPY . /app

# Da permisos al archivo mvnw
RUN chmod +x mvnw

# Construye el proyecto usando Maven
RUN ./mvnw clean package

# Expone el puerto configurado en application.properties
EXPOSE 8079

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/admclientes-0.0.1-SNAPSHOT.jar"]
