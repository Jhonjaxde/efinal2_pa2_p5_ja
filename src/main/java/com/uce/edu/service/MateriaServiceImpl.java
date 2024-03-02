package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.modelo.Materia;
@Service
public class MateriaServiceImpl implements IMateriaService {
	@Autowired
	private IMateriaRepository materiaRepository;
	

	@Override
	
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorCodigo(codigo);
	}

}