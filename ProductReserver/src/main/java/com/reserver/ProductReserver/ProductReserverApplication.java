package com.reserver.ProductReserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProductReserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductReserverApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new User(null, "John Travolta", "John", "1234", "John@Travolta.com", "John", "Travola", "0654321352", new ArrayList<>()));
//			userService.saveUser(new User(null, "Guus Arts", "Guus", "0000", "Guus@Arts.com", "Guus", "Arts", "0678943212", new ArrayList<>()));
//			userService.saveUser(new User(null, "Tijn de Rooij", "Tijn", "4567", "Tijn@Rooij.com", "Tijn", "de Rooij", "0642645454", new ArrayList<>()));
//			userService.saveUser(new User(null, "Pieter Soeren", "Pieter", "1357", "HelemaalPieter@LOL.com", "Pieter", "Soeren", "0654926431", new ArrayList<>()));
//
//			userService.addRoleToUser("John", "ROLE_MANAGER");
//			userService.addRoleToUser("Guus", "ROLE_ADMIN");
//			userService.addRoleToUser("Tijn", "ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("Pieter", "ROLE_USER");
//		};
//	}
}
