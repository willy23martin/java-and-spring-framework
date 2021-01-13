package TablaHash;

import java.util.ArrayList;

public class TablaHash<K, T> {

	private int tamanio;

	private ArrayList<ListaEnlazadaNodoHash<K, T>> elementos;

	public TablaHash(int tamanio) {
		this.tamanio = tamanio;
		this.elementos = new ArrayList<ListaEnlazadaNodoHash<K, T>>(tamanio);
		for (int i = 0; i < tamanio; i++) {
			elementos.add(i, new ListaEnlazadaNodoHash<K, T>());
		}
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public ArrayList<ListaEnlazadaNodoHash<K, T>> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<ListaEnlazadaNodoHash<K, T>> elementos) {
		this.elementos = elementos;
	}

	public boolean estaVacia() {
		return elementos.isEmpty();
	}

	public int generarPosicion(K llave, T valor) {
		NodoTablaHash<K, T> nodo = new NodoTablaHash<K, T>(llave, valor);
		if(nodo.hashCode()==0){
			return 0;
		}else{
		return tamanio % nodo.hashCode();
		}
	}

	public void agregarElemento(K llave, T valor) {
		int posicion = generarPosicion(llave, valor);
		elementos.get(posicion).agregarElemento(llave, valor);
	}

	public NodoTablaHash<K, T> buscarElemento(K llave, T valor) throws ListaEnlazadaNodoHashException {
		NodoTablaHash<K, T> b=new NodoTablaHash<K,T>(llave, valor);
		NodoTablaHash<K, T> nodoBuscado=null;
		for(int i=0;i<elementos.size();i++){
			ListaEnlazadaNodoHash<K, T> lista=elementos.get(i);
			if(lista.getPrimero().equivalentes(b)){ 
				if(lista.getPrimero().iguales(b)){
					nodoBuscado=lista.getPrimero();
				}else{
					nodoBuscado=lista.buscarElemento(llave, valor); 
				}
				break;
			}else{
				continue;
			}
		}
		
		return nodoBuscado;
	}
	
	public void eliminarElemento(K llave, T valor) throws ListaEnlazadaNodoHashException{
		NodoTablaHash<K, T> nodo=new NodoTablaHash<K,T>(llave, valor);
		for(int i=0;i<elementos.size();i++){
			ListaEnlazadaNodoHash<K, T> lista=elementos.get(i);
			if(lista.getPrimero().equivalentes(nodo)){ 
				 lista.buscarElemento(llave, valor);
				 break;
			}else{
				continue;
			}
		}
	}

	public boolean contieneElemento(K llave,T valor){
		try {
			if(buscarElemento(llave, valor)==null){
				return false;
			}else{
				return true;
			}
		} catch (ListaEnlazadaNodoHashException e) {
			return false;
		}
	}
	
}
