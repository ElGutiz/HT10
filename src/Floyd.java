
import static java.lang.String.format;
import java.util.Arrays;
import java.util.List;


public class Floyd {
	
	public Floyd() {
		
	}
	
	static int[][] floydWarshall(Nodo[][] weights, int numVertices, Nodo origen, Nodo destino, List<Nodo> nodo) {
		 
        double[][] dist = new double[numVertices][numVertices];
        for (double[] row : dist)
            Arrays.fill(row, Double.POSITIVE_INFINITY);
 
        for (Nodo[] w : weights)
            dist[w[0].getAdyacente() - 1][w[1].getAdyacente() - 1] = w[2].getAdyacente();
 
        int[][] next = new int[numVertices][numVertices];
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++)
                if (i != j)
                    next[i][j] = j + 1;
        }
 
        for (int k = 0; k < numVertices; k++)
            for (int i = 0; i < numVertices; i++)
                for (int j = 0; j < numVertices; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
 
        printResult(dist, next, origen, destino, nodo);
        
        return next;

       
    }
 
    static void printResult(double[][] dist, int[][] next, Nodo origen, Nodo destino, List<Nodo> nodo) {
    	System.out.println("=====================================================");
        System.out.println("pair     dist    path");
        String lectura = "";
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++) {
                if (i != j) {
                    int u = i + 1;
                    int v = j + 1;
                    if(u==origen.getAdyacente() && v==destino.getAdyacente()) {
                    	lectura += String.valueOf(origen.getAdyacente())+ "="+ origen.getciudad()+"\n";
	                    String path = format("%s -> %d    %2s     %s", u, v,
	                    		String.valueOf((int) dist[i][j])+"km", u);
	                    do {
	                        u = next[u - 1][v - 1];
	                        path += " -> " + u;
	                        lectura += String.valueOf(u)+ "="+ nodo.get(u-1).getciudad()+"\n";
	                    } while (u != v);
	                    if((int) dist[i][j] != 2147483647) {
	                    	System.out.println(path);
	                    }else {
	                    	System.out.println("No se puede calcular ruta.");
	                    }
                    }
                }
            }
        }
        
        System.out.println("Lectura: ");
        System.out.println(lectura);
        System.out.println("=====================================================");
    }

		
}
