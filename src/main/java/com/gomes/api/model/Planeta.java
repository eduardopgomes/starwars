package com.gomes.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {
	
	@Id
	private String id;
	
	private String name;
	
	private String climate;
	
	private String terrain;
	
	private Long qtdFilms;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public Long getQtdFilms() {
		return qtdFilms;
	}

	public void setQtdFilms(Long qtdFilms) {
		this.qtdFilms = qtdFilms;
	}
	

}
