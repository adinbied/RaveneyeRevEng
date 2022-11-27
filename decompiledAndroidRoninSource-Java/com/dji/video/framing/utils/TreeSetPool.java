package com.dji.video.framing.utils;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetPool<T>
{
  private int capacity;
  private TreeSet<T> mTreeSet;
  
  public TreeSetPool(int paramInt, Comparator<T> paramComparator)
  {
    this.capacity = paramInt;
    this.mTreeSet = new TreeSet(paramComparator);
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public T obtain(T paramT)
  {
    return null;
  }
  
  /* Error */
  public void recycle(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\TreeSetPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */