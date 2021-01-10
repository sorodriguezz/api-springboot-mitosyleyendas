package com.escalab.coleccion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "CARTA")
@ApiModel("Modelo Carta")
public class CartaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id de la Carta", required = true)
	private Integer idCarta;
	
	@Column(name = "NOMBRE_CARTA", nullable = false, length = 30)
	@ApiModelProperty(value = "nombre de la Carta, al menos 30 caracteres, no admite nulo", required = true)
	private String nombreCarta;
	
	@Column(name = "COSTE_CARTA", nullable = false, length = 2)
	@ApiModelProperty(value = "Coste de la Carta, al menos 2 caracteres del 0 al 99, no admite nulo", required = true)
	private String costeCarta;
	
	@Column(name = "HABILIDAD_CARTA", nullable = false, length = 200)
	@ApiModelProperty(value = "Habilidad de la carta, maximo 200 caracteres y no admite nulo", required = true)
	private String habilidadCarta;
	
	@Column(name = "IMAGEN_CARTA", nullable = false, length = 250)
	@ApiModelProperty(value = "Imagen de la carta, maximo 250 caracteres y no admite nulo", required = true)
	private String imagenCarta;
	
	@Column(name = "CODIGO_CARTA", nullable = false, length = 7)
	@ApiModelProperty(value = "Numero de la carta en la edicion, maximo 7 caracteres (1/100) y no admite nulo", required = true)
	private String codigoCarta;
	
	@Column(name = "ILUSTRADOR_CARTA", nullable = false, length = 25)
	@ApiModelProperty(value = "Ilustrador de la carta, maximo 25 caracteres y no admite nulo", required = true)
	private String ilustradorCarta;
	
	@Column(name = "HISTORIA_CARTA", nullable = false , length = 250)
	@ApiModelProperty(value = "Historia de la carta, maximo 250 caracteres y no admite nulo", required = true)
	private String historiaCarta;
	
	@Column(name = "FRECUENCIA_CARTA", nullable = false, length = 30)
	@ApiModelProperty(value = "Rareza de la Carta, maximo 30 caracteres y no admite nulo", required = true)
	private String frecuenciaCarta;
	
	@Column(name = "FUERZA_CARTA", nullable = false, length = 2)
	@ApiModelProperty(value = "Fuerza o daño que realiza la carta, maximo 2 caracteres (del 0 al 99) y no admite nulo", required = true)
	private String fuerzaCarta;
	
	@Column(name = "TIPO_CARTA", nullable = false, length = 30)
	@ApiModelProperty(value = "Tipo de Carta, maximo 30 caracteres y no admite nulo", required = true)
	private String tipoCarta;

	
	@ManyToMany(fetch = FetchType.EAGER)
	@ApiModelProperty(value = "Id de la coleccion que pertenece la carta", required = true)
	@JoinTable(name = "COLECCION_CARTA", joinColumns = @JoinColumn(name = "ID_CARTA", referencedColumnName = "idCarta"), inverseJoinColumns = @JoinColumn(name = "ID_COLECCION", referencedColumnName = "idColeccion"))
	private List<ColeccionModel> coleccion;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_EDICION", nullable = false, foreignKey = @ForeignKey(name = "FK_ID_EDICION"))
	private EdicionModel edicionModel;

	public CartaModel() {
		super();
	}

	public CartaModel(Integer idCarta, String nombreCarta, String costeCarta, String habilidadCarta, String imagenCarta,
			String codigoCarta, String ilustradorCarta, String historiaCarta, String frecuenciaCarta,
			String fuerzaCarta, String tipoCarta, List<ColeccionModel> coleccion, EdicionModel edicionModel) {
		super();
		this.idCarta = idCarta;
		this.nombreCarta = nombreCarta;
		this.costeCarta = costeCarta;
		this.habilidadCarta = habilidadCarta;
		this.imagenCarta = imagenCarta;
		this.codigoCarta = codigoCarta;
		this.ilustradorCarta = ilustradorCarta;
		this.historiaCarta = historiaCarta;
		this.frecuenciaCarta = frecuenciaCarta;
		this.fuerzaCarta = fuerzaCarta;
		this.tipoCarta = tipoCarta;
		this.coleccion = coleccion;
		this.edicionModel = edicionModel;
	}

	public Integer getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}

	public String getNombreCarta() {
		return nombreCarta;
	}

	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
	}

	public String getCosteCarta() {
		return costeCarta;
	}

	public void setCosteCarta(String costeCarta) {
		this.costeCarta = costeCarta;
	}

	public String getHabilidadCarta() {
		return habilidadCarta;
	}

	public void setHabilidadCarta(String habilidadCarta) {
		this.habilidadCarta = habilidadCarta;
	}

	public String getImagenCarta() {
		return imagenCarta;
	}

	public void setImagenCarta(String imagenCarta) {
		this.imagenCarta = imagenCarta;
	}

	public String getCodigoCarta() {
		return codigoCarta;
	}

	public void setCodigoCarta(String codigoCarta) {
		this.codigoCarta = codigoCarta;
	}

	public String getIlustradorCarta() {
		return ilustradorCarta;
	}

	public void setIlustradorCarta(String ilustradorCarta) {
		this.ilustradorCarta = ilustradorCarta;
	}

	public String getHistoriaCarta() {
		return historiaCarta;
	}

	public void setHistoriaCarta(String historiaCarta) {
		this.historiaCarta = historiaCarta;
	}

	public String getFrecuenciaCarta() {
		return frecuenciaCarta;
	}

	public void setFrecuenciaCarta(String frecuenciaCarta) {
		this.frecuenciaCarta = frecuenciaCarta;
	}

	public String getFuerzaCarta() {
		return fuerzaCarta;
	}

	public void setFuerzaCarta(String fuerzaCarta) {
		this.fuerzaCarta = fuerzaCarta;
	}

	public String getTipoCarta() {
		return tipoCarta;
	}

	public void setTipoCarta(String tipoCarta) {
		this.tipoCarta = tipoCarta;
	}

	public List<ColeccionModel> getColeccion() {
		return coleccion;
	}

	public void setColeccion(List<ColeccionModel> coleccion) {
		this.coleccion = coleccion;
	}

	public EdicionModel getEdicionModel() {
		return edicionModel;
	}

	public void setEdicionModel(EdicionModel edicionModel) {
		this.edicionModel = edicionModel;
	}

}