package com.example.prueba.service;

import com.example.prueba.entity.Prueba1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PruebaServiceImplTest {

    PruebaServiceImpl pruebaService;

    @BeforeEach
    void setUp(){
        pruebaService = new PruebaServiceImpl();
    }


    @Test
    @DisplayName("Probando los datos agrupados por edad...")
    void getDatosAgrupadosPorEdad(){
        Map<Object, List<Prueba1>> response = pruebaService.getDatosAgrupadosPorEdad();
        assertNotNull( response );
        assertEquals( response.size(), 7);
        assertTrue( response.containsKey(32));
        assertEquals( "Mauricio Isla", response.get(32).get(0).getName() );
        assertEquals(33, response.get(33).get(1).getAge());
        assertEquals(2, response.get(33).size());
    }

    @Test
    @DisplayName("Probando los datos agrupados alfabeticamente...")
    void ordernadosAlfabeticamente(){
        Map<Object, List<Prueba1>> response = pruebaService.ordernadosAlfabeticamente();
        assertNotNull( response );
        assertEquals( response.size(), 7);
        assertTrue( response.containsKey(32));
        assertEquals( "Mauricio Isla", response.get(32).get(0).getName() );
        assertEquals("Arturo Vidal", response.get(33).get(0).getName());
        assertEquals("Matias Fernandez", response.get(34).get(1).getName());
        assertEquals(2, response.get(33).size());
    }

}