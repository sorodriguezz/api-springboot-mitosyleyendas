package com.escalab.coleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escalab.coleccion.model.EdicionModel;

@Repository
public interface IEdicionRepo extends JpaRepository<EdicionModel, Integer> {

}
