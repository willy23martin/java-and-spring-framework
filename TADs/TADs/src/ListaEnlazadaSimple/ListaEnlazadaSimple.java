package ListaEnlazadaSimple;

public class ListaEnlazadaSimple<T> {

	private NodoEnlazadaSimple<T> primero, ultimo;

	public ListaEnlazadaSimple() {
		this.primero = null;
		this.ultimo = null;
	}

	public NodoEnlazadaSimple<T> getPrimero() {
		return primero;
	}

	public void setPrimero(NodoEnlazadaSimple<T> primero) {
		this.primero = primero;
	}

	public NodoEnlazadaSimple<T> getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoEnlazadaSimple<T> ultimo) {
		this.ultimo = ultimo;
	}

	// -----------------------------//

	public boolean estaVacia() {
		return primero == null && ultimo == null;
	}

	public void agregarElemento(T elemento) {
		NodoEnlazadaSimple<T> nodoNuevo = new NodoEnlazadaSimple<T>(elemento);
		if (estaVacia()) {
			primero = nodoNuevo;
			ultimo = nodoNuevo;
		} else {
			ultimo.setSiguiente(nodoNuevo);
			ultimo = nodoNuevo;
		}
	}

	public boolean contieneElemento(T elemento) {
		NodoEnlazadaSimple<T> nodoEncontrar = new NodoEnlazadaSimple<T>(
				elemento);
		boolean encontrado = false;
		if (estaVacia()) {
			return false;
		} else {
			NodoEnlazadaSimple<T> actual = primero;
			while (actual != null && !encontrado) {
				if (actual.equals(nodoEncontrar)) {
					encontrado = true;
				} else {
					actual = actual.getSiguiente();
				}
			}
		}
		return encontrado;
	}

	public void eliminarElemento(T elemento)
			throws ListaEnlazadaSimpleException {
		NodoEnlazadaSimple<T> nodoEliminar = new NodoEnlazadaSimple<T>(elemento);
		if (estaVacia()) {
			throw new ListaEnlazadaSimpleException(
					"La lista no contiene elementos");
		} else if (primero.equals(nodoEliminar)) {
			primero = primero.getSiguiente();
		} else {
			NodoEnlazadaSimple<T> actual = primero.getSiguiente();
			NodoEnlazadaSimple<T> anterior = primero;
			boolean encontrado = false;
			while (!encontrado && actual != null) {
				if (actual.equals(nodoEliminar)) {
					encontrado = true;
					anterior.setSiguiente(actual.getSiguiente());
				} else {
					anterior = actual;
					actual = actual.getSiguiente();
				}
			}
			if(encontrado==false){
				throw new ListaEnlazadaSimpleException("El elemento no se encuentra en la lista.");
			}
		}
	}
	
	public int numeroElementos(){
		int numeroElementos=0;
		if(estaVacia()){
			return 0;
		}else{
			NodoEnlazadaSimple<T> actual=primero;
			while(actual!=null){
				numeroElementos++;
				actual=actual.getSiguiente();
			}
		}
		return numeroElementos;
	}
	
	public NodoEnlazadaSimple<T> buscarElemento(T elemento) throws ListaEnlazadaSimpleException{
		NodoEnlazadaSimple<T> nodoEncontrar = new NodoEnlazadaSimple<T>(
				elemento);
		boolean encontrado = false;
		if (estaVacia()) {
			throw new ListaEnlazadaSimpleException("No hay elementos en la lista");
		} else {
			NodoEnlazadaSimple<T> actual = primero;
			while (actual != null && !encontrado) {
				if (actual.equals(nodoEncontrar)) {
					return actual;
				} else {
					actual = actual.getSiguiente();
				}
			}
		}
		throw new ListaEnlazadaSimpleException("El elemento no se encuentra");	
	}
	
}
