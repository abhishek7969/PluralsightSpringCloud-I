package io.schultz.dustin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
public class HystrixWeatherAppApplication {

	@Autowired
	WeatherService ws;
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixWeatherAppApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemp() {
		return new RestTemplate();
	}
	
	@GetMapping("/current/weather")
	public String getWeather() {
		return "The current weather is "+ ws.getWeather();
	}
}
