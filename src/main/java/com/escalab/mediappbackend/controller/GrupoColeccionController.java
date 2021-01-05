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

import com.escalab.mediappbackend.exception.ModeloNotFoundException;
import com.escalab.mediappbackend.model.GrupoColeccionModel;
import com.escalab.mediappbackend.service.IGrupoColeccionService;


@RestController
@RequestMapping("/grupo-coleccion")
public class GrupoColeccionController {
	
	@Autowired
	private IGrupoColeccionService grupoColeccionService;
	
//BuscarPorID
	@GetMapping("/{id}")
	public ResponseEntity<GrupoColeccionModel> listarPorId(@PathVariable("id") Integer id){
		GrupoColeccionModel cm = grupoColeccionService.leerPorId(id);
		if(cm.getIdGrupoColeccion() == null) {
			return new ResponseEntity<GrupoColeccionModel>(new GrupoColeccionModel(), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<GrupoColeccionModel>(cm, HttpStatus.OK);
		}
	}
	
//ListarGrupoColeccion
	@GetMapping("/lista")
	public ResponseEntity<List<GrupoColeccionModel>> listar(){
		List<GrupoColeccionModel> lista = grupoColeccionService.listar();
		return new ResponseEntity<List<GrupoColeccionModel>>(lista, HttpStatus.OK);
	}
	
//InsertarCartas
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody GrupoColeccionModel grupoColeccion) {
		GrupoColeccionModel gcm = grupoColeccionService.registrar(grupoColeccion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(grupoColeccion.getIdGrupoColeccion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
//EditarCartas
	@PutMapping
	public ResponseEntity<GrupoColeccionModel> modificar(@Valid @RequestBody GrupoColeccionModel grupoColeccion){
		GrupoColeccionModel gcm = grupoColeccionService.modificar(grupoColeccion);
		return new ResponseEntity<GrupoColeccionModel>(gcm, HttpStatus.OK);
	}
	
//EliminarCartas
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		GrupoColeccionModel gcm = grupoColeccionService.leerPorId(id);
		if(gcm.getIdGrupoColeccion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADA" + id);
		}
		grupoColeccionService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
		
}

