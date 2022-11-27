package org.bouncycastle.util;

public abstract interface Selector<T>
  extends Cloneable
{
  public abstract Object clone();
  
  public abstract boolean match(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\Selector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */