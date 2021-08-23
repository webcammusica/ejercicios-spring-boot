package com.webcammusica.ejercicios.springboot.ejercicio6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webcammusica.ejercicios.springboot.ejercicio6.entidades.Country;

/**
 * Repositorio con el nombre de la tabla y el tipo de dato del ID
 * @author kumo
 */

public interface CountryRepository extends JpaRepository<Country, Long> {

}