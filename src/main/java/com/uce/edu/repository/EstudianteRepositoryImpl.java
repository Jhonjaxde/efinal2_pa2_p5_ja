package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {

		TypedQuery<Estudiante> consulta = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:cedula", Estudiante.class);
		consulta.setParameter("cedula", cedula);
		return consulta.getSingleResult();
	}
}