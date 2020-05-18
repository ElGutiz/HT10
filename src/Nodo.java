import java.util.ArrayList;
import java.util.List;
 
/**
 * @author Sebasssiu
 *
 */
public class Nodo {
    private String ciudad;
    private List<Edge> edges;
    private int numero;
 
    public Nodo(String ciudad) {
        this.ciudad = ciudad;
    }

 
    public String getciudad() {
        return ciudad;
    }
 
    public void setciudad(String ciudad) {
        this.ciudad = ciudad;
    }
 
    public List<Edge> getEdges() {
        return edges;
    }
 
    public void addEdge(Edge edge) {
        if (edges == null) {
            edges = new ArrayList<>();
        }
        edges.add(edge);
    }
    
 
    /**
	 * @return the adyacente
	 */
	public int getAdyacente() {
		return numero;
	}

	/**
	 * @param adyacente the adyacente to set
	 */
	public void setAdyacente(int adyacente) {
		this.numero = adyacente;
	}

	@Override
    public String toString() {
        return "\n \tNode [ciudad=" + ciudad + ", edges=" + edges + "]";
    }
}