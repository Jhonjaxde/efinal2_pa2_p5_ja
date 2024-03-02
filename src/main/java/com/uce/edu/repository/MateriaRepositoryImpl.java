package com.uce.edu.repository;

import org.springframework.stereotype.Repository;


import com.uce.edu.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	
	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> consulta = 
				this.entityManager.createQuery("SELECT ma FROM Materia ma WHERE ma.codigo=:codigo", Materia.class);
		consulta.setParameter("codigo", codigo);
		return consulta.getSingleResult();
	}

}