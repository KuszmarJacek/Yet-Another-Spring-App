package com.kj.yetanotherspringapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kj.yetanotherspringapp.domain.Car;
import com.kj.yetanotherspringapp.domain.CarRepository;

@RestController
public class CarController {
	private final CarRepository repository;
	
	public CarController(CarRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/cars")
	Iterable<Car> getCars() {
		return repository.findAll();
	}
}
