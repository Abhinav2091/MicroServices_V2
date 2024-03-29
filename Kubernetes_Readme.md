#created a Google cloud account
https://cloud.google.com/

#create Kubernetes cluster
enable kubernetes Engine
#open cloud shell
inside the cluster we created through activate cloud shell button 

#connect to cluster after opening
through connect button copy the command and paste it in Cloud Shell

#use first command
kubectl    ->>>> stands for Kube Controller
kubectl version  -->> to check version

#sample deployment
#sample container_path = in28min/hello-world-rest-api   and tag = 0.0.0.1.RELEASE
#name_of_deployment = hello-world-rest-api created
kubectl create deployment name_of_deployment --image=container_path:tag
#delete deployment
kubectl delete deployment name_of_deployment

#expose the deployment i.e create service
#with load balancing and port 
kubectl expose deployment name_of_deployment --type=LoadBalancer --port=8080

#get events 
kubectl get events
#sort event by creationTime
kubectl get events --sort_by=.metadata.creationTimestamp

#get pods
kubectl get pods
kubectl get pods -o wide
kubectl explain pods
kubectl describe pod pod_name
kubectl delete pods hello-world-rest-api-687d9c7bc7-gct7t

#get replica
kubectl get
kubectl get rs
kubectl explain rs
kubectl get rs -o wide

##get all
kubectl get all

#get service
kubectl get service
kubectl explain service

#scale tha pp or add more pods
#no_of_replica =3 eg
kubectl scale deployment name_of_deployment --replicas=no_of_replica

#set application to new version 
kubectl set image deployment name_of_deployment name_of_deployment=container_path:tag

#get component of Master Node
kubectl get componentstatuses

### we can also run all this command in our local system as well
#install Gcloud
https://cloud.google.com/sdk/docs/install

#command to re_login
gcloud auth login

##### install kubectl in local system
https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/
kubectl version


## configure deployment yaml file 
# go inside project repo and do
#it will print all in yaml file
kubectl get deployment currency-exchange -o yaml

#redirect or write it in yaml file
kubectl get deployment currency-exchange -o yaml >>deployment.yaml

#for service
kubectl get service currency-exchange -o yaml >>service.yaml

#to apply yaml changes
kubectl apply -f yaml_file_Name

####### enable cloud logging api from google plat form 
###search api and services
#cloud api and enable

## also enable below things too ion same Api and Services
Stackdriver API in same
Stackdriver Monitoring API
Stackdriver Trace API
Stackdriver Error Reporting API
Stackdriver Profiler API

##command to delete everything related to service 
kubectl delete all -l app=deployment_name

##to watch real time use --watch
eg kubectl get service --watch

##to check logs
kubectl logs pod_id
#to tail the logs
kubectl logs -f pod_id

#centralised configuration for Kubernites
kubectl create configmap name_for_file --from-literal=Key_to_configure=Value_to_configure
#to get the name
kubectl get configmap

kubectl get configmap config_file_name -o yaml >>config.yaml

#check history
kubectl rollout history deployment deployment_name

#you can roll back to previous version by this command
kubectl rollout undo deployment deployment_name --to-revision=revesion_id_we_get_from_historey

#for auto scallling
1. either changes replicas in deployment.yaml file
2. use command kubectl scale deployment currency-conversion --replicas=no_of_replicas
##### here we are creating pods on the basis of cpu conception   
3. kubectl autoscale deployment deployment_name --min=no_of_min_pods --max=no_of_max_pods --cpu-percent=when_you_want_new_POD_to_get_created

# it creates horizontalpodautoscaler to check it
kubectl get hpa
#to delete it
kubectl delete hpa currency-exchange
after that you need to apply deployment


######### Important commands
docker run -p 8080:8080 in28min/hello-world-rest-api:0.0.1.RELEASE

kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
kubectl scale deployment hello-world-rest-api --replicas=3
kubectl delete pod hello-world-rest-api-58ff5dd898-62l9d
kubectl autoscale deployment hello-world-rest-api --max=10 --cpu-percent=70
kubectl edit deployment hello-world-rest-api #minReadySeconds: 15
kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE

gcloud container clusters get-credentials in28minutes-cluster --zone us-central1-a --project solid-course-258105
kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl get componentstatuses
kubectl get pods --all-namespaces

kubectl get events
kubectl get pods
kubectl get replicaset
kubectl get deployment
kubectl get service

kubectl get pods -o wide

kubectl explain pods
kubectl get pods -o wide

kubectl describe pod hello-world-rest-api-58ff5dd898-9trh2

kubectl get replicasets
kubectl get replicaset

kubectl scale deployment hello-world-rest-api --replicas=3
kubectl get pods
kubectl get replicaset
kubectl get events
kubectl get events --sort.by=.metadata.creationTimestamp

kubectl get rs
kubectl get rs -o wide
kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST
kubectl get rs -o wide
kubectl get pods
kubectl describe pod hello-world-rest-api-85995ddd5c-msjsm
kubectl get events --sort-by=.metadata.creationTimestamp

kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl get pods -o wide
kubectl delete pod hello-world-rest-api-67c79fd44f-n6c7l
kubectl get pods -o wide
kubectl delete pod hello-world-rest-api-67c79fd44f-8bhdt

gcloud container clusters get-credentials in28minutes-cluster --zone us-central1-c --project solid-course-258105
docker login
docker push in28min/mmv2-currency-exchange-service:0.0.11-SNAPSHOT
docker push in28min/mmv2-currency-conversion-service:0.0.11-SNAPSHOT

kubectl create deployment currency-exchange --image=in28min/mmv2-currency-exchange-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-exchange --type=LoadBalancer --port=8000
kubectl get svc
kubectl get services
kubectl get pods
kubectl get po
kubectl get replicaset
kubectl get rs
kubectl get all

kubectl create deployment currency-conversion --image=in28min/mmv2-currency-conversion-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-conversion --type=LoadBalancer --port=8100

kubectl get svc --watch

kubectl get deployments

kubectl get deployment currency-exchange -o yaml >> deployment.yaml
kubectl get service currency-exchange -o yaml >> service.yaml

kubectl diff -f deployment.yaml
kubectl apply -f deployment.yaml

kubectl delete all -l app=currency-exchange
kubectl delete all -l app=currency-conversion

kubectl rollout history deployment currency-conversion
kubectl rollout history deployment currency-exchange
kubectl rollout undo deployment currency-exchange --to-revision=1

kubectl logs currency-exchange-9fc6f979b-2gmn8
kubectl logs -f currency-exchange-9fc6f979b-2gmn8

kubectl autoscale deployment currency-exchange --min=1 --max=3 --cpu-percent=5
kubectl get hpa

kubectl top pod
kubectl top nodes
kubectl get hpa
kubectl delete hpa currency-exchange

kubectl create configmap currency-conversion --from-literal=CURRENCY_EXCHANGE_URI=http://currency-exchange
kubectl get configmap

kubectl get configmap currency-conversion -o yaml >> configmap.yaml

watch -n 0.1 curl http://34.66.241.150:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

docker push in28min/mmv2-currency-conversion-service:0.0.12-SNAPSHOT
docker push in28min/mmv2-currency-exchange-service:0.0.12-SNAPSHOT


