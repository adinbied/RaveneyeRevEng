package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;

public final class BlockingObservableMostRecent<T>
  implements Iterable<T>
{
  final T initialValue;
  final ObservableSource<T> source;
  
  public BlockingObservableMostRecent(ObservableSource<T> paramObservableSource, T paramT)
  {
    this.source = paramObservableSource;
    this.initialValue = paramT;
  }
  
  public Iterator<T> iterator()
  {
    return null;
  }
  
  static final class MostRecentObserver<T>
    extends DefaultObserver<T>
  {
    volatile Object value;
    
    MostRecentObserver(T paramT)
    {
      this.value = NotificationLite.next(paramT);
    }
    
    public MostRecentObserver<T>.Iterator getIterable()
    {
      return new Iterator();
    }
    
    public void onComplete()
    {
      this.value = NotificationLite.complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.value = NotificationLite.error(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.value = NotificationLite.next(paramT);
    }
    
    final class Iterator
      implements Iterator<T>
    {
      private Object buf;
      
      Iterator() {}
      
      public boolean hasNext()
      {
        return false;
      }
      
      public T next()
      {
        return null;
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Read only iterator");
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\BlockingObservableMostRecent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */