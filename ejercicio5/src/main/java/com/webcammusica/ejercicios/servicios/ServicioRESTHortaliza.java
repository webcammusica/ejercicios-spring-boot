package com.webcammusica.ejercicios.servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.webcammusica.ejercicios.modelo.Hortaliza;

/**
 * La anotación "@restController" indica que la clase publica un servicio REST
 * 
 * @author kumo
 *
 */
@RestController
public class ServicioRESTHortaliza {

	/**
	 * Lista de ejemplo de usuarios
	 */
	private static List<Hortaliza> listaHortalizas = new ArrayList<Hortaliza>() {
		{
			add(new Hortaliza("Daucus", "Daucus carota"));
			add(new Hortaliza("Lactuca", "Lactuca sativa"));
			add(new Hortaliza("Solanum", "Solanum lycopersicum"));
		}
	};

	/**
	 * La anotación: "@RequestMapping(value = "/hortalizas", method =
	 * RequestMethod.GET)" indica el nombre del método accesible desde el navegador,
	 * en este caso "hortalizas" y también se indica el tipo de método, en este caso
	 * de tipo GET.
	 * 
	 * @return listaHortalizas
	 */
	@RequestMapping(value = "/hortalizas", method = RequestMethod.GET)
	public List<Hortaliza> getHortalizas() {
		return listaHortalizas;
	}
}