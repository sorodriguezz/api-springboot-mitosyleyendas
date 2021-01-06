package com.escalab.mediaappbackend.dto;

import org.springframework.hateoas.ResourceSupport;

public class EdicionDTO extends ResourceSupport {
	
	private Integer idEdicion;
	private String nombreEdicion;
	private String AnioEdicion;
	
	public Integer getIdEdicion() {
		return idEdicion;
	}
	
	public void setIdEdicion(Integer idEdicion) {
		this.idEdicion = idEdicion;
	}
	
	public String getNombreEdicion() {
		return nombreEdicion;
	}
	
	public void setNombreEdicion(String nombreEdicion) {
		this.nombreEdicion = nombreEdicion;
	}
	
	public String getAnioEdicion() {
		return AnioEdicion;
	}
	
	public void setAnioEdicion(String anioEdicion) {
		AnioEdicion = anioEdicion;
	}
	
}
