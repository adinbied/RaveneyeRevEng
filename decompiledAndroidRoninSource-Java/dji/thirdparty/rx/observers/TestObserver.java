package dji.thirdparty.rx.observers;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestObserver<T>
  implements Observer<T>
{
  private static Observer<Object> INERT = new Observer()
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramAnonymousThrowable) {}
    
    public void onNext(Object paramAnonymousObject) {}
  };
  private final Observer<T> delegate;
  private final ArrayList<Notification<T>> onCompletedEvents = new ArrayList();
  private final ArrayList<Throwable> onErrorEvents = new ArrayList();
  private final ArrayList<T> onNextEvents = new ArrayList();
  
  public TestObserver()
  {
    this.delegate = INERT;
  }
  
  public TestObserver(Observer<T> paramObserver)
  {
    this.delegate = paramObserver;
  }
  
  /* Error */
  public void assertReceivedOnNext(List<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void assertTerminalEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public List<Object> getEvents()
  {
    return null;
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return Collections.unmodifiableList(this.onCompletedEvents);
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return Collections.unmodifiableList(this.onErrorEvents);
  }
  
  public List<T> getOnNextEvents()
  {
    return Collections.unmodifiableList(this.onNextEvents);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observers\TestObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */