package com.kj.yetanotherspringapp.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

/*
 * Due to bidirectional relationship between Owner and Car, use of @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
 * is required in order to not get a recursion
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ownerid;
	
	private String firstname;
	private String lastname;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "owner")
	private List<Car> cars;
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Owner() {
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
