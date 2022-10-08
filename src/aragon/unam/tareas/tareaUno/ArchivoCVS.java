package aragon.unam.tareas.tareaUno;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class ArchivoCVS {
	
	private String[][] arreglo;

	public ArchivoCVS(String ruta){
		File f = new File(System.getProperty("user.dir") + ruta);
		CSVReader reader = null;
		String[] nextLine = null;
		int filas = 0; int columnas = 0;
		 try {
			reader = new CSVReader(new FileReader(f), ',', '"');
			while ((nextLine = reader.readNext()) != null) { 
				 columnas = nextLine.length;
			 filas++; 
			 }
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 this.arreglo = new String[filas][columnas];
		 /*//////////////////////////////////////////////////////////////////////*/
		 /*Inizializa el arreglo*/
		 this.inizializarArreglo(ruta);
	}
	
	private void inizializarArreglo(String ruta) {
		File f = new File(System.getProperty("user.dir") + ruta);
		CSVReader reader = null;
		String[] nextLine = null;
		int prueba2 = 0;
		try {
			reader = new CSVReader(new FileReader(f), ',', '"');
			 while ((nextLine = reader.readNext()) != null) {
					for (int i = 0; i < nextLine.length; i++) {
						this.arreglo[prueba2][i] = nextLine[i];
					}
					prueba2++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void impresionArchivoCSV(){
		
		  for (int i = 0; i < this.arreglo.length; i++) {
		   for (int j = 0; j < this.arreglo[i].length; j++) { 
		   System.out.print(this.arreglo[i][j] + " "); 
		   }
		  System.out.println(); 
		  }		
	}
	
	public void diferenciaSeguidoresJunioEneroRedSocial(){
		int fila = 0, columna = 0, fila2 = 0, columna2 = 0;
		int enero = 0, junio = 0;

		System.out.println("Diferencia de seguidores de Twitter entre el" +
				" mes de Junio y Enero");
		while (true) {
			if (this.arreglo[fila][columna].equals("TWITTER")) {
				break;
			} else {
				fila++;
			}
		}
		columna++;

		while (true) {
			if (this.arreglo[fila][columna].equals("SEGUIDORES (FOLLOWERS)")) {
				break;
			} else {
				fila++;
			}
		}

		while (true) {
			if (this.arreglo[fila2][columna2].equals("ENERO")) {
				this.arreglo[fila][columna2] = this.arreglo[fila][columna2].replace(",", "");
				enero = Integer.parseInt(this.arreglo[fila][columna2]);
				break;
			} else {
				columna2++;
			}
		}
		
		fila2 = 0;
		columna2 = 0;
		while (true) {
			if (this.arreglo[fila2][columna2].equals("JUNIO")) {
				this.arreglo[fila][columna2] = this.arreglo[fila][columna2].replace(",", "");
				junio = Integer.parseInt(this.arreglo[fila][columna2]);
				break;
			} else {
				columna2++;
			}
		}

		System.out.println(junio - enero);
	
	}
	
public void vizualizacionesYoutube(String mesUno, String mesDos){
	int fila = 0, columna = 0, fila2 = 0, columna2 = 0;
	int primerMes = 0, segundoMes = 0;
	System.out.println("Diferencia de vizualizaciones de Youtube entre dos meses"
			+ " introducidos por el usuario");
	
	while (true) {
		if (this.arreglo[fila][columna].equals("YOUTUBE")) {
			break;
		} else {
			fila++;
		}
	}
	columna++;

	while (true) {
		if (this.arreglo[fila][columna].equals("VISUALIZACIONES")) {
			break;
		} else {
			fila++;
		}
	}

	while (true) {
		if (this.arreglo[fila2][columna2].equals(mesUno)) {
			this.arreglo[fila][columna2] = this.arreglo[fila][columna2].replace(",", "");
			primerMes = Integer.parseInt(this.arreglo[fila][columna2]);
			break;
		} else {
			columna2++;
		}
	}
	
	fila2 = 0;
	columna2 = 0;
	while (true) {
		if (this.arreglo[fila2][columna2].equals(mesDos)) {
			this.arreglo[fila][columna2] = this.arreglo[fila][columna2].replace(",", "");
			segundoMes = Integer.parseInt(this.arreglo[fila][columna2]);
			break;
		} else {
			columna2++;
		}
	}

	if(primerMes >= segundoMes) {
		System.out.println(primerMes - segundoMes);
	}else {
		System.out.println(segundoMes - primerMes);
	}

}

public void promedioRedSocial() {
	int fila = 0, columna = 0, fila2 = 0, columna2 = 0;
	double promedio = 0;
	String mes;

	System.out.println("Crecimiento de Facebook o Twitter De Enero A Junio");
	mes = this.elegirRedSocial();
	while (true) {
		if (this.arreglo[fila][columna].equals(mes)) {
			break;
		} else {
			fila++;
		}
	}
	columna++;

	while (true) {
		if (this.arreglo[fila][columna].substring(0, 10).equals("PORCENTAJE")) {
			break;
		} else {
			fila++;
		}
	}

	while (true) {
		if (this.arreglo[fila2][columna2].equals("ENERO")) {
			this.arreglo[fila][columna2] = this.arreglo[fila][columna2].replace("%", "");
			promedio += Double.parseDouble(this.arreglo[fila][columna2]);
			while(true) {
			columna2++;
				if(this.arreglo[fila2][columna2].equals("JUNIO")) {
					this.arreglo[fila][columna2] = this.arreglo[fila][columna2].replace("%", "");
					promedio += Double.parseDouble(this.arreglo[fila][columna2]);
					break;
				}else {
					this.arreglo[fila][columna2] = this.arreglo[fila][columna2].replace("%", "");
					promedio += Double.parseDouble(this.arreglo[fila][columna2]);
				}
			}
			promedio = promedio/6;
			break;
		}else {
			columna2++;
		}
	}
	
	System.out.println("El promedio de crecimiemto de " + mes + " es de " + promedio + "%");
	
}

private String elegirRedSocial() {
	@SuppressWarnings("resource")
	Scanner s = new Scanner(System.in);
	String mes = "";
	
	System.out.println();
	while(true) {
	System.out.println("Elige una RedSocial por su número: ");
	System.out.printf("%s%n%s%n%s%n", "1 - FACEBOOK", "2 - TWITTER", "3 - YOUTUBE");
	mes = s.next();
	switch (mes) {
	case "1":
		return "FACEBOOK";
	case "2":
		return "TWITTER";
	case "3":
		System.out.println("Red Social no disponible");
		break;
	default:
		System.out.println("Valor no valido");
		break;
		}
	}
	
}


}