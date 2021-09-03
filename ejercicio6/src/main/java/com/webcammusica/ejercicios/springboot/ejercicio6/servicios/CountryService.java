package com.webcammusica.ejercicios.springboot.ejercicio6.servicios;

import java.util.Collections;
/**
 * Servicio intermediario entre el repositorio y la entidad
 * la entidad y el repositorio también tienen relación directa
 * @author kumo
 */
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.webcammusica.ejercicios.springboot.ejercicio6.entidades.Country;
import com.webcammusica.ejercicios.springboot.ejercicio6.repositorios.CountryRepository;

@Service
public class CountryService {

	private final CountryRepository countryRepository;

	/**
	 * constructor
	 * 
	 * @param countryRepository
	 */
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	/**
	 * select * contiene un método de Java 8 para ordenar la lista por nombre usando
	 * una expresión Lamda.
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
}