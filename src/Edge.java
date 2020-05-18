public class Edge {
    private Nodo origen;
    private Nodo destino;
    private Nodo distancia;
 
    public Edge(Nodo origen, Nodo destino, Nodo distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
 
    public Nodo getorigen() {
        return origen;
    }
    public void Distancia(Nodo distancia) {
        this.distancia = distancia;
    }
 
    public void setorigen(Nodo origen) {
        this.origen = origen;
    }
 
    public Nodo getdestino() {
        return destino;
    }
 
    public void setdestino(Nodo destino) {
        this.destino = destino;
    }
 
    public Nodo getdistancia() {
        return distancia;
    }
 
    @Override
    public String toString() {
        return "\n Edge [Origen=" + origen.getciudad() + ", destino=" + destino.getciudad() + ", distancia="
                + distancia.getAdyacente() + "]";
    }
 
}