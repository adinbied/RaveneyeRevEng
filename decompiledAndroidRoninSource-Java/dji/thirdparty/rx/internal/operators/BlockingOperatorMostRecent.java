package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscriber;
import java.util.Iterator;

public final class BlockingOperatorMostRecent
{
  private BlockingOperatorMostRecent()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> mostRecent(final Observable<? extends T> paramObservable, T paramT)
  {
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        return null;
      }
    };
  }
  
  private static final class MostRecentObserver<T>
    extends Subscriber<T>
  {
    final NotificationLite<T> nl;
    volatile Object value;
    
    MostRecentObserver(T paramT)
    {
      NotificationLite localNotificationLite = NotificationLite.instance();
      this.nl = localNotificationLite;
      this.value = localNotificationLite.next(paramT);
    }
    
    public Iterator<T> getIterable()
    {
      new Iterator()
      {
        private Object buf = null;
        
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
      };
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\BlockingOperatorMostRecent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */