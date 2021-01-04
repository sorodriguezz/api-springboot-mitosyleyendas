package com.escalab.mediappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.mediappbackend.model.CartaModel;
import com.escalab.mediappbackend.service.ICartaService;

@RestController
@RequestMapping("/cartas")
public class CartaController {
	
	@Autowired
	private ICartaService cartaService;
	
	@GetMapping
	public ResponseEntity<List<CartaModel>> listar(){
		List<CartaModel> lista = cartaService.listar();
		return new ResponseEntity<List<CartaModel>>(lista, HttpStatus.OK);
	}
}
