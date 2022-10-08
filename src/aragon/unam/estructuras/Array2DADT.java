package aragon.unam.estructuras;

public class Array2DADT<T> {

	private int fila;
	private int columna;
	private ArrayADT<ArrayADT<T>> array;

	public Array2DADT(int filas, int columnas) {
		this.fila = filas;
		this.columna = columnas;
		array = new ArrayADT<>(columnas);

		for (int i = 0; i < array.getLength(); i++) {
			array.setItem(new ArrayADT<>(filas), i);
		}
	}

	public int getFilas() {
		return this.fila;
	}

	public int getColumnas() {
		return this.columna;
	}

	public void setElemento(T dato, int filas, int columnas) {
		this.array.getItem(columnas).setItem(dato, filas);
	}

	public T getElemento(int filas, int columnas) {
		return this.array.getItem(columnas).getItem(filas);
	}

	public void limpiar(T dato) {
		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++) {
				this.setElemento(dato, i, j);
				;
			}
		}
	}

	@Override
	public String toString() {
		String array = "";
		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++) {
				array += this.getElemento(i, j) + " ["+i+","+j+"]   ";
			}
			array += "\n";
		}
		return array;
	}
	 
	
}
