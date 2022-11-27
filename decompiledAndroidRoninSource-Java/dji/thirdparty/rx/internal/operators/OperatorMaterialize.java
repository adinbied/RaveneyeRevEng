package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorMaterialize<T>
  implements Observable.Operator<Notification<T>, T>
{
  public static <T> OperatorMaterialize<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Notification<T>> paramSubscriber)
  {
    return null;
  }
  
  private static final class Holder
  {
    static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize();
  }
  
  private static class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private boolean busy = false;
    private final Subscriber<? super Notification<T>> child;
    private boolean missed = false;
    private final AtomicLong requested = new AtomicLong();
    private volatile Notification<T> terminalNotification;
    
    ParentSubscriber(Subscriber<? super Notification<T>> paramSubscriber)
    {
      this.child = paramSubscriber;
    }
    
    /* Error */
    private void decrementRequested()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onStart()
    {
      request(0L);
    }
    
    /* Error */
    void requestMore(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorMaterialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */