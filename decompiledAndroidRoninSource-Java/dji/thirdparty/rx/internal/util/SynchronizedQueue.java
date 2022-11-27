package dji.thirdparty.rx.internal.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedQueue<T>
  implements Queue<T>
{
  private final LinkedList<T> list = new LinkedList();
  private final int size;
  
  public SynchronizedQueue()
  {
    this.size = -1;
  }
  
  public SynchronizedQueue(int paramInt)
  {
    this.size = paramInt;
  }
  
  public boolean add(T paramT)
  {
    return false;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    return false;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Object clone()
  {
    return null;
  }
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return false;
  }
  
  public T element()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return this.list.hashCode();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<T> iterator()
  {
    return null;
  }
  
  public boolean offer(T paramT)
  {
    return false;
  }
  
  public T peek()
  {
    return null;
  }
  
  public T poll()
  {
    return null;
  }
  
  public T remove()
  {
    return null;
  }
  
  public boolean remove(Object paramObject)
  {
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return false;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
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
  
  public <R> R[] toArray(R[] paramArrayOfR)
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\SynchronizedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */