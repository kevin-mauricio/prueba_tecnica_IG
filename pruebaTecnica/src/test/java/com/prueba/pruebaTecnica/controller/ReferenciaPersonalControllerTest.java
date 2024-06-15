package com.prueba.pruebaTecnica.controller;

import com.prueba.pruebaTecnica.models.ReferenciaPersonal;
import com.prueba.pruebaTecnica.repository.ReferenciaPersonalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReferenciaPersonalControllerTest {

    @Mock
    private ReferenciaPersonalRepository referenciaPersonalRepository;

    @InjectMocks
    private ReferenciaPersonalController referenciaPersonalController;

    private ReferenciaPersonal referenciaPersonal1;
    private ReferenciaPersonal referenciaPersonal2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        referenciaPersonal1 = new ReferenciaPersonal();
        referenciaPersonal1.setId(1);
        referenciaPersonal1.setNombre("Nombre1");
        referenciaPersonal1.setDireccion("Direccion1");
        referenciaPersonal1.setTelefono("123456789");
        referenciaPersonal1.setCiudad("Ciudad1");
        referenciaPersonal1.setEmail("email1@example.com");

        referenciaPersonal2 = new ReferenciaPersonal();
        referenciaPersonal2.setId(2);
        referenciaPersonal2.setNombre("Nombre2");
        referenciaPersonal2.setDireccion("Direccion2");
        referenciaPersonal2.setTelefono("987654321");
        referenciaPersonal2.setCiudad("Ciudad2");
        referenciaPersonal2.setEmail("email2@example.com");
    }

    @Test
    public void testGetAllReferenciasPersonales() {
        when(referenciaPersonalRepository.findAll()).thenReturn(Arrays.asList(referenciaPersonal1, referenciaPersonal2));

        List<ReferenciaPersonal> referenciasPersonales = referenciaPersonalController.getAllReferenciasPersonales();

        assertEquals(2, referenciasPersonales.size());
        assertEquals("Nombre1", referenciasPersonales.get(0).getNombre());
        assertEquals("Nombre2", referenciasPersonales.get(1).getNombre());
    }

    @Test
    public void testGetReferenciaPersonalById() {
        when(referenciaPersonalRepository.findById(1)).thenReturn(Optional.of(referenciaPersonal1));

        ResponseEntity<ReferenciaPersonal> response = referenciaPersonalController.getReferenciaPersonalById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nombre1", response.getBody().getNombre());
    }

    @Test
    public void testGetReferenciaPersonalByIdNotFound() {
        when(referenciaPersonalRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<ReferenciaPersonal> response = referenciaPersonalController.getReferenciaPersonalById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateReferenciaPersonal() {
        when(referenciaPersonalRepository.save(referenciaPersonal1)).thenReturn(referenciaPersonal1);

        ReferenciaPersonal createdReferenciaPersonal = referenciaPersonalController.createReferenciaPersonal(referenciaPersonal1);

        assertEquals("Nombre1", createdReferenciaPersonal.getNombre());
        verify(referenciaPersonalRepository, times(1)).save(referenciaPersonal1);
    }

    @Test
    public void testUpdateReferenciaPersonal() {
        when(referenciaPersonalRepository.findById(1)).thenReturn(Optional.of(referenciaPersonal1));
        when(referenciaPersonalRepository.save(referenciaPersonal1)).thenReturn(referenciaPersonal1);

        ReferenciaPersonal updatedDetails = new ReferenciaPersonal();
        updatedDetails.setNombre("NombreActualizado");
        updatedDetails.setDireccion("DireccionActualizada");
        updatedDetails.setTelefono("111111111");
        updatedDetails.setCiudad("CiudadActualizada");
        updatedDetails.setEmail("emailActualizado@example.com");

        ResponseEntity<ReferenciaPersonal> response = referenciaPersonalController.updateReferenciaPersonal(1, updatedDetails);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("NombreActualizado", response.getBody().getNombre());
    }

    @Test
    public void testUpdateReferenciaPersonalNotFound() {
        when(referenciaPersonalRepository.findById(1)).thenReturn(Optional.empty());

        ReferenciaPersonal updatedDetails = new ReferenciaPersonal();
        updatedDetails.setNombre("NombreActualizado");

        ResponseEntity<ReferenciaPersonal> response = referenciaPersonalController.updateReferenciaPersonal(1, updatedDetails);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteReferenciaPersonal() {
        when(referenciaPersonalRepository.findById(1)).thenReturn(Optional.of(referenciaPersonal1));

        ResponseEntity<Void> response = referenciaPersonalController.deleteReferenciaPersonal(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(referenciaPersonalRepository, times(1)).delete(referenciaPersonal1);
    }

    @Test
    public void testDeleteReferenciaPersonalNotFound() {
        when(referenciaPersonalRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = referenciaPersonalController.deleteReferenciaPersonal(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
