package com.escalab.coleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.escalab.coleccion.dto.EdicionDTO;
import com.escalab.coleccion.model.EdicionModel;

@Repository
public interface IEdicionRepo extends JpaRepository<EdicionModel, Integer> {
	
//	@Query(value = "SELECT * FROM edicion", nativeQuery = true)
//    List<EdicionDTO> findEdicion();
//
//	//select * from usuario where username = ?
//	EdicionDTO findOneByNombreEdicion(String nombreEdicion);
}
