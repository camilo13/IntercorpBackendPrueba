package com.example.demo.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.ClientesResponse;
import com.example.demo.modelo.CrearClienteRequest;
import com.example.demo.modelo.CrearClienteResponse;
import com.example.demo.modelo.KpiResponse;
import com.example.demo.service.ClientesService;
import com.example.demo.utils.Operaciones;

@Service
public class ClientesServiceImpl implements ClientesService {

	private List<Cliente> clientes = new ArrayList<>();
	private double promedio, desviacion;

    @Override
    public KpiResponse getKpi() {
        return new KpiResponse(this.promedio, this.desviacion);
    }
    
    @Override
    public ClientesResponse getClientes() {
    	return new ClientesResponse(clientes);
    }

    @Override
    public CrearClienteResponse post(CrearClienteRequest request) {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    	
    	LocalDate auxFechaNac = LocalDate.parse(request.getFechaNacimiento(), formatter);
    	Period edad = Period.between(auxFechaNac, LocalDate.now());
    	
    	Cliente cliente = new Cliente(request.getNombre(), request.getApellido(), edad.getYears(), auxFechaNac);

    	System.out.println(cliente);
    	clientes.add(cliente);
    	
    	this.promedio = Operaciones.getPromedio(clientes);
    	this.desviacion = Operaciones.getDesviacion(clientes, promedio);
    	
        return new CrearClienteResponse(clientes.size());
    }

}
