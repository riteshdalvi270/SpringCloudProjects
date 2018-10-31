package pluralsight.dmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PluralsightSpringcloudM2ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcloudM2ConfigServerGitApplication.class, args);
	}
}
