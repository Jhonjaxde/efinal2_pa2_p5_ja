package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaRepository {
public void insertar(Matricula matricula);
	
	public List<Matricula> seleccionarTodo();
}
