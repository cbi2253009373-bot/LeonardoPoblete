import java.util.Iterator;

import javax.management.remote.NotificationResult;

public class LinkedList<E> implements Lista<E> {

	private class Nodo<E> {

		private Nodo<E> siguiente= null;
        private E info=null;

		Nodo(Nodo<E> siguiente, E info) {
            this.siguiente = siguiente;
            this.info = info;
        }
    
        Nodo<E> getSiguiente() {
            return siguiente;
        }
    
        void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
    
        E getInfo() {
            return info;
        }
    
        void setInfo(E info) {
            this.info = info;
        }
    }

	private Nodo<E> primero=null; 
	private Nodo<E> ultimo=null; 		
	private int tamanio=0;


	@Override
	public void agregarElemento(E e) {
    agregarFinal(e);
	}

	@Override
	public void agregarInicio(E e) {
     Nodo <E> aux = new Nodo<E>(null,e);
	  if (esVacia()){
		  primero=aux;
		  ultimo=aux;
		}else{
			aux.setSiguiente(primero);
			primero=aux;
		}
		aux = null;
		tamanio++;
	}

	@Override
	public void agregarFinal(E e) {
	 Nodo <E> aux = new Nodo<E>(null,e);
	 if (esVacia()){
		primero = aux;
		ultimo = aux;
	 }else{
		ultimo.setSiguiente(aux);
		ultimo = aux;
	 }
	 aux = null;
	 tamanio++;
	}

	@Override
	public void agregarPosicion(E e, int posicion) {
    Nodo<E> aux = null;
    Nodo<E> nuevo = new Nodo<E>(null, e);
    if (posicion >= 0 && posicion <= tamanio) {
        if (tamanio == 0) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            if (posicion == 0){
                nuevo.setSiguiente(primero);
                primero = nuevo;
            } else {
                aux = primero;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
                if (nuevo.getSiguiente() == null) {
                    ultimo = nuevo;
                }
            }
        }
        tamanio++;
    } else {
        throw new IndexOutOfBoundsException();
    }
	}

	@Override
	public E eliminarElemento() {
		return eliminarElementoFinal();
	}

	@Override
	public E eliminarElementoInicio() {
     Nodo <E> eliminado = null;
	 E datoEliminado = null;
	 if(esVacia()){
	 	throw new NullPointerException();
     	}else{
		if(tamanio == 1){
			eliminado = primero;
			datoEliminado = eliminado.getInfo();
			primero = null;
			ultimo=null;
			tamanio--;
			return datoEliminado;
		}else{
         eliminado = primero;
	     datoEliminado = eliminado.getInfo();
	     primero = primero.getSiguiente();
		 eliminado.setSiguiente(null);
		 tamanio--;
	     return datoEliminado;
		}
	  }
	  
    }

	@Override
	public E eliminarElementoFinal() {
	 Nodo <E> iterador = null;
     Nodo <E> aux =  null;
	 Nodo <E> eliminado = null;
	 E datoEliminado = null;
	 if(esVacia()){
		throw new NullPointerException();
	 }else{
		if(tamanio == 1 ){
			eliminado = primero;
			datoEliminado = eliminado.getInfo();
			primero = null;
			ultimo = null;
			tamanio--;
			return datoEliminado;
		}else{
			iterador = primero;
			while (iterador.getSiguiente()!= ultimo){
				iterador = iterador.getSiguiente();
			}
			eliminado = ultimo;
			datoEliminado = eliminado.getInfo();
			ultimo = iterador;
			ultimo.setSiguiente(null);
			eliminado = null;
			iterador = null;
			tamanio--;
			return datoEliminado;
		}
	 }
	}

	@Override
	public E eliminarElementoPosicion(int posicion) {
	 Nodo <E> aux = null;
	 Nodo <E> eliminado = null;
	 E datoEliminado = null;
	 if (esVacia()){
		throw new NullPointerException();
	  }else{
	   if(posicion>= 0 && posicion<tamanio){
		 if(tamanio == 1 ){
			eliminado = primero;
			datoEliminado = eliminado.getInfo();
			primero = null;
			ultimo = null;
		 }else{
          if (posicion == 0){
			eliminado = primero;
            primero = primero.getSiguiente();
            eliminado.setSiguiente(null);
            datoEliminado = eliminado.getInfo();
		   }else{
			if(tamanio!=1){
		     aux = primero;
             for(int i = 0;i<posicion-1;i++){
				aux = aux.getSiguiente();
			 }
		     eliminado = aux.getSiguiente();
		     aux.setSiguiente(eliminado.getSiguiente());
			 if(eliminado == ultimo){
				ultimo = aux;
			 }
             eliminado.setSiguiente(null);
			 datoEliminado = eliminado.getInfo();
		    }
		   }
		 }
		    aux = null;
			eliminado = null;
			tamanio--;
			return datoEliminado;
		}else{
		 throw new IndexOutOfBoundsException();
	    }
	   }
	}
    
	@Override
	public boolean esVacia() {
		return tamanio==0;
	}

	@Override
	public int numElementos() {
		// TODO Auto-generated method stub
		return tamanio;
	}

	@Override
	public void limpiarLista() {
      Nodo<E> aux = primero;
      Nodo<E> eliminado = null;

      while (aux != null) {
        eliminado = aux;
        aux = aux.getSiguiente();
        eliminado.setSiguiente(null);
        eliminado = null;
       }

       primero = null;
       ultimo = null;
       tamanio = 0;
      
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] convertirArreglo() {

		Object[] arreglo = new Object[tamanio];
		Nodo<E> aux = primero;
		for(int i=0;aux!=null;i++){
			arreglo[i]=aux.getInfo();
			aux = aux.getSiguiente();
		}

		return (E[])arreglo;
	}

	@Override
	public E consultar(int posicion) {
		Nodo<E> aux = null;

    if (esVacia()) {
        throw new NullPointerException();
    } else {

        if (posicion >= 0 && posicion < tamanio) {

            aux = primero;

            for (int i = 0; i < posicion; i++) {
                aux = aux.getSiguiente();
            }

            return aux.getInfo();

        } else {
            throw new IndexOutOfBoundsException();
        }
    }
	}

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){

            Nodo<E> nodo= primero;
            @Override
            public boolean hasNext() {
                return nodo!=null;
            }

            @Override
            public E next() {
                E tmp=nodo.getInfo();
                nodo=nodo.getSiguiente();
                return tmp;
            }

        };
    }

}



