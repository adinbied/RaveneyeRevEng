package dji.thirdparty.rx.internal.util.unsafe;

abstract class SpmcArrayQueueL1Pad<E>
  extends ConcurrentCircularArrayQueue<E>
{
  long p10;
  long p11;
  long p12;
  long p13;
  long p14;
  long p15;
  long p16;
  long p30;
  long p31;
  long p32;
  long p33;
  long p34;
  long p35;
  long p36;
  long p37;
  
  public SpmcArrayQueueL1Pad(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\uti\\unsafe\SpmcArrayQueueL1Pad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */