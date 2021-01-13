package ListaDoblementeEnlazada;

public class NodoListaDoble<T> {

	private T elemento;
	
	private NodoListaDoble<T> siguiente,anterior;
	
	public NodoListaDoble(T elemento){
		this.elemento=elemento;
		this.siguiente=null;
		this.anterior=null;
	}

	public NodoListaDoble<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaDoble<T> siguiente) {
		this.siguiente = siguiente;
	}

	public NodoListaDoble<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoListaDoble<T> anterior) {
		this.anterior = anterior;
	}
	
	
	
	//----------------------------------//
	
	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public String toString(){
		return elemento.toString();
	}

	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (obj instanceof NodoListaDoble) {
			if (((NodoListaDoble) obj).getElemento() instanceof Double
					&& this.getElemento() instanceof Double
					|| ((NodoListaDoble) obj).getElemento() instanceof Integer
					&& this.getElemento() instanceof Integer) {
				return ((NodoListaDoble) obj).getElemento()==this.elemento;
			}else{
				return this.toString().equalsIgnoreCase(((NodoListaDoble)obj).toString());
			}
		}else{
			return false;
		}
	}

		
	
	
}
