package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Params {
	@Id
	@GeneratedValue
    private int id_params;
	@Column(name="uri", length=512)
	private String uri	;
	private String password;
	private String user;
	
	public int getId_params() {
		return id_params;
	}
	public void setId_params(int id_params) {
		this.id_params = id_params;
	}
	public String getDb_name() {
		return uri;
	}
	public void setDb_name(String db_name) {
		this.uri = db_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Params(int id_params, String db_name, String password, String user) {
		super();
		this.id_params = id_params;
		this.uri = db_name;
		this.password = password;
		this.user = user;
	}
	public Params() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
