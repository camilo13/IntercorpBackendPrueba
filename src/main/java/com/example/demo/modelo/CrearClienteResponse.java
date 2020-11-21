package com.example.demo.modelo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearClienteResponse {
	
	@ApiModelProperty(value = "ID asignado al nuevo cliente")
    private int id;
}
