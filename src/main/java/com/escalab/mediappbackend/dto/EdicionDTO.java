package com.escalab.mediappbackend.dto;

import org.springframework.hateoas.ResourceSupport;

public class EdicionDTO extends ResourceSupport {
	
	private String nombreEdicion;
	private String AnioEdicion;
	
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