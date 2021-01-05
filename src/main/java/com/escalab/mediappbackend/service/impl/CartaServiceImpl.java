package com.escalab.mediappbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.mediappbackend.model.CartaModel;
import com.escalab.mediappbackend.repo.ICartaRepo;
import com.escalab.mediappbackend.service.ICartaService;

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
