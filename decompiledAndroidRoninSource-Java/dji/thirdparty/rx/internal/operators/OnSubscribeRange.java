package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.concurrent.atomic.AtomicLong;

public final class OnSubscribeRange
  implements Observable.OnSubscribe<Integer>
{
  private final int endIndex;
  private final int startIndex;
  
  public OnSubscribeRange(int paramInt1, int paramInt2)
  {
    this.startIndex = paramInt1;
    this.endIndex = paramInt2;
  }
  
  /* Error */
  public void call(Subscriber<? super Integer> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static final class RangeProducer
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = 4114392207069098388L;
    private final Subscriber<? super Integer> childSubscriber;
    private long currentIndex;
    private final int endOfRange;
    
    RangeProducer(Subscriber<? super Integer> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.childSubscriber = paramSubscriber;
      this.currentIndex = paramInt1;
      this.endOfRange = paramInt2;
    }
    
    /* Error */
    void fastpath()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void slowpath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */