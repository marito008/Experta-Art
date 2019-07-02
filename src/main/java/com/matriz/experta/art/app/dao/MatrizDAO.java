package com.matriz.experta.art.app.dao;

import com.matriz.experta.art.models.BackResponse;

public interface MatrizDAO {
	public int[][][] createMatriz(int size) throws Exception;

	public int[][][] initializeMatriz(int[][][] matriz);

	public BackResponse updateValueMatriz(String[] parametros, int[][][] matriz);

	public BackResponse queryMatriz(String[] parametros, int[][][] matriz);

	

}
