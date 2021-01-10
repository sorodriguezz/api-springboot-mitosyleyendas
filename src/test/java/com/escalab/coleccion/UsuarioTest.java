package com.escalab.coleccion;

import com.escalab.coleccion.model.Usuario;
import com.escalab.coleccion.repo.IUsuarioRepo;
import com.escalab.coleccion.service.IUsuarioService;
import com.escalab.coleccion.service.impl.UsuarioServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner .class)
@SpringBootTest
public class UsuarioTest {

    @Mock
    IUsuarioRepo repo;

    @InjectMocks
    IUsuarioService usuarioService = new UsuarioServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUsuario(){
        Integer usuarioId = null;
        when(repo.findById(usuarioId)).thenReturn(Optional.of(new Usuario()));
        Usuario usuario = usuarioService.leerPorId(usuarioId);
        assertEquals(usuario.getIdUsuario(), usuarioId);
    }
}
