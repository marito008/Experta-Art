package com.matriz.experta.art.app.service;

import com.matriz.experta.art.app.dao.MatrizDAO;
import com.matriz.experta.art.app.dao.implementations.MatrizDAOImpl;
import com.matriz.experta.art.models.BackResponse;

public class MatrizService {
	private MatrizDAO matrizDAO = new MatrizDAOImpl();
	
	private int[][][] matriz;

	/**
	 * @param size
	 * Variable que indica la dimension de la matriz
	 */
	public int[][][] createMatriz(int size) throws Exception {
		matriz = matrizDAO.createMatriz(size);
		return matriz;
	}

	/**
	 * @param operacion
	 *            operacion para ejecutar
	 */
	public BackResponse execute(String param) {

		String[] parametros = param.split(" ");

		if (parametros.length > 0) {
			switch(parametros[0]) {
			  case "UPDATE":
				  return matrizDAO.updateValueMatriz(parametros, matriz);
			  case "QUERY":
				  return matrizDAO.queryMatriz(parametros, matriz);
			  default:
				  new BackResponse(BackResponse.status.ERROR, 999, 0, "operacion incorreca");
			}			
		}
		
		return new BackResponse(BackResponse.status.ERROR, 999, 0, "Method EXECUTE");
	}

}
