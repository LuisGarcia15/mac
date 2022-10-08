package aragon.unam.estructuras;

public class NodoDoble <T>{
	private T dato;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> previo;
    
    public NodoDoble() {
    }

    public NodoDoble(T valor) {
        this.dato = valor;
    }

    public NodoDoble(T dato, NodoDoble<T> siguiente, NodoDoble<T> previo) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.previo = previo;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    public NodoDoble<T> getPrevio() {
		return previo;
	}

	public void setPrevio(NodoDoble<T> previo) {
		this.previo = previo;
	}

	public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
    	return "<--> |"+dato+"| "; 
    }
    
    public String printAll(){
        return "[Previo = " + this.previo + "] <-> [Dato = " + dato + "] <-> [Siguiente : " + this.getSiguiente() + "]";
    }
}
