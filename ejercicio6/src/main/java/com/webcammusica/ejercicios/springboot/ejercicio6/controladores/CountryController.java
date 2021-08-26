package com.webcammusica.ejercicios.springboot.ejercicio6.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webcammusica.ejercicios.springboot.ejercicio6.servicios.CountryService;

/**
 * La anotación @Controller indica que esta clase es un controlador
 * 
 * @author kumo
 *
 */
@Controller
public class CountryController {

	private final CountryService countryService;

	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	/**
	 * La anotación @RequestMapping define el URL que escucha la petición procesada
	 * en el método en este caso la raíz "/"
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("countriesList", countryService.findAll());
		return "countriesList";
	}
}