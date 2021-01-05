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
@Table(name = "CARTA")
public class CartaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCarta;
	
	@Column(name = "NOMBRE_CARTA", nullable = false, length = 30)
	private String nombreCarta;
	
	@Column(name = "COSTE_CARTA", nullable = false, length = 2)
	private String costeCarta;
	
	@Column(name = "HABILIDAD_CARTA", nullable = false, length = 200)
	private String habilidadCarta;
	
	@Column(name = "IMAGEN_CARTA", nullable = false, length = 250)
	private String imagenCarta;
	
	@Column(name = "CODIGO_CARTA", nullable = false, length = 7)
	private String codigoCarta;
	
	@Column(name = "ILUSTRADOR_CARTA", nullable = false, length = 25)
	private String ilustradorCarta;
	
	@Column(name = "HISTORIA_CARTA", nullable = false , length = 250)
	private String historiaCarta;
	
	@Column(name = "FRECUENCIA_CARTA", nullable = false, length = 30)
	private String frecuenciaCarta;
	
	@Column(name = "FUERZA_CARTA", nullable = false, length = 2)
	private String fuerzaCarta;
	
	@Column(name = "TIPO_CARTA", nullable = false, length = 30)
	private String tipoCarta;

//	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "COLECTION_CARD", joinColumns = @JoinColumn(name = "ID_CARD", referencedColumnName = "idCard"), inverseJoinColumns = @JoinColumn(name = "ID_COLECTION", referencedColumnName = "idColection"))
//	private List<ColectionModel> colections;
//	
	@ManyToOne
	@JoinColumn(name = "FK_ID_EDICION", nullable = false, foreignKey = @ForeignKey(name = "FK_ID_EDICION"))
	private EdicionModel edicionModel;

	public CartaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartaModel(Integer idCarta, String nombreCarta, String costeCarta, String habilidadCarta, String imagenCarta,
			String codigoCarta, String ilustradorCarta, String historiaCarta, String frecuenciaCarta,
			String fuerzaCarta, String tipoCarta, EdicionModel edicionModel) {
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

	public EdicionModel getEdicionModel() {
		return edicionModel;
	}

	public void setEdicionModel(EdicionModel edicionModel) {
		this.edicionModel = edicionModel;
	}
	
}