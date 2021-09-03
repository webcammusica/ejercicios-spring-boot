package com.webcammusica.ejercicios.springboot.ejercicio6.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webcammusica.ejercicios.springboot.ejercicio6.servicios.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.webcammusica.ejercicios.springboot.ejercicio6.CustomProperties;

/**
 * La anotación @Controller indica que esta clase es un controlador
 * 
 * @author kumo
 *
 */
@Controller
public class CountryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	private final CountryService countryService;

	private final CustomProperties customProperties;

	public CountryController(CountryService countryService, CustomProperties customProperties) {
		this.countryService = countryService;
		this.customProperties = customProperties;
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
		logger.info(customProperties.getValue());
		model.addAttribute("countriesList", countryService.findAll());
		return "countriesList";
	}
}