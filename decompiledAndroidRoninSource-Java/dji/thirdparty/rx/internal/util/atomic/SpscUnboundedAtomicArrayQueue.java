package dji.thirdparty.rx.internal.util.atomic;

import dji.thirdparty.rx.internal.util.unsafe.Pow2;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscUnboundedAtomicArrayQueue<T>
  implements Queue<T>
{
  static final AtomicLongFieldUpdater<SpscUnboundedAtomicArrayQueue> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscUnboundedAtomicArrayQueue.class, "consumerIndex");
  private static final Object HAS_NEXT = new Object();
  static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
  static final AtomicLongFieldUpdater<SpscUnboundedAtomicArrayQueue> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscUnboundedAtomicArrayQueue.class, "producerIndex");
  protected AtomicReferenceArray<Object> consumerBuffer;
  protected volatile long consumerIndex;
  protected int consumerMask;
  protected AtomicReferenceArray<Object> producerBuffer;
  protected volatile long producerIndex;
  protected long producerLookAhead;
  protected int producerLookAheadStep;
  protected int producerMask;
  
  public SpscUnboundedAtomicArrayQueue(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(Math.max(8, paramInt));
    int i = paramInt - 1;
    AtomicReferenceArray localAtomicReferenceArray = new AtomicReferenceArray(paramInt + 1);
    this.producerBuffer = localAtomicReferenceArray;
    this.producerMask = i;
    adjustLookAheadStep(paramInt);
    this.consumerBuffer = localAtomicReferenceArray;
    this.consumerMask = i;
    this.producerLookAhead = (i - 1);
    soProducerIndex(0L);
  }
  
  /* Error */
  private void adjustLookAheadStep(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static int calcDirectOffset(int paramInt)
  {
    return paramInt;
  }
  
  private static int calcWrappedOffset(long paramLong, int paramInt)
  {
    return calcDirectOffset((int)paramLong & paramInt);
  }
  
  private long lpConsumerIndex()
  {
    return this.consumerIndex;
  }
  
  private long lpProducerIndex()
  {
    return this.producerIndex;
  }
  
  private long lvConsumerIndex()
  {
    return this.consumerIndex;
  }
  
  private static <E> Object lvElement(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    return paramAtomicReferenceArray.get(paramInt);
  }
  
  private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> paramAtomicReferenceArray)
  {
    return null;
  }
  
  private long lvProducerIndex()
  {
    return this.producerIndex;
  }
  
  private T newBufferPeek(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong, int paramInt)
  {
    this.consumerBuffer = paramAtomicReferenceArray;
    return (T)lvElement(paramAtomicReferenceArray, calcWrappedOffset(paramLong, paramInt));
  }
  
  private T newBufferPoll(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong, int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void resize(AtomicReferenceArray<Object> arg1, long arg2, int arg4, T arg5, long arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void soConsumerIndex(long paramLong)
  {
    CONSUMER_INDEX.lazySet(this, paramLong);
  }
  
  private static void soElement(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt, Object paramObject)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramObject);
  }
  
  /* Error */
  private void soNext(AtomicReferenceArray<Object> arg1, AtomicReferenceArray<Object> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void soProducerIndex(long paramLong)
  {
    PRODUCER_INDEX.lazySet(this, paramLong);
  }
  
  private boolean writeToQueue(AtomicReferenceArray<Object> paramAtomicReferenceArray, T paramT, long paramLong, int paramInt)
  {
    return false;
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
  
  public final Iterator<T> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean offer(T paramT)
  {
    return false;
  }
  
  public final T peek()
  {
    return null;
  }
  
  public final T poll()
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
  
  public final int size()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\atomic\SpscUnboundedAtomicArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */