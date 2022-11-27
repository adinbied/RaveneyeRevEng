package dji.thirdparty.afinal.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class ArrayDeque<E>
  extends AbstractCollection<E>
  implements Deque<E>, Cloneable, Serializable
{
  private static final int MIN_INITIAL_CAPACITY = 8;
  private static final long serialVersionUID = 2340985798034038923L;
  private transient E[] elements;
  private transient int head;
  private transient int tail;
  
  public ArrayDeque()
  {
    this.elements = ((Object[])new Object[16]);
  }
  
  public ArrayDeque(int paramInt)
  {
    allocateElements(paramInt);
  }
  
  public ArrayDeque(Collection<? extends E> paramCollection)
  {
    allocateElements(paramCollection.size());
    addAll(paramCollection);
  }
  
  /* Error */
  private void allocateElements(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private void checkInvariants() {}
  
  private <T> T[] copyElements(T[] paramArrayOfT)
  {
    return null;
  }
  
  private boolean delete(int paramInt)
  {
    return false;
  }
  
  /* Error */
  private void doubleCapacity()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readObject(java.io.ObjectInputStream arg1)
    throws java.io.IOException, java.lang.ClassNotFoundException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void writeObject(java.io.ObjectOutputStream arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  /* Error */
  public void addFirst(E arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addLast(E arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ArrayDeque<E> clone()
  {
    return null;
  }
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  public Iterator<E> descendingIterator()
  {
    return new DescendingIterator(null);
  }
  
  public E element()
  {
    return (E)getFirst();
  }
  
  public E getFirst()
  {
    return null;
  }
  
  public E getLast()
  {
    return null;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<E> iterator()
  {
    return new DeqIterator(null);
  }
  
  public boolean offer(E paramE)
  {
    return offerLast(paramE);
  }
  
  public boolean offerFirst(E paramE)
  {
    addFirst(paramE);
    return true;
  }
  
  public boolean offerLast(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public E peek()
  {
    return (E)peekFirst();
  }
  
  public E peekFirst()
  {
    return (E)this.elements[this.head];
  }
  
  public E peekLast()
  {
    return null;
  }
  
  public E poll()
  {
    return (E)pollFirst();
  }
  
  public E pollFirst()
  {
    return null;
  }
  
  public E pollLast()
  {
    return null;
  }
  
  public E pop()
  {
    return (E)removeFirst();
  }
  
  public void push(E paramE)
  {
    addFirst(paramE);
  }
  
  public E remove()
  {
    return (E)removeFirst();
  }
  
  public boolean remove(Object paramObject)
  {
    return removeFirstOccurrence(paramObject);
  }
  
  public E removeFirst()
  {
    return null;
  }
  
  public boolean removeFirstOccurrence(Object paramObject)
  {
    return false;
  }
  
  public E removeLast()
  {
    return null;
  }
  
  public boolean removeLastOccurrence(Object paramObject)
  {
    return false;
  }
  
  public int size()
  {
    return 0;
  }
  
  public Object[] toArray()
  {
    return null;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return null;
  }
  
  private class DeqIterator
    implements Iterator<E>
  {
    private int cursor = ArrayDeque.this.head;
    private int fence = ArrayDeque.this.tail;
    private int lastRet = -1;
    
    private DeqIterator() {}
    
    public boolean hasNext()
    {
      return false;
    }
    
    public E next()
    {
      return null;
    }
    
    /* Error */
    public void remove()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private class DescendingIterator
    implements Iterator<E>
  {
    private int cursor = ArrayDeque.this.tail;
    private int fence = ArrayDeque.this.head;
    private int lastRet = -1;
    
    private DescendingIterator() {}
    
    public boolean hasNext()
    {
      return false;
    }
    
    public E next()
    {
      return null;
    }
    
    /* Error */
    public void remove()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\core\ArrayDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */