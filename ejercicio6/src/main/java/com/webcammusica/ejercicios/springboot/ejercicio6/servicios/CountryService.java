package com.webcammusica.ejercicios.springboot.ejercicio6.servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcammusica.ejercicios.springboot.ejercicio6.entidades.Country;
import com.webcammusica.ejercicios.springboot.ejercicio6.repositorios.CountryRepository;

/**
 * Servicio intermediario entre el repositorio y la entidad la entidad y el
 * repositorio también tienen relación directa. Contiene la lógica de
 * programación.
 * 
 * @author kumo
 */
@Service
public class CountryService {

	/**
	 * La anotación @Autowired carga el bean en la aplicación Spring, inicializa el
	 * atributo de la misma manera que lo haríamos en Java:
	 * 
	 * Como atributo: private final CountryRepository countryRepository;
	 * 
	 * Dentro del constructor: "this.countryRepository = countryRepository;"
	 * 
	 * Es decir inicializa.
	 */

	@Autowired
	CountryRepository countryRepository;

	/**
	 * constructor
	 * 
	 * @param countryRepository
	 */
	public CountryService(CountryRepository countryRepository) {

	}

	/**
	 * select * que además contiene un método de Java 8 para ordenar la lista por
	 * nombre usando una expresión Lamda.
	 * 
	 * @return
	 */
	public List<Country> findAll() {
		List<Country> list = countryRepository.findAll();
		Collections.sort(list, (x, y) -> x.getName().compareToIgnoreCase(y.getName()));
		return list;
	}

	/**
	 * select * where id = id
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Country> findById(Long id) {

		return countryRepository.findById(id);
	}

	/**
	 * insert
	 */
	public Long insert(Country country) {
		country.setId(null);
		return countryRepository.save(country).getId();
	}

	/**
	 * update
	 * Los campos no mapeados son actualizados con "null".
	 * @param countryUpdate
	 * @return mensaje de éxito o error de actualización
	 */
	public String patchUpdate(Country countryUpdate) {

		Long id = countryUpdate.getId();
		if (countryRepository.findById(id).isPresent()) {
			Country updatedCountry = countryRepository.findById(id).get();
			updatedCountry.setId(countryUpdate.getId());
			//updatedCountry.setName(countryUpdate.getName());
			updatedCountry.setPopulation(countryUpdate.getPopulation());
			
			agregarInfoAuditabe(updatedCountry);
			
			countryRepository.save(updatedCountry);
			return "País con id: " + updatedCountry.getId() + ", actualizado correctamente";
		}

		return "El país con id: " + countryUpdate.getId() + " no existe.";
	}
	
	

	public Country agregarInfoAuditabe(Country country) {
		
		country.setCreateBy("carlos");
		country.setCreatedDate(LocalDateTime.now());
		country.setLastModifiedBy("carlos");
		country.setLastModifiedDate(LocalDateTime.now());
		
		return country;
	}
}