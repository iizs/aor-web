package net.iizs.aor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class AorWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AorWebApplication.class, args);
	}
}
