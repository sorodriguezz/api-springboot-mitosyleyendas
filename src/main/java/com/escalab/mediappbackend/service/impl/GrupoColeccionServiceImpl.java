package com.escalab.mediappbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.mediappbackend.model.GrupoColeccionModel;
import com.escalab.mediappbackend.repo.IGrupoColeccionRepo;
import com.escalab.mediappbackend.service.IGrupoColeccionService;

@Service
public class GrupoColeccionServiceImpl implements IGrupoColeccionService {
	
	@Autowired
	private IGrupoColeccionRepo repo;
	
	@Override
	public GrupoColeccionModel registrar(GrupoColeccionModel obj) {
		return repo.save(obj);
	}
	
	@Override
	public GrupoColeccionModel modificar(GrupoColeccionModel obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<GrupoColeccionModel> listar() {
		return repo.findAll();
	}
	
	@Override
	public GrupoColeccionModel leerPorId(Integer id) {
		Optional<GrupoColeccionModel> op = repo.findById(id);
		return op.isPresent() ? op.get() : new GrupoColeccionModel();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
