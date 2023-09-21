**instructions**
jus run mvn spring-boot:build-image
then 
 docker run --tty --publish 8080:9090 docker-spring-boot:0.0.1-SNAPSHOT
