package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Single;
import dji.thirdparty.rx.Single.OnSubscribe;
import dji.thirdparty.rx.SingleSubscriber;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousSingle<T>
  extends Single<T>
{
  final T value;
  
  protected ScalarSynchronousSingle(T paramT)
  {
    super(new Single.OnSubscribe()
    {
      public void call(SingleSubscriber<? super T> paramAnonymousSingleSubscriber)
      {
        paramAnonymousSingleSubscriber.onSuccess(ScalarSynchronousSingle.this);
      }
    });
    this.value = paramT;
  }
  
  public static final <T> ScalarSynchronousSingle<T> create(T paramT)
  {
    return new ScalarSynchronousSingle(paramT);
  }
  
  public T get()
  {
    return (T)this.value;
  }
  
  public <R> Single<R> scalarFlatMap(Func1<? super T, ? extends Single<? extends R>> paramFunc1)
  {
    return null;
  }
  
  public Single<T> scalarScheduleOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  static final class DirectScheduledEmission<T>
    implements Single.OnSubscribe<T>
  {
    private final EventLoopsScheduler es;
    private final T value;
    
    DirectScheduledEmission(EventLoopsScheduler paramEventLoopsScheduler, T paramT)
    {
      this.es = paramEventLoopsScheduler;
      this.value = paramT;
    }
    
    /* Error */
    public void call(SingleSubscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class NormalScheduledEmission<T>
    implements Single.OnSubscribe<T>
  {
    private final Scheduler scheduler;
    private final T value;
    
    NormalScheduledEmission(Scheduler paramScheduler, T paramT)
    {
      this.scheduler = paramScheduler;
      this.value = paramT;
    }
    
    /* Error */
    public void call(SingleSubscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ScalarSynchronousSingleAction<T>
    implements Action0
  {
    private final SingleSubscriber<? super T> subscriber;
    private final T value;
    
    ScalarSynchronousSingleAction(SingleSubscriber<? super T> paramSingleSubscriber, T paramT)
    {
      this.subscriber = paramSingleSubscriber;
      this.value = paramT;
    }
    
    /* Error */
    public void call()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\ScalarSynchronousSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */