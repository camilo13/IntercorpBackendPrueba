package com.example.demo.modelo;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@ApiModelProperty(value = "Nombre del cliente.")
	private String nombre;
	
	@ApiModelProperty(value = "Apellido del cliente.")
	private String apellido;
	
	@ApiModelProperty(value = "Edad del cliente, se calcula a partir de la fecha de nacimiento.")
	private int edad;
	
	@ApiModelProperty(value = "Fecha de nacimiento del cliente. Type: LocalDate")
	private LocalDate fechaNac;
	
}
