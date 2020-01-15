package tema.frr.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {

  private static final int DEFAULT_CAPACITY = 10;

  Object[] elementData;
  int size;

  public Stack() {
    this.elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }
  
  public void push(E obj) {
    if (this.size == elementData.length) {
      grow();
    }
    
    elementData[this.size++] = obj;
  }

  public void grow() {
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }
  
  public int newCapacity() {
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }
  
  @SuppressWarnings("unchecked")
  public E pop() {
    if (empty())
      return null;
    E value = (E) this.elementData[--this.size];
    this.elementData[this.size] = null; // 가비지 주소값을 null로 바꿔준다.
    return value;
  }
  
  public boolean empty() {
    return this.size == 0;
  }
  
  /*
  @Override
  public Stack clone() {
    try {
      return (Stack) super.clone();
    } catch(CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */
  
  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
      Stack<E> temp = (Stack<E>) super.clone();
      Object[] arr = new Object[this.size];
      for (int i = 0; i < this.size; i++) {
        arr[i] = elementData[i];
      }
      temp.elementData = arr;
      return temp;
      
    } catch(CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
}
