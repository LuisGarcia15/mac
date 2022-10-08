package aragon.unam.tareas.tareaTres;

public class Empleado implements Comparable<Empleado>{
	private final int numTrabajador;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private double hrExtra;
	private double sueldoBase;
	private int anioIngreso;
	
	public Empleado(int numTrabajador, String nombre, String apellidoPaterno, String apellidoMaterno, double hrExtra,
			double sueldoBase, int anioIngreso) {
		this.numTrabajador = numTrabajador;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.hrExtra = hrExtra;
		this.sueldoBase = sueldoBase;
		this.anioIngreso = anioIngreso;
	}

	public int getNumTrabajador() {
		return numTrabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public double getHrExtra() {
		return hrExtra;
	}

	public void setHrExtra(double hrExtra) {
		this.hrExtra = hrExtra;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;	
	}
	
	public double sueldoTotal() {
		double sueldoTotal = this.sueldoBase + (this.hrExtra*276.5) + ((((2022 - this.anioIngreso)*3)/100.0)*(this.sueldoBase));
		return sueldoTotal;
	}

	@Override
	public String toString() {
		return "Empleado [numTrabajador=" + numTrabajador + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", hrExtra=" + hrExtra + ", sueldoBase="
				+ sueldoBase + ", anioIngreso=" + anioIngreso + "]";
	}

	@Override
	public int compareTo(Empleado o) {
		return this.anioIngreso - o.anioIngreso;
	}
	
}