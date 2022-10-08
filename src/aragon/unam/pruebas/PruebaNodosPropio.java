package aragon.unam.pruebas;

import aragon.unam.estructuras.Nodo;

public class PruebaNodosPropio {
	public static void main(String[] args) {
		Nodo head = new Nodo();
		head.setDato(new Integer(5));
		System.out.println(imprimirNodos(head));
		
		head.setSiguiente(new Nodo(new Integer (10)));
		System.out.println(imprimirNodos(head));
		System.out.println(head.getSiguiente().getSiguiente());
		
		head.getSiguiente().setSiguiente(new Nodo(new Integer(15)));
		System.out.println(head.getSiguiente().getSiguiente().getSiguiente());
		System.out.println(imprimirNodos(head));
		
		head.getSiguiente().getSiguiente().setSiguiente(new Nodo
				(new Integer(20), new Nodo (new Integer (25))));
		System.out.println(imprimirNodos(head));
		
		//Estructura para agregar numeros a head
		int numeroNuevo = 30, contador = 1;
		Nodo aux = head; //nodo aux apunta al mismo objeto que nodo "nodo"
		/*Esto nos da la posibilidad de reecorrer aux, ingresar valores
		 * y nodo no se altera, agregando el numero 30*/
		System.out.println("****** Abriendo estructutura para agregar numero a head *******");
		while( aux.getSiguiente() != null){
			System.out.println(imprimirNodos(head) + " head " + contador);
			System.out.println(imprimirNodos(aux) + " aux " + contador);
            aux = aux.getSiguiente();
            contador++;
        }
		contador++;
        aux.setSiguiente(new Nodo(numeroNuevo));
        System.out.println(imprimirNodos(head) + " head " + contador);
		System.out.println(imprimirNodos(aux) + " aux " + contador);
       
        aux = head;
        contador++;
        System.out.println(imprimirNodos(head) + " head " + contador);
		System.out.println(imprimirNodos(aux) + " aux " + contador);
		System.out.println("Verificando que #30 aparezca en head: \n" + 
		imprimirNodos(head));
		System.out.println("****** Cerrando estructutura para agregar numero a head *******");
		contador = 1;
		System.out.println("****** Abriendo estructutura para agregar numero a head entre nodos *******");
		aux = head;//nodo aux apunta al mismo objeto que nodo "nodo"
		/*Esto nos da la posibilidad de reecorrer aux, ingresar valores
		 * y nodo no se altera, agregando el numero 35*/
        while( !aux.getDato().equals(10)){
        	System.out.println(imprimirNodos(head) + " head " + contador);
    		System.out.println(imprimirNodos(aux) + " aux " + contador);
    		contador++;
            aux = aux.getSiguiente();
        }
        Nodo aux2 = new Nodo(12);//Creamos un nuevo nodo con dato 12
        System.out.println(imprimirNodos(aux2) + " aux2 " + contador);
        contador++;
        aux2.setSiguiente(aux.getSiguiente());/*Al nuevo nodo aux2 con 
        dato 12, le agregamos los siguientes nodos de aux, |15|,
        |20|, |25| y |30|. aux2 queda en |12|, |15|, |20| ,|25| y |30|. */
        System.out.println(imprimirNodos(aux2) + " aux2 " + contador);
        contador++;
        aux.setSiguiente(aux2);/*A la variable aux que se quedo en |10|, 
        le agregamos el nodo aux2 que tiene |12|, |15|, |20| 
        ,|25| y |30|. 
        Y como aux apunta al mismo objeto que head, se agregan el 12*/
        System.out.println(imprimirNodos(aux) + " aux " + contador);
        contador++;
        System.out.println("Verificando que #12 aparezca en head: \n" + 
        		imprimirNodos(head));
        System.out.println("****** Cerrando estructutura para agregar numero a head entre nodos *******");
		
	}
	
	public static String imprimirNodos(Nodo<String> n) {
		String nodo = "";
		Nodo aux = n;
        while(true){
        	if(aux != null) {
        	nodo += "|"+aux.getDato()+"| --> ";
        	aux = aux.getSiguiente();
        	}else {
        	nodo += "|"+null+"|";
        	break;
        	}
        }
		return nodo;
	}
}
