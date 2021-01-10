package com.escalab.coleccion;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.escalab.coleccion.model.EdicionModel;
import com.escalab.coleccion.repo.IEdicionRepo;
import com.escalab.coleccion.service.IEdicionService;
import com.escalab.coleccion.service.impl.EdicionServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner .class)
@SpringBootTest
public class EdicionTest {
	
	@Mock
	IEdicionRepo repo;
	
	@InjectMocks
	IEdicionService edicionService = new EdicionServiceImpl();
	
	@Test
	public void getEdicion() {
		Integer edicionId = null;
		when(repo.findById(edicionId)).thenReturn(Optional.of(new EdicionModel()));
		EdicionModel edicion = edicionService.leerPorId(edicionId);
		assertEquals(edicion.getIdEdicion(), edicionId);
	}
}
