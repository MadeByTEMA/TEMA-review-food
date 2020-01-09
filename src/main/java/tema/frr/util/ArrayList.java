package tema.frr.util;

import java.util.Arrays;

public class ArrayList<E> {

  static final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public void add(E e) {
    if (this.list.length == size) {
      int oldCapacity = this.size;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = e;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index > this.size) {
      return null;
    }
    return (E) this.list[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index > this.size) {
      return null;
    }
    E old = (E) this.list[index];
    this.list[index] = e;
    return old;
  }

  public E remove(int index) {
    if (index < 0 || index > this.size)
      return null;
    @SuppressWarnings("unchecked")
    E old = (E) this.list[index];
    System.arraycopy(this.list, index + 1, this.list, index, this.size);
    this.size--;
    return old;
  }

  public int size() {
    return this.size;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if(arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
    }
    System.arraycopy(this.list, 0, arr, 0, this.size);
    return arr;
  }
}
