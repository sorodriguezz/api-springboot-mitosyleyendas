package com.escalab.coleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.coleccion.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);

}
