package com.in28minutes.microservices.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

//Global filter class that works for all request come in in gateway
@Component
public class LoggingFilter implements GlobalFilter {

	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	
	@Override
	//info about the request is present in ServerWebExchange
	public Mono<Void> filter(ServerWebExchange exchange, 
			GatewayFilterChain chain) {
		logger.info("Path of the request received -> {}", 
				exchange.getRequest().getPath());
		//let the execution continue as it was
		return chain.filter(exchange);
	}

}
