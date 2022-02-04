package com.manoj.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="state")
//@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}












