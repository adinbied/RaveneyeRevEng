package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T>
  implements SimplePlainQueue<T>
{
  private static final Object HAS_NEXT = new Object();
  static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
  AtomicReferenceArray<Object> consumerBuffer;
  final AtomicLong consumerIndex = new AtomicLong();
  final int consumerMask;
  AtomicReferenceArray<Object> producerBuffer;
  final AtomicLong producerIndex = new AtomicLong();
  long producerLookAhead;
  int producerLookAheadStep;
  final int producerMask;
  
  public SpscLinkedArrayQueue(int paramInt)
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
    return this.consumerIndex.get();
  }
  
  private long lpProducerIndex()
  {
    return this.producerIndex.get();
  }
  
  private long lvConsumerIndex()
  {
    return this.consumerIndex.get();
  }
  
  private static <E> Object lvElement(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    return paramAtomicReferenceArray.get(paramInt);
  }
  
  private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    return null;
  }
  
  private long lvProducerIndex()
  {
    return this.producerIndex.get();
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
    this.consumerIndex.lazySet(paramLong);
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
    this.producerIndex.lazySet(paramLong);
  }
  
  private boolean writeToQueue(AtomicReferenceArray<Object> paramAtomicReferenceArray, T paramT, long paramLong, int paramInt)
  {
    soElement(paramAtomicReferenceArray, paramInt, paramT);
    soProducerIndex(paramLong + 1L);
    return true;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean offer(T paramT)
  {
    return false;
  }
  
  public boolean offer(T paramT1, T paramT2)
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
  
  public int size()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\queue\SpscLinkedArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */