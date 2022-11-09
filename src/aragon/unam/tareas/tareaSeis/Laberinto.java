package aragon.unam.tareas.tareaSeis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import aragon.unam.estructuras.Array2DADT;
import aragon.unam.estructuras.ArrayADT;
import aragon.unam.estructuras.StackADT;

public class Laberinto{
	
	private Array2DADT<String> laberinto;
	private StackADT<String> pila;
	private ArrayADT<Integer> coordenadas = new ArrayADT<>(6);
	
	public Laberinto() {
		String filas, texto = "";
		int contador = 1, punteroCoordenadas = 0,punteroFilas = 0;
		String auxiliar[] = new String[2];
		File f = new File(System.getProperty("user.dir") + "/archivos/laberinto.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while((filas = br.readLine()) != null) {
				texto = filas + ",\n";
				switch(contador) {
					case 1:
						auxiliar = texto.split(",");
						laberinto = new Array2DADT<>(Integer.parseInt(auxiliar[0]), 
								Integer.parseInt(auxiliar[1]));
						this.pila.push(auxiliar[0] + "," + auxiliar[1]);
						contador++;
						break;
					case 2:
						auxiliar = texto.split(",");
						for(int i = 0; i < auxiliar.length-1; i++) {
							this.coordenadas.setItem(Integer.parseInt(auxiliar[i]), i);
							punteroCoordenadas++;
						}
						contador++;
						break;
					case 3:
						auxiliar = texto.split(",");
						for(int i = 0; i < auxiliar.length-1; i++) {
							this.coordenadas.setItem(Integer.parseInt(auxiliar[i]), punteroCoordenadas);
							punteroCoordenadas++;
						}
						contador++;
						break;
					default:
						auxiliar = texto.split(",");
						for (int i = 0; i < auxiliar.length-1; i++) {
							if(i == this.coordenadas.getItem(0) && 
									punteroFilas == this.coordenadas.getItem(1)) {
								this.laberinto.setElemento("L", punteroFilas, i);
							}else {
								if(i == this.coordenadas.getItem(2) && 
										punteroFilas == this.coordenadas.getItem(3)) {
									this.laberinto.setElemento("F", punteroFilas, i);
								}else {
								this.laberinto.setElemento(auxiliar[i], punteroFilas, i);
								}
							}
						}
						punteroFilas++;
						break;
				}
			}
			System.out.println(this.laberinto.toString());
		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
		}
	
	public Array2DADT<String> getLaberinto() {
		return laberinto;
	}

	public StackADT<String> getPila() {
		return pila;
	}

	public ArrayADT<Integer> getCoordenadas() {
		return coordenadas;
	}

	public  void evaluarReglas(int filas, int columnas) {
		int fila = filas, columna = columnas, contador = 1;
		String casilla;
		switch (contador) {
		case 1:
			columna++;
			if(columna >= 0 && columna <= this.laberinto.getColumnas() &&
					fila >= 0 && fila <= this.laberinto.getFilas()) {
				casilla = this.laberinto.getElemento(fila, columna);
				if(casilla.equals(" ")) {
					this.avanzar(filas, columnas, fila, columna);
				}
			}
			contador++;
			break;
		case 2:
			fila++;
			if(columna >= 0 && columna <= this.laberinto.getColumnas() &&
					fila >= 0 && fila <= this.laberinto.getFilas()) {
				casilla = this.laberinto.getElemento(fila, columna);
				switch(casilla) {
					case "F":
						this.isMeta(fila, columna,filas,columnas);
						break;
					case " ":
						break;
					case "X":
						break;
				}
			}
			contador++;
			break;
		case 3:
			columna--;
			if(columna >= 0 && columna <= this.laberinto.getColumnas() &&
					fila >= 0 && fila <= this.laberinto.getFilas()) {
				casilla = this.laberinto.getElemento(fila, columna);
				switch(casilla) {
					case "F":
						this.isMeta(fila, columna,filas,columnas);
						break;
					case " ":
						break;
					case "X":
						break;
				}
			}
			contador++;
			break;
		case 4:
			fila++;
			if(columna >= 0 && columna <= this.laberinto.getColumnas() &&
					fila >= 0 && fila <= this.laberinto.getFilas()) {
				casilla = this.laberinto.getElemento(fila, columna);
				switch(casilla) {
					case "F":
						this.isMeta(fila, columna,filas,columnas);
						break;
					case " ":
						break;
					case "X":
						break;
				}
			}
			contador++;
			break;
		default:
			System.out.println("El laberinto no tiene solución");
			break;
		}
		
	}
	
	public boolean isMeta(int filas, int columnas, int filasEvaluadas, int columnasEvaluadas) {
		return filas == this.coordenadas.getItem(2) && 
				columnas == this.coordenadas.getItem(3);
	}
	
	public void avanzar(int filas, int columnas, int filasEvaluadas, int columnasEvaluadas) {
		this.laberinto.setElemento("L", filasEvaluadas, columnasEvaluadas);
		this.laberinto.setElemento("|", filas, columnas);
		this.pila.push(this.laberinto.getElemento(filas, columnas));
		System.out.println(this.laberinto.toString());
	}
	
	public void retroceder(int filas, int columnas, int filasEvaluadas, int columnasEvaluadas) {
		this.laberinto.setElemento("L", filasEvaluadas, columnasEvaluadas);
		this.laberinto.setElemento("|", filas, columnas);
		this.pila.push(this.laberinto.getElemento(filas, columnas));
		System.out.println(this.laberinto.toString());
	}
	
	
}