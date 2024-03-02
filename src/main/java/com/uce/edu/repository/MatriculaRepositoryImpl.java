package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	
	@Override
	public List<Matricula> seleccionarTodo() {
		TypedQuery<Matricula> consulta = this.entityManager.createQuery("SELECT matri FROM Matricula matri ", Matricula.class);

		return consulta.getResultList();
	}

}
