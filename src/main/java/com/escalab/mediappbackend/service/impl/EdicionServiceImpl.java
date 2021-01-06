package com.escalab.mediappbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.mediappbackend.dto.EdicionDTO;
import com.escalab.mediappbackend.model.EdicionModel;
import com.escalab.mediappbackend.repo.IEdicionRepo;
import com.escalab.mediappbackend.service.IEdicionService;

@Service
public class EdicionServiceImpl implements IEdicionService {

	@Autowired
	private IEdicionRepo repo;
	
	
	@Override
	public EdicionModel registrar(EdicionModel obj) {
		return repo.save(obj);
	}

	@Override
	public EdicionModel modificar(EdicionModel obj) {
		return repo.save(obj);
	}

	@Override
	public List<EdicionModel> listar() {
		return repo.findAll();
	}

	@Override
	public EdicionModel leerPorId(Integer id) {
		Optional<EdicionModel> op = repo.findById(id);
		return op.isPresent() ? op.get() : new EdicionModel();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<EdicionDTO> findEdicion() {
		return repo.findEdicion();
	}
	

}
