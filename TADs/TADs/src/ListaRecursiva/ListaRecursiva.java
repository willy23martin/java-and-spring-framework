package ListaRecursiva;

public class ListaRecursiva<T> {

	private T cabeza;

	private ListaRecursiva<T> cola;

	public ListaRecursiva(){

	}

	public ListaRecursiva(T cabeza, ListaRecursiva<T> cola) {
		this.cabeza = cabeza;
		this.cola = cola;
	}

	public T getCabeza() {
		return cabeza;
	}

	public void setCabeza(T cabeza) {
		this.cabeza = cabeza;
	}

	public ListaRecursiva<T> getCola() {
		return cola;
	}

	public void setCola(ListaRecursiva<T> cola) {
		this.cola = cola;
	}

	public boolean isEmpty() {
		return cabeza == null || cola == null ? true : false;
	}

	public boolean tieneCola() {
		return cola != null ? true : false;
	}

	public ListaRecursiva<T> agregarElemento(T elemento) {
		if (isEmpty()) {
			return new ListaRecursiva<T>(elemento, new ListaRecursiva<T>());
		} else {
			if (!tieneCola()) {
				return new ListaRecursiva<T>(cabeza, new ListaRecursiva<T>(
						elemento, new ListaRecursiva<T>()));
			} else {
				return new ListaRecursiva<T>(cabeza,
						cola.agregarElemento(elemento));
			}
		}

	}

	public T buscarElemento(T elemento) throws ListaRecursivaException {
		if (isEmpty()) {
			throw new ListaRecursivaException("La lista está vacía.");
		} else {
			if (tieneCola()) {
				if (cabeza.equals(elemento)) {
					return cabeza;
				} else {
					return cola.buscarElemento(elemento);
				}
			} else {
			
				if (cabeza.equals(elemento)) {
					return cabeza;
				} else
					throw new ListaRecursivaException(
							"El elemento a buscar no se encuentra en la lista.");
			}
		}
	}

	public ListaRecursiva<T> eliminarElemento(T elemento)
			throws ListaRecursivaException {
		if (isEmpty()) {
			throw new ListaRecursivaException(
					"La lista está vacía no se puede eliminar.");
		} else {
			if (!tieneCola()) {
				if (cabeza.equals(elemento)) {
					return new ListaRecursiva<T>();
				} else {
					throw new ListaRecursivaException(
							"La lista no contiene ese elemento.");
				}
			} else {
				if (cabeza.equals(elemento)) {
					return new ListaRecursiva<T>(cola.getCabeza(),
							cola.getCola());
				} else {
					return new ListaRecursiva<T>(cabeza,
							cola.eliminarElemento(elemento));
				}
			}
		}
	}

	public int getNumeroElementos() {
		if (isEmpty()) {
			return 0;
		} else {
			if (!tieneCola()) {
				return 1;
			} else {
				return 1 + cola.getNumeroElementos();
			}
		}
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("La lista está vacía");
		} else {
			if (!tieneCola()) {
				System.out.println(cabeza);
			} else {
				System.out.println(cabeza.toString());
				cola.print();
			}
		}
	}

}
