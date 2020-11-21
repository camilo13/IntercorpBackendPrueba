package com.example.demo.modelo;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearClienteRequest {
	
    public static final String MSG_NOT_EMPTY = "No puede quedar sin valor";

    @NotEmpty(message = MSG_NOT_EMPTY)
    @ApiModelProperty(example = "Camilo", required = true)
    private String nombre;

    @NotEmpty(message = MSG_NOT_EMPTY)
    @ApiModelProperty(example = "Medina", required = true)
    private String apellido;

    @NotEmpty(message = MSG_NOT_EMPTY)
    @ApiModelProperty(example = "13/08/1990", required = true)
    private String fechaNacimiento;

}
