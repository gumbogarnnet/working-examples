 # To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8
expose 8080
add target/docker-mongo-db.jar docker-mongo-db.jar
entrypoint ["java","-jar","docker-mongo-db.jar"]
CMD ["/bin/sh"]
