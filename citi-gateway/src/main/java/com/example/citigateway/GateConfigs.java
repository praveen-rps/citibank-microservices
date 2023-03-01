package com.example.citigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateConfigs {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/notes/**").uri("lb://NOTES-SERVICE/notes"))
				.route(p->p.path("/comments/**").uri("lb://COMMENTS-SERVICE/comments"))
				.build();
	}

}
