package dji.thirdparty.rx.internal.util.unsafe;

public final class SpscArrayQueue<E>
  extends SpscArrayQueueL3Pad<E>
{
  public SpscArrayQueue(int paramInt)
  {
    super(paramInt);
  }
  
  private long lvConsumerIndex()
  {
    return 278052690L;
  }
  
  private long lvProducerIndex()
  {
    return 278052695L;
  }
  
  /* Error */
  private void soConsumerIndex(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void soProducerIndex(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpscArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */