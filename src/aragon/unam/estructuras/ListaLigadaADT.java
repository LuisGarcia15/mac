package aragon.unam.estructuras;

import java.util.Iterator;

public class ListaLigadaADT<T> implements Iterable<T>{

	private Nodo<T> head;
	private Nodo<T> aux;
	private int tamanio;

	public ListaLigadaADT() {
		this.head = null;
		this.aux = null;
		this.tamanio = 0;
	}

	public boolean estaVacia() {
		return this.head == null;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void agregarAlFinal(T valor) {
		Nodo nuevo = new Nodo(valor);
		if (this.estaVacia()) {
			this.head = nuevo;
			this.tamanio++;
		} else {
			Nodo aux = this.head;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			this.tamanio++;
		}
	}

	public void agregarAlInicio(T valor) {
		Nodo nuevo = new Nodo(valor);
		if (this.estaVacia()) {
			this.head = nuevo;
			this.tamanio++;
		} else {
			nuevo.setSiguiente(this.head);
			this.head = nuevo;
			this.tamanio++;
		}
	}

	public void agregarDespuesDe(T valor, int posicion) {
		Nodo nuevo = new Nodo(valor);
		Nodo aux = this.head;
		if (posicion > 1) {
			for (int contador = 1; contador <= posicion - 1; contador++) {
				aux = aux.getSiguiente();
			}
		}
			nuevo.setSiguiente(aux.getSiguiente());
			aux.setSiguiente(nuevo);
			this.tamanio++;
	}

	public void eliminar(int posicion) {
		Nodo aux = this.head;
		Nodo aux2 = aux;
		boolean bandera = true;
		int contador = 1;
		if (posicion == 1) {
			if (aux.getSiguiente() == null) {
				this.head = null;
				this.tamanio--;
			} else {
				this.head = aux.getSiguiente();
				this.tamanio--;
			}
		} else {
			if (posicion > 1) {
				while (bandera) {
					if (contador == posicion) {
						if (aux.getSiguiente() == null) {
							aux2.setSiguiente(null);
							this.tamanio--;
							break;
						} else {
							aux2.setSiguiente(aux.getSiguiente());
							this.tamanio--;
							break;
						}
					}
					contador++;
					aux2 = aux;
					aux = aux.getSiguiente();
				}
			}
		}
	}

	public void eliminarElPrimero() {
		if (this.head != null) {
			Nodo aux = this.head;
			aux = aux.getSiguiente();
			this.head = aux;
			this.tamanio--;
		}
	}

	public void eliminarElFinal() {
		if (this.getTamanio() == 1) {
			this.head = null;
			this.tamanio--;
		} else {
			if (this.getTamanio() > 1) {
				Nodo aux = this.head;
				Nodo aux2 = new Nodo();
				while (aux.getSiguiente() != null) {
					aux2 = aux;
					aux = aux.getSiguiente();
				}
				aux2.setSiguiente(null);
				this.tamanio--;
			}
		}
	}

	public int buscarElemento(T dato) {
		Nodo aux = this.head;
		int contador = 1;
		for (int i = 1; i <= this.tamanio; i++) {
			if (aux.getDato() == dato) {
				return contador;
			}
			contador++;
			aux = aux.getSiguiente();
		}
		return 0;
	}

	public void actualizar(T valorABuscar, T valorParaActualizar) {
		Nodo aux = this.head;
		for (int i = 1; i <= this.tamanio; i++) {
			if (aux.getDato() == valorABuscar) {
				aux.setDato(valorParaActualizar);
				break;
			}
			aux = aux.getSiguiente();
		}

	}

	public void transversal() {
		Nodo curr_node = this.head;
		while (curr_node != null) {
			System.out.print(curr_node);
			curr_node = curr_node.getSiguiente();
		}
		System.out.println(" " + curr_node);
		System.out.println("");
	}

	@Override
	public Iterator<T> iterator() {
		aux = head;
		return new Iterator() {
			@Override
			public boolean hasNext() {
				return aux != null;	
			}

			@Override
			public T next() {
				T next = aux.getDato();
				aux = aux.getSiguiente();
				return next;
			}
			
		};
		}
}