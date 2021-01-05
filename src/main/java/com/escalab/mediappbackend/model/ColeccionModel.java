package com.escalab.mediappbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COLECCION")
public class ColeccionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idColeccion;
	
	@Column(name = "NOMBRE_COLECCION", nullable = false, unique = true, length = 30)
	private String nombreColeccion;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_GROUPCOLECTION", nullable = false, foreignKey = @ForeignKey(name = "FK_COLECCION_GRUPOCOLECCION"))
	private GrupoColeccionModel grupoColeccionModel;

	public ColeccionModel() {
		super();
	}

	public ColeccionModel(Integer idColeccion, String nombreColeccion, GrupoColeccionModel grupoColeccionModel) {
		super();
		this.idColeccion = idColeccion;
		this.nombreColeccion = nombreColeccion;
		this.grupoColeccionModel = grupoColeccionModel;
	}

	public Integer getIdColeccion() {
		return idColeccion;
	}

	public void setIdColeccion(Integer idColeccion) {
		this.idColeccion = idColeccion;
	}

	public String getNombreColeccion() {
		return nombreColeccion;
	}

	public void setNombreColeccion(String nombreColeccion) {
		this.nombreColeccion = nombreColeccion;
	}

	public GrupoColeccionModel getGrupoColeccionModel() {
		return grupoColeccionModel;
	}

	public void setGrupoColeccionModel(GrupoColeccionModel grupoColeccionModel) {
		this.grupoColeccionModel = grupoColeccionModel;
	}
	
}
