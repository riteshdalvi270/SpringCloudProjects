package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PluralsightEurekaTollrateBillboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightEurekaTollrateBillboardApplication.class, args);
	}
}
