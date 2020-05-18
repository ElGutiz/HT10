
import networkx as nx
        
def ruta():
    
    graf = nx.DiGraph()

    archivo = open("guategrafo.txt", "r")
    contenido = archivo.readlines()
    archivo.close()

    for lineas in contenido:
        string = lineas.split(" ")
        graf.add_node(string[0])
        graf.add_node(string[1])
        graf.add_edge(string[0],string[1],weight=float(string[2]))


    path = nx.floyd_warshall_predecessor_and_distance(graf)
    nodos = graf.nodes()
    
    ciudadI = input("Ingrese la ciudad de la cual desea partir: ")
    while ciudadI not in graf.nodes():
        print ("La ciudad que ingreso no se encuentra en la base de datos")
        ciudadI = input("Ingrese la ciudad de la cual desea partir: ")

    ciudadD = input("Indique la ciudad de destino: ")

    while ciudadD not in graf.nodes():
        print ("La ciudad que ingreso no se encuentra en la base de datos")
        ciudadD = input("Indique la ciudad de destino: ")

    

    try:
        predecesor1 = path[0][ciudadI][ciudadD]
        ciudades = []
        ciudades.append(predecesor1)
        #print predecesor1
        cont = 0
        if predecesor1!=ciudadI:
            while cont == 0:
                predecesor = path[0][ciudadI][predecesor1]
                ciudades.append(predecesor)
                predecesor1 = predecesor
                if predecesor1 == ciudadI:
                    cont = 1
                else:
                    predecesor1 = predecesor
                    #print predecesor1

        imprimir = []
        for i in reversed(ciudades):
            if ciudadI!=i:
                imprimir.append(i)
                
        print ("La ruta mas corta de ", ciudadI, " a ", ciudadD, " es por: ")
        print (ciudadI, "-> "+"-> ".join(imprimir),"->", ciudadD)

        print ("La distancia en kilometros es: ")
        print (path[1][ciudadI][ciudadD])
    except:
        print ("No existen rutas entre esas ciudades")
    
def centroGrafo():
    graf = nx.DiGraph()

    archivo = open("guategrafo.txt", "r")
    contenido = archivo.readlines()
    archivo.close()

    for lineas in contenido:
        string = lineas.split(" ")
        graf.add_node(string[0])
        graf.add_node(string[1])
        graf.add_edge(string[0],string[1],weight=float(string[2]))
        
    Centro = nx.center(graf, e=None)
    print("Centro del grafo: "+", ".join(Centro)) 
                                
def add(origen, destino, distancia):
    archivo = open("guategrafo.txt", "w")
    archivo.write(origen + " " + destino + " " + distancia+"km" + "\n")
    archivo.close()
    
def remove(origen, destino, distancia):
    f = open("guategrafo.txt","r")
    lines = f.readlines()
    f.close()
    
    file = open("guategrafo.txt","w")
    for line in lines: 
        if line!= origen+" "+destino+" "+distancia: 
            file.write(line)
        
    file.close() 