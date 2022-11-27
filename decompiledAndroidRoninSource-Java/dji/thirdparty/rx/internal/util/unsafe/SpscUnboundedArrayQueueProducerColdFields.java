package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueProducerColdFields<E>
  extends SpscUnboundedArrayQueueProducerFields<E>
{
  protected E[] producerBuffer;
  protected long producerLookAhead;
  protected int producerLookAheadStep;
  protected long producerMask;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpscUnboundedArrayQueueProducerColdFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */