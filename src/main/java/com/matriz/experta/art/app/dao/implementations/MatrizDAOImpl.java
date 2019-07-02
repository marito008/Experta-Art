package com.matriz.experta.art.app.dao.implementations;

import com.matriz.experta.art.app.dao.MatrizDAO;
import com.matriz.experta.art.models.BackResponse;
import com.matriz.experta.art.models.Matriz;

public class MatrizDAOImpl implements MatrizDAO{

	@Override
	public int[][][] createMatriz(int size) throws Exception {
		if (!(size >= 1 && size <= 100)) {
			throw new Exception("Lado debe estar entre 0 y 100");
		}		
		int [][][] matriz = new int[size][size][size];
		return initializeMatriz(matriz);
	}

	@Override
	public int[][][] initializeMatriz(int[][][] matriz) {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				for (int z = 0; z < 3; z++) {
					matriz[x][y][z] = 0;
				}
			}
		}

		return matriz;
	}

	/**
	 * operation UPDATE
	 * @param parametros, matriz
	 * 4 parameters example ( UPDATE x y z W), x,y,z coordinates, W = value, matriz[][][]
	 * @return
	 */
	@Override
	public BackResponse updateValueMatriz(String[] parametros, int[][][] matriz) {

		if (parametros.length <= 5) {
			try {
				Matriz value = new Matriz(Integer.parseInt(parametros[1]), Integer.parseInt(parametros[2]), Integer.parseInt(parametros[3]), Integer.parseInt(parametros[4])); 
				
				if (valuesValidUpdate(value)) {
					matriz[value.getValX()][value.getValY()][value.getValZ()] = value.getValW();
					
					return new BackResponse(BackResponse.status.SUCCESS, 0, value.getValW(), "Method UPDATE");
				}

			} catch (Exception e) {

				return new BackResponse(BackResponse.status.ERROR, 999, 0, "Method UPDATE");
			}
		}

		return new BackResponse(BackResponse.status.ERROR, 999, 0, "PARAMETROS INCORRECTOS UPDATE");
	}

	private boolean valuesValidUpdate(Matriz value) {
		if (value.getValX() >= 0 && value.getValX() <= 3 && 
			value.getValY() >= 0 && value.getValY() <= 3 && 
			value.getValZ() >= 0 && value.getValZ() <= 3 &&
			value.getValW() > -127 && value.getValW() <= 126) {
			
			return true;
		}
		
		return false;
	}


	
	@Override
	public BackResponse queryMatriz(String[] parametros, int[][][] matriz) {
			Matriz ini;
			Matriz fin;
			int total = 0;
			if (parametros.length == 7) {
				try {
					ini = new Matriz(Integer.parseInt(parametros[1]), Integer.parseInt(parametros[2]), Integer.parseInt(parametros[3]), 0);
					fin = new Matriz(Integer.parseInt(parametros[4]), Integer.parseInt(parametros[5]), Integer.parseInt(parametros[6]), 0); 


					if (valuesValidQuery(ini, fin)) {
						for (int x = ini.getValX(); x <= fin.getValX(); x++) {
							for (int y = ini.getValY(); y <= fin.getValX(); y++) {
								for (int z = ini.getValZ(); z <= fin.getValZ(); z++) {
									total = total + matriz[x-1][y-1][z-1];
								}
							}
						}

						return new BackResponse(BackResponse.status.SUCCESS, 0, 0, "Method QUERY");
					}
				} catch (Exception e) {

					return new BackResponse(BackResponse.status.ERROR, 999, 0, "Method QUERY");
				}
			}

			return new BackResponse(BackResponse.status.ERROR, 999, 0, "PARAMETROS INCORRECTOS QUERY");
	}

	private boolean valuesValidQuery(Matriz ini, Matriz fin) {
		
		if (ini.getValX() > 0 && ini.getValX() <= fin.getValX() && 
			ini.getValY() >= 0 && ini.getValY() <= fin.getValY() && 
			ini.getValZ() >= 0 && ini.getValZ() <= fin.getValZ()) {
			
			return true;
		}
		
		return false;
	}
}
