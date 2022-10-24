package com.example.companydemo;

import com.example.companydemo.repository.CompanyRepository;
import com.unicloud.boot.annotation.EnableAutoConfiguration;
import com.unicloud.repository.UUIDMongoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = {"com.unicloud.repository", "com.example.companydemo.repository"}, repositoryBaseClass = UUIDMongoRepository.class)
public class CompanyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CompanyRepository re) {
        return args -> {
//            List<CompanyInfo> et = re.getInfoListByTaxCode("123456");
//            System.out.println();
        };
    }

}
