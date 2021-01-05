package com.escalab.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.mediappbackend.model.CartaModel;

public interface ICartaRepo extends JpaRepository<CartaModel, Integer>  {
	
}
