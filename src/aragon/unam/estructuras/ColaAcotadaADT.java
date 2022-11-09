package aragon.unam.estructuras;

public class ColaAcotadaADT <T>{
	private ListaLigadaADT<ListaLigadaADT<T>> colaAcotada;
	private int tamanio;
	private boolean esVacia = true;
	
	public ColaAcotadaADT(int prioridad) {
		this.colaAcotada = new ListaLigadaADT<>();
		this.tamanio = 0;
		for (int i = 1; i <= prioridad ; i++) {
			this.colaAcotada.agregarAlFinal(new ListaLigadaADT<>());
		}
	}
	
	public boolean isEmpty() {
		return esVacia;
	}
	
	public int length() {
		return this.tamanio;
	}
	
	public void enqueue(int prioridad, T elemento) {
		int contador = 1;
		for (ListaLigadaADT<T> colaAcotada : colaAcotada) {
			if(contador == prioridad) {
				esVacia = true;
				colaAcotada.agregarAlFinal(elemento);
				this.tamanio++;
				break;
			}else {
				contador++;
			}
		}
	}
	
	public T dequeue() {
		T dato = null;
		for (ListaLigadaADT<T> colaAcotada : colaAcotada) {
			if(!colaAcotada.estaVacia()) {
				for (T t: colaAcotada) {
					dato = t;
					colaAcotada.eliminarElPrimero();
					this.tamanio--;
					break;
				}
				break;
			}
		}
		return dato;
	}

	@Override
	public String toString() {
		String estado = "";
		int contador = 1;
		
		for (ListaLigadaADT<T> listaLigadaADT : colaAcotada) {
			estado += contador + " - ";
			for (T t : listaLigadaADT) {
				estado += "|" + t + "|" + " ";
			}
			contador++;
			estado += "\n";
		}
		return estado;
	}
	
	
}

