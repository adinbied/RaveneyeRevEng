package dji.thirdparty.rx.internal.util.unsafe;

abstract class MpmcArrayQueueProducerField<E>
  extends MpmcArrayQueueL1Pad<E>
{
  private static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueProducerField.class, "producerIndex");
  private volatile long producerIndex;
  
  public MpmcArrayQueueProducerField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final boolean casProducerIndex(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  protected final long lvProducerIndex()
  {
    return this.producerIndex;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\MpmcArrayQueueProducerField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */