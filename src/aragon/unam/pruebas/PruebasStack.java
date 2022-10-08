package aragon.unam.pruebas;

import aragon.unam.estructuras.StackADT;

public class PruebasStack {
	public static void main(String[] args) {
		StackADT<Integer> s = new StackADT<>();
		//System.out.println("Elemento en el top: "+ s.push(2));
		System.out.println("Esta vacia?: "+s.isEmpty());
		System.out.println(s);
		System.out.println("Agregando 1 con push()");
		s.push(1);
		System.out.println(s);
		System.out.println("Agregando 2 con push()");
		s.push(2);
		System.out.println(s);
		System.out.println("Agregando 3 con push()");
		s.push(3);
		System.out.println(s);
		System.out.println("Agregando 4 con push()");
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
