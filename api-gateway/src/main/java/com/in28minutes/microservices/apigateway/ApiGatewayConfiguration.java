package com.in28minutes.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

//configure a route locater bean for customise the url we are provide in MicroServices
@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouteLocator(RouteLocatorBuilder builder)
	{
		return builder.routes().route(
				//example to understand rout
				//if path of request is get then redirect to this specfic uri
				//with customise header and request param
				p -> p.path("/get")
						.filters(f->f.addRequestHeader("MyHeader","MyURI")
								.addRequestParameter("Param","Values"))
						.uri("http://httpbin.org:80"))

				//cutomize currency-exchange uri
				//and load balnce it too
				.route(p->p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p->p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
				//redirect this uri to feign uri
				.route(p->p.path("/currency-conversion-new/**").filters(
						//uri to replace,uri to replace with segment is used in regular expression
						f->f.rewritePath("/currency-conversion-new/(?<segment>.*)",
								"/currency-conversion-feign/${segment}"))
								.uri("lb://currency-conversion")
				
		).build();
	}



}
