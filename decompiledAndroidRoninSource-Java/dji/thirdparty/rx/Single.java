package dji.thirdparty.rx;

import dji.thirdparty.rx.exceptions.OnErrorNotImplementedException;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.functions.Func3;
import dji.thirdparty.rx.functions.Func4;
import dji.thirdparty.rx.functions.Func5;
import dji.thirdparty.rx.functions.Func6;
import dji.thirdparty.rx.functions.Func7;
import dji.thirdparty.rx.functions.Func8;
import dji.thirdparty.rx.functions.Func9;
import dji.thirdparty.rx.functions.FuncN;
import dji.thirdparty.rx.internal.operators.OnSubscribeToObservableFuture;
import dji.thirdparty.rx.internal.operators.OperatorOnErrorResumeNextViaFunction;
import dji.thirdparty.rx.internal.operators.SingleOnSubscribeUsing;
import dji.thirdparty.rx.internal.operators.SingleOperatorZip;
import dji.thirdparty.rx.internal.producers.SingleDelayedProducer;
import dji.thirdparty.rx.internal.util.ScalarSynchronousSingle;
import dji.thirdparty.rx.internal.util.UtilityFunctions;
import dji.thirdparty.rx.plugins.RxJavaPlugins;
import dji.thirdparty.rx.plugins.RxJavaSingleExecutionHook;
import dji.thirdparty.rx.singles.BlockingSingle;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Single<T>
{
  static RxJavaSingleExecutionHook hook = RxJavaPlugins.getInstance().getSingleExecutionHook();
  final Observable.OnSubscribe<T> onSubscribe;
  
  private Single(Observable.OnSubscribe<T> paramOnSubscribe)
  {
    this.onSubscribe = paramOnSubscribe;
  }
  
  protected Single(final OnSubscribe<T> paramOnSubscribe)
  {
    this.onSubscribe = new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  private static <T> Observable<T> asObservable(Single<T> paramSingle)
  {
    return Observable.create(paramSingle.onSubscribe);
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8));
  }
  
  public static <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8, Single<? extends T> paramSingle9)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8), asObservable(paramSingle9));
  }
  
  public static <T> Single<T> create(OnSubscribe<T> paramOnSubscribe)
  {
    return new Single(hook.onCreate(paramOnSubscribe));
  }
  
  public static <T> Single<T> defer(Callable<Single<T>> paramCallable)
  {
    create(new OnSubscribe()
    {
      /* Error */
      public void call(SingleSubscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  public static <T> Single<T> error(Throwable paramThrowable)
  {
    create(new OnSubscribe()
    {
      public void call(SingleSubscriber<? super T> paramAnonymousSingleSubscriber)
      {
        paramAnonymousSingleSubscriber.onError(this.val$exception);
      }
    });
  }
  
  public static <T> Single<T> from(Future<? extends T> paramFuture)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture));
  }
  
  public static <T> Single<T> from(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static <T> Single<T> from(Future<? extends T> paramFuture, Scheduler paramScheduler)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture)).subscribeOn(paramScheduler);
  }
  
  public static <T> Single<T> fromCallable(Callable<? extends T> paramCallable)
  {
    create(new OnSubscribe()
    {
      /* Error */
      public void call(SingleSubscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  static <T> Single<? extends T>[] iterableToArray(Iterable<? extends Single<? extends T>> paramIterable)
  {
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Collection)paramIterable;
      return (Single[])paramIterable.toArray(new Single[paramIterable.size()]);
    }
    Object localObject = new Single[8];
    Iterator localIterator = paramIterable.iterator();
    int i = 0;
    for (paramIterable = (Iterable<? extends Single<? extends T>>)localObject; localIterator.hasNext(); paramIterable = (Iterable<? extends Single<? extends T>>)localObject)
    {
      Single localSingle = (Single)localIterator.next();
      localObject = paramIterable;
      if (i == paramIterable.length)
      {
        localObject = new Single[(i >> 2) + i];
        System.arraycopy(paramIterable, 0, localObject, 0, i);
      }
      localObject[i] = localSingle;
      i += 1;
    }
    if (paramIterable.length == i) {
      return paramIterable;
    }
    localObject = new Single[i];
    System.arraycopy(paramIterable, 0, localObject, 0, i);
    return (Single<? extends T>[])localObject;
  }
  
  public static <T> Single<T> just(T paramT)
  {
    return ScalarSynchronousSingle.create(paramT);
  }
  
  private <R> Single<R> lift(Observable.Operator<? extends R, ? super T> paramOperator)
  {
    return null;
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8));
  }
  
  public static <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8, Single<? extends T> paramSingle9)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8), asObservable(paramSingle9));
  }
  
  public static <T> Single<T> merge(Single<? extends Single<? extends T>> paramSingle)
  {
    if ((paramSingle instanceof ScalarSynchronousSingle)) {
      return ((ScalarSynchronousSingle)paramSingle).scalarFlatMap(UtilityFunctions.identity());
    }
    create(new OnSubscribe()
    {
      /* Error */
      public void call(SingleSubscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  private Single<Observable<T>> nest()
  {
    return null;
  }
  
  public static <T, Resource> Single<T> using(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Single<? extends T>> paramFunc1, Action1<? super Resource> paramAction1)
  {
    return using(paramFunc0, paramFunc1, paramAction1, false);
  }
  
  public static <T, Resource> Single<T> using(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Single<? extends T>> paramFunc1, Action1<? super Resource> paramAction1, boolean paramBoolean)
  {
    if (paramFunc0 != null)
    {
      if (paramFunc1 != null)
      {
        if (paramAction1 != null) {
          return create(new SingleOnSubscribeUsing(paramFunc0, paramFunc1, paramAction1, paramBoolean));
        }
        throw new NullPointerException("disposeAction is null");
      }
      throw new NullPointerException("singleFactory is null");
    }
    throw new NullPointerException("resourceFactory is null");
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Single<? extends T8> paramSingle7, Single<? extends T9> paramSingle8, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunc9)
  {
    paramFunc9 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5, paramSingle6, paramSingle7, paramSingle8 }, paramFunc9);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Single<? extends T8> paramSingle7, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunc8)
  {
    paramFunc8 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5, paramSingle6, paramSingle7 }, paramFunc8);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunc7)
  {
    paramFunc7 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5, paramSingle6 }, paramFunc7);
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunc6)
  {
    paramFunc6 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4, paramSingle5 }, paramFunc6);
  }
  
  public static <T1, T2, T3, T4, T5, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunc5)
  {
    paramFunc5 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3, paramSingle4 }, paramFunc5);
  }
  
  public static <T1, T2, T3, T4, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunc4)
  {
    paramFunc4 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2, paramSingle3 }, paramFunc4);
  }
  
  public static <T1, T2, T3, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Func3<? super T1, ? super T2, ? super T3, ? extends R> paramFunc3)
  {
    paramFunc3 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1, paramSingle2 }, paramFunc3);
  }
  
  public static <T1, T2, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    paramFunc2 = new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        return null;
      }
    };
    return SingleOperatorZip.zip(new Single[] { paramSingle, paramSingle1 }, paramFunc2);
  }
  
  public static <R> Single<R> zip(Iterable<? extends Single<?>> paramIterable, FuncN<? extends R> paramFuncN)
  {
    return SingleOperatorZip.zip(iterableToArray(paramIterable), paramFuncN);
  }
  
  public <R> Single<R> compose(Transformer<? super T, ? extends R> paramTransformer)
  {
    return (Single)paramTransformer.call(this);
  }
  
  public final Observable<T> concatWith(Single<? extends T> paramSingle)
  {
    return concat(this, paramSingle);
  }
  
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Single<T> doAfterTerminate(Action0 paramAction0)
  {
    return null;
  }
  
  public final Single<T> doOnError(Action1<Throwable> paramAction1)
  {
    return null;
  }
  
  public final Single<T> doOnSubscribe(Action0 paramAction0)
  {
    return null;
  }
  
  public final Single<T> doOnSuccess(Action1<? super T> paramAction1)
  {
    return null;
  }
  
  public final Single<T> doOnUnsubscribe(Action0 paramAction0)
  {
    return null;
  }
  
  public final <R> Single<R> flatMap(Func1<? super T, ? extends Single<? extends R>> paramFunc1)
  {
    return null;
  }
  
  public final <R> Observable<R> flatMapObservable(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return Observable.merge(asObservable(map(paramFunc1)));
  }
  
  public final <R> Single<R> map(Func1<? super T, ? extends R> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> mergeWith(Single<? extends T> paramSingle)
  {
    return merge(this, paramSingle);
  }
  
  public final Single<T> observeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Single<T> onErrorResumeNext(Single<? extends T> paramSingle)
  {
    return null;
  }
  
  public final Single<T> onErrorResumeNext(Func1<Throwable, ? extends Single<? extends T>> paramFunc1)
  {
    return null;
  }
  
  public final Single<T> onErrorReturn(Func1<Throwable, ? extends T> paramFunc1)
  {
    return lift(OperatorOnErrorResumeNextViaFunction.withSingle(paramFunc1));
  }
  
  public final Single<T> retry()
  {
    return null;
  }
  
  public final Single<T> retry(long paramLong)
  {
    return null;
  }
  
  public final Single<T> retry(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    return null;
  }
  
  public final Single<T> retryWhen(Func1<Observable<? extends Throwable>, ? extends Observable<?>> paramFunc1)
  {
    return null;
  }
  
  public final Subscription subscribe()
  {
    return null;
  }
  
  public final Subscription subscribe(Observer<? super T> paramObserver)
  {
    return null;
  }
  
  public final Subscription subscribe(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    return null;
  }
  
  public final Subscription subscribe(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  public final Subscription subscribe(Action1<? super T> paramAction1)
  {
    return null;
  }
  
  public final Subscription subscribe(Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    return null;
  }
  
  public final Single<T> subscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Single<T> takeUntil(Completable paramCompletable)
  {
    return null;
  }
  
  public final <E> Single<T> takeUntil(Observable<? extends E> paramObservable)
  {
    return null;
  }
  
  public final <E> Single<T> takeUntil(Single<? extends E> paramSingle)
  {
    return null;
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Single<? extends T> paramSingle)
  {
    return null;
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Single<? extends T> paramSingle, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final BlockingSingle<T> toBlocking()
  {
    return BlockingSingle.from(this);
  }
  
  public final Observable<T> toObservable()
  {
    return asObservable(this);
  }
  
  public final Subscription unsafeSubscribe(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  public final <T2, R> Single<R> zipWith(Single<? extends T2> paramSingle, Func2<? super T, ? super T2, ? extends R> paramFunc2)
  {
    return zip(this, paramSingle, paramFunc2);
  }
  
  public static abstract interface OnSubscribe<T>
    extends Action1<SingleSubscriber<? super T>>
  {}
  
  public static abstract interface Transformer<T, R>
    extends Func1<Single<T>, Single<R>>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Single.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */