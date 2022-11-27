package dji.thirdparty.rx.observers;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestSubscriber<T>
  extends Subscriber<T>
{
  private static final Observer<Object> INERT = new Observer()
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramAnonymousThrowable) {}
    
    public void onNext(Object paramAnonymousObject) {}
  };
  private volatile Thread lastSeenThread;
  private final CountDownLatch latch = new CountDownLatch(1);
  private final TestObserver<T> testObserver;
  
  public TestSubscriber()
  {
    this(-1L);
  }
  
  public TestSubscriber(long paramLong)
  {
    this(INERT, paramLong);
  }
  
  public TestSubscriber(Observer<T> paramObserver)
  {
    this(paramObserver, -1L);
  }
  
  public TestSubscriber(Observer<T> paramObserver, long paramLong)
  {
    if (paramObserver != null)
    {
      this.testObserver = new TestObserver(paramObserver);
      if (paramLong >= 0L) {
        request(paramLong);
      }
      return;
    }
    throw null;
  }
  
  public TestSubscriber(Subscriber<T> paramSubscriber)
  {
    this(paramSubscriber, -1L);
  }
  
  public static <T> TestSubscriber<T> create()
  {
    return new TestSubscriber();
  }
  
  public static <T> TestSubscriber<T> create(long paramLong)
  {
    return new TestSubscriber(paramLong);
  }
  
  public static <T> TestSubscriber<T> create(Observer<T> paramObserver)
  {
    return new TestSubscriber(paramObserver);
  }
  
  public static <T> TestSubscriber<T> create(Observer<T> paramObserver, long paramLong)
  {
    return new TestSubscriber(paramObserver, paramLong);
  }
  
  public static <T> TestSubscriber<T> create(Subscriber<T> paramSubscriber)
  {
    return new TestSubscriber(paramSubscriber);
  }
  
  /* Error */
  public void assertCompleted()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void assertError(Class<? extends Throwable> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void assertError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void assertNoErrors()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void assertNoTerminalEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void assertNoValues()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void assertNotCompleted()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void assertReceivedOnNext(List<T> paramList)
  {
    this.testObserver.assertReceivedOnNext(paramList);
  }
  
  public void assertTerminalEvent()
  {
    this.testObserver.assertTerminalEvent();
  }
  
  /* Error */
  public void assertUnsubscribed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void assertValue(T paramT)
  {
    assertReceivedOnNext(Collections.singletonList(paramT));
  }
  
  /* Error */
  public void assertValueCount(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void assertValues(T... paramVarArgs)
  {
    assertReceivedOnNext(Arrays.asList(paramVarArgs));
  }
  
  /* Error */
  public void awaitTerminalEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void awaitTerminalEvent(long arg1, java.util.concurrent.TimeUnit arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  public void awaitTerminalEventAndUnsubscribeOnTimeout(long arg1, java.util.concurrent.TimeUnit arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  public Thread getLastSeenThread()
  {
    return this.lastSeenThread;
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return this.testObserver.getOnCompletedEvents();
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return this.testObserver.getOnErrorEvents();
  }
  
  public List<T> getOnNextEvents()
  {
    return this.testObserver.getOnNextEvents();
  }
  
  /* Error */
  public void onCompleted()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onNext(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observers\TestSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */