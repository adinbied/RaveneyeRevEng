package io.reactivex.internal.disposables;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.QueueDisposable;

public enum EmptyDisposable
  implements QueueDisposable<Object>
{
  static
  {
    EmptyDisposable localEmptyDisposable = new EmptyDisposable("NEVER", 1);
    NEVER = localEmptyDisposable;
    $VALUES = new EmptyDisposable[] { INSTANCE, localEmptyDisposable };
  }
  
  private EmptyDisposable() {}
  
  public static void complete(CompletableObserver paramCompletableObserver)
  {
    paramCompletableObserver.onSubscribe(INSTANCE);
    paramCompletableObserver.onComplete();
  }
  
  public static void complete(MaybeObserver<?> paramMaybeObserver)
  {
    paramMaybeObserver.onSubscribe(INSTANCE);
    paramMaybeObserver.onComplete();
  }
  
  public static void complete(Observer<?> paramObserver)
  {
    paramObserver.onSubscribe(INSTANCE);
    paramObserver.onComplete();
  }
  
  public static void error(Throwable paramThrowable, CompletableObserver paramCompletableObserver)
  {
    paramCompletableObserver.onSubscribe(INSTANCE);
    paramCompletableObserver.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, MaybeObserver<?> paramMaybeObserver)
  {
    paramMaybeObserver.onSubscribe(INSTANCE);
    paramMaybeObserver.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, Observer<?> paramObserver)
  {
    paramObserver.onSubscribe(INSTANCE);
    paramObserver.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, SingleObserver<?> paramSingleObserver)
  {
    paramSingleObserver.onSubscribe(INSTANCE);
    paramSingleObserver.onError(paramThrowable);
  }
  
  public void clear() {}
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return this == INSTANCE;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean offer(Object paramObject)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public boolean offer(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public Object poll()
    throws Exception
  {
    return null;
  }
  
  public int requestFusion(int paramInt)
  {
    return paramInt & 0x2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\EmptyDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */