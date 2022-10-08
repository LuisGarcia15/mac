package aragon.unam.pruebas;

import aragon.unam.estructuras.Nodo;

public class ClasePruebasNodoProfesor {
	
	  public static void main(String[] args) {
	        // TODO code application logic here
	        Nodo t = new Nodo(new Integer(10));
	        System.out.println( t.getSiguiente() );
	        Nodo p = new Nodo(25, new Nodo(30));
	        System.out.println( p.getSiguiente() );
	        System.out.println( p.getSiguiente().getDato() );
	        p.getSiguiente().setSiguiente(new Nodo(40));
	        
	        //System.out.println(p.printAll());
	        System.out.println(".-.-.-.-.-.-.-");
	        Nodo aux = p;
	        while( aux != null){
	            System.out.print( aux );
	            aux = aux.getSiguiente();
	        }
	        System.out.println(aux);
	        System.out.println("--- agregar nodo 55 al final---"); 
	        aux = p;
	        while( aux.getSiguiente() != null){
	            aux = aux.getSiguiente();
	        }
	        aux.setSiguiente(new Nodo(55));
	        System.out.println("---- nuevo estado ---");
	        aux = p;
	        while( aux != null){
	            System.out.print( aux );
	            aux = aux.getSiguiente();
	        }
	        System.out.println(aux);
	        System.out.println("---- inseertar 35 despues del 30 ---");
	        
	        aux = p;
	        while( !aux.getDato().equals(30)){
	            aux = aux.getSiguiente();
	        }
	        Nodo aux2 = new Nodo(35);
	        aux2.setSiguiente(aux.getSiguiente());
	        aux.setSiguiente(aux2);
	        System.out.println("---- nuevo estado ---");
	        aux = p;
	        while( aux != null){
	            System.out.print( aux );
	            aux = aux.getSiguiente();
	        }
	        
	    }
}
