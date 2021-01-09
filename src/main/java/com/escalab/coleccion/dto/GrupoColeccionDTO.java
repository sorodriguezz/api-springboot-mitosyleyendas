package com.escalab.coleccion.dto;

import org.springframework.hateoas.ResourceSupport;

import com.escalab.coleccion.model.ColeccionModel;
import com.escalab.coleccion.model.Usuario;


public class GrupoColeccionDTO extends ResourceSupport {
	
	private Integer idGrupoColeccion;
	private Usuario usuario;
	
	public Integer getIdGrupoColeccion() {
		return idGrupoColeccion;
	}
	public void setIdGrupoColeccion(Integer idGrupoColeccion) {
		this.idGrupoColeccion = idGrupoColeccion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
