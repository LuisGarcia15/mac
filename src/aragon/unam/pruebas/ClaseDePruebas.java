package aragon.unam.pruebas;

import aragon.unam.estructuras.StackADT;

public class ClaseDePruebas {
	public static void main(String[] args) {
		StackADT<Integer> s = new StackADT<>();
		
		System.out.println("Esta vacia?: "+s.isEmpty());
		System.out.println(s);
		s.push(1);
		System.out.println(s);
		s.push(2);
		System.out.println(s);
		s.push(3);
		System.out.println(s);
		s.push(4);
		System.out.println(s);
		System.out.println("Esta vacia?: "+s.isEmpty());
		System.out.println(s);
		System.out.println("# de elementos: "+s.length());
		System.out.println(s);
		System.out.println("Utilizando pop()");
		s.pop();
		System.out.println(s);
		System.out.println("Elemento en el top: "+s.peek());
		System.out.println(s);
		System.out.println("# de elementos: "+s.length());
		System.out.println(s);
		System.out.println("Utilizando push()");
		s.push(5);
		System.out.println(s);
		System.out.println("# de elementos: "+s.length());
		System.out.println(s);
		System.out.println("Elemento en el top: "+s.peek());
	}
}
