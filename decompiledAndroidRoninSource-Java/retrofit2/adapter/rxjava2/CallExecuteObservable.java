package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

final class CallExecuteObservable<T>
  extends Observable<Response<T>>
{
  private final Call<T> originalCall;
  
  CallExecuteObservable(Call<T> paramCall)
  {
    this.originalCall = paramCall;
  }
  
  protected void subscribeActual(Observer<? super Response<T>> paramObserver)
  {
    Object localObject1 = this.originalCall.clone();
    CallDisposable localCallDisposable = new CallDisposable((Call)localObject1);
    paramObserver.onSubscribe(localCallDisposable);
    if (localCallDisposable.isDisposed()) {
      return;
    }
    int i;
    try
    {
      localObject1 = ((Call)localObject1).execute();
      if (!localCallDisposable.isDisposed()) {
        paramObserver.onNext(localObject1);
      }
      boolean bool = localCallDisposable.isDisposed();
      if (bool) {
        return;
      }
      try
      {
        paramObserver.onComplete();
        return;
      }
      finally
      {
        i = 1;
      }
      Exceptions.throwIfFatal(localThrowable);
    }
    finally
    {
      i = 0;
    }
    if (i != 0)
    {
      RxJavaPlugins.onError(localThrowable);
      return;
    }
    if (!localCallDisposable.isDisposed()) {
      try
      {
        paramObserver.onError(localThrowable);
        return;
      }
      finally
      {
        Exceptions.throwIfFatal(paramObserver);
        RxJavaPlugins.onError(new CompositeException(new Throwable[] { localThrowable, paramObserver }));
      }
    }
  }
  
  private static final class CallDisposable
    implements Disposable
  {
    private final Call<?> call;
    private volatile boolean disposed;
    
    CallDisposable(Call<?> paramCall)
    {
      this.call = paramCall;
    }
    
    public void dispose()
    {
      this.disposed = true;
      this.call.cancel();
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\adapter\rxjava2\CallExecuteObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */