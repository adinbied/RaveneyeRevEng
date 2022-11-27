package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpscArrayQueueConsumerField<E>
  extends SpscArrayQueueL2Pad<E>
{
  protected static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueConsumerField.class, "consumerIndex");
  protected long consumerIndex;
  
  public SpscArrayQueueConsumerField(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpscArrayQueueConsumerField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */