package com.escalab.coleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.coleccion.model.GrupoColeccionModel;

public interface IGrupoColeccionRepo extends JpaRepository<GrupoColeccionModel, Integer> {

}
