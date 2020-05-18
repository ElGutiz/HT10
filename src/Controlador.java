
import java.util.List;

public class Controlador {
	
	private Nodo[][] Adyacente;
	private int[][] next;
	
	public Controlador() {
		
	}
	
	public void hallarDistancia(List<Nodo> grafo, String origen, String destino){		
		int aristas = 0;
		int contador = 0;
		int contador1 = 0;
		int contador2 = 0;
		for(int i = 0; i<grafo.size(); i++) {
			try {
				aristas += grafo.get(i).getEdges().size();
			}catch(Exception e) {
				aristas += 0;
			}
		}
		Adyacente = new Nodo[aristas][3];
		
		for(int i = 0; i<grafo.size(); i++) {
			try {
				for(int j = 0; j<grafo.get(i).getEdges().size(); j++) {
					Adyacente[contador][0] = grafo.get(i).getEdges().get(j).getorigen();
					Adyacente[contador][1] = grafo.get(i).getEdges().get(j).getdestino();
					Adyacente[contador][2] = grafo.get(i).getEdges().get(j).getdistancia();
					contador++;
				}
			}catch(Exception e) {
			}
		}
		
		for (int k = 0; k < grafo.size(); k++) {
   		 if(grafo.get(k).getciudad().equals(origen)) {
   			 contador1 = k;
   		 }
   		 if(grafo.get(k).getciudad().equals(destino)) {
   			 contador2 = k;
   		 }
   	 }
		
		this.next = Floyd.floydWarshall(Adyacente, grafo.size(), grafo.get(contador1), grafo.get(contador2), grafo);
	}
	
	public String getCenter(List<Nodo> nodo) {
		 int centerEx = Integer.MAX_VALUE, ex = 0, center = 0;
		//Se revisan los valores maximos de las columnas de la matriz de Floyd para obtener las excentricidades de cada nodo
		 
	        for (int i = 0; i < this.next.length; i++) {
	            for (int j = 0; j < this.next.length; j++) {
	                if (this.next[j][i] > ex)
	                    ex = this.next[j][i];
	            }

	            //Se lleva un contador de la excentricidad minima para obtener el centro
	            if (centerEx > ex) {
	                centerEx = ex;
	                center = i;
	            }
	            
	        }
	        return nodo.get(center).getciudad();
	 }
	public Grafo eliminarRuta(String origen, String destino, Grafo grafo) {
		int contador1 = 0;
		int contador2 = 0;
		for (int k = 0; k < grafo.getNodos().size(); k++) {
	   		 if(grafo.getNodos().get(k).getciudad().equals(origen)) {
	   			 contador1 = k;
	   		 }
	   		 if(grafo.getNodos().get(k).getciudad().equals(destino)) {
	   			 contador2 = k;
	   		 }
	   	 }
		for (int k = 0; k < grafo.getNodos().get(contador1).getEdges().size(); k++) {
			if(grafo.getNodos().get(contador1).getEdges().get(k).getdestino().getciudad().equals(destino)) {
				grafo.getNodos().get(contador1).getEdges().remove(k);
			}
		}
		return grafo;
		
	}
	public Grafo agregarRuta(String origen, String destino, Grafo grafo, int distancia) {
		int contador1 = 0;
		int contador2 = 0;
		Nodo distancia1 = new Nodo("new");
		distancia1.setAdyacente(distancia);
		for (int k = 0; k < grafo.getNodos().size(); k++) {
	   		 if(grafo.getNodos().get(k).getciudad().equals(origen)) {
	   			 contador1 = k;
	   		 }
	   		 if(grafo.getNodos().get(k).getciudad().equals(destino)) {
	   			 contador2 = k;
	   		 }
	   	 }
		
		grafo.getNodos().get(contador1).addEdge(new Edge(grafo.getNodos().get(contador1), grafo.getNodos().get(contador2), distancia1));
		return grafo;
	}
	
}
