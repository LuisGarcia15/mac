package aragon.unam.tareas.tareaCuatro;

import java.util.Scanner;

import aragon.unam.estructuras.Array2DADT;

public class Juego {
	
	private JuegoDeLaVida objeto;
	private Array2DADT<String> espejo;
	
	public Juego() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);
		int fila, columna, numeroDeCelulas = 1;
		String salida = "c";
		System.out.printf("%22s %n","JUEGO DE LA VIDA");
		System.out.println("Introduzca el número de filas que tendrá la matriz:");
		fila = Integer.parseInt(s.nextLine());
		System.out.println("Introduzca el número de columnas que tendrá la matriz:");
		columna = Integer.parseInt(s.nextLine());
		this.objeto = new JuegoDeLaVida(fila, columna);
		this.espejo = new Array2DADT<>(this.objeto.getCeldas().getFilas(), this.objeto.getCeldas().getColumnas());
		System.out.println("\n");
		for(int i = 0; i < this.objeto.getCeldas().getFilas(); i++) {
			for(int j = 0; j < this.objeto.getCeldas().getColumnas(); j++) {
				this.objeto.getCeldas().setElemento("-", i, j);
			}	
		}
		
		fila = 0;
		columna = 0;
		while(salida.equals("c")) {
			System.out.println("Ingresa una coordenada para la fila de la celula #" + numeroDeCelulas + ":");
			fila = Integer.parseInt(s.nextLine());
			System.out.println("Ingresa una coordenada para la columna de la celula #" + numeroDeCelulas + ":");
			columna = Integer.parseInt(s.nextLine());
			objeto.getCeldas().setElemento("+", fila, columna);
			System.out.println("¿Desea ingresar más células vivas? Ingrese la letra c para seguir añadiendo o "
					+ "ingrese la letra f para salir.");
			salida = s.nextLine();
			numeroDeCelulas++;
		}
		System.out.println("\n");
	}
	
	public void iniziarJuego() {
		Scanner s = new Scanner(System.in);
		String celda;
		boolean entrada = true;
		int numeroGeneraciones, contadorGeneraciones = 1;
		
		System.out.println("Introduzca el número de generaciones que quiere visualizar:");
		numeroGeneraciones = Integer.parseInt(s.nextLine());
		s.close();
		do{
			System.out.printf("%40s %n","******** " + contadorGeneraciones + "° Generación ********* \n");
			System.out.println(this.imprimirMatriz(this.objeto.getCeldas()));
		for(int filas = 0; filas < this.objeto.getCeldas().getFilas(); filas++) {
			for(int columnas = 0; columnas < this.objeto.getCeldas().getColumnas(); columnas++) {
				if(filas == 0| filas == (this.objeto.getCeldas().getFilas()- 1) | columnas == 0 | columnas == (this.objeto.getCeldas().getColumnas()- 1) ) {
					celda = this.objeto.recorrerCeldaExterior(filas, columnas);
					this.espejo.setElemento(celda, filas, columnas);
				}else {
					celda = this.objeto.recorrerCeldaCentral(filas, columnas);
					this.espejo.setElemento(celda, filas, columnas);
				}
			}	
		}
		contadorGeneraciones++;
		this.copiarArrayADT();
		entrada = this.evaluarArrayADT();
		if(!entrada) {
			System.out.printf("%40s %n","******** " + contadorGeneraciones + "° Generación ********* \n");
			System.out.println(this.imprimirMatriz(this.objeto.getCeldas()));
			System.out.printf("%60s %n","La población murió en su totalidad en la " + contadorGeneraciones + "° generación");
		}
		if(contadorGeneraciones == (numeroGeneraciones + 1)) {
			entrada = !entrada;
		}
		}while(entrada);
	}
	
	private void copiarArrayADT() {
		for(int filas = 0; filas < this.objeto.getCeldas().getFilas(); filas++) {
			for(int columnas = 0; columnas < this.objeto.getCeldas().getColumnas(); columnas++) {
				this.objeto.getCeldas().setElemento(this.espejo.getElemento(filas, columnas), filas, columnas);
				this.espejo.setElemento(null, filas, columnas);
			}	
		}
	}
	
	private boolean evaluarArrayADT() {
		for(int filas = 0; filas < this.objeto.getCeldas().getFilas(); filas++) {
			for(int columnas = 0; columnas < this.objeto.getCeldas().getColumnas(); columnas++) {
				if(this.objeto.getCeldas().getElemento(filas, columnas).equals("+")) {
					return true;
				}
			}	
		}
		return false;
	}
	
	private String imprimirMatriz(Array2DADT<String> objeto) {
		String array = "";
		for (int i = 0; i < objeto.getFilas(); i++) {
			for (int j = 0; j < objeto.getColumnas(); j++) {
				array += objeto.getElemento(i, j) + "       ";
			}
			array += "\n";
		}
		return array;
	}
}
