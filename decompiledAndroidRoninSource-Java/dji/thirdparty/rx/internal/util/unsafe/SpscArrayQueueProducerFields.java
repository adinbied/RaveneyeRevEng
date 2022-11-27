package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpscArrayQueueProducerFields<E>
  extends SpscArrayQueueL1Pad<E>
{
  protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueProducerFields.class, "producerIndex");
  protected long producerIndex;
  protected long producerLookAhead;
  
  public SpscArrayQueueProducerFields(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpscArrayQueueProducerFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */