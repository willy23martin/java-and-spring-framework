package TablaHash;

public class NodoTablaHash<K, T> {

	private K llave;

	private T valor;

	private NodoTablaHash<K, T> siguiente; 

	public NodoTablaHash(K llave, T valor) {
		this.llave = llave;
		this.valor = valor;
		this.siguiente = null;
	}

	public K getLlave() {
		return llave;
	}

	public void setLlave(K llave) {
		this.llave = llave;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public NodoTablaHash<K, T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoTablaHash<K, T> siguiente) {
		this.siguiente = siguiente;
	}

	public String toString() {
		return String.valueOf(llave) + "," + valor.toString();
	}

	public int hashCode() {
		return llave.hashCode();
	}

	public boolean equivalentes(NodoTablaHash<K, T> nodo) {
		return nodo.hashCode() == this.hashCode();
	}

	public boolean semejantes(NodoTablaHash<K, T> nodo) {
		if (nodo.getValor() instanceof Double
				&& this.getValor() instanceof Double
				|| nodo.getValor() instanceof Integer
				&& this.getValor() instanceof Integer) {
			return nodo.getValor() == this.getValor();
		} else {
			return this.getValor().equals(nodo.getValor());
		}
	}

	public boolean iguales(NodoTablaHash<K, T> nodo) {
		return this.equivalentes(nodo) && this.semejantes(nodo);
	}
	
}
