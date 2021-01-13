package ArbolNArio;

import java.util.*;

public class NodoNArio<T> {

	private T elemento;

	private ArrayList<NodoNArio<T>> hijos;

	public NodoNArio(T elemento) {

		this.elemento = elemento;
		this.hijos = new ArrayList<NodoNArio<T>>();

	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public ArrayList<NodoNArio<T>> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList<NodoNArio<T>> hijos) {
		this.hijos = hijos;
	}

	// --------------------------------//

	public String toString() {
		return elemento.toString();
	}

	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (obj instanceof NodoNArio) {
			if (((NodoNArio) obj).getElemento() instanceof Double
					&& this.getElemento() instanceof Double
					|| ((NodoNArio) obj).getElemento() instanceof Integer
					&& this.getElemento() instanceof Integer) {
				return ((NodoNArio) obj).getElemento() == this.elemento;
			} else {
				return this.toString().equalsIgnoreCase(
						((NodoNArio) obj).toString());
			}
		} else {
			return false;
		}
	}

	public boolean tieneHijos() {
		return hijos.size() != 0;
	}

	public void agregarElemento(T elemento) {
		hijos.add(new NodoNArio<T>(elemento));
	}

	public NodoNArio<T> buscarElemento(T elemento) throws ArbolNArioException {
		NodoNArio<T> buscado = null;
		NodoNArio<T> encontrar = new NodoNArio<T>(elemento);
		if (this.equals(encontrar)) {
			buscado = this;
		} else if (tieneHijos()) {
			for (int i = 0; i < hijos.size(); i++) {
				NodoNArio<T> hijo = hijos.get(i);
				if (hijo.equals(encontrar)) {
					buscado = hijo;
				} else {
					buscado = hijo.buscarElemento(elemento);
				}
			}
		} else {
			throw new ArbolNArioException("El elemento no se encuentra");
		}
		return buscado;
	}

	public boolean contieneElemento(T elemento) {
		try {
			NodoNArio<T> nodo = this.buscarElemento(elemento);
			if (nodo != null) {
				return true;
			} else {
				return false;
			}
		} catch (ArbolNArioException e) {
			return false;
		}

	}

	public int numeroElementos() {
		int numeroElementos = 0;
		if (!tieneHijos()) {
			numeroElementos = 1;
		} else {
			for (int i = 0; i < hijos.size(); i++) {
				numeroElementos += 1 + hijos.get(i).numeroElementos();
			}
		}
		return numeroElementos;
	}

}
