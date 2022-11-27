package io.reactivex.internal.util;

public class LinkedArrayList
{
  final int capacityHint;
  Object[] head;
  int indexInTail;
  volatile int size;
  Object[] tail;
  
  public LinkedArrayList(int paramInt)
  {
    this.capacityHint = paramInt;
  }
  
  /* Error */
  public void add(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Object[] head()
  {
    return this.head;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\LinkedArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */