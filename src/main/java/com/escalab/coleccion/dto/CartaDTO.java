package com.escalab.coleccion.dto;

import org.springframework.hateoas.ResourceSupport;

import com.escalab.coleccion.model.EdicionModel;

public class CartaDTO  extends ResourceSupport {
	
	private Integer idCarta;
	private EdicionModel edicion;
	
	public Integer getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}
	public EdicionModel getEdicion() {
		return edicion;
	}
	public void setEdicion(EdicionModel edicion) {
		this.edicion = edicion;
	}
	
	
	
}
