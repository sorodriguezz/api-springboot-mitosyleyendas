package com.escalab.coleccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EDICION")
public class EdicionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEdicion;
	
	@Column(name = "NOMBRE_EDICION", nullable = false, length = 30)
	private String nombreEdicion;
	
	@Column(name = "ANIO_EDICION" , nullable = false,  length = 4)
	private String anioEdicion;
	
	@Column(name = "NUMERO_CARTAS_EDICION", nullable = false, length = 3)
	private String numeroCartasEdicion;

	public EdicionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EdicionModel(Integer idEdicion, String nombreEdicion, String anioEdicion, String numeroCartasEdicion) {
		super();
		this.idEdicion = idEdicion;
		this.nombreEdicion = nombreEdicion;
		this.anioEdicion = anioEdicion;
		this.numeroCartasEdicion = numeroCartasEdicion;
	}

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
		return anioEdicion;
	}

	public void setAnioEdicion(String anioEdicion) {
		this.anioEdicion = anioEdicion;
	}

	public String getNumeroCartasEdicion() {
		return numeroCartasEdicion;
	}

	public void setNumeroCartasEdicion(String numeroCartasEdicion) {
		this.numeroCartasEdicion = numeroCartasEdicion;
	}

	
}
