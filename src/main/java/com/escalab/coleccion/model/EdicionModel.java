package com.escalab.coleccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "EDICION")
@ApiModel("Modelo Edicion")
public class EdicionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id de la Edicion", required = true)
	private Integer idEdicion;
	
	@Column(name = "NOMBRE_EDICION", nullable = false, length = 30)
	@ApiModelProperty(value = "Nombre de la edicion, maximo 30 caracteres y no admite nulos", required = true)
	private String nombreEdicion;
	
	@Column(name = "ANIO_EDICION" , nullable = false,  length = 4)
	@ApiModelProperty(value = "Año de la edicion, maximo 4 caracteres (2021) y no admite nulos", required = true)
	private String anioEdicion;
	
	@Column(name = "NUMERO_CARTAS_EDICION", nullable = false, length = 3)
	@ApiModelProperty(value = "Numero de cartas, maximo 3 caracteres(0 a 999) y no admite nulos", required = true)
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
