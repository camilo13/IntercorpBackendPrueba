package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.ClientesResponse;
import com.example.demo.modelo.CrearClienteRequest;
import com.example.demo.modelo.CrearClienteResponse;
import com.example.demo.modelo.KpiResponse;
import com.example.demo.service.ClientesService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientesApi")
@AllArgsConstructor
public class ClientesController {
	
	@Autowired
	private ClientesService clientesService;

	@PostMapping("/creacliente")
    public ResponseEntity<CrearClienteResponse> setCliente(@RequestBody CrearClienteRequest request) {
        return ResponseEntity.ok(clientesService.post(request));
    }
	
	@GetMapping("/kpideclientes")
	public ResponseEntity<KpiResponse> getKpi() {
		return ResponseEntity.ok(clientesService.getKpi());
	}
	
	@GetMapping("/listclientes")
	public ResponseEntity<ClientesResponse> getClientes() {
		return ResponseEntity.ok(clientesService.getClientes());
	}
}
