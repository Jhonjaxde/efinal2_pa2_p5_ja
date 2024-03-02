package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	@Id
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@Column(name = "matr_id")
	private Integer id;
	@Column(name = "matr_fecha")
	private LocalDateTime fecha;
	@Column(name = "matr_nombreHilo")
	private String nombreHilo;
	//SET Y GET
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "esma_id_estudiante")
	private Estudiante estudiante;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "esma_id_materia")
	private Materia materia;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getNombreHilo() {
		return nombreHilo;
	}
	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
