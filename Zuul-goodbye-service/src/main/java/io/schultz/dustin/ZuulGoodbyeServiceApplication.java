package io.schultz.dustin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ZuulGoodbyeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGoodbyeServiceApplication.class, args);
	}

	@RequestMapping
	public String goodbye(@RequestHeader("x-location") String location) {
		return "Goodbye from "+ location +"!!";
	}
}
