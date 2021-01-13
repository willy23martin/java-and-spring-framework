package Pila;

public class Pila<T> {

	private Nodo<T> ultimo;

	private int numeroElementos;

	public Pila() {
		ultimo = null;
		this.numeroElementos = 0;
	}

	public Nodo<T> getUltimo() {
		return ultimo;
	}

	public void setUltimo(Nodo<T> ultimo) {
		this.ultimo = ultimo;
	}

	public int getNumeroElementos() {
		return numeroElementos;
	}

	public void setNumeroElementos(int numeroElementos) {
		this.numeroElementos = numeroElementos;
	}

	public boolean isEmpty() {
		return (ultimo == null) ? true : false;
	}

	public void push(T elemento) {
		if (isEmpty()) {
			Nodo<T> e = new Nodo<T>(elemento);
			ultimo = e;
		} else {
			Nodo<T> e1 = new Nodo<T>(elemento);
			e1.setSiguiente(ultimo);
			ultimo = e1;
		}
		numeroElementos++;
	}

	public T pop() {
		Nodo<T> u = ultimo;
		if (isEmpty()) {
			return null;
		} else{
			ultimo = ultimo.getSiguiente();
		}
		numeroElementos--;
		return u.getElemento();
	}

}
