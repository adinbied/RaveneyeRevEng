package dji.thirdparty.rx.subjects;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.schedulers.TestScheduler;

public final class TestSubject<T>
  extends Subject<T, T>
{
  private final Scheduler.Worker innerScheduler;
  private final SubjectSubscriptionManager<T> state;
  
  protected TestSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager, TestScheduler paramTestScheduler)
  {
    super(paramOnSubscribe);
    this.state = paramSubjectSubscriptionManager;
    this.innerScheduler = paramTestScheduler.createWorker();
  }
  
  public static <T> TestSubject<T> create(TestScheduler paramTestScheduler)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onAdded = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
    localSubjectSubscriptionManager.onTerminated = localSubjectSubscriptionManager.onAdded;
    return new TestSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, paramTestScheduler);
  }
  
  /* Error */
  void _onCompleted()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void _onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void _onNext(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean hasObservers()
  {
    return false;
  }
  
  public void onCompleted()
  {
    onCompleted(0L);
  }
  
  /* Error */
  public void onCompleted(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void onError(Throwable paramThrowable)
  {
    onError(paramThrowable, 0L);
  }
  
  /* Error */
  public void onError(Throwable arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onNext(T paramT)
  {
    onNext(paramT, 0L);
  }
  
  /* Error */
  public void onNext(T arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subjects\TestSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */