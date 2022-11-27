package dji.thirdparty.rx.observers;

import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.exceptions.OnErrorNotImplementedException;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;

public final class Subscribers
{
  private Subscribers()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Subscriber<T> create(Action1<? super T> paramAction1)
  {
    if (paramAction1 != null) {
      new Subscriber()
      {
        public final void onCompleted() {}
        
        public final void onError(Throwable paramAnonymousThrowable)
        {
          throw new OnErrorNotImplementedException(paramAnonymousThrowable);
        }
        
        public final void onNext(T paramAnonymousT)
        {
          this.val$onNext.call(paramAnonymousT);
        }
      };
    }
    throw new IllegalArgumentException("onNext can not be null");
  }
  
  public static <T> Subscriber<T> create(final Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    if (paramAction1 != null)
    {
      if (paramAction11 != null) {
        new Subscriber()
        {
          public final void onCompleted() {}
          
          public final void onError(Throwable paramAnonymousThrowable)
          {
            this.val$onError.call(paramAnonymousThrowable);
          }
          
          public final void onNext(T paramAnonymousT)
          {
            paramAction1.call(paramAnonymousT);
          }
        };
      }
      throw new IllegalArgumentException("onError can not be null");
    }
    throw new IllegalArgumentException("onNext can not be null");
  }
  
  public static <T> Subscriber<T> create(final Action1<? super T> paramAction1, final Action1<Throwable> paramAction11, Action0 paramAction0)
  {
    if (paramAction1 != null)
    {
      if (paramAction11 != null)
      {
        if (paramAction0 != null) {
          new Subscriber()
          {
            public final void onCompleted()
            {
              this.val$onComplete.call();
            }
            
            public final void onError(Throwable paramAnonymousThrowable)
            {
              paramAction11.call(paramAnonymousThrowable);
            }
            
            public final void onNext(T paramAnonymousT)
            {
              paramAction1.call(paramAnonymousT);
            }
          };
        }
        throw new IllegalArgumentException("onComplete can not be null");
      }
      throw new IllegalArgumentException("onError can not be null");
    }
    throw new IllegalArgumentException("onNext can not be null");
  }
  
  public static <T> Subscriber<T> empty()
  {
    return from(Observers.empty());
  }
  
  public static <T> Subscriber<T> from(Observer<? super T> paramObserver)
  {
    new Subscriber()
    {
      public void onCompleted()
      {
        this.val$o.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        this.val$o.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        this.val$o.onNext(paramAnonymousT);
      }
    };
  }
  
  public static <T> Subscriber<T> wrap(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramSubscriber.onNext(paramAnonymousT);
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observers\Subscribers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */