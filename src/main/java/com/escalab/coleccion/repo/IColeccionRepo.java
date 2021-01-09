package com.escalab.coleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.coleccion.model.ColeccionModel;

public interface IColeccionRepo extends JpaRepository<ColeccionModel, Integer> {

}
