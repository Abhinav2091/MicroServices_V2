#Installing Docker
https://docs.docker.com/


https://hub.docker.com/editions/community/docker-ce-desktop-windows/

#important my window was Windows 10 Home so i dont have virtulization enable 
#so downloadd docker for window Home


#Recommendation 1

If you are using Windows, make sure that you use PowerShell instead of Command Prompt.

#Recommendation 2

If you are using Window 10 and are using docker toolbox

Use 192.168.99.100 instead of localhost.

#Note: If 192.168.99.100 does not work, you can find the IP by using the command docker-machine ip

#Reason

In Window 10 when using docker toolbox, docker is configured to use the default machine with IP 192.168.99.100

#Docker few commands
docker --version

#sample repo with tag and port it is running too 
in28min/todo-rest-api-h2:1.0.0.RELEASE  5000

#sample to run throw docker hub 
docker run {reponame:tag}

# to use bridge network in out system 
docker run -p {HOSTPORT}:{CONTAINERPORT} {reponame:tag}
http://localhost:{HOSTPORT}/hello-world

NOTE add -ti if ctrl+c is not working after run

# run the contain in back mode after ctrl c too i.e in detach mode
#HOST PORT can be multiple
docker run -p {HOSTPORT}:{CONTAINERPORT} -d {reponame:tag}

#or use
docker container run -p {HOSTPORT}:{CONTAINERPORT} -d {reponame:tag}
you will get the id of container

#get log of
docker logs {container id}

#either can see sub logs by passing some sub set of container id
#to continue tailing
docker logs -f {container id}

#to check the list of container
docker container ls

#images present in my machine
docker images

#to show all running and stopped container
docker container ls -a

#to stop container
docker stop {container id}

#commands few more
#add a new tag for already existing images
docker tag {reponame}:{alreadyexistingTag} {reponame}:{newTag}

#eg if we won't put the tag while pulling it will pull the latest tag Image
docker pull mysql

#to search all images in repo eq:
docker search mysql

#to check history
docker image history {imageId}/{reponame:tag}

#to inspect history
docker image inspect {imageId}/{reponame:tag}

#remove image, but it will only remove fom local
docker image remove {imageId}/{reponame:tag}

#container commands
#pause a container
docker container pause {container id}

#unpause
docker container unpause {container id}
#inspect container 
docker container inspect {container id}

docker container ls -a

#to remove all the stopped container from ls 
docker container prune   -->>>Y
docker container logs -f {container id}

#stop container gracefully
docker container stop {container id}

#stop immediately
docker container kill {container id}

#if we restart docker terminal again then our image will start automatically for policy restart
#and docker container prune will remove this if you don't want this to happen in restart, and you have to add restart policy again
#--restart=always/no by default is no
docker container run -p 5000:5000  -d --restart=always in28min/todo-rest-api-h2:1.0.0.RELEASE

docker container logs -f {container id}

#to check event like start or stop
docker events

#to check all the processes running in the container
docker top {container id}

#to check the status of our container
docker stats

#provide memory and cpu to container we run 
#-m is for memory where 512m is mega bite we can use g as well for GB
#--cpu-quota is for cpu cpu have quota of 100000-100% 5000=5%
docker container run -p 5001:5000  -m 512m --cpu-quota 5000 -d  in28min/todo-rest-api-h2:1.0.0.RELEASE

#check docker deamon manges like size CPU etc
docker system df

#Distributed Tracing Server (Zipkin for microservices)
docker run -p 9411:9411 openzipkin/zipkin:2.23

#To build image throw maven if installed locally else do it by ide include mvn
mvn spring-boot:build-image -DskipTests
