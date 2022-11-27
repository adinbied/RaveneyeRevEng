package dji.thirdparty.rx.internal.util.unsafe;

abstract class MpmcArrayQueueConsumerField<E>
  extends MpmcArrayQueueL2Pad<E>
{
  private static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueConsumerField.class, "consumerIndex");
  private volatile long consumerIndex;
  
  public MpmcArrayQueueConsumerField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final boolean casConsumerIndex(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  protected final long lvConsumerIndex()
  {
    return this.consumerIndex;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\MpmcArrayQueueConsumerField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */