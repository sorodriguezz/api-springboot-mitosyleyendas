package com.escalab.coleccion.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.escalab.coleccion.model.EdicionModel;
import com.escalab.coleccion.service.IEdicionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ediciones")
public class EdicionController {
	
	@Autowired
	private IEdicionService edicionService;
	
//BuscarPorID
	@GetMapping("/{id}")
	@ApiOperation(value="Buscar Edicion por ID", notes="Buscar coleccion por su ID en el endpoint")
	public ResponseEntity<EdicionModel> listarPorId(@PathVariable("id") Integer id){
		EdicionModel em = edicionService.leerPorId(id);
		if(em.getIdEdicion() == null) {
			return new ResponseEntity<EdicionModel>(new EdicionModel(), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<EdicionModel>(em, HttpStatus.OK);
		}
	}

//ListarEdiciones
	@GetMapping("/lista")
	@ApiOperation(value="Listar todas las Ediciones", notes="Listar todas las colecciones que esten en la base de datos")
	public ResponseEntity<List<EdicionModel>> listar(){
		List<EdicionModel> lista = edicionService.listar();
		return new ResponseEntity<List<EdicionModel>>(lista, HttpStatus.OK);
	}

//InsertarEdiciones
	@PostMapping
	@ApiOperation(value="Registrar nueva Edicion", notes="Registrar una nueva Edicion en la base de datos")
	public ResponseEntity<Object> registrar(@Valid @RequestBody EdicionModel edicion){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DBA")) || auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN") )) {
			EdicionModel em = edicionService.registrar(edicion);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(edicion.getIdEdicion()).toUri();
			return ResponseEntity.created(location).build();
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

//EditarEdicion
	@PutMapping
	@ApiOperation(value="Editar Edicion", notes="Editar una Edicion existente")
	public ResponseEntity<EdicionModel> modificar(@Valid @RequestBody EdicionModel edicion){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DBA")) || auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN") )) {
			EdicionModel em = edicionService.modificar(edicion);
			return new ResponseEntity<EdicionModel>(em, HttpStatus.OK);
		}else {
			return new ResponseEntity<EdicionModel>(HttpStatus.UNAUTHORIZED);
		}
	}

//EliminarEdicion
	@DeleteMapping("/{id}")
	@ApiOperation(value="Eliminar Edicion", notes="Eliminar una edicion por su ID")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DBA")) || auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN") )) {
			EdicionModel em = edicionService.leerPorId(id);
			if(em.getIdEdicion() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADA" + id);
			}
			edicionService.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
