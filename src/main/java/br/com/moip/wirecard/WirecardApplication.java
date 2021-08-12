package br.com.moip.wirecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class WirecardApplication {

	public static void main(String[] args) {
		SpringApplication.run(WirecardApplication.class, args);
	}

}
