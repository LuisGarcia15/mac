package aragon.unam.tareas.tareaCuatro;

import aragon.unam.estructuras.Array2DADT;

public class JuegoDeLaVida {
	private Array2DADT<String> celdas;
	private int celulasVivas = 0;

	public JuegoDeLaVida(int filas, int columnas) {
		celdas = new Array2DADT<>(filas, columnas);
	}

	public Array2DADT<String> getCeldas() {
		return celdas;
	}

	public String recorrerCeldaCentral(int fila, int columna) {
		int filas = fila, columnas = columna;
		String celda;
		for (int i = 0; i <= 8; i++) {
			switch (i) {
			case 1:
			case 7:
				columnas++;
				this.evaluarVecino(filas, columnas);
				break;
			case 2:
				filas++;
				this.evaluarVecino(filas, columnas);
				break;
			case 3:
			case 4:
				columnas--;
				this.evaluarVecino(filas, columnas);
				break;
			case 5:
			case 6:
				filas--;
				this.evaluarVecino(filas, columnas);
				break;
			case 8:
				columnas++;
				this.evaluarVecino(filas, columnas);
				celda = this.aplicarReglas(fila, columna);
				return celda;
			}
		}
		return "";
	}

	public String recorrerCeldaExterior(int fila, int columna) {
		int filas = fila, columnas = columna;
		String celda;
			for (int i = 0; i <= 8; i++) {
				switch (i) {
				case 1:
				case 7:
					columnas++;
					if (filas >= 0 && filas < this.celdas.getFilas() && columnas >= 0
							&& columnas < this.celdas.getColumnas()) {
						this.evaluarVecino(filas, columnas);
					}
					break;
				case 2:
					filas++;
					if (filas >= 0 && filas < this.celdas.getFilas() && columnas >= 0
							&& columnas < this.celdas.getColumnas()) {
						this.evaluarVecino(filas, columnas);
					}
					break;
				case 3:
				case 4:
					columnas--;
					if (filas >= 0 && filas < this.celdas.getFilas() && columnas >= 0
							&& columnas < this.celdas.getColumnas()) {
						this.evaluarVecino(filas, columnas);
					}
					break;
				case 5:
				case 6:
					filas--;
					if (filas >= 0 && filas < this.celdas.getFilas() && columnas >= 0
							&& columnas < this.celdas.getColumnas()) {
						this.evaluarVecino(filas, columnas);
					}
					break;
				case 8:
					columnas++;
					if (filas >= 0 && filas < this.celdas.getFilas() && columnas >= 0
							&& columnas < this.celdas.getColumnas()) {
						this.evaluarVecino(filas, columnas);
					}
					celda = this.aplicarReglas(fila, columna);
					return celda;
				}
			}
			return "";
	}

	private void evaluarVecino(int filas, int columnas) {
		String celda = this.celdas.getElemento(filas, columnas);
		if (celda.equals("+")) {
			this.celulasVivas++;
		}
	}

	private String aplicarReglas(int filas, int columnas) {
		String celula = this.celdas.getElemento(filas, columnas);
		if (celula.equals("+")) {
			if (this.celulasVivas == 2 || this.celulasVivas == 3) {
				this.celulasVivas = 0;
				return "+";
			}
		}

		if (celula.equals("+")) {
			if (this.celulasVivas == 0 || this.celulasVivas == 1) {
				this.celulasVivas = 0;
				return "-";
			}
		}

		if (celula.equals("+")) {
			if (this.celulasVivas >= 4) {
				this.celulasVivas = 0;
				return "-";
			}
		}

		if (celula.equals("-")) {
			if (this.celulasVivas == 3) {
				this.celulasVivas = 0;
				return "+";
			}
		}
		this.celulasVivas = 0;
		return "-";
	}

	@Override
	public String toString() {
		return this.celdas.toString();
	}
	
}
