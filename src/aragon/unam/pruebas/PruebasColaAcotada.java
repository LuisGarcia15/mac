package aragon.unam.pruebas;

import aragon.unam.estructuras.ColaAcotadaADT;

public class PruebasColaAcotada {
	public static void main(String[] args) {
		ColaAcotadaADT<String> cola =new ColaAcotadaADT<>(3);
		
		System.out.println(cola.isEmpty());
		cola.enqueue(1, "Luis");
		System.out.println(cola);
		cola.enqueue(1, "Gustavo");
		System.out.println(cola);
		cola.enqueue(2, "Jose");
		System.out.println(cola);
		cola.enqueue(2, "Garcia");
		System.out.println(cola);
		cola.enqueue(3, "Elena");
		System.out.println(cola);
		cola.enqueue(3, "Lara");
		System.out.println(cola);
		System.out.println("Recuperando el elemento con más prioridad");
		System.out.println(cola.dequeue());
		System.out.println(cola);
		System.out.println(cola.dequeue());
		System.out.println(cola);
		System.out.println(cola.dequeue());
		System.out.println(cola);
		System.out.println(cola.dequeue());
		System.out.println(cola);
		System.out.println(cola.dequeue());
		System.out.println(cola);
		System.out.println(cola.dequeue());
		System.out.println(cola);
	}
}
