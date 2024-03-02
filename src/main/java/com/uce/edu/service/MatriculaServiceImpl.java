package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Matricula;
@Service
public class MatriculaServiceImpl implements IMatriculaService {
	@Autowired
	private IMatriculaRepository matriculaRepository;
	

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepository.insertar(matricula);
	}

	

	@Override
	
	public List<Matricula> buscarTodo() {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionarTodo();
	}

}
