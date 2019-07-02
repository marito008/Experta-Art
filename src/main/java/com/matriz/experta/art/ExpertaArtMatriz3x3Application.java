package com.matriz.experta.art;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matriz.experta.art.app.service.MatrizService;
import com.matriz.experta.art.models.BackResponse;

@SpringBootApplication
public class ExpertaArtMatriz3x3Application implements CommandLineRunner {
	@Autowired
	private static MatrizService matrizService = new MatrizService();
	
	public static void main(String[] args) {
		SpringApplication.run(ExpertaArtMatriz3x3Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int[][][] matriz = matrizService.createMatriz(3);
		
		execute("UPDATE 2 2 2 4");
		execute("QUERY 1 1 1 3 3 3");
		execute("UPDATE 1 1 1 23");
		execute("QUERY 2 2 2 4 4 4");
		execute("QUERY 1 1 1 3 3 3");
		execute("UPDATE 2 2 2 1");
		execute("QUERY 1 1 1 2 2 2");
		execute("QUERY 2 2 2 2 2 2");

		
		System.out.println("Prueba de sistemas: " + matriz[1][1][1]);
		
	}

	/* 
	 * metodo que se encarga de evaluar y ejecutar un UPDATE 
	 * o una QUERY segun el parametro de entrada
	 * 
	 */
	static private void execute(String param) {
		BackResponse res = matrizService.execute(param);
		if(param.length()>16) {
		    System.out.println(param + "\t->\t" + generateMessage(res));
		} else {
			System.out.println(param + "\t\t->\t" + generateMessage(res));
		}
	}

	private static String generateMessage(BackResponse res) {
		// TODO Auto-generated method stub
		String message = "Respuesta: " + res.status.name() + " - code: " + res.statusCode + " - W: " + res.w + " - " + res.message; 
		return message;
	}
}
