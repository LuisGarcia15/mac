package aragon.unam.estructuras;

public class ColaADT <T>{
	private ListaLigadaADT<T> cola;
	private int tamanio;
	
	public ColaADT() {
		this.cola = new ListaLigadaADT<>();
		this.tamanio = 0;
	}
	
	public boolean isEmpty() {
		return this.cola.estaVacia();
	}
	
	public int length() {
		return this.tamanio;
	}
	
	public void enqueue(T elemento) {
		this.cola.agregarAlFinal(elemento);
	}
	
	public T dequeue() {
		T dato = null;
		if(!this.cola.estaVacia()) {
			for (T t : cola) {
				dato = t;
				this.cola.eliminarElPrimero();
				break;
			}
		}
		return dato;
	}

	@Override
	public String toString() {
		String estado = "";
		if(this.isEmpty()) {
			estado += "| |";
		}else {
		for (T t : this.cola) {
			if(t != null) {
				estado += "|" + t + "|" + " ";
			}else {
				break;
			}
		}
		}
		return estado;
	}
	
	
}
