package ListaEnlazadaSimple;

public class NodoEnlazadaSimple<T> {

	private T elemento;

	private NodoEnlazadaSimple<T> siguiente;

	public NodoEnlazadaSimple(T elemento) {
		siguiente = null;
		this.elemento = elemento;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NodoEnlazadaSimple<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoEnlazadaSimple<T> siguiente) {
		this.siguiente = siguiente;
	}
	
	public String toString(){
		return elemento.toString();
	}

	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (obj instanceof NodoEnlazadaSimple) {
			if (((NodoEnlazadaSimple) obj).getElemento() instanceof Double
					&& this.getElemento() instanceof Double
					|| ((NodoEnlazadaSimple) obj).getElemento() instanceof Integer
					&& this.getElemento() instanceof Integer) {
				return ((NodoEnlazadaSimple) obj).getElemento()==this.elemento;
			}else{
				return this.toString().equalsIgnoreCase(((NodoEnlazadaSimple)obj).toString());
			}
		}else{
			return false;
		}
	}

		

}
