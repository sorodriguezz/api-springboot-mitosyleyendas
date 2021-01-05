package com.escalab.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.mediappbackend.model.ColeccionModel;

public interface IColeccionRepo extends JpaRepository<ColeccionModel, Integer> {

}
