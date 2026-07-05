public class Alumnos {
    private int id;
    private String nombre;
    private double promedio;

    public Alumnos(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - Promedio: " + promedio;
    }
}
