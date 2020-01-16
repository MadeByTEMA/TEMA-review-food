package tema.frr.util;

public interface List<E> {

  int size();

  void add(E e);

  void add(int index, E arr);

  E get(int index);

  E set(int index, E e);
  
  E remove(int index);

  Object[] toArray();

  E[] toArray(E[] arr);

}
