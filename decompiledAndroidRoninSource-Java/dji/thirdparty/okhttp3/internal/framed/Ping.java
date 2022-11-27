package dji.thirdparty.okhttp3.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping
{
  private final CountDownLatch latch = new CountDownLatch(1);
  private long received = -1L;
  private long sent = -1L;
  
  /* Error */
  void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void receive()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long roundTripTime()
    throws InterruptedException
  {
    return 277750680L;
  }
  
  public long roundTripTime(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return 277750685L;
  }
  
  /* Error */
  void send()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\Ping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */