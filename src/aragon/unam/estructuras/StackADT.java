package aragon.unam.estructuras;

import java.util.ArrayList;
import java.util.Iterator;

public class StackADT <T>{
	ArrayList<T> pila;

	public StackADT() {
		this.pila = new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return this.pila.isEmpty();
	}
	
	public int length() {
		return this.pila.size();
	}
	
	public T pop(){
		if(!this.pila.isEmpty()) {
		T elemento = this.pila.get(this.pila.size()-1);
		this.pila.remove(this.pila.size()-1);
		return elemento;
		}
		return null;
	}
	
	public T peek() {
		if(!this.pila.isEmpty()) {
		T elemento = this.pila.get(this.pila.size()-1);
		return elemento;
		}
		return null;
	}
	
	public void push(T valor){
		this.pila.add(valor);
	}
	
	@Override
	public String toString() {
		String pila = "";
		if(this.pila.isEmpty()) {
			pila += "| | \n";
		}else {
		Iterator<T> iterator = this.pila.iterator();
		while(iterator.hasNext()) {
			pila += "|" + iterator.next() + "| \n";
		}
		}
		return pila;
	}
	
}
