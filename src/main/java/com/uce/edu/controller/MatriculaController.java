package com.uce.edu.controller;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.uce.edu.repository.modelo.Matricula;

import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.service.IMatriculaService;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {
	@Autowired
	private IMatriculaService matriculaService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired 
	private IMateriaService materiaService;
	//http://localhost:8085/matricula/nuevaMatricula
	@GetMapping("/nuevaMatricula")
	public String mostrarNuevaMatricula(Model modelo) {
		Matricula matri = new Matricula();
		modelo.addAttribute("matricula",matri);
		return "vistaNuevaMatricula";
		
	}
	//http://localhost:8085/matricula/guardar
	@PostMapping("/guardar")
	public String guardar(Matricula matricula) {
		
		
		
		if(matricula.getEstudiante().getCedula().contains(this.estudianteService.buscarPorCedula(matricula.getEstudiante().getCedula()).getCedula())) {
			
			matricula.setEstudiante(this.estudianteService.buscarPorCedula(matricula.getEstudiante().getCedula()));
			
		}else {
			matricula.getEstudiante().setCedula(matricula.getMateria().getCodigo());
		}	
		if(matricula.getMateria().getCodigo().contains(this.materiaService.buscarPorCodigo(matricula.getMateria().getCodigo()).getCodigo())) {
			matricula.setMateria(this.materiaService.buscarPorCodigo(matricula.getMateria().getCodigo()));
			
		}else {
			matricula.getMateria().setCodigo(matricula.getMateria().getCodigo());
		}
		
		this.matriculaService.guardar(matricula);
		
		return "redirect:/matricula/nuevaMatricula";
	}
	//http://localhost:8085/matricula/reporte
	@GetMapping("/reporte")
	public String buscarTodos(Model modelo) {
		List<Matricula> lista = this.matriculaService.buscarTodo();
		lista.parallelStream().forEach(matricula -> {
			matricula.setFecha(LocalDateTime.now());
			matricula.setNombreHilo(Thread.currentThread().getName().toString());
		});
		modelo.addAttribute("matricula",lista);
		return "vistaReporteMatricula";
	}
}
