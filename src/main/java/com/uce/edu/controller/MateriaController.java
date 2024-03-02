package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	@Autowired
	private IMateriaService materiaService;
	//http://localhost:8085/materia/nuevaMateria
	@GetMapping("/nuevaMateria")
	public String mostrarNuevaMateria(Model modelo) {
		modelo.addAttribute("materia",new Materia());
		return "vistaNuevaMateria";
		
	}
	//http://localhost:8085/materia/guardar
	@PostMapping("/guardar")
	public String guardar(Materia materia) {
		this.materiaService.guardar(materia);
		return "redirect:/materia/nuevaMateria";
	}
}
