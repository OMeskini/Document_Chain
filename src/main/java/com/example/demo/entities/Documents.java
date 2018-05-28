package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class Documents implements Serializable{
	@Id
@GeneratedValue
	private Long id;
private String type	;
private String id_type;
@Lob 
@Column(name="query", length=512)
private String query;
private String client	;
private int mapping;
private int params;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getIdType() {
	return id_type;
}
public void setIdType(String idType) {
	this.id_type = idType;
}
public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public String getClient() {
	return client;
}
public void setClient(String client) {
	this.client = client;
}
public int getMapping() {
	return mapping;
}
public void setMapping(int mapping) {
	this.mapping = mapping;
}
public int getParams() {
	return params;
}
public void setParams(int params) {
	this.params = params;
}
public Documents(Long id, String type, String idType, String query, String client, int mapping, int params) {
	super();
	this.id = id;
	this.type = type;
	this.id_type = idType;
	this.query = query;
	this.client = client;
	this.mapping = mapping;
	this.params = params;
}
public Documents() {
	super();
	// TODO Auto-generated constructor stub
}


}