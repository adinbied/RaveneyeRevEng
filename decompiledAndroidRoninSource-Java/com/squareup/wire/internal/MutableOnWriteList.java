package com.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

final class MutableOnWriteList<T>
  extends AbstractList<T>
  implements RandomAccess, Serializable
{
  private final List<T> immutableList;
  List<T> mutableList;
  
  MutableOnWriteList(List<T> paramList)
  {
    this.immutableList = paramList;
    this.mutableList = paramList;
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    return new ArrayList(this.mutableList);
  }
  
  public void add(int paramInt, T paramT)
  {
    if (this.mutableList == this.immutableList) {
      this.mutableList = new ArrayList(this.immutableList);
    }
    this.mutableList.add(paramInt, paramT);
  }
  
  public T get(int paramInt)
  {
    return (T)this.mutableList.get(paramInt);
  }
  
  public T remove(int paramInt)
  {
    if (this.mutableList == this.immutableList) {
      this.mutableList = new ArrayList(this.immutableList);
    }
    return (T)this.mutableList.remove(paramInt);
  }
  
  public T set(int paramInt, T paramT)
  {
    if (this.mutableList == this.immutableList) {
      this.mutableList = new ArrayList(this.immutableList);
    }
    return (T)this.mutableList.set(paramInt, paramT);
  }
  
  public int size()
  {
    return this.mutableList.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\internal\MutableOnWriteList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */