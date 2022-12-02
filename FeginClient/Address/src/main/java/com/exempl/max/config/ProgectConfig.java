package com.exempl.max.config;

import java.awt.print.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.exempl.max.model.Address;
import com.exempl.max.repository.AddressRepository;

import jakarta.persistence.Column;

@Configuration
@ComponentScan("com")
public class ProgectConfig {

	@Bean
	public CommandLineRunner dataLoader(AddressRepository repo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
	    		 repo.save(new Address(1l, "г.Киев","ул.Набережная"));
	    		 repo.save(new Address(2l, "г.Москва","ул.Пролетарская"));
	    		 repo.save(new Address(3l, "г.Екатеренбург","ул.Цветочная"));
	    		
			}
		};
	}
}
