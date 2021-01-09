package com.escalab.coleccion.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.coleccion.exception.ModeloNotFoundException;
import com.escalab.coleccion.model.CartaModel;
import com.escalab.coleccion.service.ICartaService;

@RestController
@RequestMapping("/cartas")
public class CartaController {
	
	@Autowired
	private ICartaService cartaService;

//BuscarPorID
	@GetMapping("/{id}")
	public ResponseEntity<CartaModel> listarPorId(@PathVariable("id") Integer id){
		CartaModel cm = cartaService.leerPorId(id);
		if(cm.getIdCarta() == null) {
			return new ResponseEntity<CartaModel>(new CartaModel(), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CartaModel>(cm, HttpStatus.OK);
		}
	}

//ListarCartas
	@GetMapping("/lista")
	public ResponseEntity<List<CartaModel>> listar(){
		List<CartaModel> lista = cartaService.listar();
		return new ResponseEntity<List<CartaModel>>(lista, HttpStatus.OK);
	}

//InsertarCartas
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody CartaModel carta) {
		CartaModel cm = cartaService.registrar(carta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carta.getIdCarta()).toUri();
		return ResponseEntity.created(location).build();
	}

//EditarCartas
	@PutMapping
	public ResponseEntity<CartaModel> modificar(@Valid @RequestBody CartaModel carta){
		CartaModel cm = cartaService.modificar(carta);
		return new ResponseEntity<CartaModel>(cm, HttpStatus.OK);
	}
	
//EliminarCartas
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		CartaModel cm = cartaService.leerPorId(id);
		if(cm.getIdCarta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADA" + id);
		}
		cartaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
