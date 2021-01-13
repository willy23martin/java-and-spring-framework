package Z.Pruebas;

import java.util.Arrays;

import ArbolBinario.ArbolBinario;
import ArbolNArio.ArbolNArio;
import Cola.Cola;
import ListaDoblementeEnlazada.ListaDoblementeEnlazada;
import ListaEnlazadaSimple.ListaEnlazadaSimple;
import ListaRecursiva.ListaRecursiva;
import Pila.Pila;
import TablaHash.TablaHash;

public class Tester {

	static ArbolBinario<Integer> numerosB = new ArbolBinario<Integer>();
	static ArbolNArio<Integer> numerosN = new ArbolNArio<Integer>();
	static Cola<Integer> numerosC = new Cola<Integer>();
	static ListaDoblementeEnlazada<Integer> numerosLDE = new ListaDoblementeEnlazada<Integer>();
	static ListaEnlazadaSimple<Integer> numerosLES = new ListaEnlazadaSimple<Integer>();
	static ListaRecursiva<Integer> numerosLR = new ListaRecursiva<Integer>();
	static Pila<Integer> numerosP = new Pila<Integer>();
	static TablaHash<Integer, String> contactosTH = new TablaHash<Integer, String>(20);

	public static void main(String args[]) {
		/**
		numerosC.enQueue(0);
		numerosB.agregarElemento(0);
		numerosLDE.agregarElemento(0);
		int i = 1;
		int j = -1;
		while (j > -10 && i < 10) {

			numerosB.agregarElemento(i);
			numerosB.agregarElemento(j);

			numerosC.enQueue(i);
			numerosC.enQueue(j);

			numerosLDE.agregarElemento(i);
			numerosLDE.agregarElemento(j);
			i++;
			j--;
		}

		System.out.println("Recorrido Inorder numerosB: " + numerosB.recorrerInorden());

		System.out.println("Primeros tres numeros en cola: " + numerosC.disQueue() + "," + numerosC.disQueue() + ","
				+ numerosC.disQueue());
		System.out.println("Primer y último números en Lista doblemente enlazada: \n" + numerosLDE.getPrimero() + ", "
				+ numerosLDE.getUltimo());
				**/
		/**
		int i1=5;
		int i2=2;
		int i3=i1/i2;
		System.out.println(i3);*/ 
		
		
		/**
		 * System.out.println(Ps.E == Ps.E);
		System.out.println(Ps.E.equals(Ps.E)); */
		
				
	}

	enum Ps {
		E, T
	}
}
