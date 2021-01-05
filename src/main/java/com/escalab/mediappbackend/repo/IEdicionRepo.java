package com.escalab.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.mediappbackend.model.EdicionModel;

public interface IEdicionRepo extends JpaRepository<EdicionModel, Integer> {
	
}
