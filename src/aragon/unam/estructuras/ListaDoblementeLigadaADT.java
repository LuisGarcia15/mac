package aragon.unam.estructuras;

public class ListaDoblementeLigadaADT <T>{
	private NodoDoble<T> head;
	private int tamanio;

	public ListaDoblementeLigadaADT() {
		this.head = null;
		this.tamanio = 0;
	}
	
	public boolean estaVacia() {
		return this.head == null;
	}
	
	public int getTamanio() {
		return tamanio;
	}
	
	public void agregarAlFinal(T valor) {
		NodoDoble nuevo = new NodoDoble(valor);
		if (this.head == null) {
			this.head = nuevo;
			this.tamanio++;
		} else {
			NodoDoble aux = this.head;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			nuevo.setPrevio(aux);
			this.tamanio++;
		}
	}
	
	public void agregarAlInicio(T valor) {
		NodoDoble nuevo = new NodoDoble(valor);
		if (this.estaVacia()) {
			this.head = nuevo;
			this.tamanio++;
		} else {
			nuevo.setSiguiente(this.head);
			this.head.setPrevio(nuevo);
			this.head = nuevo;
			this.tamanio++;
		}
	}
	
	public void agregarDespuesDe(T valor, int posicion) {
		NodoDoble nuevo = new NodoDoble(valor);
		NodoDoble aux = this.head;
		if (posicion > 1) {
			for (int contador = 1; contador <= (posicion - 1); contador++) {
				aux = aux.getSiguiente();
			}
		}
			nuevo.setSiguiente(aux.getSiguiente());
			aux.setSiguiente(nuevo);
			aux.getSiguiente().setPrevio(nuevo);
			nuevo.setPrevio(aux);
			this.tamanio++;
	}
	
	public void eliminar(int posicion) {
		NodoDoble aux = this.head;
		NodoDoble aux2 = aux;
		boolean bandera = true;
		int contador = 1;
		if (posicion == 1) {
			if (aux.getSiguiente() == null) {
				this.head = null;
				this.tamanio--;
			} else {
				aux.getSiguiente().setPrevio(null);
				this.head = aux.getSiguiente();
				aux.setSiguiente(null);
				this.tamanio--;
			}
		} else {
			if (posicion > 1) {
				while (bandera) {
					if (contador == posicion) {
						if (aux.getSiguiente() == null) {
							aux2.setSiguiente(null);
							aux.setPrevio(null);
							this.tamanio--;
							break;
						} else {
							aux2.setSiguiente(aux.getSiguiente());
							aux.getSiguiente().setPrevio(aux2);
							aux.setSiguiente(null);
							aux.setPrevio(null);
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
			if(this.tamanio == 1) {
				this.head = null;
				this.tamanio--;
			}else {
			NodoDoble aux = this.head;
			aux.getSiguiente().setPrevio(null);
			aux = aux.getSiguiente();
			aux.setPrevio(null);
			this.head.setSiguiente(null);
			this.head = aux;
			this.tamanio--;
			}
		}
	}
	
	public void eliminarElFinal() {
		if (this.getTamanio() == 1) {
			this.head = null;
			this.tamanio--;
		} else {
			if (this.getTamanio() > 1) {//podria ser una instrucción redundante
				NodoDoble aux = this.head;
				NodoDoble aux2 = new NodoDoble();
				while (aux.getSiguiente() != null) {
					aux2 = aux;
					aux = aux.getSiguiente();
				}
				aux2.setSiguiente(null);
				aux.setPrevio(null);
				this.tamanio--;
			}
		}
	}
	
	public int buscarElemento(T dato) {
		NodoDoble aux = this.head;
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
		NodoDoble aux = this.head;
		for (int i = 1; i <= this.tamanio; i++) {
			if (aux.getDato() == valorABuscar) {
				aux.setDato(valorParaActualizar);
				break;
			}
			aux = aux.getSiguiente();
		}

	}
	
	public void transversal() {
		NodoDoble curr_node = this.head;
		System.out.print(null + " ");
		while (curr_node != null) {
			System.out.print(curr_node);
			curr_node = curr_node.getSiguiente();
		}
		System.out.println("<--> " + curr_node);
		System.out.println("");
	}
}
