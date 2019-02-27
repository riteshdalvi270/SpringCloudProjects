package pluralsight.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Controller
public class DashboardController {

	@Autowired
	private RestTemplate restTemplate;

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@HystrixCommand(fallbackMethod = "getTollRateBackup")
	@RequestMapping("/dashboard")
	public String GetTollRate(@RequestParam int stationId, Model m) {
		
		//RestTemplate rest = new RestTemplate();
		TollRate tr = restTemplate.getForObject("http://spring-eureka-tollrate-service/tollrate/" + stationId, TollRate.class);
		System.out.println("stationId: " + stationId);
		m.addAttribute("rate", tr.getCurrentRate());
		return "dashboard";
	}

	private String getTollRateBackup(@RequestParam int stationId, Model m) {

		System.out.println("Backup method called for toll rate service");

		m.addAttribute("rate", BigDecimal.ONE);

		return "dashboard";
	}
}
