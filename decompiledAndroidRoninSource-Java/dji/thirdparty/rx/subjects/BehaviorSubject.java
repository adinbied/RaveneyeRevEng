package dji.thirdparty.rx.subjects;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.internal.operators.NotificationLite;

public final class BehaviorSubject<T>
  extends Subject<T, T>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  private final NotificationLite<T> nl = NotificationLite.instance();
  private final SubjectSubscriptionManager<T> state;
  
  protected BehaviorSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager)
  {
    super(paramOnSubscribe);
    this.state = paramSubjectSubscriptionManager;
  }
  
  public static <T> BehaviorSubject<T> create()
  {
    return create(null, false);
  }
  
  public static <T> BehaviorSubject<T> create(T paramT)
  {
    return create(paramT, true);
  }
  
  private static <T> BehaviorSubject<T> create(T paramT, boolean paramBoolean)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    if (paramBoolean) {
      localSubjectSubscriptionManager.setLatest(NotificationLite.instance().next(paramT));
    }
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
    return new BehaviorSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager);
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public T getValue()
  {
    return null;
  }
  
  public Object[] getValues()
  {
    return null;
  }
  
  public T[] getValues(T[] paramArrayOfT)
  {
    return null;
  }
  
  public boolean hasCompleted()
  {
    return false;
  }
  
  public boolean hasObservers()
  {
    return false;
  }
  
  public boolean hasThrowable()
  {
    return false;
  }
  
  public boolean hasValue()
  {
    return false;
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
  
  int subscriberCount()
  {
    return this.state.observers().length;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subjects\BehaviorSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */