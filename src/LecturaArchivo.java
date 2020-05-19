import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class LecturaArchivo {
	File archivo = null;
    FileReader fr = null;
    Grafo grafo = new Grafo();
    BufferedReader br = null;
	public Grafo LeerTxt() 
	{
		// Leer el archivo para mandarlo a la lista de operaciones
				int cont = 0;
				try {
					// Apertura del fichero y creacion de BufferedReader para poder
			         // hacer una lectura comoda (disponer del metodo readLine()).
					String path = System.getProperty("user.dir");
			        archivo = new File ( path + "\\guategrafo.txt");
			        fr = new FileReader (archivo);
			        br = new BufferedReader(fr);

			        // Lectura del fichero
			         String linea;
			         String[] a;
			         int contadorT = 0;
			         
			         while((linea=br.readLine())!=null)
			         {
			        	 int contador = 0;
				         int contador1 = 0;
				         
			        	 a = linea.split(" ");
			        	 
			        	 try {
				        	 for (int k = 0; k < grafo.getNodos().size(); k++) {
				        		 if(grafo.getNodos().get(k).getciudad().equals(a[0].toLowerCase())) {
				        			 contador = k;
				        		 }
				        		 if(grafo.getNodos().get(k).getciudad().equals(a[1].toLowerCase())) {
				        			 contador1 = k;
				        		 }
				        	 }
			        	 }catch(Exception e) {
			        		 
			        	 }
			        	 
			        	 
			        	 
			        	 
			        	 if(contador1 != 0 || contador != 0) {
			        		 if(contador != 0) {
			        			 Nodo nodo = new Nodo(a[1].toLowerCase());
			        			 Nodo distancia = new Nodo(a[2].toLowerCase());
			        			 nodo.setAdyacente(contadorT+1);
			        			 distancia.setAdyacente(Integer.parseInt(a[2]));
			        			 grafo.getNodos().get(contador).addEdge(new Edge(grafo.getNodos().get(contador), nodo, distancia));
			        			 grafo.addNodo(nodo);
			        			 contadorT++;
			        		 }
			        		 if(contador1 != 0) {
			        			 Nodo nodo = new Nodo(a[0].toLowerCase());
			        			 nodo.setAdyacente(contadorT+1);
			        			 Nodo distancia = new Nodo(a[2].toLowerCase());
			        			 distancia.setAdyacente(Integer.parseInt(a[2]));
			        			 nodo.addEdge(new Edge(nodo, grafo.getNodos().get(contador1), distancia));
			        			 grafo.addNodo(nodo);
			        			 contadorT++;
			        		 }
			        	 }
			        	 if(contador1 != 0 && contador != 0) {
			        		 Nodo distancia = new Nodo(a[2].toLowerCase());
			        		 distancia.setAdyacente(Integer.parseInt(a[2]));
			        		 grafo.getNodos().get(contador).addEdge(new Edge(grafo.getNodos().get(contador), grafo.getNodos().get(contador1), distancia));
			        		
			        	 }
			        	 if(contador1 == 0 && contador == 0) {
			        		 Nodo nodo = new Nodo(a[0].toLowerCase());
			        		 nodo.setAdyacente(contadorT+1);
			        		 Nodo nodo1 = new Nodo(a[1].toLowerCase());
			        		 nodo1.setAdyacente(contadorT+2);
		        			 Nodo distancia = new Nodo(a[2]);
		        			 distancia.setAdyacente(Integer.parseInt(a[2]));
		        			 nodo.addEdge(new Edge(nodo, nodo1, distancia));
		        			 grafo.addNodo(nodo);
		        			 grafo.addNodo(nodo1);
		        			 contadorT += 2;
			        	 }
			        	 
			         }
			         
			         
		        } catch (Exception ex) 
				{
		            ex.printStackTrace();
		        }finally
				{
		            // En el finally cerramos el fichero, para asegurarnos
		            // que se cierra tanto si todo va bien como si salta 
		            // una excepcion.
		            try
		            {                    
		               if( null != fr ){   
		                  fr.close();     
		               }                  
		            }catch (Exception e2){ 
		               e2.printStackTrace();
		            }
		         }
				return grafo;
				
			}
}
