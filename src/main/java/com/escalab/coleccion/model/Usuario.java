package com.escalab.coleccion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id del usuario", required = true)
	private Integer idUsuario;
	
	@Column(name = "nombre", nullable = false)
	@ApiModelProperty(value = "Nombre del usuario", required = true)
	private String username;
	
	@Column(name = "clave", nullable = false)
	@ApiModelProperty(value = "Contraseña del usuario", required = true)
	private String password;
	
	@Column(name = "estado", nullable = false)
	@ApiModelProperty(value = "Estado del usuario", required = true)
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@ApiModelProperty(value = "Id del rol al que pertenece el usuario", required = true)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
