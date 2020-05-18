import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EliminarAristaTest {

	@Test
	void test() {
		Controlador con = new Controlador();
		Grafo grafo = new Grafo();
		Nodo origen = new Nodo("Antigua");
		Nodo destino = new Nodo("Escuintla");
		Nodo distancia = new Nodo("Distancia");
		origen.setAdyacente(1);
		destino.setAdyacente(2);
		distancia.setAdyacente(10);
		origen.addEdge(new Edge(origen, destino, distancia));
		grafo.addNodo(origen);
		grafo.addNodo(destino);
		
		
		
		
		grafo = con.eliminarRuta("Antigua", "Escuintla", grafo);
		
		assertEquals(0, grafo.getNodos().get(0).getEdges().size());
	}

}
