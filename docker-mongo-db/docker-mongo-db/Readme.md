**Readme**

*pull and run mongo container first*
-- docker pull mongo:latest 
-- docker run -d -p 27017:27017 --name ggumbomongodb mongo:latest

*build our jar file*
-- docker build -t  docker-mongo-db:1.0 .
-- docker run -p 9090:8080 --name docker-mongo-db --link ggumbomongodb:mongo -d docker-mongo-db:1.0

*checking the logs*
--docker logs ggumbomongodb
--docker logs docker-mongo-db

*ps*
--docker-mongo-db finalname of our jarfile
--ggumbomongodb is the host  of our mongo connection 
-- 27017 port to mongo connection 
--database name <anyname>
*bash*
 docker exec -it ggumbomongodb bash
 
 
 **Compose**
 -- alternatively create a docker compose file and run:docker-compose up 
 
