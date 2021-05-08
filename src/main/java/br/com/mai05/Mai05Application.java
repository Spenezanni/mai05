package br.com.mai05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableSpringDataWebSupport
@SpringBootApplication
public class Mai05Application {

	public static void main(String[] args) {
		SpringApplication.run(Mai05Application.class, args);
	}

}
