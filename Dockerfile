FROM amazoncorretto:17.0.4-alpine as packager

# Primero creamos con jlink una JRE ligera con los módulos indispensables
RUN $JAVA_HOME/bin/jlink \
    --module-path $JAVA_HOME/jmods \
    --verbose \
    --add-modules java.base,java.desktop,java.instrument,java.management.rmi,java.naming,java.prefs,java.scripting,java.security.jgss,java.sql,jdk.httpserver,jdk.jfr,jdk.unsupported \
    --compress 2 \
    --no-header-files \
    --output /opt/jre-17-minimal

# Utilizamos una distro de linux ligera y agregamos nuestro microservicio
FROM alpine:latest
COPY --from=packager /opt/jre-17-minimal /opt/jre-17-minimal

# Add app user
ARG APPLICATION_USER=spring
# Create a user to run the application, don't run as root
RUN addgroup --system $APPLICATION_USER &&  adduser --system $APPLICATION_USER --ingroup $APPLICATION_USER

# Create the application directory
RUN mkdir /app && chown -R $APPLICATION_USER /app

COPY --chown=$APPLICATION_USER:$APPLICATION_USER ./target/demo-franquicia-hexagonal-1.0.jar /app/app.jar

WORKDIR /app
#
ENV JDBC_URL_BD=jdbc:mysql://host.docker.internal:3306/franquicia
ENV USERNAME_BD=root
ENV PASSWORD_BD=root

ENV JAVA_HOME=/opt/jre-17-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"
EXPOSE 8080
#CMD java -jar /app/app.jar
CMD ["java","-Djavax.net.debug=ssl:handshake:plaintext", "-Djavax.net.ssl.trustStorePassword=changeit", "-jar", "app.jar"]




#$ docker build -t jmantillap/franquicia-hexagonal:v1 .
#$ docker run -it --name franquicia-contenedor-app -p 8080:8080 <identificadorImagen>

#creacion del contenedor y que lo elimine cuando se detenga el contenedor
#$ docker build -t jmantillap/franquicia-hexagonal:v1 .
#$ docker run -it --rm --name franquicia-hexagonal-app -p 8080:8080 jmantillap/franquicia-hexagonal:v1
