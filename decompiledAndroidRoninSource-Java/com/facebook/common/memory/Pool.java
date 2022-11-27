package com.facebook.common.memory;

import com.facebook.common.references.ResourceReleaser;

public abstract interface Pool<V>
  extends ResourceReleaser<V>, MemoryTrimmable
{
  public abstract V get(int paramInt);
  
  public abstract void release(V paramV);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\Pool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */