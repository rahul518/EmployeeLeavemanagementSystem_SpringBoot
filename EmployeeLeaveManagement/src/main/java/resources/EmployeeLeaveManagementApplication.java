package resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"service","restcontroller","controller"})
@EnableJpaRepositories(basePackages = {"interfaces"})
@EntityScan(basePackages = {"bean"})
@SpringBootApplication
public class EmployeeLeaveManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeLeaveManagementApplication.class, args);
	}
}