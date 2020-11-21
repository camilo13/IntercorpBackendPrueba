package com.example.demo.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	private String nombre;
	private String apellido;
	private int edad;
	private LocalDate fechaNac;
	
}
