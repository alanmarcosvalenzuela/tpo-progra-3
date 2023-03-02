package TPO;

import Grafo.ImplemEstatica;

public class Floyd {

    public static void main(String[] args) {

        int j, w;

        ImplemEstatica grafo = new ImplemEstatica();
        grafo.inicializarGrafo(7);

        for(int i = 1; i <= 6; i++) {
            grafo.agregarVertice(i);
        }

        int[][] aristas = {{1, 2, 10}, {1, 6, 7}, {2, 3, 15}, {3, 4, 22}, {4, 5, 1}, {6, 4, 30}, {6, 5, 45}};

        for(int[] arista : aristas) {
            grafo.agregarArista(arista[0], arista[1], arista[2]);
        }

        System.out.println("El grafo en forma matricial se mostrará de la siguiente manera:");
        System.out.println("\t");

        grafo.mostrarMatriz();

        System.out.println("*******************************************");
        System.out.println("\t");

        System.out.println("El camino mínimo para llegar a los vértices será:");
        System.out.println("(El valor 99999 hace referencia a un valor alto como infinito, es decir, que no habrá conexión entre los vértices)");
        System.out.println("\t");

        int[][] floyd = calcularFloyd(grafo.retornarMatriz());

        for(j = 0; j < floyd.length; j++) {
            for(w = 0; w < floyd.length; w++) {
                System.out.print(floyd[j][w] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static int[][] calcularFloyd(int matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j] == 0) {
                    matriz[i][j] = 99999;
                }
                if(i == j) {
                    matriz[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                    if(matriz[j][i] + matriz[i][k] < matriz[j][k]) {
                        matriz[j][k] = matriz[j][i] + matriz[i][k];
                    }
                }
            }
        }

        return matriz;
    }
}
