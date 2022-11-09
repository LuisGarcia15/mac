package aragon.unam.pruebas;

import aragon.unam.estructuras.ColaADT;

public class PrubasColaOrdinaria {
	public static void main(String[] args) {
		ColaADT<Integer> cola =  new ColaADT<>();
		
		System.out.println(cola);
		cola.enqueue(1);
		System.out.println(cola);
		cola.enqueue(2);
		System.out.println(cola);
		cola.enqueue(3);
		System.out.println(cola);
		cola.enqueue(4);
		System.out.println(cola);
		System.out.println("Eliminando y retornando elemento de la cola");
		System.out.println("Recuperanco #1: " + cola.dequeue());
		System.out.println(cola);
		System.out.println("Recuperanco #2: " + cola.dequeue());
		System.out.println(cola);
		System.out.println("Recuperanco #3: " + cola.dequeue());
		System.out.println(cola);
		System.out.println("Recuperanco #4: " + cola.dequeue());
		System.out.println(cola);

	}
}
