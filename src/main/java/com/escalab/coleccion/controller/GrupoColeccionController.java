package com.escalab.coleccion.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.escalab.coleccion.dto.GrupoColeccionDTO;
import com.escalab.coleccion.exception.ModeloNotFoundException;
import com.escalab.coleccion.model.GrupoColeccionModel;
import com.escalab.coleccion.service.IGrupoColeccionService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/grupo-coleccion")
public class GrupoColeccionController {
	
	@Autowired
	private IGrupoColeccionService grupoColeccionService;

//HATEOAS GrupoColeccion
	@GetMapping(value = "/hateoas-grupocoleccion-usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Hateoas de  grupo coleccion y usuario", notes="Listar Hateoas de Grupo Coleccion y Usuario")
	public List<GrupoColeccionDTO> listarHateoas() {
		List<GrupoColeccionModel> grupoColeccion = new ArrayList<>();
		List<GrupoColeccionDTO> grupoColeccionDTO = new ArrayList<>();
		grupoColeccion = grupoColeccionService.listar();

		for (GrupoColeccionModel gc : grupoColeccion) {
			GrupoColeccionDTO gcdto = new GrupoColeccionDTO();
			gcdto.setIdGrupoColeccion(gc.getIdGrupoColeccion());
			gcdto.setUsuario(gc.getUsuarioModel());

			ControllerLinkBuilder linkTo = linkTo(methodOn(GrupoColeccionController.class).listarPorId((gc.getIdGrupoColeccion())));
			gcdto.add(linkTo.withSelfRel());

			ControllerLinkBuilder linkTo1 = linkTo(methodOn(UsuarioController.class).listarPorId((gc.getUsuarioModel().getIdUsuario())));
			gcdto.add(linkTo1.withSelfRel());

			grupoColeccionDTO.add(gcdto);
		}
		return grupoColeccionDTO;
	}
	
//BuscarPorID
	@GetMapping("/{id}")
	@ApiOperation(value="Buscar Grupo Coleccion por ID", notes="Buscar Grupo de Coleccion por ID en la base de datos")
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
	@ApiOperation(value="Lista Grupo Coleccion", notes="Listar todos los Grupos de Colecciones registrados en la base de datos")
	public ResponseEntity<List<GrupoColeccionModel>> listar(){
		List<GrupoColeccionModel> lista = grupoColeccionService.listar();
		return new ResponseEntity<List<GrupoColeccionModel>>(lista, HttpStatus.OK);
	}
	
//InsertarGrupoColeccion
	@PostMapping
	@ApiOperation(value="Registrar nuevo Grupo Coleccion", notes="Registrar una nueva coleccion en la base de datos")
	public ResponseEntity<Object> registrar(@Valid @RequestBody GrupoColeccionModel grupoColeccion) {
		GrupoColeccionModel gcm = grupoColeccionService.registrar(grupoColeccion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(grupoColeccion.getIdGrupoColeccion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
//EditarGrupoColeccion
	@PutMapping
	@ApiOperation(value="Editar Grupo Coleccion", notes="Editar Grupo Coleccion existente por ID en endpoint")
	public ResponseEntity<GrupoColeccionModel> modificar(@Valid @RequestBody GrupoColeccionModel grupoColeccion){
		GrupoColeccionModel gcm = grupoColeccionService.modificar(grupoColeccion);
		return new ResponseEntity<GrupoColeccionModel>(gcm, HttpStatus.OK);
	}
	
//EliminarGrupoColeccion
	@DeleteMapping("/{id}")
	@ApiOperation(value="Eliminar Grupo Coleccion", notes="Eliminar Grupo Coleccion por ID")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		GrupoColeccionModel gcm = grupoColeccionService.leerPorId(id);
		if(gcm.getIdGrupoColeccion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADA" + id);
		}
		grupoColeccionService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
		
}

