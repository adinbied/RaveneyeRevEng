package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpmcArrayQueueProducerField<E>
  extends SpmcArrayQueueL1Pad<E>
{
  protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueProducerField.class, "producerIndex");
  private volatile long producerIndex;
  
  public SpmcArrayQueueProducerField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long lvProducerIndex()
  {
    return this.producerIndex;
  }
  
  /* Error */
  protected final void soTail(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpmcArrayQueueProducerField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */