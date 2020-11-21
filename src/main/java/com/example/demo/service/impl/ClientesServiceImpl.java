package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

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

//    private final ParametersRepository parametersRepository;
//    private final ErrorMessageRepository errorMessageRepository;
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

//        GenerarCipResponse generarCipResponse = null;

//        Parameters accessToken = parametersRepository.findByElement("aldeamo.token.accesstoken");
//        Parameters refreshToken = parametersRepository.findByElement("aldeamo.token.refreshtoken");
//        TdpErrorMessageService message = errorMessageRepository.findByServiceCodeAndServiceKey("UF2", "upfront2");

//        String aux = message.getResponseMessage().replace("{CIP}",
//            String.valueOf(generarCipResponse.getData().getCip())).replace("{monto}",
//            String.valueOf(generarCipResponse.getData().getAmount()))
//            .replace("{fecha}", Objects.requireNonNull(parseStringDateAldeamo(request.getExpirationDate())));

//        AldeamoRequest aldeamoRequest = new AldeamoRequest(createHeaders(), AldeamoBodyIn.of(aux,
//            new AldeamoShortcut(request.getUserPhone(),
//                generarCipResponse.getData().getCipUrl())));
    	
    	LocalDate auxFechaNac = LocalDate.parse(request.getFechaNacimiento(), formatter);
    	Period edad = Period.between(auxFechaNac, LocalDate.now());
    	
    	Cliente cliente = new Cliente();
    	
    	cliente.setNombre(request.getNombre());
    	cliente.setApellido(request.getApellido());
    	cliente.setFechaNac(auxFechaNac);
    	cliente.setEdad(edad.getYears());

    	System.out.println(cliente);
    	clientes.add(cliente);
    	
    	this.promedio = Operaciones.getPromedio(clientes);
    	this.desviacion = Operaciones.getDesviacion(clientes, promedio);
    	
        return new CrearClienteResponse(clientes.size());
    }

}
