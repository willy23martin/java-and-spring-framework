package TablaHash;

public class ListaEnlazadaNodoHash<K, T> {

	private NodoTablaHash<K, T> primero, ultimo;

	public ListaEnlazadaNodoHash() {
		primero = null;
		ultimo = null;
	}

	public NodoTablaHash<K, T> getPrimero() {
		return primero;
	}

	public void setPrimero(NodoTablaHash<K, T> primero) {
		this.primero = primero;
	}

	public NodoTablaHash<K, T> getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoTablaHash<K, T> ultimo) {
		this.ultimo = ultimo;
	}

	public boolean estaVacia() {
		return primero == null && ultimo == null;
	}

	public void agregarElemento(K llave, T valor) {
		NodoTablaHash<K, T> nodoNuevo = new NodoTablaHash<K, T>(llave, valor);
		if (estaVacia()) {
			primero = nodoNuevo;
			ultimo = nodoNuevo;
		} else {
			ultimo.setSiguiente(nodoNuevo);
			ultimo = nodoNuevo;
		}
	}

	public boolean contieneElemento(K llave, T valor) {
		NodoTablaHash<K, T> nodoEncontrar = new NodoTablaHash<K, T>(llave,
				valor);
		boolean encontrado = false;
		if (estaVacia()) {
			return false;
		} else {
			NodoTablaHash<K, T> actual = primero;
			while (actual != null && !encontrado) {
				if (actual.semejantes(nodoEncontrar)) {
					encontrado = true;
				} else {
					actual = actual.getSiguiente();
				}
			}
		}
		return encontrado;
	}

	public void eliminarElemento(K llave, T valor)
			throws ListaEnlazadaNodoHashException {
		NodoTablaHash<K, T> nodoEliminar = new NodoTablaHash<K, T>(llave, valor);
		if (estaVacia()) {
			throw new ListaEnlazadaNodoHashException(
					"La lista no contiene elementos");
		} else if (primero.iguales(nodoEliminar)) {
			primero = primero.getSiguiente();
		} else {
			NodoTablaHash<K, T> actual = primero.getSiguiente();
			NodoTablaHash<K, T> anterior = primero;
			boolean encontrado = false;
			while (!encontrado && actual != null) {
				if (actual.iguales(nodoEliminar)) {
					encontrado = true;
					anterior.setSiguiente(actual.getSiguiente());
				} else {
					anterior = actual;
					actual = actual.getSiguiente();
				}
			}
			if (encontrado == false) {
				throw new ListaEnlazadaNodoHashException(
						"El elemento no se encuentra en la lista.");
			}
		}
	}

	public int numeroElementos() {
		int numeroElementos = 0;
		if (estaVacia()) {
			return 0;
		} else {
			NodoTablaHash<K, T> actual = primero;
			while (actual != null) {
				numeroElementos++;
				actual = actual.getSiguiente();
			}
		}
		return numeroElementos;
	}

	public NodoTablaHash<K, T> buscarElemento(K llave, T valor)
			throws ListaEnlazadaNodoHashException {
		NodoTablaHash<K, T> nodoEncontrar = new NodoTablaHash<K, T>(llave,
				valor);
		boolean encontrado = false;
		if (estaVacia()) {
			throw new ListaEnlazadaNodoHashException(
					"No hay elementos en la lista");
		} else {
			NodoTablaHash<K, T> actual = primero;
			while (actual != null && !encontrado) {
				if (actual.equals(nodoEncontrar)) {
					return actual;
				} else {
					actual = actual.getSiguiente();
				}
			}
		}
		throw new ListaEnlazadaNodoHashException("El elemento no se encuentra");
	}

}
