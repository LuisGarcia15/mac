package aragon.unam.tareas.tareaTres;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import aragon.unam.ejercicios.Empleado;
import aragon.unam.ejercicios.NominaADT;

@SuppressWarnings("unused")
public class Tarea_Tres {
	public static void main(String[] args) throws IOException {
		NominaADT n = new NominaADT("/archivos/junio.dat");
		
		System.out.println("+++++++ Presentación de todos los trabajadores +++++++\n");
		System.out.println(n);
		System.out.println("+++++++ Presentación de los sueldos totales de todos los trabajadores +++++++\n");
		System.out.println(n.listaSueldosEmpleados());
		System.out.println("+++++++ Presentación de los trabajadores de mayor y menor antigüedad +++++++\n");
		System.out.println(n.mostrarEmpleadosMayorYMenorAntiguedad());
		
	}
}