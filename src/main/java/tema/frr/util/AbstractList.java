package tema.frr.util;

public abstract class AbstractList<E> implements List<E> {

  protected int size;
  
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {
    return this.new ListIterator<E>();
  }
  
  public class ListIterator<E> implements Iterator<E> {

    List<E> list;
    int cursor;

    @SuppressWarnings("unchecked")
    public ListIterator() {
      this.list = (List<E>) AbstractList.this;
    }

    @Override
    public boolean hasNext() {
      return cursor < list.size();
    }

    @Override
    public E next() {
      return list.get(cursor++);
    }
  }
}
