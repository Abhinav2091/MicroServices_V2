#AdvanceToole or upgraded Tooles
Spring Cloud load Balancer instead of Ribbon
Spring Cloud Gateway instead of Zuull
Resilence4j instead of hysrix

#Ports Standardization
Limits Microservices              :  8080,8081,...
Spring Cloud Config Server        :  8888 
Currency Exchange Microservices   :  8000,8001,8002,...
Currency Conversion Microservices :  8100,8101,8102,...
NetFlix Eureka Naming Server      :  8761
Api Gateway                       :  8765
Zipkin Distributed Tracing Server :  9411

#to check service Instance in Spring cloud config
http://localhost:8888/limit-service/{profile-to_check}

# H2 Db (data.sql) is bydefault db for JPA in memory database

#sesilience4j url to study more
https://resilience4j.readme.io/docs/getting-started-3
