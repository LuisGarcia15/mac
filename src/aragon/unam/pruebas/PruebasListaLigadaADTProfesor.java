package aragon.unam.pruebas;

import aragon.unam.estructuras.ListaLigadaADT;
import aragon.unam.estructuras.Nodo;

public class PruebasListaLigadaADTProfesor {
public static void main(String[] args) {
	System.out.println("Probando implementación de Lista Ligada");
    ListaLigadaADT<Integer> lista = new ListaLigadaADT();
    System.out.println("Agrega al final un nodo con el objeto dado");
    lista.agregarAlFinal(10);
    lista.transversal();
    System.out.println("Agrega al final un nodo con el objeto dado");
    lista.agregarAlFinal(5);
    lista.transversal();
    System.out.println("Agrega al final un nodo con el objeto dado");
    lista.agregarAlFinal(40);
    lista.transversal();
    System.out.println("Agrega al inicio un nodo con el objeto dado");
    lista.agregarAlInicio(100);
    lista.transversal();
    System.out.println("Agrega despues de un nodo según su lugar un nodo con un objeto dado");
    lista.agregarDespuesDe(42, 3);
    lista.transversal();
    System.out.println("Elimina un nodo en una posición dada");
    lista.eliminar(2);
    lista.transversal();
    System.out.println("Elimina el primer nodo");
    lista.eliminarElPrimero();
    lista.transversal();
    System.out.println("Obtención del tamaño");
    System.out.println(lista.getTamanio());
    System.out.println("Elimina el ultimo nodo");
    lista.eliminarElFinal();
    lista.transversal();
    System.out.println("Obtención del tamaño");
    System.out.println(lista.getTamanio());
    System.out.println("Obtención del lugar donde se ubica un nodo según su objeto");
    System.out.println(lista.buscarElemento(10));
    System.out.println("Actualiza un objeto de un nodo por otro");
    lista.actualizar(42, 20);
    lista.transversal();
}
}
