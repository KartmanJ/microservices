package microservices.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductManageService {

	public static void main(String[] args) {
		SpringApplication.run(ProductManageService.class, args);
	}

}
