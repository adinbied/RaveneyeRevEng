package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E>
  implements List<E>, RandomAccess
{
  private final List<E> immutableList;
  
  private ImmutableList(List<E> paramList)
  {
    this.immutableList = Collections.unmodifiableList(paramList);
  }
  
  public static <E> ImmutableList<E> from(List<E> paramList)
  {
    return new ImmutableList(paramList);
  }
  
  public static <E> ImmutableList<E> from(E... paramVarArgs)
  {
    return new ImmutableList(Arrays.asList(paramVarArgs));
  }
  
  public void add(int paramInt, E paramE)
  {
    this.immutableList.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    return this.immutableList.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    return this.immutableList.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    return this.immutableList.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.immutableList.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.immutableList.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.immutableList.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.immutableList.equals(paramObject);
  }
  
  public E get(int paramInt)
  {
    return (E)this.immutableList.get(paramInt);
  }
  
  public int hashCode()
  {
    return this.immutableList.hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return this.immutableList.indexOf(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.immutableList.isEmpty();
  }
  
  public Iterator<E> iterator()
  {
    return this.immutableList.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return this.immutableList.lastIndexOf(paramObject);
  }
  
  public ListIterator<E> listIterator()
  {
    return this.immutableList.listIterator();
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    return this.immutableList.listIterator(paramInt);
  }
  
  public E remove(int paramInt)
  {
    return (E)this.immutableList.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    return this.immutableList.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.immutableList.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.immutableList.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    return (E)this.immutableList.set(paramInt, paramE);
  }
  
  public int size()
  {
    return this.immutableList.size();
  }
  
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return this.immutableList.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray()
  {
    return this.immutableList.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.immutableList.toArray(paramArrayOfT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */