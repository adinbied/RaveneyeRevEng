package com.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

final class ImmutableList<T>
  extends AbstractList<T>
  implements RandomAccess, Serializable
{
  private final ArrayList<T> list;
  
  ImmutableList(List<T> paramList)
  {
    this.list = new ArrayList(paramList);
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public T get(int paramInt)
  {
    return (T)this.list.get(paramInt);
  }
  
  public int size()
  {
    return this.list.size();
  }
  
  public Object[] toArray()
  {
    return this.list.toArray();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\internal\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */