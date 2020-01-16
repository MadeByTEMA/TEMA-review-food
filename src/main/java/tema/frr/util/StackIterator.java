package tema.frr.util;

public class StackIterator<E> implements Iterator<E> {

  Stack<E> stack;
  
  public StackIterator(Stack<E> stack) {
    this.stack = stack.clone();
  }
  
   @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return !stack.empty();
  }

  @Override
  public E next() {
    // TODO Auto-generated method stub
    return stack.pop();
  }
}
