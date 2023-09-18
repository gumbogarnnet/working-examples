quick recap


(spring-boot)
1)Create Dockerfile
2)docker build -T spring-boot-docker.jar .
3)docker image ls
3)docker run -p 9090:8080 


Lesson 2 adding the image to dockerhub
docker tag spring-boot-docker.jar ggumbo/spring-boot-docker.jar
docker push  ggumbo/spring-boot-docker.jar
docker pull  ggumbo/spring-boot-docker.jar
