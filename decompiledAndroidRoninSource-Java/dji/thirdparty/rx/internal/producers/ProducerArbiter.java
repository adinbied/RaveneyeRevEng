package dji.thirdparty.rx.internal.producers;

import dji.thirdparty.rx.Producer;

public final class ProducerArbiter
  implements Producer
{
  static final Producer NULL_PRODUCER = new Producer()
  {
    public void request(long paramAnonymousLong) {}
  };
  Producer currentProducer;
  boolean emitting;
  long missedProduced;
  Producer missedProducer;
  long missedRequested;
  long requested;
  
  /* Error */
  public void emitLoop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void produced(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  public void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  public void setProducer(Producer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\producers\ProducerArbiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */