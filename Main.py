from funciones import *

opcion = ""
opcion1 = ""
while(opcion!="4"):
    opcion = input("1.Calcular la ruta mas corta\n2.Calcular el centro del grafo\n3.Agregar nueva ruta\n4.Salir\n")
    if (opcion=="1"):
        ruta()
    if (opcion=="2"):
        centroGrafo()
    if (opcion=="3"):
        opcion1 = input("1.Agregar ruta\n2.Eliminar ruta")
        origen = input("Ingrese la ciudad de origin: ")
        destino = input("Ingrese la ciudad de destino: ")
        distancia = input("Ingrese los kilometros entre ruta: ")
        if (opcion=="1"):
            add(origen,destino,distancia)
        if (opcion=="2"):
            remove(origen,destino,distancia)