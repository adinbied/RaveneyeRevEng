package dji.thirdparty.rx.observables;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Action2;
import dji.thirdparty.rx.functions.Action3;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func3;
import dji.thirdparty.rx.internal.operators.BufferUntilSubscriber;
import dji.thirdparty.rx.observers.SerializedObserver;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AsyncOnSubscribe<S, T>
  implements Observable.OnSubscribe<T>
{
  public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action3<? super S, Long, ? super Observer<Observable<? extends T>>> paramAction3)
  {
    new AsyncOnSubscribeImpl(paramFunc0, new Func3()
    {
      public S call(S paramAnonymousS, Long paramAnonymousLong, Observer<Observable<? extends T>> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousS, paramAnonymousLong, paramAnonymousObserver);
        return paramAnonymousS;
      }
    });
  }
  
  public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> paramFunc0, Action3<? super S, Long, ? super Observer<Observable<? extends T>>> paramAction3, Action1<? super S> paramAction1)
  {
    new AsyncOnSubscribeImpl(paramFunc0, new Func3()
    {
      public S call(S paramAnonymousS, Long paramAnonymousLong, Observer<Observable<? extends T>> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousS, paramAnonymousLong, paramAnonymousObserver);
        return paramAnonymousS;
      }
    }, paramAction1);
  }
  
  public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3)
  {
    return new AsyncOnSubscribeImpl(paramFunc0, paramFunc3);
  }
  
  public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3, Action1<? super S> paramAction1)
  {
    return new AsyncOnSubscribeImpl(paramFunc0, paramFunc3, paramAction1);
  }
  
  public static <T> AsyncOnSubscribe<Void, T> createStateless(Action2<Long, ? super Observer<Observable<? extends T>>> paramAction2)
  {
    new AsyncOnSubscribeImpl(new Func3()
    {
      public Void call(Void paramAnonymousVoid, Long paramAnonymousLong, Observer<Observable<? extends T>> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousLong, paramAnonymousObserver);
        return paramAnonymousVoid;
      }
    });
  }
  
  public static <T> AsyncOnSubscribe<Void, T> createStateless(Action2<Long, ? super Observer<Observable<? extends T>>> paramAction2, Action0 paramAction0)
  {
    new AsyncOnSubscribeImpl(new Func3()new Action1
    {
      public Void call(Void paramAnonymousVoid, Long paramAnonymousLong, Observer<Observable<? extends T>> paramAnonymousObserver)
      {
        this.val$next.call(paramAnonymousLong, paramAnonymousObserver);
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
  
  protected abstract S next(S paramS, long paramLong, Observer<Observable<? extends T>> paramObserver);
  
  protected void onUnsubscribe(S paramS) {}
  
  private static final class AsyncOnSubscribeImpl<S, T>
    extends AsyncOnSubscribe<S, T>
  {
    private final Func0<? extends S> generator;
    private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
    private final Action1<? super S> onUnsubscribe;
    
    public AsyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3)
    {
      this(paramFunc0, paramFunc3, null);
    }
    
    AsyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> paramFunc3, Action1<? super S> paramAction1)
    {
      this.generator = paramFunc0;
      this.next = paramFunc3;
      this.onUnsubscribe = paramAction1;
    }
    
    public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> paramFunc3)
    {
      this(null, paramFunc3, null);
    }
    
    public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> paramFunc3, Action1<? super S> paramAction1)
    {
      this(null, paramFunc3, paramAction1);
    }
    
    protected S generateState()
    {
      return null;
    }
    
    protected S next(S paramS, long paramLong, Observer<Observable<? extends T>> paramObserver)
    {
      return null;
    }
    
    protected void onUnsubscribe(S paramS)
    {
      Action1 localAction1 = this.onUnsubscribe;
      if (localAction1 != null) {
        localAction1.call(paramS);
      }
    }
  }
  
  static final class AsyncOuterManager<S, T>
    implements Producer, Subscription, Observer<Observable<? extends T>>
  {
    private static final AtomicIntegerFieldUpdater<AsyncOuterManager> IS_UNSUBSCRIBED = AtomicIntegerFieldUpdater.newUpdater(AsyncOuterManager.class, "isUnsubscribed");
    Producer concatProducer;
    boolean emitting;
    long expectedDelivery;
    private boolean hasTerminated;
    private volatile int isUnsubscribed;
    private final AsyncOnSubscribe.UnicastSubject<Observable<T>> merger;
    private boolean onNextCalled;
    private final AsyncOnSubscribe<S, T> parent;
    List<Long> requests;
    private final SerializedObserver<Observable<? extends T>> serializedSubscriber;
    private S state;
    final CompositeSubscription subscriptions = new CompositeSubscription();
    
    public AsyncOuterManager(AsyncOnSubscribe<S, T> paramAsyncOnSubscribe, S paramS, AsyncOnSubscribe.UnicastSubject<Observable<T>> paramUnicastSubject)
    {
      this.parent = paramAsyncOnSubscribe;
      this.serializedSubscriber = new SerializedObserver(this);
      this.state = paramS;
      this.merger = paramUnicastSubject;
    }
    
    /* Error */
    private void handleThrownError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void subscribeBufferToObservable(Observable<? extends T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void cleanup()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isUnsubscribed()
    {
      return this.isUnsubscribed != 0;
    }
    
    /* Error */
    public void nextIteration(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
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
    public void onNext(Observable<? extends T> arg1)
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
      //   2: return
    }
    
    /* Error */
    public void requestRemaining(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    /* Error */
    void setConcatProducer(Producer arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean tryEmit(long paramLong)
    {
      return false;
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class UnicastSubject<T>
    extends Observable<T>
    implements Observer<T>
  {
    private State<T> state;
    
    protected UnicastSubject(State<T> paramState)
    {
      super();
      this.state = paramState;
    }
    
    public static <T> UnicastSubject<T> create()
    {
      return new UnicastSubject(new State());
    }
    
    public void onCompleted()
    {
      this.state.subscriber.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.state.subscriber.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.state.subscriber.onNext(paramT);
    }
    
    static final class State<T>
      implements Observable.OnSubscribe<T>
    {
      Subscriber<? super T> subscriber;
      
      /* Error */
      public void call(Subscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observables\AsyncOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */