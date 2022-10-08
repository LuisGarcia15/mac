package aragon.unam.ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import aragon.unam.estructuras.ArrayADT;

public class NominaADT{
	
	private ArrayADT<Empleado>datos;

	public NominaADT(String ruta) throws IOException {
		File f = new File(System.getProperty("user.dir") + ruta);
		String filas, texto = "";
		String[] atributosEmp, atributos;
		int contador = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while((filas = br.readLine()) != null) {
				texto += filas + "\n";
				contador++;
			}
			
			this.datos = new ArrayADT<>(contador-1);
			atributosEmp = texto.split("\n");
			atributosEmp = Arrays.copyOfRange(atributosEmp, 1, contador);
			
			for (int i = 0; i < atributosEmp.length; i++) {
				texto = atributosEmp[i];
				atributos = texto.split(",");
				this.datos.setItem(new Empleado(Integer.parseInt(atributos[0]),
					atributos[1], atributos[2], atributos[3], 
					Double.parseDouble(atributos[4]),
					Double.parseDouble(atributos[5]), 
					Integer.parseInt(atributos[6])),i);
			}
			br.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		
	}
	
	public String mostrarEmpleadosMayorYMenorAntiguedad() {
		Empleado empleadoMenor = datos.getItem(0);
		Empleado empleadoMayor = null;
		
		for (int i = 0; i < this.datos.getLength(); i++) {
			if(empleadoMenor.compareTo(datos.getItem(i)) < 0) {
				empleadoMayor = datos.getItem(i);
			}else {
					if(empleadoMenor.compareTo(datos.getItem(i)) > 0) {
						empleadoMayor = empleadoMenor;
						empleadoMenor = datos.getItem(i);
					}
			}
		}
		
		return "El empleado más antiguo es: " + empleadoMenor.getNombre() + 
				" que inicio en el año: " + empleadoMenor.getAnioIngreso() + 
				"\nEl empleado más reciente es: " + empleadoMayor.getNombre() + " que inicio en el año: " 
				+ empleadoMayor.getAnioIngreso();
	}

	public String listaSueldosEmpleados() {
		String cadena = "";
		for (int i = 0; i < this.datos.getLength(); i++) {
			cadena += "Nombre del trabajador: " + this.datos.getItem(i).getNombre() + " - con ID: " + 
					this.datos.getItem(i).getNumTrabajador() + " - Tiene un sueldo de: $" + 
					this.datos.getItem(i).sueldoTotal() + "\n";
		}
		return cadena;
	}
	
	@Override
	public String toString() {
		return datos.toString();
	}
	
	

}