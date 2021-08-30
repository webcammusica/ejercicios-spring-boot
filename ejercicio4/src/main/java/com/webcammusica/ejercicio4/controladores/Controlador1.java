package com.webcammusica.ejercicio4.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class Controlador1 {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("tstamp", LocalDateTime.now());
		return "index";
	}
}