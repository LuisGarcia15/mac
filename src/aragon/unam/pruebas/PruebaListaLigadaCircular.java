package aragon.unam.pruebas;

import aragon.unam.estructuras.ListaLigadaADT;
import aragon.unam.estructuras.ListaLigadaCircularADT;

public class PruebaListaLigadaCircular {
	public static void main(String[] args) {
		System.out.println("Probando implementación Lista Ligada Circular");
        ListaLigadaCircularADT l = new ListaLigadaCircularADT();
        l.agregarAlFinal(1);
        l.agregarAlFinal(2);
        l.agregarAlFinal(3);
        l.agregarAlFinal(4);
        l.agregarAlFinal(5);
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        l.eliminar(5);
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        l.eliminarElFinal();
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        l.eliminarElPrimero();
        System.out.println("Tail: ");
        l.transversal(true);
        System.out.println("Head: ");
        l.transversal(false);
        
        
	}
}
