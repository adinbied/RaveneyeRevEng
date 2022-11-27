package io.reactivex.internal.util;

public final class OpenHashSet<T>
{
  private static final int INT_PHI = -1640531527;
  T[] keys;
  final float loadFactor;
  int mask;
  int maxSize;
  int size;
  
  public OpenHashSet()
  {
    this(16, 0.75F);
  }
  
  public OpenHashSet(int paramInt)
  {
    this(paramInt, 0.75F);
  }
  
  public OpenHashSet(int paramInt, float paramFloat)
  {
    this.loadFactor = paramFloat;
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.maxSize = ((int)(paramFloat * paramInt));
    this.keys = ((Object[])new Object[paramInt]);
  }
  
  static int mix(int paramInt)
  {
    paramInt *= -1640531527;
    return paramInt ^ paramInt >>> 16;
  }
  
  public boolean add(T paramT)
  {
    return false;
  }
  
  public Object[] keys()
  {
    return this.keys;
  }
  
  /* Error */
  void rehash()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean remove(T paramT)
  {
    return false;
  }
  
  boolean removeEntry(int paramInt1, T[] paramArrayOfT, int paramInt2)
  {
    return false;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\OpenHashSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */