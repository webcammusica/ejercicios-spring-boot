package com.webcammusica.ejercicios.springboot.ejercicio6.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import com.webcammusica.ejercicios.springboot.ejercicio6.entidades.Country;
import com.webcammusica.ejercicios.springboot.ejercicio6.servicios.CountryService;

@RestController
@RequestMapping(CountryRestController.COUNTRY_RESOURCE)
public class CountryRestController {

	/**
	 * log de la clase 
	 */
	private static final Logger logger = LoggerFactory.getLogger(CountryRestController.class);
	
	/**
	 * Raíz para las llamadas al servicio REST
	 */
	public static final String COUNTRY_RESOURCE = "/api/country";
	
	private final CountryService countryService;
	
	/**
	 * Método constructor
	 * @param countryService
	 */
	public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }
	
	@GetMapping(value = "/{id}/")
	public ResponseEntity<Country> getById(@PathVariable("id") Long id) {
	    Optional<Country> country = countryService.findById(id);
	    return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	            .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
	}
}