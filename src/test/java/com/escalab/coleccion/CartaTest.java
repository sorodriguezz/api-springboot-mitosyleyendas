package com.escalab.coleccion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import com.escalab.coleccion.model.CartaModel;
import com.escalab.coleccion.repo.ICartaRepo;
import com.escalab.coleccion.service.ICartaService;
import com.escalab.coleccion.service.impl.CartaServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner .class)
@SpringBootTest
public class CartaTest {
	
	@Mock
	ICartaRepo repo;
	
	@InjectMocks
	ICartaService cartaService = new CartaServiceImpl();
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getCarta() {
		Integer cartaId = null;
		when(repo.findById(cartaId)).thenReturn(Optional.of(new CartaModel()));
		CartaModel carta = cartaService.leerPorId(cartaId);
		assertEquals(carta.getIdCarta(), cartaId);
	}
}
