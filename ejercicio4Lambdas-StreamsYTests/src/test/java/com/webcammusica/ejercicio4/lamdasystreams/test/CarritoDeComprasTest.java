package com.webcammusica.ejercicio4.lamdasystreams.test;

import org.junit.Assert;
import org.junit.Test;

import com.webcammusica.ejercicio4.lamdasystreams.CarritoDeCompras;
import com.webcammusica.ejercicio4.lamdasystreams.ConstructorCarrito;

public class CarritoDeComprasTest {

	/**
	 * Números grandes para las pruebas
	 */
	private final Long TAMAÑO_TOTAL = 20000000L;
	private final Long NUEVO_VALOR = 1000000L;

	@Test
	public void debeRetornarElConteoDeTodosLosItems() throws Exception {

		ConstructorCarrito constructorCarrito = new ConstructorCarrito(30);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertEquals(30, carritoDeCompras.contarNumeroDeProductos());
	}

	@Test
	public void debeRetornarElPrecioTotalCalculado() throws Exception {

		ConstructorCarrito constructorCarrito = new ConstructorCarrito(60, 5);
		CarritoDeCompras carritoDeLaCompra = constructorCarrito.construir();
		Assert.assertEquals(300, carritoDeLaCompra.calcularPrecioTotal());

	}

	/**
	 * Test de los calculos mediante programación funcional con un lambda pasado
	 * como predicado al método stream() del objeto Collection "precios".
	 * 
	 * @throws Exception
	 */

	@Test
	public void debeCalcularElPrecioTotalConLambda() throws Exception {

		ConstructorCarrito constructorCarrito = new ConstructorCarrito(60, 5);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertEquals(300, carritoDeCompras.calcularPrecioTotalLambda());
	}

	/**
	 * Se prueba para un carrito de compras de 20 items a un precio de 100 cada uno
	 * el 5% de 100 que es el parámetro de calcularDescuentoTotal(parámetro) es 5, y
	 * 5*20=100.
	 * 
	 * @throws Exception
	 */
	@Test
	public void debeCalcularElTotalDelDescuentoMedianteProgramaciónImperativa() throws Exception {

		ConstructorCarrito constructorCarrito = new ConstructorCarrito(20, 100);
		CarritoDeCompras carritoDeLaCompra = constructorCarrito.construir();
		Assert.assertEquals(100, carritoDeLaCompra.calcularDescuentoTotal(100));

	}

	@Test
	public void debeCalcularElTotalDelDescuentoMedianteProgramaciónFuncional() throws Exception {

		ConstructorCarrito constructorCarrito = new ConstructorCarrito(20, 100);
		CarritoDeCompras carritoDeLaCompra = constructorCarrito.construir();
		Assert.assertEquals(100, carritoDeLaCompra.calcularDescuentoTotalLambda(100));

	}

	/**
	 * Si el número Long excede la capacidad del tipo int se genera una
	 * "java.lang.ArithmeticException: integer overflow" Si no debe detectar si la
	 * comprobación para un precio negativo es "true".
	 */
	@Test
	public void debeDetectarSiExisteAlgúnPrecioNegativoMedianteProgramaciónImperativa() {

		int tamañoTotal = Math.toIntExact(TAMAÑO_TOTAL);
		int nuevoValor = Math.toIntExact(NUEVO_VALOR);
		ConstructorCarrito constructorCarrito = new ConstructorCarrito(tamañoTotal, nuevoValor);
		constructorCarrito.agregarItem(Math.toIntExact(-1L));
		constructorCarrito.agregarItems(tamañoTotal, nuevoValor);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertTrue(carritoDeCompras.detectarError());

	}

	@Test
	public void debeDetectarSiExisteAlgúnPrecioNegativoMedianteProgramaciónFuncionalFindLambdaFindAny() {

		int tamañoTotal = Math.toIntExact(TAMAÑO_TOTAL);
		int nuevoValor = Math.toIntExact(NUEVO_VALOR);
		ConstructorCarrito constructorCarrito = new ConstructorCarrito(tamañoTotal, nuevoValor);
		constructorCarrito.agregarItem(Math.toIntExact(-1L));
		constructorCarrito.agregarItems(tamañoTotal, nuevoValor);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertTrue(carritoDeCompras.detectarErrorFindAny());

	}

	@Test
	public void debeDetectarSiExisteAlgúnPrecioNegativoMedianteProgramaciónFuncionalLambdaFindFirst() {

		int tamañoTotal = Math.toIntExact(TAMAÑO_TOTAL);
		int nuevoValor = Math.toIntExact(NUEVO_VALOR);
		ConstructorCarrito constructorCarrito = new ConstructorCarrito(tamañoTotal, nuevoValor);
		constructorCarrito.agregarItem(Math.toIntExact(-1L));
		constructorCarrito.agregarItems(tamañoTotal, nuevoValor);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertTrue(carritoDeCompras.detectarErrorFindFirst());

	}

	/**
	 * Pruebas de con stream paralelo
	 */

	@Test
	public void debeDetectarSiExisteAlgúnPrecioNegativoMedianteProgramaciónFuncionalLambdaAnyMatchParallel() {

		int tamañoTotal = Math.toIntExact(TAMAÑO_TOTAL);
		int nuevoValor = Math.toIntExact(NUEVO_VALOR);
		ConstructorCarrito constructorCarrito = new ConstructorCarrito(tamañoTotal, nuevoValor);
		constructorCarrito.agregarItem(Math.toIntExact(-1L));
		constructorCarrito.agregarItems(tamañoTotal, nuevoValor);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertTrue(carritoDeCompras.detectarErrorAnyMatchParallel());

	}
	
	@Test
	public void debeDetectarSiExisteAlgúnPrecioNegativoMedianteProgramaciónFuncionalLambdaFindAnyParallel() {

		int tamañoTotal = Math.toIntExact(TAMAÑO_TOTAL);
		int nuevoValor = Math.toIntExact(NUEVO_VALOR);
		ConstructorCarrito constructorCarrito = new ConstructorCarrito(tamañoTotal, nuevoValor);
		constructorCarrito.agregarItem(Math.toIntExact(-1L));
		constructorCarrito.agregarItems(tamañoTotal, nuevoValor);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertTrue(carritoDeCompras.detectarErrorFindAnyParallel());

	}
	
	@Test
	public void debeDetectarSiExisteAlgúnPrecioNegativoMedianteProgramaciónFuncionalLambdaFindFirstParallel() {

		int tamañoTotal = Math.toIntExact(TAMAÑO_TOTAL);
		int nuevoValor = Math.toIntExact(NUEVO_VALOR);
		ConstructorCarrito constructorCarrito = new ConstructorCarrito(tamañoTotal, nuevoValor);
		constructorCarrito.agregarItem(Math.toIntExact(-1L));
		constructorCarrito.agregarItems(tamañoTotal, nuevoValor);
		CarritoDeCompras carritoDeCompras = constructorCarrito.construir();
		Assert.assertTrue(carritoDeCompras.detectarErrorFindFirstParallel());

	}

}