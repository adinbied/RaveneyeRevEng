package dji.thirdparty.rx;

import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeConcat;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeConcatArray;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeConcatIterable;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeMerge;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeMergeArray;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable;
import dji.thirdparty.rx.internal.operators.CompletableOnSubscribeMergeIterable;
import dji.thirdparty.rx.internal.util.SubscriptionList;
import dji.thirdparty.rx.plugins.RxJavaErrorHandler;
import dji.thirdparty.rx.plugins.RxJavaPlugins;
import dji.thirdparty.rx.schedulers.Schedulers;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import dji.thirdparty.rx.subscriptions.MultipleAssignmentSubscription;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import dji.thirdparty.rx.subscriptions.Subscriptions;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Completable
{
  static final Completable COMPLETE = create(new CompletableOnSubscribe()
  {
    /* Error */
    public void call(Completable.CompletableSubscriber arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  });
  static final RxJavaErrorHandler ERROR_HANDLER = RxJavaPlugins.getInstance().getErrorHandler();
  static final Completable NEVER = create(new CompletableOnSubscribe()
  {
    public void call(Completable.CompletableSubscriber paramAnonymousCompletableSubscriber)
    {
      paramAnonymousCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
    }
  });
  private final CompletableOnSubscribe onSubscribe;
  
  protected Completable(CompletableOnSubscribe paramCompletableOnSubscribe)
  {
    this.onSubscribe = paramCompletableOnSubscribe;
  }
  
  public static Completable amb(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  public static Completable amb(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return paramVarArgs[0];
    }
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static Completable complete()
  {
    return COMPLETE;
  }
  
  public static Completable concat(Observable<? extends Completable> paramObservable)
  {
    return concat(paramObservable, 2);
  }
  
  public static Completable concat(Observable<? extends Completable> paramObservable, int paramInt)
  {
    requireNonNull(paramObservable);
    if (paramInt >= 1) {
      return create(new CompletableOnSubscribeConcat(paramObservable, paramInt));
    }
    paramObservable = new StringBuilder();
    paramObservable.append("prefetch > 0 required but it was ");
    paramObservable.append(paramInt);
    throw new IllegalArgumentException(paramObservable.toString());
  }
  
  public static Completable concat(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    return create(new CompletableOnSubscribeConcatIterable(paramIterable));
  }
  
  public static Completable concat(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return paramVarArgs[0];
    }
    return create(new CompletableOnSubscribeConcatArray(paramVarArgs));
  }
  
  /* Error */
  public static Completable create(CompletableOnSubscribe paramCompletableOnSubscribe)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 177	dji/thirdparty/rx/Completable:requireNonNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: new 2	dji/thirdparty/rx/Completable
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 233	dji/thirdparty/rx/Completable:<init>	(Ldji/thirdparty/rx/Completable$CompletableOnSubscribe;)V
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: astore_0
    //   17: getstatic 161	dji/thirdparty/rx/Completable:ERROR_HANDLER	Ldji/thirdparty/rx/plugins/RxJavaErrorHandler;
    //   20: aload_0
    //   21: invokevirtual 238	dji/thirdparty/rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   24: aload_0
    //   25: invokestatic 242	dji/thirdparty/rx/Completable:toNpe	(Ljava/lang/Throwable;)Ljava/lang/NullPointerException;
    //   28: athrow
    //   29: astore_0
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	paramCompletableOnSubscribe	CompletableOnSubscribe
    // Exception table:
    //   from	to	target	type
    //   5	14	16	finally
    //   5	14	29	java/lang/NullPointerException
  }
  
  public static Completable defer(Func0<? extends Completable> paramFunc0)
  {
    requireNonNull(paramFunc0);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  private static void deliverUncaughtException(Throwable paramThrowable)
  {
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
  }
  
  public static Completable error(Func0<? extends Throwable> paramFunc0)
  {
    requireNonNull(paramFunc0);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  public static Completable error(Throwable paramThrowable)
  {
    requireNonNull(paramThrowable);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static Completable fromAction(Action0 paramAction0)
  {
    requireNonNull(paramAction0);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  public static Completable fromCallable(Callable<?> paramCallable)
  {
    requireNonNull(paramCallable);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  public static Completable fromFuture(Future<?> paramFuture)
  {
    requireNonNull(paramFuture);
    return fromObservable(Observable.from(paramFuture));
  }
  
  public static Completable fromObservable(Observable<?> paramObservable)
  {
    requireNonNull(paramObservable);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static Completable fromSingle(Single<?> paramSingle)
  {
    requireNonNull(paramSingle);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static Completable merge(Observable<? extends Completable> paramObservable)
  {
    return merge0(paramObservable, Integer.MAX_VALUE, false);
  }
  
  public static Completable merge(Observable<? extends Completable> paramObservable, int paramInt)
  {
    return merge0(paramObservable, paramInt, false);
  }
  
  public static Completable merge(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    return create(new CompletableOnSubscribeMergeIterable(paramIterable));
  }
  
  public static Completable merge(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return paramVarArgs[0];
    }
    return create(new CompletableOnSubscribeMergeArray(paramVarArgs));
  }
  
  protected static Completable merge0(Observable<? extends Completable> paramObservable, int paramInt, boolean paramBoolean)
  {
    requireNonNull(paramObservable);
    if (paramInt >= 1) {
      return create(new CompletableOnSubscribeMerge(paramObservable, paramInt, paramBoolean));
    }
    paramObservable = new StringBuilder();
    paramObservable.append("maxConcurrency > 0 required but it was ");
    paramObservable.append(paramInt);
    throw new IllegalArgumentException(paramObservable.toString());
  }
  
  public static Completable mergeDelayError(Observable<? extends Completable> paramObservable)
  {
    return merge0(paramObservable, Integer.MAX_VALUE, true);
  }
  
  public static Completable mergeDelayError(Observable<? extends Completable> paramObservable, int paramInt)
  {
    return merge0(paramObservable, paramInt, true);
  }
  
  public static Completable mergeDelayError(Iterable<? extends Completable> paramIterable)
  {
    requireNonNull(paramIterable);
    return create(new CompletableOnSubscribeMergeDelayErrorIterable(paramIterable));
  }
  
  public static Completable mergeDelayError(Completable... paramVarArgs)
  {
    requireNonNull(paramVarArgs);
    return create(new CompletableOnSubscribeMergeDelayErrorArray(paramVarArgs));
  }
  
  public static Completable never()
  {
    return NEVER;
  }
  
  static <T> T requireNonNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw null;
  }
  
  public static Completable timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  public static Completable timer(final long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    requireNonNull(paramTimeUnit);
    requireNonNull(paramScheduler);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  static NullPointerException toNpe(Throwable paramThrowable)
  {
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    return localNullPointerException;
  }
  
  public static <R> Completable using(Func0<R> paramFunc0, Func1<? super R, ? extends Completable> paramFunc1, Action1<? super R> paramAction1)
  {
    return using(paramFunc0, paramFunc1, paramAction1, true);
  }
  
  public static <R> Completable using(Func0<R> paramFunc0, final Func1<? super R, ? extends Completable> paramFunc1, final Action1<? super R> paramAction1, final boolean paramBoolean)
  {
    requireNonNull(paramFunc0);
    requireNonNull(paramFunc1);
    requireNonNull(paramAction1);
    create(new CompletableOnSubscribe()
    {
      /* Error */
      public void call(Completable.CompletableSubscriber arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  public final Completable ambWith(Completable paramCompletable)
  {
    return null;
  }
  
  public final <T> Observable<T> andThen(Observable<T> paramObservable)
  {
    return null;
  }
  
  /* Error */
  public final void await()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public final boolean await(long paramLong, TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  public final Completable compose(CompletableTransformer paramCompletableTransformer)
  {
    return (Completable)to(paramCompletableTransformer);
  }
  
  public final Completable concatWith(Completable paramCompletable)
  {
    return null;
  }
  
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  public final Completable doAfterTerminate(Action0 paramAction0)
  {
    return null;
  }
  
  @Deprecated
  public final Completable doOnComplete(Action0 paramAction0)
  {
    return doOnCompleted(paramAction0);
  }
  
  public final Completable doOnCompleted(Action0 paramAction0)
  {
    return null;
  }
  
  public final Completable doOnError(Action1<? super Throwable> paramAction1)
  {
    return null;
  }
  
  protected final Completable doOnLifecycle(Action1<? super Subscription> paramAction1, Action1<? super Throwable> paramAction11, Action0 paramAction01, Action0 paramAction02, Action0 paramAction03)
  {
    return null;
  }
  
  public final Completable doOnSubscribe(Action1<? super Subscription> paramAction1)
  {
    return null;
  }
  
  public final Completable doOnTerminate(Action0 paramAction0)
  {
    return null;
  }
  
  public final Completable doOnUnsubscribe(Action0 paramAction0)
  {
    return null;
  }
  
  public final Completable endWith(Completable paramCompletable)
  {
    return concatWith(paramCompletable);
  }
  
  public final <T> Observable<T> endWith(Observable<T> paramObservable)
  {
    return null;
  }
  
  public final Throwable get()
  {
    return null;
  }
  
  public final Throwable get(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Completable lift(CompletableOperator paramCompletableOperator)
  {
    return null;
  }
  
  public final Completable mergeWith(Completable paramCompletable)
  {
    return null;
  }
  
  public final Completable observeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Completable onErrorComplete()
  {
    return null;
  }
  
  public final Completable onErrorComplete(Func1<? super Throwable, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final Completable onErrorResumeNext(Func1<? super Throwable, ? extends Completable> paramFunc1)
  {
    return null;
  }
  
  public final Completable repeat()
  {
    return null;
  }
  
  public final Completable repeat(long paramLong)
  {
    return null;
  }
  
  public final Completable repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> paramFunc1)
  {
    return null;
  }
  
  public final Completable retry()
  {
    return null;
  }
  
  public final Completable retry(long paramLong)
  {
    return null;
  }
  
  public final Completable retry(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    return null;
  }
  
  public final Completable retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> paramFunc1)
  {
    return null;
  }
  
  public final Completable startWith(Completable paramCompletable)
  {
    return null;
  }
  
  public final <T> Observable<T> startWith(Observable<T> paramObservable)
  {
    return null;
  }
  
  public final Subscription subscribe()
  {
    return null;
  }
  
  public final Subscription subscribe(Action0 paramAction0)
  {
    return null;
  }
  
  public final Subscription subscribe(Action1<? super Throwable> paramAction1, Action0 paramAction0)
  {
    return null;
  }
  
  /* Error */
  public final void subscribe(CompletableSubscriber arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public final <T> void subscribe(Subscriber<T> arg1)
  {
    // Byte code:
    //   0: goto +6 -> 6
    //   3: return
    //   4: astore_1
    //   5: return
    //   6: goto -3 -> 3
  }
  
  public final Completable subscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Completable paramCompletable)
  {
    return null;
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, Completable paramCompletable)
  {
    requireNonNull(paramCompletable);
    return timeout0(paramLong, paramTimeUnit, paramScheduler, paramCompletable);
  }
  
  public final Completable timeout0(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, Completable paramCompletable)
  {
    return null;
  }
  
  public final <U> U to(Func1<? super Completable, U> paramFunc1)
  {
    return (U)paramFunc1.call(this);
  }
  
  public final <T> Observable<T> toObservable()
  {
    return null;
  }
  
  public final <T> Single<T> toSingle(Func0<? extends T> paramFunc0)
  {
    return null;
  }
  
  public final <T> Single<T> toSingleDefault(T paramT)
  {
    return null;
  }
  
  public final Completable unsubscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public static abstract interface CompletableOnSubscribe
    extends Action1<Completable.CompletableSubscriber>
  {}
  
  public static abstract interface CompletableOperator
    extends Func1<Completable.CompletableSubscriber, Completable.CompletableSubscriber>
  {}
  
  public static abstract interface CompletableSubscriber
  {
    public abstract void onCompleted();
    
    public abstract void onError(Throwable paramThrowable);
    
    public abstract void onSubscribe(Subscription paramSubscription);
  }
  
  public static abstract interface CompletableTransformer
    extends Func1<Completable, Completable>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Completable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */