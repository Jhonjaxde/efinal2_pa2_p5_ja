package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {
	@Autowired
	private IEstudianteService estudianteService;
	//http://localhost:8085/estudiante/nuevoEstudiante
	@GetMapping("/nuevoEstudiante")
	public String mostrarNuevoEstudiante(Model modelo) {
		modelo.addAttribute("estudiante",new Estudiante());
		return "vistaNuevoEstudiante";
		
	}
	//http://localhost:8085/estudiante/guardar
	@PostMapping("/guardar")
	public String guardar(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiante/nuevoEstudiante";
	}
}
