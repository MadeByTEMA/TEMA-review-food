package tema.frr.util;

public abstract class AbstractList<E> {

  protected int size;

  public abstract int size();

  public abstract void add(E e);

  public abstract void add(int index, E arr);

  public abstract E get(int index);

  public abstract E set(int index, E e);
  
  public abstract E remove(int index);

  public abstract Object[] toArray();

  public abstract E[] toArray(E[] arr);

}
