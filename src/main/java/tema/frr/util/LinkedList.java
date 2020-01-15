package tema.frr.util;

public class LinkedList<E> {
  Node first;
  Node last;
  int size;
  
  static class Node {
    Object value;
    Node next;
  }
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if (first == null) {
      first = last = newNode;
    } else { 
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
        return cursor.value;
  }
  
  public void add(int index, Object value) {
    if (index < 0 || index >= size)
      return;
    
    Node newNode = new Node(); 
    newNode.value = value;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    } 
    
    if (index == 0) {
      newNode.next = cursor;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    
    this.size++;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    } 
    
    Node deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else { 
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }
    
    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    } 
    
    Node deletedNode = null;
    if (index == 0) {
      deletedNode.value = first.value;
      first.value = value;
      return deletedNode.value;
    }
    
  }
}
