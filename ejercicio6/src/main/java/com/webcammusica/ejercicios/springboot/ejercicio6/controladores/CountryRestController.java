package com.webcammusica.ejercicios.springboot.ejercicio6.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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
	 * 
	 * @param countryService
	 */
	public CountryRestController(CountryService countryService) {
		this.countryService = countryService;
	}

	/**
	 * Ejemplo: "http://localhost:9090/countries/api/country/2/". En este ejemplo la
	 * parte del URL que define esta clase es "/api/country" y la que define este
	 * metodo es "/2/". Es indispensable incluir el "/" al final.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}/")
	public ResponseEntity<Country> getById(@PathVariable("id") Long id) {
		Optional<Country> country = countryService.findById(id);
		return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
	}

	/**
	 * Se debe usar una aplicación para el envío de peticiones REST como Postman.
	 * Ejemplo: URL: "http://localhost:9090/países/api/country/".
	 * También funciona: "http://localhost:9090/países/api/country" sin "/" al final.
	 * Body de archivo tipo JSON (en Postman usar opción botón de radio: "raw"): 
	 "
	 {
	    "name": "Germany",
	    "population": 79778000
	}
	"
	 * @param country
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Map<String, Object>> add(@RequestBody @Valid Country country) {
		try {
			Long id = countryService.insert(country);
			return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<>(Collections.singletonMap("error", ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}