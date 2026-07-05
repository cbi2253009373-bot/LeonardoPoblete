import java.util.Iterator;
public class Arraylist <E> implements Lista<E> {
    private int indice;
    private static final int MAX = 5;
    private Object[] datos;

    public Arraylist(int MAX) {
        this.indice = 0;
        this.datos = new Object[MAX];
    }
    public int numElementos() {
        return this.indice;
    }
    public boolean esVacia() {
        if (this.indice == 0) {
            return true;
        } else {
            return false;
        }
    }
    public void aseguramiento(){
        for (int i = 0; i < this.indice; i++) {
            this.datos[i] = null;
        }
    }

    public void vaciarLista() {
        if (!esVacia()) {
            aseguramiento();
            this.indice = 0;
        }
    }
    public void agregarFinal(E elemento) {
        if (this.indice >= this.datos.length){
            Object[] aux = new Object[datos.length + datos.length / 2];
            System.arraycopy(this.datos, 0, aux, 0, datos.length);
            this.datos = aux;
        }
        datos[this.indice] = elemento;
        this.indice++;
    }
    public void agregarInicio(E elemento) {
        if (this.indice < this.datos.length) {
            System.arraycopy(this.datos, 0, this.datos, 1, this.indice);
            this.datos[0] = elemento;
            this.indice++;
        } else {
            Object[] aux = new Object[this.datos.length + this.datos.length / 2];
            System.arraycopy(this.datos, 0, aux, 0, datos.length);
            this.datos = aux;
            System.arraycopy(this.datos, 0, this.datos, 1, this.indice);
            datos[0] = elemento;
            this.indice++;
        }
    }
    public void agregarPosicion(E elemento, int pos) {    
     Object[] aux = null;
        if (esVacia()){
         agregarInicio(elemento);
        }else{
         if (indice == datos.length){
           aux = new Object[datos.length + datos.length / 2];
           System.arraycopy(this.datos, 0, aux, 0, pos);
           System.arraycopy(this.datos, pos, aux, pos + 1, this.indice - pos);
           this.datos = aux;
           datos[pos] = elemento;
           this.indice++;
            }else{
           System.arraycopy(this.datos, pos, this.datos, pos + 1, this.indice - pos);
            }
        }


       if (pos>0 && pos < this.indice) {
        if (this.indice == datos.length) {
         aux = new Object[datos.length + datos.length / 2];
         System.arraycopy(this.datos, 0, aux, 0, pos);
         System.arraycopy(this.datos, pos, aux, pos + 1, this.indice - pos);
         this.datos = aux;
         datos[pos] = elemento;
         this.indice++;
         }else{
           throw new IndexOutOfBoundsException("Posición inválida");
            }
        }
    }
    public void agregarElemento(E elemento){
     agregarFinal(elemento);
    }
    public E eliminarElemento(){
     if(esVacia()){
       return null;
     }else{
          E elementoaeliminar = (E) this.datos[this.indice-1];
          this.datos[this.indice-1]= null;
          this.indice--;
          return elementoaeliminar;    
        }
    }
    public E eliminarFinal(){
        return eliminarElemento();
    }
    public E eliminarInicio(){
        Object [] aux = null; 
        if(!esVacia()){
            E elementoaeliminar2 = (E) this.datos[0];
            this.datos[0]=null;
            aux = new Object[datos.length];
            System.arraycopy(this.datos,1,aux,0,this.indice-1);
            this.datos = aux;
            this.indice--;
            return elementoaeliminar2;
        }else{
            return null;
        }
    }
    public E eliminarPosicion(int pos){
        Object [] aux = null;
        if(esVacia()){
            return null;
        }else{
            if(pos >= 0 && pos < this.indice){
                aux = new Object[datos.length];
               E elementoEliminado = (E) this.datos[pos];
               this.datos[pos]= null;
               System.arraycopy(this.datos,0,aux,0,pos);
               System.arraycopy(this.datos,pos+1,aux,pos,this.indice-pos-1);
               this.datos=aux;
               this.indice--;
               return elementoEliminado;
            }else{
                return null;
            }
        }
    }
    public E consultarElementos(int pos){
        if(esVacia()){
            return null;
        }else{
            if(pos >= 0 && pos < this.indice){
                return (E) this.datos[pos];
            }else{
                return null;
            }
        }
    }
    @Override
    public Iterator<E> iterator() {
      return new Iterator<E>() {
         int i = 0;
         @Override
         public boolean hasNext() {
            return i < indice;
         }
         @Override
         @SuppressWarnings("unchecked")
         public E next() {
            E aux = (E) datos[i];
            i++;
            return aux;
            }
        };
    }
    //puse el to string 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.indice; i++) {
            sb.append(this.datos[i]);
            if (i < this.indice - 1) {
                sb.append(",\n ");
            }
        }
        return sb.toString();
    }


}


