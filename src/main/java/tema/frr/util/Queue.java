package tema.frr.util;

public class Queue<E> extends LinkedList<E> implements Cloneable{

  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return (E) this.remove(0);
  }
  
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    
    for (int i = 0; i < size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
  
  public Iterator<E> iterator() {
    
    class QueueIterator<E> implements Iterator<E>{
      
      Queue<E> queue;
      
      @SuppressWarnings("unchecked")
      public QueueIterator() {
        this.queue = (Queue<E>) Queue.this.clone();
      }
      
      @Override
      public boolean hasNext() {
        return queue.size > 0;
      }

      @Override
      public E next() {
        // TODO Auto-generated method stub
        return queue.get(0);
      }
      
    }
    
    return new QueueIterator<E>();
  }

}
