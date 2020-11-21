package com.example.demo.utils;

import java.util.List;

import com.example.demo.modelo.Cliente;

public class Operaciones {

	public static Double getPromedio(List<Cliente> clientes) {
		int suma = clientes.stream().mapToInt(m -> m.getEdad()).sum();
		return ((double) suma / clientes.size());
	}
	
	public static Double getDesviacion(List<Cliente> clientes, Double promedio) {
		Double sumatoria = (double) clientes.stream().mapToDouble(m -> Math.pow(m.getEdad() - promedio, 2)).sum();
		return Math.sqrt(sumatoria/clientes.size());
	}
}
