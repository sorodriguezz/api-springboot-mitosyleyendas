package com.escalab.coleccion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.coleccion.model.CartaModel;
import com.escalab.coleccion.repo.ICartaRepo;
import com.escalab.coleccion.service.ICartaService;

@Service
public class CartaServiceImpl implements ICartaService {

	@Autowired
	private ICartaRepo repo;
	
	@Override
	public CartaModel registrar(CartaModel obj) {
		return repo.save(obj);
	}

	@Override
	public CartaModel modificar(CartaModel obj) {
		return repo.save(obj);
	}

	@Override
	public List<CartaModel> listar() {
		return repo.findAll();
	}

	@Override
	public CartaModel leerPorId(Integer id) {
		Optional<CartaModel> op = repo.findById(id);
		return op.isPresent() ? op.get() : new CartaModel(); 
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}


}
