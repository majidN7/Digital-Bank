package net.majid.customerservice;

import net.majid.customerservice.config.GlobalConfig;
import net.majid.customerservice.entities.Customer;
import net.majid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List <Customer> customerList=List.of(
                    Customer.builder()
                            .firstName("Sami")
                            .lastName("CHADAD")
                            .email("sami@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Loujayne")
                            .lastName("LOUJAYNE")
                            .email("louajayne@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Majid")
                            .lastName("CHADAD")
                            .email("majid@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Ourssoula")
                            .lastName("SIKAL")
                            .email("sikal@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
