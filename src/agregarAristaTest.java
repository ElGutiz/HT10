

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class agregarAristaTest {

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
		grafo.addNodo(origen);
		grafo.addNodo(destino);
		
		
		Edge ed = new Edge(origen, destino, distancia);
		
		grafo = con.agregarRuta("Antigua", "Escuintla", grafo, 10);
		
		assertEquals(ed.getdestino(), grafo.getNodos().get(0).getEdges().get(0).getdestino());
	}

}
