package aragon.unam.pruebas;

import aragon.unam.estructuras.ListaDoblementeLigadaCircularADT;

public class PruebaListaDoblementeLigadaCircular {
	public static void main(String[] args) {
		System.out.println("Probando implementación Lista Ligada Doblemente Circular");
        ListaDoblementeLigadaCircularADT<Integer> l = new ListaDoblementeLigadaCircularADT<>();
        l.agregarAlFinal(1);
        l.agregarAlFinal(2);
        l.agregarAlFinal(3);
        l.agregarAlFinal(4);
        l.agregarAlFinal(5);
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        System.out.println("************");
        l.eliminar(5);
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        System.out.println("************");
        l.eliminarElFinal();
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        System.out.println("************");
        l.eliminarElPrimero();
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        l.eliminarElPrimero();
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        l.eliminarElFinal();
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
	}
}
