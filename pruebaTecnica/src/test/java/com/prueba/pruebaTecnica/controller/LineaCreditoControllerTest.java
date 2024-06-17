package com.prueba.pruebaTecnica.controller;

import com.prueba.pruebaTecnica.models.LineaCredito;
import com.prueba.pruebaTecnica.repository.LineaCreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LineaCreditoControllerTest {

    @Mock
    private LineaCreditoRepository lineaCreditoRepository;

    @InjectMocks
    private LineaCreditoController lineaCreditoController;

    private LineaCredito lineaCredito1;
    private LineaCredito lineaCredito2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        lineaCredito1 = new LineaCredito();
        lineaCredito1.setCreditoId(1);
        lineaCredito1.setValorMaximo(10000f);
        lineaCredito1.setValorMinimo(5000f);
        lineaCredito1.setPlazoMaximo(60);

        lineaCredito2 = new LineaCredito();
        lineaCredito2.setCreditoId(2);
        lineaCredito2.setValorMaximo(20000f);
        lineaCredito2.setValorMinimo(10000f);
        lineaCredito2.setPlazoMaximo(60);
    }

    @Test
    public void testGetAllLineasCredito() {
        when(lineaCreditoRepository.findAll()).thenReturn(Arrays.asList(lineaCredito1, lineaCredito2));

        List<LineaCredito> lineasCredito = lineaCreditoController.getAllLineasCredito();

        assertEquals(2, lineasCredito.size());
        assertEquals(10000f, lineasCredito.get(0).getValorMaximo());
        assertEquals(20000f, lineasCredito.get(1).getValorMaximo());
    }

    @Test
    public void testGetLineaCreditoById() {
        when(lineaCreditoRepository.findById(1)).thenReturn(Optional.of(lineaCredito1));

        ResponseEntity<LineaCredito> response = lineaCreditoController.getLineaCreditoById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10000f, response.getBody().getValorMaximo());
    }

    @Test
    public void testGetLineaCreditoByIdNotFound() {
        when(lineaCreditoRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<LineaCredito> response = lineaCreditoController.getLineaCreditoById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateLineaCredito() {
        when(lineaCreditoRepository.save(lineaCredito1)).thenReturn(lineaCredito1);

        LineaCredito createdLineaCredito = lineaCreditoController.createLineaCredito(lineaCredito1);

        assertEquals(10000f, createdLineaCredito.getValorMaximo());
        verify(lineaCreditoRepository, times(1)).save(lineaCredito1);
    }

    @Test
    public void testUpdateLineaCredito() {
        when(lineaCreditoRepository.findById(1)).thenReturn(Optional.of(lineaCredito1));
        when(lineaCreditoRepository.save(lineaCredito1)).thenReturn(lineaCredito1);

        LineaCredito updatedDetails = new LineaCredito();
        updatedDetails.setValorMaximo(15000f);
        updatedDetails.setValorMinimo(8000f);
        updatedDetails.setPlazoMaximo(60);

        ResponseEntity<LineaCredito> response = lineaCreditoController.updateLineaCredito(1, updatedDetails);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(15000f, response.getBody().getValorMaximo());
    }

    @Test
    public void testUpdateLineaCreditoNotFound() {
        when(lineaCreditoRepository.findById(1)).thenReturn(Optional.empty());

        LineaCredito updatedDetails = new LineaCredito();
        updatedDetails.setValorMaximo(15000f);

        ResponseEntity<LineaCredito> response = lineaCreditoController.updateLineaCredito(1, updatedDetails);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteLineaCredito() {
        when(lineaCreditoRepository.findById(1)).thenReturn(Optional.of(lineaCredito1));

        ResponseEntity<Void> response = lineaCreditoController.deleteLineaCredito(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(lineaCreditoRepository, times(1)).delete(lineaCredito1);
    }

    @Test
    public void testDeleteLineaCreditoNotFound() {
        when(lineaCreditoRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = lineaCreditoController.deleteLineaCredito(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
