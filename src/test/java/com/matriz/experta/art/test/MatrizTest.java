package com.matriz.experta.art.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.matriz.experta.art.app.service.MatrizService;
import com.matriz.experta.art.models.BackResponse;

public class MatrizTest {
	private static MatrizService matrizService = new MatrizService();
	private static int matriz[][][];

	@Before
	public  void before() throws Exception {
//		int[][][] matriz = matrizService.createMatriz(3);
		matriz = matrizService.createMatriz(3);
	}

	@Test
	public void execueteTest() {
		BackResponse br = matrizService.execute("UPDATE 2 2 2 4");
		assertTrue(br.status == BackResponse.status.SUCCESS);
		br = matrizService.execute("QUERY 1 1 1 2 2 2");
		assertTrue(br.status == BackResponse.status.SUCCESS);

	}

	@Test
	public void executeTest2() {
		BackResponse br = matrizService.execute("UPDATE 1 1 1 23");
		assertTrue(br.status == BackResponse.status.SUCCESS);
		br = matrizService.execute("QUERY 2 2 2 4 4 4");
		assertTrue(br.status == BackResponse.status.ERROR && br.w == 0);
		br = matrizService.execute("QUERY 1 1 1 3 3 3");
		assertTrue(br.status == BackResponse.status.SUCCESS);
	}
	
	/*
	 * Test validaciones
	 * 1- W <= 100
	 * 2- update con mas de 5 parametros
	 * 3- query con mas de 7 parametros
	 * 4- posicion fuera de rango
	 */
	@Test
	public void executeValidationsTest() {
		BackResponse br = matrizService.execute("UPDATE 1 1 1 223");
		assertTrue(br.status == BackResponse.status.ERROR);	
		
		br = matrizService.execute("UPDATE 1 1 1 23 4");
		assertTrue(br.status == BackResponse.status.ERROR);
		
		br = matrizService.execute("QUERY 2 2 2 4 4 4 7");
		assertTrue(br.status == BackResponse.status.ERROR);		

		br = matrizService.execute("QUERY 2 1 0 3 3 4 7");
		assertTrue(br.status == BackResponse.status.ERROR);	

	}
	
}
