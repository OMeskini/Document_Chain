package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mapping {
	@Id
	@GeneratedValue
    private Long id_map;
	private String first_name	;
	private String last_name;
	private String id_cin;
		
	public Long getId_map() {
		return id_map;
	}
	public void setId_map(Long id_map) {
		this.id_map = id_map;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getId_cin() {
		return id_cin;
	}
	public void setId_cin(String id_cin) {
		this.id_cin = id_cin;
	}
	public Mapping(Long id_map, String first_name, String last_name, String id_cin) {
		super();
		this.id_map = id_map;
		this.first_name = first_name;
		this.last_name = last_name;
		this.id_cin = id_cin;
	}
	public Mapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
