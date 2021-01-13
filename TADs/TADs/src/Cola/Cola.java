package Cola;

public class Cola<T> {

	private int numeroElementos;
	
	private Nodo<T> primero,ultimo;
	
	public Cola(){
		primero=null;
		ultimo=null;
		numeroElementos=0;
	}

	public int getNumeroElementos() {
		return numeroElementos;
	}

	public void setNumeroElementos(int numeroElementos) {
		this.numeroElementos = numeroElementos;
	}

	public Nodo<T> getPrimero() {
		return primero;
	}

	public void setPrimero(Nodo<T> primero) {
		this.primero = primero;
	}
	
	public boolean noHayElementos(){
		return (numeroElementos==0) ? true:false;
	}
	
	public void enQueue(T elemento){
		if(noHayElementos()){
			primero=ultimo=new Nodo<T>(elemento);
		}else{
			Nodo<T> u =new Nodo<T>(elemento);
			ultimo.setSiguiente(u);
			ultimo=u;
		}
		numeroElementos++;
	}
	
	public T disQueue(){
		T elemento=primero.getElemento();
		primero=primero.getSiguiente();
		numeroElementos--;
		return elemento;
	}
	
}
