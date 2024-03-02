package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Estudiante;
@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;
	

	@Override
	
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	
	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		
		
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}
	
}
