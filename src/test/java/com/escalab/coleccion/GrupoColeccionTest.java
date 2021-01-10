package com.escalab.coleccion;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.escalab.coleccion.model.GrupoColeccionModel;
import com.escalab.coleccion.repo.IGrupoColeccionRepo;
import com.escalab.coleccion.service.IGrupoColeccionService;
import com.escalab.coleccion.service.impl.GrupoColeccionServiceImpl;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner .class)
@SpringBootTest
public class GrupoColeccionTest {
	
    @Mock
    IGrupoColeccionRepo repo;

    @InjectMocks
    IGrupoColeccionService grupoColeccionService = new GrupoColeccionServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getGrupoColeccion(){
        Integer grupoColeccionId = null;
        when(repo.findById(grupoColeccionId)).thenReturn(Optional.of(new GrupoColeccionModel()));
        GrupoColeccionModel grupoColeccion = grupoColeccionService.leerPorId(grupoColeccionId);
        assertEquals(grupoColeccion.getIdGrupoColeccion(), grupoColeccionId);
    }
	
}
