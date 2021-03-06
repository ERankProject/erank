


package com.erank;

import com.erank.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ERankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERankApplication.class, args);		
		}
}
