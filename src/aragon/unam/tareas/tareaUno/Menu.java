package aragon.unam.tareas.tareaUno;

import java.util.Scanner;

public class Menu {
	private ArchivoCVS csv;
	private int contador = 1;

	public void inicioPrograma() {
		Scanner s = new Scanner(System.in);
		String opcion, ruta = "/archivos/presenciaredes.csv";
		boolean entrada = false;

		System.out.println("Bienvenido");
		this.csv = new ArchivoCVS(ruta);

		while (!entrada) {
			System.out.println("Seleccione una opción: ");
			System.out.printf("%s%n%s%n%s%n%s%n%s%n", 
					"(1) Imprimir Archivo CSV en Consola.",
					"(2) Imprimir la diferencia de los seguidores De Twitter Entre Junio y Enero.",
					"(3) Imprimir las visualizaciones de Youtube entre dos meses dados.",
					"(4) Imprimir el promedio de crecimiento de Twitter o Facebook entre dos meses dados", 
					"(5) Salir");
			opcion = s.next();
			this.figura();

			switch (opcion.charAt(0)) {
			case '1':
				this.csv.impresionArchivoCSV();
				this.figura();
				break;
			case '2':
				this.csv.diferenciaSeguidoresJunioEneroRedSocial();
				this.figura();
				break;
			case '3':
				String mesUno, mesDos;
				mesUno = this.seleccionarMes();
				mesDos = this.seleccionarMes();
				this.contador -= 2;
				this.csv.vizualizacionesYoutube(mesUno, mesDos);
				this.figura();
				break;
			case '4':
				this.csv.promedioRedSocial();
				this.figura();
				break;
			case '5':
				System.out.println("Hasta Luego");
				this.figura();
				entrada = !entrada;
				break;
			default:
				System.out.println("Opción no valida");
				this.figura();
				break;
			}
		}
		s.close();
	}

	private String seleccionarMes() {
		Scanner s = new Scanner(System.in);
		String mes = "";
		boolean entrada = false;

		while (!entrada) {
			System.out.println("Seleccione el mes #" + this.contador + ":");

			System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n",
					"(1) ENERO", "(2) FEBRERO","(3) MARZO", "(4) ABRIL", "(5) MAYO", 
					"(6)JUNIO", "(7)JULIO", "(8)AGOSTO", "(9)SEPTIEMBRE","(10)OCTUBRE", 
					"(11)NOVIEMBRE", "(12)DICIEMBRE", "(13)SALIR");
			mes = s.next();
			switch (mes) {
			case "1": {
				++this.contador;
				return "ENERO";
			}
			case "2": {
				++this.contador;
				return "FEBRERO";
			}
			case "3": {
				++this.contador;
				return "MARZO";
			}
			case "4": {
				++this.contador;
				return "ABRIL";
			}
			case "5": {
				++this.contador;
				return "MAYO";
			}
			case "6": {
				++this.contador;
				return "JUNIO";
			}
			case "7": {
				++this.contador;
				return "JULIO";
			}
			case "8": {
				++this.contador;
				return "AGOSTO";
			}
			case "9": {
				++this.contador;
				return "SEPTIEMBRE";
			}
			case "10": {
				++this.contador;
				return "OCTUBRE";
			}
			case "11": {
				++this.contador;
				return "NOVIEMBRE";
			}
			case "12": {
				++this.contador;
				return "DICIEMBRE";
			}
			case "13": {
				System.out.println("Hasta Luego");
				entrada = !entrada;
				s.close();
				return "5";
			}
			default:
				System.out.println("Opción no valida");
				break;
			}
		}
		s.close();
		return mes;
	}
	
	private void figura() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
}