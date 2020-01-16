package tema.frr.util;

public class QueueIterator<E> implements Iterator<E>{
  
  Queue<E> queue;
  
  public QueueIterator(Queue<E> queue) {
    this.queue = queue.clone();
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
