package net.iizs.aor;

import net.iizs.aor.support.EuropeanGameComponentFactory;
import net.iizs.aor.support.GameComponentFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class AorWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AorWebApplication.class, args);
	}

	@Bean
    public GameComponentFactory gameComponentFactory() {
	    return new EuropeanGameComponentFactory();
    }
}
