package dji.thirdparty.rx.internal.util.atomic;

import dji.thirdparty.rx.internal.util.unsafe.Pow2;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class AtomicReferenceArrayQueue<E>
  extends AbstractQueue<E>
{
  protected final AtomicReferenceArray<E> buffer;
  protected final int mask;
  
  public AtomicReferenceArrayQueue(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.buffer = new AtomicReferenceArray(paramInt);
  }
  
  protected final int calcElementOffset(long paramLong)
  {
    int i = (int)paramLong;
    return this.mask & i;
  }
  
  protected final int calcElementOffset(long paramLong, int paramInt)
  {
    return (int)paramLong & paramInt;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final E lpElement(int paramInt)
  {
    return (E)this.buffer.get(paramInt);
  }
  
  protected final E lpElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt)
  {
    return (E)paramAtomicReferenceArray.get(paramInt);
  }
  
  protected final E lvElement(int paramInt)
  {
    return (E)lvElement(this.buffer, paramInt);
  }
  
  protected final E lvElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt)
  {
    return (E)paramAtomicReferenceArray.get(paramInt);
  }
  
  protected final void soElement(int paramInt, E paramE)
  {
    this.buffer.lazySet(paramInt, paramE);
  }
  
  protected final void soElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramE);
  }
  
  protected final void spElement(int paramInt, E paramE)
  {
    this.buffer.lazySet(paramInt, paramE);
  }
  
  protected final void spElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramE);
  }
  
  protected final void svElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.set(paramInt, paramE);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\atomic\AtomicReferenceArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */