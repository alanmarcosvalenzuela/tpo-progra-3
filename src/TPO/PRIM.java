package TPO;
import Grafo.ImplemEstatica;

public class PRIM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Creamos una instancia de la implementación estática del grafo
	    ImplemEstatica grafo = new ImplemEstatica();

	    // Inicializamos el grafo con 6 nodos
	    grafo.inicializarGrafo(6);

	    // Agregamos los nodos al grafo
	    grafo.agregarVertice(1);
	    grafo.agregarVertice(2);
	    grafo.agregarVertice(3);
	    grafo.agregarVertice(4);
	    grafo.agregarVertice(5);
	    grafo.agregarVertice(6);

	    // Agregamos las aristas al grafo
	    grafo.agregarArista(1, 2, 6);
	    grafo.agregarArista(1, 4, 5);
	    grafo.agregarArista(1, 5, 2);
	    grafo.agregarArista(2, 3, 3);
	    grafo.agregarArista(2, 5, 3);
	    grafo.agregarArista(3, 4, 4);
	    grafo.agregarArista(3, 5, 4);
	    grafo.agregarArista(3, 6, 5);
	    grafo.agregarArista(4, 6, 2);
	    grafo.agregarArista(5, 6, 6);

	    // Imprimimos la matriz de adyacencia del grafo
	    grafo.mostrarMatriz();

	    // Creamos una instancia del algoritmo Prim y lo ejecutamos sobre el grafo
	    ImplemEstatica prim = grafo.prim(4);
	    
	    
	    // Imprimimos el árbol de expansión mínimo generado por el algoritmo Prim
	    System.out.println("Árbol de expansión mínimo:");
	    
	    prim.mostrarMatriz();

	}

}
