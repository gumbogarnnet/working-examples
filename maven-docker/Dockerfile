# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8
ADD target/maven-docker.jar maven-docker.jar
ENTRYPOINT ["java","-jar","maven-docker.jar"]
expose 8080

CMD ["/bin/sh"]
