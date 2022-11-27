package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

final class BodyObservable<T>
  extends Observable<T>
{
  private final Observable<Response<T>> upstream;
  
  BodyObservable(Observable<Response<T>> paramObservable)
  {
    this.upstream = paramObservable;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver)
  {
    this.upstream.subscribe(new BodyObserver(paramObserver));
  }
  
  private static class BodyObserver<R>
    implements Observer<Response<R>>
  {
    private final Observer<? super R> observer;
    private boolean terminated;
    
    BodyObserver(Observer<? super R> paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public void onComplete()
    {
      if (!this.terminated) {
        this.observer.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.terminated)
      {
        this.observer.onError(paramThrowable);
        return;
      }
      AssertionError localAssertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
      localAssertionError.initCause(paramThrowable);
      RxJavaPlugins.onError(localAssertionError);
    }
    
    public void onNext(Response<R> paramResponse)
    {
      if (paramResponse.isSuccessful())
      {
        this.observer.onNext(paramResponse.body());
        return;
      }
      this.terminated = true;
      paramResponse = new HttpException(paramResponse);
      try
      {
        this.observer.onError(paramResponse);
        return;
      }
      finally
      {
        Exceptions.throwIfFatal(localThrowable);
        RxJavaPlugins.onError(new CompositeException(new Throwable[] { paramResponse, localThrowable }));
      }
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.observer.onSubscribe(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\adapter\rxjava2\BodyObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */