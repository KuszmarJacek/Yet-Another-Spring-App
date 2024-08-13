package com.kj.yetanotherspringapp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kj.yetanotherspringapp.domain.AppUser;
import com.kj.yetanotherspringapp.domain.AppUserRepository;
import com.kj.yetanotherspringapp.domain.Car;
import com.kj.yetanotherspringapp.domain.CarRepository;
import com.kj.yetanotherspringapp.domain.Owner;
import com.kj.yetanotherspringapp.domain.OwnerRepository;

//@EnableMethodSecurity
@SpringBootApplication
public class YetAnotherSpringApplication implements CommandLineRunner {
	
	public static final Logger logger = LoggerFactory.getLogger(YetAnotherSpringApplication.class);
	private final CarRepository repository;
	private final OwnerRepository orepository;
	private final AppUserRepository urepository;
	
	public YetAnotherSpringApplication(
			CarRepository repository, 
			OwnerRepository orepository,
			AppUserRepository urepository) {
		this.repository = repository;
		this.orepository = orepository;
		this.urepository = urepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// Add owner objects and save these to db
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));

		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));

		// Fetch all cars and log to console
		for (Car car : repository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
		
		urepository.save(new AppUser(
			"user",
			"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue",
			"USER"));
			
		urepository.save(new AppUser(
			"admin",
			"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", 
			"ADMIN"));
	}

	public static void main(String[] args) {	
		SpringApplication.run(YetAnotherSpringApplication.class, args);
	}
}
