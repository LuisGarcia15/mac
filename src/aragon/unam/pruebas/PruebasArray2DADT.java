package aragon.unam.pruebas;

import aragon.unam.estructuras.Array2DADT;

public class PruebasArray2DADT {
	public static void main(String[] args) {
		
		Array2DADT<Integer> array = new Array2DADT<>(3, 3);
		int filas = 0, columnas = 2;
		
		array.setElemento(1, 1, 2);
		array.setElemento(2, 2, 2);
		array.setElemento(3, 2, 1);
		array.setElemento(4, 2, 0);
		array.setElemento(5, 1, 0);
		array.setElemento(6, 0, 0);
		array.setElemento(7, 0, 1);
		array.setElemento(8, 0, 2);
		array.setElemento(10, 1, 1);
		
		System.out.println("+++++++++++++++++++");
		
		for (int i = 0; i <= 8; i++) {
			switch (i) {
			case 1 : case 7 : case 8:
				columnas++;
				if(filas >= 0 && filas < 3 && columnas >= 0 && columnas < 3){
				System.out.println(array.getElemento(filas, columnas) + " ["+filas+","+columnas+"]   ");
				}
				break;
			case 2:
				filas++;
				if(filas >= 0 && filas < 3 && columnas >= 0 && columnas < 3){
				System.out.println(array.getElemento(filas, columnas) + " ["+filas+","+columnas+"]   ");
				}
				break;
			case 3: case 4:
				columnas--;
				if(filas >= 0 && filas < 3 && columnas >= 0 && columnas < 3){
				System.out.println(array.getElemento(filas, columnas) + " ["+filas+","+columnas+"]   ");
				}
				break;
			case 5: case 6:
				filas--;
				if(filas >= 0 && filas < 3 && columnas >= 0 && columnas < 3){
				System.out.println(array.getElemento(filas, columnas) + " ["+filas+","+columnas+"]   ");
				}
				break;
			}
		}
		System.out.println("+++++++++++++++++++");
		System.out.println(array);
		
		
	}
}