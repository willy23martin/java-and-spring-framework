package ArbolNArio;

public class ArbolNArio<T> {

	private NodoNArio<T> raiz;

	public ArbolNArio() {
		this.raiz = null;
	}

	public NodoNArio<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoNArio<T> raiz) {
		this.raiz = raiz;
	}
	
	//------------------------//
	
	public boolean estaVacio(){
		return raiz==null;
	}
	
	public void agregarElemento(T padre, T elemento){
		if(estaVacio()){
			raiz=new NodoNArio<T>(elemento);
		}else{
			try {
				NodoNArio<T> nodoNArio=raiz.buscarElemento(padre);
				nodoNArio.agregarElemento(elemento);
			} catch (ArbolNArioException e) {
				e.printStackTrace();
			}
		}
	}
	
	public NodoNArio<T> buscarElemento(T elemento) throws ArbolNArioException{
		if(estaVacio()){
			throw new ArbolNArioException("El arbol está vacío.");
		}else{
			return raiz.buscarElemento(elemento);
		}
	}

	public void eliminarElemento(T padre, T elemento) throws ArbolNArioException{
		if(estaVacio()){
			throw new ArbolNArioException("El arbol está vacío.");
		}else{
			NodoNArio<T> p=this.buscarElemento(padre);
			NodoNArio<T> h=p.buscarElemento(elemento);
			if(h.tieneHijos()){
				h.setHijos(null);
			}else{
				p.getHijos().remove(h);
			}
		}
	}
	
	public boolean contieneElemento(T elemento){
		return raiz.contieneElemento(elemento);
	}
	
	public int numeroElementos(){
		return raiz.numeroElementos();
	}
	
}
