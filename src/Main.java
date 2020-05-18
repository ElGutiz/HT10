import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sr = new Scanner(System.in);
		Controlador cont = new Controlador();
		Grafo grafo = new Grafo();
		LecturaArchivo archivo = new LecturaArchivo();
		grafo = archivo.LeerTxt();
		int opcion = 0;
		
		
		//FALTA ARREGLAR QUE ELIMINE ARISTAS
		
		while(opcion != 4) {
			System.out.println("Opciones: ");
			System.out.println("1.Buscar ruta mas corta a ciudad ingresada \n2.Ciudad que queda en el centro \n3.Modificar rutas por problemas de trafico, derrumbes, etc. \n4.Salir");
			opcion = Integer.parseInt(sr.nextLine());
			if(opcion == 1) {
				try {
					System.out.print("Ingrese ciudad de origen: ");
					String ciudadOrigen = sr.nextLine();
					System.out.print("Ingrese ciudad de destino: ");
					String ciudadDestino = sr.nextLine();
					//Funcion que encuentra ruta mas corta entre ambas ciudades
					cont.hallarDistancia(grafo.getNodos(), ciudadOrigen.toLowerCase(), ciudadDestino.toLowerCase());
				}catch(Exception e) {
					System.out.println("Instruccion incorrecta");
				}
			}
			if(opcion == 2) {
				//Funcion centro del grafo
				try {
					System.out.println("======================Centro graf====================");
					System.out.println(cont.getCenter(grafo.getNodos()));
					System.out.println("=====================================================");
				}catch(Exception e) {
					System.out.println("Error");
				}
			}
			if(opcion == 3) {
				//Modificar los grafos
				try {
					System.out.println("=====================================================");
					System.out.println("Opciones: ");
					System.out.println("1.Descartar ruta por trafico \n 2.Agregar nueva ruta");
					int opcion1 = Integer.parseInt(sr.nextLine());
					System.out.print("Ingrese ciudad de origen: ");
					String ciudadOrigen = sr.nextLine();
					System.out.print("Ingrese ciudad de destino: ");
					String ciudadDestino = sr.nextLine();
					if(opcion1 == 1) {
						grafo = cont.eliminarRuta(ciudadOrigen, ciudadDestino, grafo);
						System.out.println("Ruta eliminada Exitosamente!!");
					}
					else if(opcion1 == 2) {
						System.out.print("Ingrese distancia entre ciudades: ");
						int distancia = Integer.parseInt(sr.nextLine());
						grafo = cont.agregarRuta(ciudadOrigen, ciudadDestino, grafo, distancia);
						System.out.println("Ruta agregada exitosamente!!");
					}else {
						System.out.println("Instruccion incorrecta");
					}
				}catch(Exception e) {
					System.out.println("Instruccion incorrecta");
				}
				System.out.println("=====================================================");
			}
			if(opcion == 4) {
				System.out.println("Gracias por utilizar nuestro algoritmo de rutas para el COVID-19.");
			}
		}
	}
}
