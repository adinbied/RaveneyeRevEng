package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T>
  extends BaseTestConsumer<T, TestObserver<T>>
  implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver
{
  private final Observer<? super T> downstream;
  private QueueDisposable<T> qd;
  private final AtomicReference<Disposable> upstream = new AtomicReference();
  
  public TestObserver()
  {
    this(EmptyObserver.INSTANCE);
  }
  
  public TestObserver(Observer<? super T> paramObserver)
  {
    this.downstream = paramObserver;
  }
  
  public static <T> TestObserver<T> create()
  {
    return new TestObserver();
  }
  
  public static <T> TestObserver<T> create(Observer<? super T> paramObserver)
  {
    return new TestObserver(paramObserver);
  }
  
  static String fusionModeToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown(");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(")");
          return localStringBuilder.toString();
        }
        return "ASYNC";
      }
      return "SYNC";
    }
    return "NONE";
  }
  
  final TestObserver<T> assertFuseable()
  {
    return null;
  }
  
  final TestObserver<T> assertFusionMode(int paramInt)
  {
    return null;
  }
  
  final TestObserver<T> assertNotFuseable()
  {
    return null;
  }
  
  public final TestObserver<T> assertNotSubscribed()
  {
    return null;
  }
  
  public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> paramConsumer)
  {
    try
    {
      paramConsumer.accept(this);
      return this;
    }
    finally {}
  }
  
  public final TestObserver<T> assertSubscribed()
  {
    return null;
  }
  
  public final void cancel()
  {
    dispose();
  }
  
  public final void dispose()
  {
    DisposableHelper.dispose(this.upstream);
  }
  
  public final boolean hasSubscription()
  {
    return false;
  }
  
  public final boolean isCancelled()
  {
    return isDisposed();
  }
  
  public final boolean isDisposed()
  {
    return false;
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onNext(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onSuccess(T paramT)
  {
    onNext(paramT);
    onComplete();
  }
  
  final TestObserver<T> setInitialFusionMode(int paramInt)
  {
    this.initialFusionMode = paramInt;
    return this;
  }
  
  static enum EmptyObserver
    implements Observer<Object>
  {
    static
    {
      EmptyObserver localEmptyObserver = new EmptyObserver("INSTANCE", 0);
      INSTANCE = localEmptyObserver;
      $VALUES = new EmptyObserver[] { localEmptyObserver };
    }
    
    private EmptyObserver() {}
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable) {}
    
    public void onNext(Object paramObject) {}
    
    public void onSubscribe(Disposable paramDisposable) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observers\TestObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */