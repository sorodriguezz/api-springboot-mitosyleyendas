package com.escalab.coleccion;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.escalab.coleccion.model.CartaModel;
import com.escalab.coleccion.repo.ICartaRepo;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ColeccionApplicacionTest {
//	
//	@Autowired
//	private ICartaRepo repo;
//	
//	@Test
//	public void getCarta() {
//		CartaModel carta = new CartaModel();
//		carta.setNombreCarta("Midyir");
//		carta.setCosteCarta("2");
//		carta.setHabilidadCarta("Midyir puede portar más de un Arma, si lo hace es Imbloqueable.");
//		carta.setImagenCarta("midyir.jpg");
//		carta.setCodigoCarta("003/236");
//		carta.setIlustradorCarta("Mauricio Herrera");
//		carta.setHistoriaCarta("El de la cabellera roja: suya es la guerra y el fulgor de la vida, jamás perderá lo que es suyo.");
//		carta.setFrecuenciaCarta("Real");
//		carta.setFuerzaCarta("2");
//		carta.setTipoCarta("Aliado");
//		
//		Optional<CartaModel> retorno = repo.findById(carta.getIdCarta());
//		assertEquals(retorno.get().getCodigoCarta(), carta.getCodigoCarta());
//	}
}
