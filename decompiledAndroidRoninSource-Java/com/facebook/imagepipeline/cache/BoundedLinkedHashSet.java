package com.facebook.imagepipeline.cache;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class BoundedLinkedHashSet<E>
{
  private LinkedHashSet<E> mLinkedHashSet;
  private int mMaxSize;
  
  public BoundedLinkedHashSet(int paramInt)
  {
    this.mLinkedHashSet = new LinkedHashSet(paramInt);
    this.mMaxSize = paramInt;
  }
  
  public boolean add(E paramE)
  {
    try
    {
      if (this.mLinkedHashSet.size() == this.mMaxSize) {
        this.mLinkedHashSet.remove(this.mLinkedHashSet.iterator().next());
      }
      this.mLinkedHashSet.remove(paramE);
      boolean bool = this.mLinkedHashSet.add(paramE);
      return bool;
    }
    finally {}
  }
  
  public boolean contains(E paramE)
  {
    try
    {
      boolean bool = this.mLinkedHashSet.contains(paramE);
      return bool;
    }
    finally
    {
      paramE = finally;
      throw paramE;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\BoundedLinkedHashSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */