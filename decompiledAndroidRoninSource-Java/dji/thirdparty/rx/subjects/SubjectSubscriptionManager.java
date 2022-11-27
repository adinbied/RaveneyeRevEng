package dji.thirdparty.rx.subjects;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Actions;
import dji.thirdparty.rx.internal.operators.NotificationLite;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class SubjectSubscriptionManager<T>
  extends AtomicReference<State<T>>
  implements Observable.OnSubscribe<T>
{
  boolean active = true;
  volatile Object latest;
  public final NotificationLite<T> nl = NotificationLite.instance();
  Action1<SubjectObserver<T>> onAdded = Actions.empty();
  Action1<SubjectObserver<T>> onStart = Actions.empty();
  Action1<SubjectObserver<T>> onTerminated = Actions.empty();
  
  public SubjectSubscriptionManager()
  {
    super(State.EMPTY);
  }
  
  boolean add(SubjectObserver<T> paramSubjectObserver)
  {
    return false;
  }
  
  /* Error */
  void addUnsubscriber(dji.thirdparty.rx.Subscriber<? super T> arg1, SubjectObserver<T> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void call(dji.thirdparty.rx.Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  Object getLatest()
  {
    return this.latest;
  }
  
  SubjectObserver<T>[] next(Object paramObject)
  {
    setLatest(paramObject);
    return ((State)get()).observers;
  }
  
  SubjectObserver<T>[] observers()
  {
    return null;
  }
  
  /* Error */
  void remove(SubjectObserver<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  void setLatest(Object paramObject)
  {
    this.latest = paramObject;
  }
  
  SubjectObserver<T>[] terminate(Object paramObject)
  {
    setLatest(paramObject);
    this.active = false;
    if (((State)get()).terminated) {
      return State.NO_OBSERVERS;
    }
    return ((State)getAndSet(State.TERMINATED)).observers;
  }
  
  protected static final class State<T>
  {
    static final State EMPTY = new State(false, NO_OBSERVERS);
    static final SubjectSubscriptionManager.SubjectObserver[] NO_OBSERVERS = new SubjectSubscriptionManager.SubjectObserver[0];
    static final State TERMINATED = new State(true, NO_OBSERVERS);
    final SubjectSubscriptionManager.SubjectObserver[] observers;
    final boolean terminated;
    
    public State(boolean paramBoolean, SubjectSubscriptionManager.SubjectObserver[] paramArrayOfSubjectObserver)
    {
      this.terminated = paramBoolean;
      this.observers = paramArrayOfSubjectObserver;
    }
    
    public State add(SubjectSubscriptionManager.SubjectObserver paramSubjectObserver)
    {
      return null;
    }
    
    public State remove(SubjectSubscriptionManager.SubjectObserver paramSubjectObserver)
    {
      return null;
    }
  }
  
  protected static final class SubjectObserver<T>
    implements Observer<T>
  {
    final Observer<? super T> actual;
    protected volatile boolean caughtUp;
    boolean emitting;
    boolean fastPath;
    boolean first = true;
    private volatile Object index;
    List<Object> queue;
    
    public SubjectObserver(Observer<? super T> paramObserver)
    {
      this.actual = paramObserver;
    }
    
    protected void accept(Object paramObject, NotificationLite<T> paramNotificationLite)
    {
      if (paramObject != null) {
        paramNotificationLite.accept(this.actual, paramObject);
      }
    }
    
    /* Error */
    protected void emitFirst(Object arg1, NotificationLite<T> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    protected void emitLoop(List<Object> arg1, Object arg2, NotificationLite<T> arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    protected void emitNext(Object arg1, NotificationLite<T> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    protected Observer<? super T> getActual()
    {
      return this.actual;
    }
    
    public <I> I index()
    {
      return (I)this.index;
    }
    
    public void index(Object paramObject)
    {
      this.index = paramObject;
    }
    
    public void onCompleted()
    {
      this.actual.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subjects\SubjectSubscriptionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */