package dji.thirdparty.rx.internal.util.atomic;

import java.util.concurrent.atomic.AtomicLong;

public final class SpscAtomicArrayQueue<E>
  extends AtomicReferenceArrayQueue<E>
{
  private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
  final AtomicLong consumerIndex = new AtomicLong();
  final int lookAheadStep;
  final AtomicLong producerIndex = new AtomicLong();
  protected long producerLookAhead;
  
  public SpscAtomicArrayQueue(int paramInt)
  {
    super(paramInt);
    this.lookAheadStep = Math.min(paramInt / 4, MAX_LOOK_AHEAD_STEP.intValue());
  }
  
  private long lvConsumerIndex()
  {
    return this.consumerIndex.get();
  }
  
  private long lvProducerIndex()
  {
    return this.producerIndex.get();
  }
  
  private void soConsumerIndex(long paramLong)
  {
    this.consumerIndex.lazySet(paramLong);
  }
  
  private void soProducerIndex(long paramLong)
  {
    this.producerIndex.lazySet(paramLong);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean offer(E paramE)
  {
    return false;
  }
  
  public E peek()
  {
    return null;
  }
  
  public E poll()
  {
    return null;
  }
  
  public int size()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\atomic\SpscAtomicArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */