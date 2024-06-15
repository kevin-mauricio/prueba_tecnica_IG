package com.prueba.pruebaTecnica.controller;

import com.prueba.pruebaTecnica.models.Cliente;
import com.prueba.pruebaTecnica.repository.ClienteRepository;
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

public class ClienteControllerTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteController clienteController;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente1 = new Cliente();
        cliente1.setCliente_id(1);
        cliente1.setApellidos("Apellido1");
        cliente1.setResidencia("Residencia1");
        cliente1.setTelefono("123456789");

        cliente2 = new Cliente();
        cliente2.setCliente_id(2);
        cliente2.setApellidos("Apellido2");
        cliente2.setResidencia("Residencia2");
        cliente2.setTelefono("987654321");
    }

    @Test
    public void testGetAllClientes() {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteController.getAllClientes();

        assertEquals(2, clientes.size());
        assertEquals("Apellido1", clientes.get(0).getApellidos());
        assertEquals("Apellido2", clientes.get(1).getApellidos());
    }

    @Test
    public void testGetClienteById() {
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente1));

        ResponseEntity<Cliente> response = clienteController.getClienteById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Apellido1", response.getBody().getApellidos());
    }

    @Test
    public void testGetClienteByIdNotFound() {
        when(clienteRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Cliente> response = clienteController.getClienteById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateCliente() {
        when(clienteRepository.save(cliente1)).thenReturn(cliente1);

        Cliente createdCliente = clienteController.createCliente(cliente1);

        assertEquals("Apellido1", createdCliente.getApellidos());
        verify(clienteRepository, times(1)).save(cliente1);
    }

    @Test
    public void testUpdateCliente() {
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente1));
        when(clienteRepository.save(cliente1)).thenReturn(cliente1);

        cliente1.setApellidos("Updated Apellido1");
        ResponseEntity<Cliente> response = clienteController.updateCliente(1, cliente1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Apellido1", response.getBody().getApellidos());
        verify(clienteRepository, times(1)).save(cliente1);
    }

    @Test
    public void testUpdateClienteNotFound() {
        when(clienteRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Cliente> response = clienteController.updateCliente(1, cliente1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteCliente() {
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente1));

        ResponseEntity<Void> response = clienteController.deleteCliente(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(clienteRepository, times(1)).delete(cliente1);
    }

    @Test
    public void testDeleteClienteNotFound() {
        when(clienteRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = clienteController.deleteCliente(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
