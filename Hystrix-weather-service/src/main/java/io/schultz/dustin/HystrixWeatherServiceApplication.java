package io.schultz.dustin;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HystrixWeatherServiceApplication {

	private String[] weather = new String[] {"Spring","Summer","Winter","Rainy"};
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixWeatherServiceApplication.class, args);
	}
	
	
	@GetMapping("/weather")
	public String getWeather() {
		int rand = ThreadLocalRandom.current().nextInt(0,4);
		return weather[rand];
	}

}
