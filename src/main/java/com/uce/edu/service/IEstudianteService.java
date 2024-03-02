package com.uce.edu.service;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public void guardar(Estudiante estudiante);
	
	public Estudiante buscarPorCedula(String cedula);
}
