public class App {
    public static void main(String[] args) throws Exception {
     
        System.out.println("Creando Listas con Arreglos  (ArrayList)");
          // Crear una lista de alumnos con capacidad 3
        Arraylist<Alumnos> listaAlumnos = new Arraylist<>(3);

        // Verificar si la lista está vacía
        System.out.println("¿La lista está vacía? " + listaAlumnos.esVacia());
        System.out.println("Número de alumnos: " + listaAlumnos.numElementos());
        System.out.println(listaAlumnos);

        //Agregando alumnos a  mi lista
        listaAlumnos.agregarFinal(new Alumnos(10000, "Hugo Roque", 9.5));
        listaAlumnos.agregarFinal(new Alumnos(10001, "Ana Pérez", 8.7));
        listaAlumnos.agregarFinal(new Alumnos(10002, "Luis Carmona", 9.0));

        // Mostrando la lista
        System.out.println("¿La lista está vacía? " + listaAlumnos.esVacia());
        System.out.println("Número de alumnos: " + listaAlumnos.numElementos());
        System.out.println(listaAlumnos);

        //Eliminando un elemento
        Alumnos a=listaAlumnos.eliminarInicio();
        System.out.println("Alumno Eliminado");
        System.out.println(a);

        //implemente el tostring
        // Mostrando la lista despues de la eliminacion
        System.out.println("Número de alumnos: " + listaAlumnos.numElementos());
        System.out.println(listaAlumnos);
    }
    
}

