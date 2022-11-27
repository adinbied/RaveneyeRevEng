package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;

public final class BlockingFlowableMostRecent<T>
  implements Iterable<T>
{
  final T initialValue;
  final Flowable<T> source;
  
  public BlockingFlowableMostRecent(Flowable<T> paramFlowable, T paramT)
  {
    this.source = paramFlowable;
    this.initialValue = paramT;
  }
  
  public Iterator<T> iterator()
  {
    return null;
  }
  
  static final class MostRecentSubscriber<T>
    extends DefaultSubscriber<T>
  {
    volatile Object value;
    
    MostRecentSubscriber(T paramT)
    {
      this.value = NotificationLite.next(paramT);
    }
    
    public MostRecentSubscriber<T>.Iterator getIterable()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\BlockingFlowableMostRecent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */