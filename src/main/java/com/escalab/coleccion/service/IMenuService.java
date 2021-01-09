package com.escalab.coleccion.service;

import java.util.List;

import com.escalab.coleccion.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
