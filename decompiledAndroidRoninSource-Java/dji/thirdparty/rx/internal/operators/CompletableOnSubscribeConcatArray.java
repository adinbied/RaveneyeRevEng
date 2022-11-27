package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Completable;
import dji.thirdparty.rx.Completable.CompletableOnSubscribe;
import dji.thirdparty.rx.Completable.CompletableSubscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableOnSubscribeConcatArray
  implements Completable.CompletableOnSubscribe
{
  final Completable[] sources;
  
  public CompletableOnSubscribeConcatArray(Completable[] paramArrayOfCompletable)
  {
    this.sources = paramArrayOfCompletable;
  }
  
  /* Error */
  public void call(Completable.CompletableSubscriber arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatInnerSubscriber
    extends AtomicInteger
    implements Completable.CompletableSubscriber
  {
    private static final long serialVersionUID = -7965400327305809232L;
    final Completable.CompletableSubscriber actual;
    int index;
    final SerialSubscription sd;
    final Completable[] sources;
    
    public ConcatInnerSubscriber(Completable.CompletableSubscriber paramCompletableSubscriber, Completable[] paramArrayOfCompletable)
    {
      this.actual = paramCompletableSubscriber;
      this.sources = paramArrayOfCompletable;
      this.sd = new SerialSubscription();
    }
    
    /* Error */
    void next()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onCompleted()
    {
      next();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      this.sd.set(paramSubscription);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\CompletableOnSubscribeConcatArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */