package io.schultz.dustin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ClientApplication {
	
	@Autowired
	private EurekaClient client;
	
	@Autowired
	RestTemplateBuilder builder;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@RequestMapping("/")
	public String callService() {
		RestTemplate rest = builder.build();
		InstanceInfo info = client.getNextServerFromEureka("service", false);
		
		String baseUrl = info.getHomePageUrl();
		System.out.println("Base URL "+baseUrl);
		ResponseEntity<String> reponse = rest.exchange(baseUrl, HttpMethod.GET, null, String.class);
		
		return reponse.getBody();
	}

}
