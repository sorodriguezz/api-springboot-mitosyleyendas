package com.escalab.coleccion;


import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.escalab.coleccion.model.ColeccionModel;
import com.escalab.coleccion.repo.IColeccionRepo;
import com.escalab.coleccion.service.IColeccionService;
import com.escalab.coleccion.service.impl.ColeccionServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner .class)
@SpringBootTest
public class ColeccionTest {
	
	@Mock
	IColeccionRepo repo;
	
	@InjectMocks
	IColeccionService coleccionService = new ColeccionServiceImpl();
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getColeccion() {
		Integer coleccionId = null;
		when(repo.findById(coleccionId)).thenReturn(Optional.of(new ColeccionModel()));
		ColeccionModel coleccion = coleccionService.leerPorId(coleccionId);
		assertEquals(coleccion.getIdColeccion(), coleccionId);
	}
}
