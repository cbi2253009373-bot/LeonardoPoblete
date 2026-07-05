public interface Lista<E> extends Iterable<E>{
  public int numElementos();//listo
  public void agregarElemento(E elemento);//listo
  public void agregarInicio(E elemento);//listo
  public void agregarFinal(E elemento);//lsito
  public void agregarPosicion(E elemento, int pos);//listo
  public E eliminarElemento();//listo
  public E eliminarFinal();//listo
  public E eliminarInicio();//listo
  public E eliminarPosicion(int pos);//listo
  public void vaciarLista();//listo
  public E consultarElementos(int pos);
  public boolean esVacia();//listo
}
