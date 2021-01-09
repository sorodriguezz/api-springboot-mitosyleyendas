package com.escalab.coleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.coleccion.model.ResetToken;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}

