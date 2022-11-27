package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

final class CallEnqueueObservable<T>
  extends Observable<Response<T>>
{
  private final Call<T> originalCall;
  
  CallEnqueueObservable(Call<T> paramCall)
  {
    this.originalCall = paramCall;
  }
  
  protected void subscribeActual(Observer<? super Response<T>> paramObserver)
  {
    Call localCall = this.originalCall.clone();
    CallCallback localCallCallback = new CallCallback(localCall, paramObserver);
    paramObserver.onSubscribe(localCallCallback);
    if (!localCallCallback.isDisposed()) {
      localCall.enqueue(localCallCallback);
    }
  }
  
  private static final class CallCallback<T>
    implements Disposable, Callback<T>
  {
    private final Call<?> call;
    private volatile boolean disposed;
    private final Observer<? super Response<T>> observer;
    boolean terminated = false;
    
    CallCallback(Call<?> paramCall, Observer<? super Response<T>> paramObserver)
    {
      this.call = paramCall;
      this.observer = paramObserver;
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
    
    public void onFailure(Call<T> paramCall, Throwable paramThrowable)
    {
      if (paramCall.isCanceled()) {
        return;
      }
      try
      {
        this.observer.onError(paramThrowable);
        return;
      }
      finally
      {
        Exceptions.throwIfFatal(paramCall);
        RxJavaPlugins.onError(new CompositeException(new Throwable[] { paramThrowable, paramCall }));
      }
    }
    
    public void onResponse(Call<T> paramCall, Response<T> paramResponse)
    {
      if (this.disposed) {
        return;
      }
      try
      {
        this.observer.onNext(paramResponse);
        if (!this.disposed)
        {
          this.terminated = true;
          this.observer.onComplete();
          return;
        }
      }
      finally
      {
        Exceptions.throwIfFatal(paramCall);
        if (this.terminated)
        {
          RxJavaPlugins.onError(paramCall);
          return;
        }
        if (!this.disposed) {
          try
          {
            this.observer.onError(paramCall);
            return;
          }
          finally
          {
            Exceptions.throwIfFatal(paramResponse);
            RxJavaPlugins.onError(new CompositeException(new Throwable[] { paramCall, paramResponse }));
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\adapter\rxjava2\CallEnqueueObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */