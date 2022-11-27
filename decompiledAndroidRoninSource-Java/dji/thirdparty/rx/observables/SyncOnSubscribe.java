package dji.thirdparty.rx.observables;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Action2;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func2;
import java.util.concurrent.atomic.AtomicLong;

public abstract class SyncOnSubscribe<S, T>
  implements Observable.OnSubscribe<T>
{
  public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action2<? super S, ? super Observer<? super T>> paramAction2)
  {
    new SyncOnSubscribeImpl(paramFunc0, new Func2()
    {
      public S call(S paramAnonymousS, Observer<? super T> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousS, paramAnonymousObserver);
        return paramAnonymousS;
      }
    });
  }
  
  public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action2<? super S, ? super Observer<? super T>> paramAction2, Action1<? super S> paramAction1)
  {
    new SyncOnSubscribeImpl(paramFunc0, new Func2()
    {
      public S call(S paramAnonymousS, Observer<? super T> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousS, paramAnonymousObserver);
        return paramAnonymousS;
      }
    }, paramAction1);
  }
  
  public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2)
  {
    return new SyncOnSubscribeImpl(paramFunc0, paramFunc2);
  }
  
  public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2, Action1<? super S> paramAction1)
  {
    return new SyncOnSubscribeImpl(paramFunc0, paramFunc2, paramAction1);
  }
  
  public static <T> SyncOnSubscribe<Void, T> createStateless(Action1<? super Observer<? super T>> paramAction1)
  {
    new SyncOnSubscribeImpl(new Func2()
    {
      public Void call(Void paramAnonymousVoid, Observer<? super T> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousObserver);
        return paramAnonymousVoid;
      }
    });
  }
  
  public static <T> SyncOnSubscribe<Void, T> createStateless(Action1<? super Observer<? super T>> paramAction1, Action0 paramAction0)
  {
    new SyncOnSubscribeImpl(new Func2()new Action1
    {
      public Void call(Void paramAnonymousVoid, Observer<? super T> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousObserver);
        return null;
      }
    }, new Action1()
    {
      public void call(Void paramAnonymousVoid)
      {
        this.val$onUnsubscribe.call();
      }
    });
  }
  
  /* Error */
  public final void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected abstract S generateState();
  
  protected abstract S next(S paramS, Observer<? super T> paramObserver);
  
  protected void onUnsubscribe(S paramS) {}
  
  private static class SubscriptionProducer<S, T>
    extends AtomicLong
    implements Producer, Subscription, Observer<T>
  {
    private static final long serialVersionUID = -3736864024352728072L;
    private final Subscriber<? super T> actualSubscriber;
    private boolean hasTerminated;
    private boolean onNextCalled;
    private final SyncOnSubscribe<S, T> parent;
    private S state;
    
    SubscriptionProducer(Subscriber<? super T> paramSubscriber, SyncOnSubscribe<S, T> paramSyncOnSubscribe, S paramS)
    {
      this.actualSubscriber = paramSubscriber;
      this.parent = paramSyncOnSubscribe;
      this.state = paramS;
    }
    
    /* Error */
    private void doUnsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void fastpath()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void handleThrownError(Subscriber<? super T> arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void nextIteration(SyncOnSubscribe<S, T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void slowPath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    private boolean tryUnsubscribe()
    {
      return false;
    }
    
    public boolean isUnsubscribed()
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
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static final class SyncOnSubscribeImpl<S, T>
    extends SyncOnSubscribe<S, T>
  {
    private final Func0<? extends S> generator;
    private final Func2<? super S, ? super Observer<? super T>, ? extends S> next;
    private final Action1<? super S> onUnsubscribe;
    
    public SyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2)
    {
      this(paramFunc0, paramFunc2, null);
    }
    
    SyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2, Action1<? super S> paramAction1)
    {
      this.generator = paramFunc0;
      this.next = paramFunc2;
      this.onUnsubscribe = paramAction1;
    }
    
    public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> paramFunc2)
    {
      this(null, paramFunc2, null);
    }
    
    public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> paramFunc2, Action1<? super S> paramAction1)
    {
      this(null, paramFunc2, paramAction1);
    }
    
    protected S generateState()
    {
      return null;
    }
    
    protected S next(S paramS, Observer<? super T> paramObserver)
    {
      return (S)this.next.call(paramS, paramObserver);
    }
    
    protected void onUnsubscribe(S paramS)
    {
      Action1 localAction1 = this.onUnsubscribe;
      if (localAction1 != null) {
        localAction1.call(paramS);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observables\SyncOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */