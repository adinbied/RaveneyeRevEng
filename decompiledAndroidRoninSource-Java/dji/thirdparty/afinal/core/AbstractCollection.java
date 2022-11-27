package dji.thirdparty.afinal.core;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E>
  implements Collection<E>
{
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    return false;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return false;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public abstract Iterator<E> iterator();
  
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
  
  public abstract int size();
  
  public Object[] toArray()
  {
    return null;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\core\AbstractCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */