package org.bouncycastle.util;

public abstract interface Memoable
{
  public abstract Memoable copy();
  
  public abstract void reset(Memoable paramMemoable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\Memoable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */