package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public void guardar(Matricula matricula);
	
	public List<Matricula> buscarTodo();
}
