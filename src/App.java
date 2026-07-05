public class App {
    public static void main(String[] args) throws Exception {
     
        System.out.println("Creando Listas con Arreglos  (ArrayList)");
          // Crear una lista de alumnos con capacidad 3
        Arraylist<Alumnos> listaAlumnos = new Arraylist<>(3);

        // Verificar si la lista está vacía
        System.out.println("¿La lista está vacía? " + listaAlumnos.esVacia());
        System.out.println("Número de alumnos: " + listaAlumnos.numElementos());
        System.out.println(listaAlumnos);
        System.out.println("Agregando alumnos");
        //Agregando alumnos a  mi lista
        Alumnos a1 = new Alumnos(10000, "Hugo Roque", 9.5);
        Alumnos a2 = new Alumnos(10001, "Ana Pérez", 8.7);
        Alumnos a3 = new Alumnos(10002, "Luis Carmona", 9.0);
        Alumnos a4 = new Alumnos(10003, "María López", 9.2);
        Alumnos a5 = new Alumnos(10004, "Carlos Gómez", 8.9);
        
        //Agregando al inicio de la lista
        listaAlumnos.agregarInicio(a3);
        System.out.println("Agregamos al inicio de la lista");
        System.out.println(a3);
        System.out.println("");
        
        //Agregando al final de la lista
        listaAlumnos.agregarFinal(a1);
        listaAlumnos.agregarFinal(a2);
        System.out.println("Agregamos al final de la lista");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("");

        //Agregando en una posición específica
        listaAlumnos.agregarPosicion(a4, 2);
        System.out.println("Agregamos en la posición 2: ");
        System.out.println(a4);
        System.out.println("Agregamos un elemento a la lista");
        listaAlumnos.agregarElemento(a5);
        System.out.println(a5);
        System.out.println("");
        
        //Consultadno elemeneto
        System.out.println("Consultando elemento en la posición 1: ");
        Alumnos alumnoConsultado = listaAlumnos.consultarElementos(1);
        System.out.println(alumnoConsultado);
        System.out.println("");

        // Mostrando la lista
        System.out.println("¿La lista está vacía? " + listaAlumnos.esVacia());
        System.out.println("Número de alumnos: " + listaAlumnos.numElementos());
        System.out.println(listaAlumnos);
        System.out.println("");

        //Eliminando un elemento
        Alumnos a=listaAlumnos.eliminarInicio();
        System.out.println("Alumno Eliminado");
        System.out.println(a);
        System.out.println("");
        Alumnos b=listaAlumnos.eliminarFinal();
        System.out.println("Alumno Eliminado");
        System.out.println(b);
        System.out.println("");
        Alumnos c=listaAlumnos.eliminarElemento();
        System.out.println("Alumno Eliminado");
        System.out.println(c);
        System.out.println("");
        Alumnos d = listaAlumnos.eliminarPosicion(2);
        System.out.println("Alumno Eliminado");
        System.out.println(d);
        System.out.println("");
        
        //esvacia
        System.out.println("¿La lista está vacía? " + listaAlumnos.esVacia());
        //implemente el tostring
        // Mostrando la lista despues de la eliminacion
        System.out.println("Número de alumnos: " + listaAlumnos.numElementos());
        System.out.println(listaAlumnos);
    }
    
}

