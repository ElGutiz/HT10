import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrafoTest {

	@Test
	void test() {
		Grafo grafo = new Grafo();
		Nodo origen = new Nodo("Antigua");
		
		grafo.addNodo(origen);
		
		
		
		assertEquals(origen, grafo.getNodos().get(0));
	}

}
