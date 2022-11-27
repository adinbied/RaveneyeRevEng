package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpmcArrayQueueProducerIndexCacheField<E>
  extends SpmcArrayQueueMidPad<E>
{
  private volatile long producerIndexCache;
  
  public SpmcArrayQueueProducerIndexCacheField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long lvProducerIndexCache()
  {
    return this.producerIndexCache;
  }
  
  protected final void svProducerIndexCache(long paramLong)
  {
    this.producerIndexCache = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpmcArrayQueueProducerIndexCacheField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */