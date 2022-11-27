package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T>
  extends AtomicInteger
  implements List<T>, RandomAccess
{
  private static final long serialVersionUID = 3972397474470203923L;
  final ArrayList<T> list;
  
  public VolatileSizeArrayList()
  {
    this.list = new ArrayList();
  }
  
  public VolatileSizeArrayList(int paramInt)
  {
    this.list = new ArrayList(paramInt);
  }
  
  /* Error */
  public void add(int arg1, T arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean add(T paramT)
  {
    return false;
  }
  
  public boolean addAll(int paramInt, Collection<? extends T> paramCollection)
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
    //   2: goto -2 -> 0
  }
  
  public boolean contains(Object paramObject)
  {
    return this.list.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.list.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public T get(int paramInt)
  {
    return (T)this.list.get(paramInt);
  }
  
  public int hashCode()
  {
    return this.list.hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return this.list.indexOf(paramObject);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<T> iterator()
  {
    return this.list.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return this.list.lastIndexOf(paramObject);
  }
  
  public ListIterator<T> listIterator()
  {
    return this.list.listIterator();
  }
  
  public ListIterator<T> listIterator(int paramInt)
  {
    return this.list.listIterator(paramInt);
  }
  
  public T remove(int paramInt)
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
  
  public T set(int paramInt, T paramT)
  {
    return (T)this.list.set(paramInt, paramT);
  }
  
  public int size()
  {
    return get();
  }
  
  public List<T> subList(int paramInt1, int paramInt2)
  {
    return this.list.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray()
  {
    return this.list.toArray();
  }
  
  public <E> E[] toArray(E[] paramArrayOfE)
  {
    return this.list.toArray(paramArrayOfE);
  }
  
  public String toString()
  {
    return this.list.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\VolatileSizeArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */