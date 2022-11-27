package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpmcArrayQueueConsumerField<E>
  extends SpmcArrayQueueL2Pad<E>
{
  protected static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueConsumerField.class, "consumerIndex");
  private volatile long consumerIndex;
  
  public SpmcArrayQueueConsumerField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final boolean casHead(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  protected final long lvConsumerIndex()
  {
    return this.consumerIndex;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpmcArrayQueueConsumerField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */