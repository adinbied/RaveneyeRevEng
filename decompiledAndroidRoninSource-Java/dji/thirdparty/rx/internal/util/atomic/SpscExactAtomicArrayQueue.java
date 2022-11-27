package dji.thirdparty.rx.internal.util.atomic;

import dji.thirdparty.rx.internal.util.unsafe.Pow2;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscExactAtomicArrayQueue<T>
  extends AtomicReferenceArray<T>
  implements Queue<T>
{
  static final AtomicLongFieldUpdater<SpscExactAtomicArrayQueue> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscExactAtomicArrayQueue.class, "consumerIndex");
  static final AtomicLongFieldUpdater<SpscExactAtomicArrayQueue> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscExactAtomicArrayQueue.class, "producerIndex");
  private static final long serialVersionUID = 6210984603741293445L;
  final int capacitySkip;
  volatile long consumerIndex;
  final int mask;
  volatile long producerIndex;
  
  public SpscExactAtomicArrayQueue(int paramInt)
  {
    super(Pow2.roundToPowerOfTwo(paramInt));
    int i = length();
    this.mask = (i - 1);
    this.capacitySkip = (i - paramInt);
  }
  
  public boolean add(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean contains(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public T element()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<T> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean offer(T paramT)
  {
    return false;
  }
  
  public T peek()
  {
    return null;
  }
  
  public T poll()
  {
    return null;
  }
  
  public T remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return 0;
  }
  
  public Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public <E> E[] toArray(E[] paramArrayOfE)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\atomic\SpscExactAtomicArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */