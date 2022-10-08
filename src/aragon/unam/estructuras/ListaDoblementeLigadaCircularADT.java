package aragon.unam.estructuras;

public class ListaDoblementeLigadaCircularADT <T>{
	private NodoDoble<T> head;
	private NodoDoble<T> tail;
	private int tamanio;

	public ListaDoblementeLigadaCircularADT(){
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
		NodoDoble nuevo = new NodoDoble(valor);
		if (this.head == null) {
			this.head = nuevo;
			this.tail = nuevo;
			this.head = this.tail;
			this.tail = this.head;
			this.tamanio++;
		} else {
			NodoDoble aux = this.tail;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			nuevo.setPrevio(aux);
			this.head = nuevo;
			this.tamanio++;
		}
	}
	
	public void agregarAlInicio(T valor) {
		NodoDoble nuevo = new NodoDoble(valor);
		if (this.estaVacia()) {
			this.head = nuevo;
			this.tail = nuevo;
			this.head = this.tail;
			this.tail = this.head;
			this.tamanio++;
		} else {
			nuevo.setSiguiente(this.tail);
			this.tail.setPrevio(nuevo);
			this.tail = nuevo;
			this.tamanio++;
		}
	}
	
	public void agregarDespuesDe(T valor, int posicion) {
		NodoDoble nuevo = new NodoDoble(valor);
		NodoDoble aux = this.tail;
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
			aux.getSiguiente().setPrevio(nuevo);
			nuevo.setPrevio(aux);
			this.tamanio++;
	}
	
	public void eliminar(int posicion) {
		NodoDoble aux = this.tail;
		NodoDoble aux2 = aux;
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
				aux.getSiguiente().setPrevio(null);
				this.tail = aux.getSiguiente();
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
							this.head = aux2;
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
		if (this.tail != null) {
			if(this.tamanio == 1) {
				this.head = null;
				this.tail = null;
				this.head = this.tail;
				this.tail = this.head;
				this.tamanio--;
			}else {
			NodoDoble aux = this.tail;
			aux.getSiguiente().setPrevio(null);
			aux = aux.getSiguiente();
			aux.setPrevio(null);
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
			if (this.getTamanio() > 1) {//podria ser una instrucción redundante
				NodoDoble aux = this.tail;
				NodoDoble aux2 = new NodoDoble();
				while (aux.getSiguiente() != null) {
					aux2 = aux;
					aux = aux.getSiguiente();
				}
				aux2.setSiguiente(null);
				this.head = aux2;
				aux.setPrevio(null);
				this.tamanio--;
			}
		}
	}
	
	public int buscarElemento(T dato) {
		NodoDoble aux = this.tail;
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
		NodoDoble aux = this.tail;
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
		NodoDoble curr_node = this.tail;
		System.out.print(null + " ");
		while (curr_node != null) {
			System.out.print(curr_node);
			curr_node = curr_node.getSiguiente();
		}
		System.out.println("<--> " + curr_node);
		System.out.println("");
		}else {
			NodoDoble curr_node = this.head;
			System.out.print(null + " ");
			while (curr_node != null) {
				System.out.print(curr_node);
				curr_node = curr_node.getPrevio();
			}
			System.out.println("<--> " + curr_node);
			System.out.println("");
		}
	}
}
