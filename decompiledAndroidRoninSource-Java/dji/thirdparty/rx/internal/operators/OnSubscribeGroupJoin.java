package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import dji.thirdparty.rx.subscriptions.RefCountSubscription;
import java.util.HashMap;
import java.util.Map;

public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R>
  implements Observable.OnSubscribe<R>
{
  protected final Observable<T1> left;
  protected final Func1<? super T1, ? extends Observable<D1>> leftDuration;
  protected final Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector;
  protected final Observable<T2> right;
  protected final Func1<? super T2, ? extends Observable<D2>> rightDuration;
  
  public OnSubscribeGroupJoin(Observable<T1> paramObservable, Observable<T2> paramObservable1, Func1<? super T1, ? extends Observable<D1>> paramFunc1, Func1<? super T2, ? extends Observable<D2>> paramFunc11, Func2<? super T1, ? super Observable<T2>, ? extends R> paramFunc2)
  {
    this.left = paramObservable;
    this.right = paramObservable1;
    this.leftDuration = paramFunc1;
    this.rightDuration = paramFunc11;
    this.resultSelector = paramFunc2;
  }
  
  /* Error */
  public void call(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class ResultManager
    implements Subscription
  {
    final RefCountSubscription cancel;
    final CompositeSubscription group;
    final Object guard = new Object();
    boolean leftDone;
    int leftIds;
    final Map<Integer, Observer<T2>> leftMap = new HashMap();
    boolean rightDone;
    int rightIds;
    final Map<Integer, T2> rightMap = new HashMap();
    final Subscriber<? super R> subscriber;
    
    public ResultManager()
    {
      Subscriber localSubscriber;
      this.subscriber = localSubscriber;
      this.group = new CompositeSubscription();
      this.cancel = new RefCountSubscription(this.group);
    }
    
    /* Error */
    void complete(java.util.List<Observer<T2>> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void errorAll(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void errorMain(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void init()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isUnsubscribed()
    {
      return this.cancel.isUnsubscribed();
    }
    
    public void unsubscribe()
    {
      this.cancel.unsubscribe();
    }
    
    final class LeftDurationObserver
      extends Subscriber<D1>
    {
      final int id;
      boolean once = true;
      
      public LeftDurationObserver(int paramInt)
      {
        this.id = paramInt;
      }
      
      /* Error */
      public void onCompleted()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorMain(paramThrowable);
      }
      
      public void onNext(D1 paramD1)
      {
        onCompleted();
      }
    }
    
    final class LeftObserver
      extends Subscriber<T1>
    {
      LeftObserver() {}
      
      /* Error */
      public void onCompleted()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorAll(paramThrowable);
      }
      
      /* Error */
      public void onNext(T1 arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
    
    final class RightDurationObserver
      extends Subscriber<D2>
    {
      final int id;
      boolean once = true;
      
      public RightDurationObserver(int paramInt)
      {
        this.id = paramInt;
      }
      
      /* Error */
      public void onCompleted()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorMain(paramThrowable);
      }
      
      public void onNext(D2 paramD2)
      {
        onCompleted();
      }
    }
    
    final class RightObserver
      extends Subscriber<T2>
    {
      RightObserver() {}
      
      /* Error */
      public void onCompleted()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorAll(paramThrowable);
      }
      
      /* Error */
      public void onNext(T2 arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
  }
  
  static final class WindowObservableFunc<T>
    implements Observable.OnSubscribe<T>
  {
    final RefCountSubscription refCount;
    final Observable<T> underlying;
    
    public WindowObservableFunc(Observable<T> paramObservable, RefCountSubscription paramRefCountSubscription)
    {
      this.refCount = paramRefCountSubscription;
      this.underlying = paramObservable;
    }
    
    /* Error */
    public void call(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class WindowSubscriber
      extends Subscriber<T>
    {
      private final Subscription ref;
      final Subscriber<? super T> subscriber;
      
      public WindowSubscriber(Subscription paramSubscription)
      {
        super();
        this.subscriber = paramSubscription;
        Subscription localSubscription;
        this.ref = localSubscription;
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
      
      public void onNext(T paramT)
      {
        this.subscriber.onNext(paramT);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeGroupJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */