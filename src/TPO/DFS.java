package TPO;
import Grafo.ImplemEstatica;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int j, w;

	        // Creación del grafo
	        ImplemEstatica grafo = new ImplemEstatica();
	        grafo.inicializarGrafo(10);
	        grafo.agregarVertice(1);
	        grafo.agregarVertice(2);
	        grafo.agregarVertice(3);
	        grafo.agregarVertice(4);

	        // Agregando aristas
	        grafo.agregarArista(1, 2, 1);
	        grafo.agregarArista(1, 4, 1);
	        grafo.agregarArista(2, 3, 1);
	        grafo.agregarArista(3, 4, 1);
	        grafo.agregarArista(4, 2, 1);

	        System.out.println("Los vértices y aristas del grafo se representarán a través de una matriz de la siguiente manera:");

	        // Mostrando el grafo
	        System.out.println("\t");
	        grafo.mostrarMatriz();

	        // Realizando DFS
	        System.out.println("Vertices con sus respectivos padres según el recorrido de DFS:");
	        System.out.println("\t");

	        int[] p = new int[5];

	        // Creación del arreglo de marcas
	        String marca[] = new String[5];
	        for (w = 0; w < marca.length; w++) {
	            marca[w] = "B";
	        }

	        // Llamando a la función DFS
	        int[] dfs = DFS(grafo, 1, p, marca);

	        // Imprimiendo el recorrido
	        for (j = 1; j < dfs.length; j++) {
	            System.out.println("Hijo: " + j + " / Padre: " + dfs[j]);
	        }
	    }

	    public static int[] DFS(ImplemEstatica grafo, int origen, int[] p, String[] marca) {

	        // Marcando el vértice como descubierto
	        marca[origen] = "G";

	        // Recorriendo los adyacentes al vértice origen
	        for (int v : grafo.adyacentes(origen)) 
	            if (marca[v] == "B") {
	                // Agregando el padre al arreglo de padres
	                p[v] = origen;
	                // Llamando recursivamente a DFS
	                DFS(grafo, v, p, marca);
	            }

	        // Cambiando la marca a visitado
	        marca[origen] = "N";

	        // Retornando el arreglo de padres
	        return p;
	    }

}
