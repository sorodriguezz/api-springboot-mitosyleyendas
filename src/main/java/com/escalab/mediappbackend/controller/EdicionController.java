package com.escalab.mediappbackend.controller;

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

import com.escalab.mediappbackend.dto.EdicionDTO;
import com.escalab.mediappbackend.exception.ModeloNotFoundException;
import com.escalab.mediappbackend.model.EdicionModel;
import com.escalab.mediappbackend.service.IEdicionService;

@RestController
@RequestMapping("/ediciones")
public class EdicionController {
	
	@Autowired
	private IEdicionService edicionService;
	
//BuscarPorID
	@GetMapping("/{id}")
	public ResponseEntity<EdicionModel> listarPorId(@PathVariable("id") Integer id){
		EdicionModel em = edicionService.leerPorId(id);
		if(em.getIdEdicion() == null) {
			return new ResponseEntity<EdicionModel>(new EdicionModel(), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<EdicionModel>(em, HttpStatus.OK);
		}
	}
	
// Listar DTO Ediciones
	@GetMapping("/lista-dto")
	public ResponseEntity<List<EdicionDTO>> listardto(){
		List<EdicionDTO> lista = edicionService.findEdicion();
		return new ResponseEntity<List<EdicionDTO>>(lista, HttpStatus.OK);
	}

//ListarEdiciones
	@GetMapping("/lista")
	public ResponseEntity<List<EdicionModel>> listar(){
		List<EdicionModel> lista = edicionService.listar();
		return new ResponseEntity<List<EdicionModel>>(lista, HttpStatus.OK);
	}

//InsertarEdiciones
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody EdicionModel edicion){
		EdicionModel em = edicionService.registrar(edicion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(edicion.getIdEdicion()).toUri();
		return ResponseEntity.created(location).build();
	}

//EditarEdicion
	@PutMapping
	public ResponseEntity<EdicionModel> modificar(@Valid @RequestBody EdicionModel edicion){
		EdicionModel em = edicionService.modificar(edicion);
		return new ResponseEntity<EdicionModel>(em, HttpStatus.OK);
	}

//EliminarEdicion
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		EdicionModel em = edicionService.leerPorId(id);
		if(em.getIdEdicion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADA" + id);
		}
		edicionService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
