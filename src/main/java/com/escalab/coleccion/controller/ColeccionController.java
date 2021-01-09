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
import com.escalab.coleccion.model.ColeccionModel;
import com.escalab.coleccion.service.IColeccionService;

@RestController
@RequestMapping("/colecciones")
public class ColeccionController {
	
	@Autowired
	private IColeccionService coleccionService;
	
//BuscarPorID
	@GetMapping("/{id}")
	public ResponseEntity<ColeccionModel> listarPorId(@PathVariable("id") Integer id){
		ColeccionModel cm = coleccionService.leerPorId(id);
		if(cm.getIdColeccion() == null) {
			return new ResponseEntity<ColeccionModel>(new ColeccionModel(), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ColeccionModel>(cm, HttpStatus.OK);
		}
	}

//ListarColeccion
	@GetMapping("/lista")
	public ResponseEntity<List<ColeccionModel>> listar(){
		List<ColeccionModel> lista = coleccionService.listar();
		return new ResponseEntity<List<ColeccionModel>>(lista, HttpStatus.OK);
	}

//InsertarColeccion
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody ColeccionModel coleccion) {
		ColeccionModel cm = coleccionService.registrar(coleccion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(coleccion.getIdColeccion()).toUri();
		return ResponseEntity.created(location).build();
	}

//EditarColeccion
	@PutMapping
	public ResponseEntity<ColeccionModel> modificar(@Valid @RequestBody ColeccionModel coleccion){
		ColeccionModel cm = coleccionService.modificar(coleccion);
		return new ResponseEntity<ColeccionModel>(cm, HttpStatus.OK);
	}

//EliminarColeccion
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		ColeccionModel cm = coleccionService.leerPorId(id);
		if(cm.getIdColeccion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADA" + id);
		}
		coleccionService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
