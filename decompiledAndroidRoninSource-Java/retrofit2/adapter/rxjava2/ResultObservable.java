package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

final class ResultObservable<T>
  extends Observable<Result<T>>
{
  private final Observable<Response<T>> upstream;
  
  ResultObservable(Observable<Response<T>> paramObservable)
  {
    this.upstream = paramObservable;
  }
  
  protected void subscribeActual(Observer<? super Result<T>> paramObserver)
  {
    this.upstream.subscribe(new ResultObserver(paramObserver));
  }
  
  private static class ResultObserver<R>
    implements Observer<Response<R>>
  {
    private final Observer<? super Result<R>> observer;
    
    ResultObserver(Observer<? super Result<R>> paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public void onComplete()
    {
      this.observer.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        this.observer.onNext(Result.error(paramThrowable));
        this.observer.onComplete();
        return;
      }
      finally
      {
        try
        {
          this.observer.onError(paramThrowable);
          return;
        }
        finally
        {
          Exceptions.throwIfFatal(localThrowable);
          RxJavaPlugins.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
        }
      }
    }
    
    public void onNext(Response<R> paramResponse)
    {
      this.observer.onNext(Result.response(paramResponse));
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.observer.onSubscribe(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\adapter\rxjava2\ResultObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */