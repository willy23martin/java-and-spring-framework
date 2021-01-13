package ListaDoblementeEnlazada;

public class ListaDoblementeEnlazada<T> {

	private NodoListaDoble<T> primero, ultimo;

	public ListaDoblementeEnlazada() {
		this.primero = null;
		this.ultimo = null;
	}

	public NodoListaDoble<T> getPrimero() {
		return primero;
	}

	public void setPrimero(NodoListaDoble<T> primero) {
		this.primero = primero;
	}

	public NodoListaDoble<T> getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoListaDoble<T> ultimo) {
		this.ultimo = ultimo;
	}

	// ----------------------------------------//

	public boolean estaVacia() {
		return primero == null && ultimo == null;
	}

	public void agregarElemento(T elemento) {
		NodoListaDoble<T> nodoNuevo = new NodoListaDoble<T>(elemento);
		if (estaVacia()) {
			primero = nodoNuevo;
			ultimo = nodoNuevo;
		} else {
			ultimo.setSiguiente(nodoNuevo);
			nodoNuevo.setAnterior(ultimo);
			ultimo = nodoNuevo;
		}
	}

	public boolean contieneElemento(T elemento) {
		NodoListaDoble<T> nodo = new NodoListaDoble<T>(elemento);
		NodoListaDoble<T> actual = primero;
		boolean encontrado = false;
		while (actual != null) {
			if (actual.equals(nodo)) {
				encontrado = true;
				break;
			} else {
				actual = actual.getSiguiente();
			}
		}
		return encontrado;
	}

	public int numeroElementos() {
		NodoListaDoble<T> actual = primero;
		int numeroElementos = 0;
		if (estaVacia()) {
			numeroElementos = 0;
		} else {
			while (actual != null) {
				numeroElementos++;
				actual = actual.getSiguiente();
			}
		}
		return numeroElementos;
	}

	public void eliminarElemento(T elemento) throws ListaDoblementeEnlazadaException{
		NodoListaDoble<T> nodoEliminar=new NodoListaDoble<T>(elemento);
		if(estaVacia()){
			throw new ListaDoblementeEnlazadaException("La lista no contiene elementos.");
		}else{
			NodoListaDoble<T> actual = primero.getSiguiente();
			NodoListaDoble<T> anterior = primero;
			boolean encontrado = false;
			while (!encontrado && actual != null) {
				if (actual.equals(nodoEliminar)) {
					encontrado = true;
					anterior.setSiguiente(actual.getSiguiente());
					anterior.getSiguiente().setAnterior(anterior);
				} else {
					anterior = actual;
					actual = actual.getSiguiente();
				}
			}
		}
	}

}
