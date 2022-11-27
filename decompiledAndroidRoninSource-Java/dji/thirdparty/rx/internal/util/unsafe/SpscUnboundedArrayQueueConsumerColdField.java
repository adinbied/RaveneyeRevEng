package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueConsumerColdField<E>
  extends SpscUnboundedArrayQueueL2Pad<E>
{
  protected E[] consumerBuffer;
  protected long consumerMask;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpscUnboundedArrayQueueConsumerColdField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */