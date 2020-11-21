package com.example.demo.service;

import com.example.demo.modelo.ClientesResponse;
import com.example.demo.modelo.CrearClienteRequest;
import com.example.demo.modelo.CrearClienteResponse;
import com.example.demo.modelo.KpiResponse;

public interface ClientesService {
    
	KpiResponse getKpi();
	
	ClientesResponse getClientes();

    CrearClienteResponse post(CrearClienteRequest request);

}
