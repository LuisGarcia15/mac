package aragon.unam.pruebas;

import aragon.unam.estructuras.ListaLigadaADT;

public class PruebaListaLigada2 {
public static void main(String[] args) {
	ListaLigadaADT<Integer> i = new ListaLigadaADT<>();
	i.agregarAlFinal(1);
	i.agregarAlFinal(2);
	i.agregarAlFinal(3);
	i.transversal();
	i.agregarDespuesDe(10, 1);
	i.transversal();
}
}
