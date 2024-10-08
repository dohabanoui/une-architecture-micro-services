package org.SDIA.customer_service;

import org.SDIA.customer_service.entities.Customer;
import org.SDIA.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(
				new Customer(null, "doha", "doha@gmail.com")
			);
			customerRepository.save(
					new Customer(null, "wiam", "wiam@gmail.com")
			);
			customerRepository.save(
					new Customer(null, "amine", "amine@gmail.com")
			);
			customerRepository.findAll().forEach(c ->{
				System.out.println(c.toString());
			});

		};
	}

}
