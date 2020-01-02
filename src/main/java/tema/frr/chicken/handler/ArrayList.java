package tema.frr.chicken.handler;

import java.util.Arrays;
import tema.frr.chicken.domain.Client;

public class ArrayList {
  
  static final int DEFAULT_CAPACITY = 2;
  Object[] list;
  int size = 0;
  
  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }
  
  public void add(Object obj) {
    if (this.list.length == size) {
      int oldCapacity = this.size;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = obj;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
}
