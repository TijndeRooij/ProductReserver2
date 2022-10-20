package com.reserver.ProductReserver;

import com.reserver.ProductReserver.Domain.Role.Role;
import com.reserver.ProductReserver.Domain.User.User;
import com.reserver.ProductReserver.Domain.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ProductReserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductReserverApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "John", "1234", "John@Travolta", new ArrayList<>()));
			userService.saveUser(new User(null, "Guus Arts", "Guus", "0000", "Guus@Arts", new ArrayList<>()));
			userService.saveUser(new User(null, "Tijn de Rooij", "Tijn", "4567", "Tijn@Rooij", new ArrayList<>()));
			userService.saveUser(new User(null, "Pieter Soeren", "Pieter", "1357", "Helemaal@Pieter", new ArrayList<>()));

			userService.addRoleToUser("John", "ROLE_MANAGER");
			userService.addRoleToUser("Guus", "ROLE_ADMIN");
			userService.addRoleToUser("Tijn", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Pieter", "ROLE_USER");
		};
	}

}
