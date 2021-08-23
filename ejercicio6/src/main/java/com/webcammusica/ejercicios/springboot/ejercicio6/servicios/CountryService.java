package com.webcammusica.ejercicios.springboot.ejercicio6.servicios;

/**
 * Servicio intermediario con el repositorio
 * @author kumo
 */
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.webcammusica.ejercicios.springboot.ejercicio6.entidades.Country;
import com.webcammusica.ejercicios.springboot.ejercicio6.repositorios.CountryRepository;

@Service
public class CountryService {

	private final CountryRepository countryRepository;

	/**
	 * constructor
	 * @param countryRepository
	 */
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	/**
	 * select *
	 * @return
	 */
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	/**
	 * select * where id = id
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
}