package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E>
  extends AtomicReferenceArray<E>
  implements SimplePlainQueue<E>
{
  private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
  private static final long serialVersionUID = -1296597691183856449L;
  final AtomicLong consumerIndex = new AtomicLong();
  final int lookAheadStep;
  final int mask = length() - 1;
  final AtomicLong producerIndex = new AtomicLong();
  long producerLookAhead;
  
  public SpscArrayQueue(int paramInt)
  {
    super(Pow2.roundToPowerOfTwo(paramInt));
    this.lookAheadStep = Math.min(paramInt / 4, MAX_LOOK_AHEAD_STEP.intValue());
  }
  
  int calcElementOffset(long paramLong)
  {
    int i = (int)paramLong;
    return this.mask & i;
  }
  
  int calcElementOffset(long paramLong, int paramInt)
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
  
  public boolean isEmpty()
  {
    return false;
  }
  
  E lvElement(int paramInt)
  {
    return (E)get(paramInt);
  }
  
  public boolean offer(E paramE)
  {
    return false;
  }
  
  public boolean offer(E paramE1, E paramE2)
  {
    return (offer(paramE1)) && (offer(paramE2));
  }
  
  public E poll()
  {
    return null;
  }
  
  void soConsumerIndex(long paramLong)
  {
    this.consumerIndex.lazySet(paramLong);
  }
  
  void soElement(int paramInt, E paramE)
  {
    lazySet(paramInt, paramE);
  }
  
  void soProducerIndex(long paramLong)
  {
    this.producerIndex.lazySet(paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\queue\SpscArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */