package io.schultz.dustin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.schultz.dustin.filter.AddRequestHeaderFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@Configuration
public class ZuulGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayServiceApplication.class, args);
	}
	
	@Bean
	public AddRequestHeaderFilter addRequestHeaderFilter() {
		return new AddRequestHeaderFilter();
	}

}
