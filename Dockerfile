FROM openjdk:11-jre-slim
ADD target/backend20170569-image.jar backend20170569-image.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend20170569-image.jar"]


#FROM openjdk:11-jre-slim
#WORKDIR /home
#ENV TZ="America/Lima"
#COPY /target/EMA-0.0.1-SNAPSHOT.jar ema.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "backend20170569-image.jar"]


# > mvn clean package
# > docker build -t 404ms/ema .
# > docker run -p 8080:8080 my-image
# > docker run -d -p 80:8080 my-image