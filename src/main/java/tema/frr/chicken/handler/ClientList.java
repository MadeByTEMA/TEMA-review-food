package tema.frr.chicken.handler;

import java.util.Arrays;
import tema.frr.chicken.domain.Client;

public class ClientList {
  
  static final int DEFAULT_CAPACITY = 2;
  Client[] list;
  int size = 0;
  
  public ClientList() {
    this.list = new Client[DEFAULT_CAPACITY];
  }
  
  public void add(Client client) {
    if (this.list.length == size) {
      int oldCapacity = this.size;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      /*
      Client[] arr = new Client[newCapacity];
      for(int i = 0; i < this.size; i++) {
        arr[i] = this.list[i];
      }
      this.list = arr;
      */
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = client;
  }
  
  public Client[] toArray() {
    /*
    Client[] clients = new Client[this.size];
    for (int i = 0; i < this.size; i++) {
      clients[i] = this.list[i];
    }
    return clients;
    */
    return Arrays.copyOf(this.list, this.size);
  }
}
