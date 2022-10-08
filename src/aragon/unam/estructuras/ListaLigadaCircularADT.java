package aragon.unam.estructuras;

public class ListaLigadaCircularADT<T> {

	Nodo<T> head;
	Nodo<T> tail;
	int tamanio;

	public ListaLigadaCircularADT() {
		this.head = null;
		this.tail = null;
		this.head = this.tail;
		this.tail = this.head;
		this.tamanio = 0;
	}

	public boolean estaVacia() {
		return this.head == null && this.tail == null;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void agregarAlFinal(T valor) {
		Nodo nuevo = new Nodo(valor);
		if (this.estaVacia()) {
			this.head = nuevo;
			this.tail = nuevo;
			this.head = this.tail;
			this.tail = this.head;
			this.tamanio++;
		} else {
			Nodo aux = this.tail;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			this.head = aux.getSiguiente();
			this.tamanio++;
		}
	}

	public void agregarAlInicio(T valor) {
		Nodo nuevo = new Nodo(valor);
		if (this.estaVacia()) {
			this.head = nuevo;
			this.tail = nuevo;
			this.head = this.tail;
			this.tail = this.head;
			this.tamanio++;
		} else {
			nuevo.setSiguiente(this.tail);
			this.tail = nuevo;
			this.tamanio++;
		}
	}

	public void agregarDespuesDe(T valor, int posicion) {
		Nodo nuevo = new Nodo(valor);
		Nodo aux = this.tail;
		if (posicion > 1) {
			for (int contador = 1; contador <= (posicion - 1); contador++) {
				aux = aux.getSiguiente();
			}
		}
		if(posicion == this.tamanio) {
			this.head = nuevo;
		}
			nuevo.setSiguiente(aux.getSiguiente());
			aux.setSiguiente(nuevo);
			this.tamanio++;
	}

	public void eliminar(int posicion) {
		Nodo aux = this.tail;
		Nodo aux2 = aux;
		boolean bandera = true;
		int contador = 1;
		if (posicion == 1) {
			if (aux.getSiguiente() == null) {
				this.head = null;
				this.tail = null;
				this.head = this.tail;
				this.tail = this.head;
				this.tamanio--;
			} else {
				this.tail = aux.getSiguiente();
				this.tamanio--;
			}
		} else {
			if (posicion > 1) {
				while (bandera) {
					if (contador == posicion) {
						if (aux.getSiguiente() == null) {
							aux2.setSiguiente(null);
							this.head = aux2;
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
		if (this.tail != null) {
			if(this.tamanio == 1) {
				this.head = null;
				this.tail = null;
				this.head = this.tail;
				this.tail = this.head;
				this.tamanio--;
			}else {
			Nodo aux = this.tail;
			aux = aux.getSiguiente();
			this.tail.setSiguiente(null);
			this.tail = aux;
			this.tamanio--;
			}
		}
	}

	public void eliminarElFinal() {
		if (this.getTamanio() == 1) {
			this.head = null;
			this.tail = null;
			this.head = this.tail;
			this.tail = this.head;
			this.tamanio--;
		} else {
			if (this.getTamanio() > 1) {
				Nodo aux = this.tail;
				Nodo aux2 = new Nodo();
				while (aux.getSiguiente() != null) {
					aux2 = aux;
					aux = aux.getSiguiente();
				}
				aux2.setSiguiente(null);
				this.head = aux2;
				this.tamanio--;
			}
		}
	}

	public int buscarElemento(T dato) {
		Nodo aux = this.tail;
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
		Nodo aux = this.tail;
		for (int i = 1; i <= this.tamanio; i++) {
			if (aux.getDato() == valorABuscar) {
				aux.setDato(valorParaActualizar);
				break;
			}
			aux = aux.getSiguiente();
		}

	}

	public void transversal(boolean direccion) {
		if(direccion) {
			Nodo curr_node = this.tail;
		while (curr_node != null) {
			System.out.print(curr_node);
			curr_node = curr_node.getSiguiente();
		}
		System.out.println(" " + curr_node);
		System.out.println("");
		}else {
			System.out.println(this.head);
		}
	}

}