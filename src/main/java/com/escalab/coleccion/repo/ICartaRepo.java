package com.escalab.coleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.coleccion.model.CartaModel;

public interface ICartaRepo extends JpaRepository<CartaModel, Integer>  {
	
}
