package com.escalab.coleccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "GRUPO_COLECCION")
@ApiModel("Modelo Grupo Coleccion")
public class GrupoColeccionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id del grupo de la coleccion", required = true)
	private Integer idGrupoColeccion;
	
	@Column(name = "NOMBRE_GRUPO_COLECCION", nullable = false, length = 30)
	@ApiModelProperty(value = "Nombre del grupo de la coleccion, maximo 30 caracteres y no admite nulos", required = true)
	private String nombreGrupoColeccion;
	
	@OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	@ApiModelProperty(value = "Id del usuario al que pertenece el grupo de la coleccion", required = true)
	@JoinColumn(nullable = false, name = "FK_ID_USUARIO")
	private Usuario usuarioModel;

	public GrupoColeccionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GrupoColeccionModel(Integer idGrupoColeccion, String nombreGrupoColeccion, Usuario usuarioModel) {
		super();
		this.idGrupoColeccion = idGrupoColeccion;
		this.nombreGrupoColeccion = nombreGrupoColeccion;
		this.usuarioModel = usuarioModel;
	}

	public Integer getIdGrupoColeccion() {
		return idGrupoColeccion;
	}

	public void setIdGrupoColeccion(Integer idGrupoColeccion) {
		this.idGrupoColeccion = idGrupoColeccion;
	}

	public String getNombreGrupoColeccion() {
		return nombreGrupoColeccion;
	}

	public void setNombreGrupoColeccion(String nombreGrupoColeccion) {
		this.nombreGrupoColeccion = nombreGrupoColeccion;
	}

	public Usuario getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(Usuario usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

}
