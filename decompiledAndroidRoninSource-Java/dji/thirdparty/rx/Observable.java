package dji.thirdparty.rx;

import dji.thirdparty.rx.exceptions.Exceptions;
import dji.thirdparty.rx.exceptions.OnErrorNotImplementedException;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Action2;
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
import dji.thirdparty.rx.functions.Functions;
import dji.thirdparty.rx.internal.operators.CachedObservable;
import dji.thirdparty.rx.internal.operators.OnSubscribeAmb;
import dji.thirdparty.rx.internal.operators.OnSubscribeCombineLatest;
import dji.thirdparty.rx.internal.operators.OnSubscribeDefer;
import dji.thirdparty.rx.internal.operators.OnSubscribeFromArray;
import dji.thirdparty.rx.internal.operators.OnSubscribeFromCallable;
import dji.thirdparty.rx.internal.operators.OnSubscribeFromIterable;
import dji.thirdparty.rx.internal.operators.OnSubscribeRange;
import dji.thirdparty.rx.internal.operators.OnSubscribeRedo;
import dji.thirdparty.rx.internal.operators.OnSubscribeTimerOnce;
import dji.thirdparty.rx.internal.operators.OnSubscribeTimerPeriodically;
import dji.thirdparty.rx.internal.operators.OnSubscribeToObservableFuture;
import dji.thirdparty.rx.internal.operators.OnSubscribeUsing;
import dji.thirdparty.rx.internal.operators.OperatorAny;
import dji.thirdparty.rx.internal.operators.OperatorMapPair;
import dji.thirdparty.rx.internal.operators.OperatorMerge;
import dji.thirdparty.rx.internal.operators.OperatorOnErrorResumeNextViaFunction;
import dji.thirdparty.rx.internal.operators.OperatorPublish;
import dji.thirdparty.rx.internal.operators.OperatorReplay;
import dji.thirdparty.rx.internal.operators.OperatorSequenceEqual;
import dji.thirdparty.rx.internal.operators.OperatorSwitch;
import dji.thirdparty.rx.internal.operators.OperatorZip;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.internal.util.ScalarSynchronousObservable;
import dji.thirdparty.rx.internal.util.UtilityFunctions;
import dji.thirdparty.rx.observables.AsyncOnSubscribe;
import dji.thirdparty.rx.observables.BlockingObservable;
import dji.thirdparty.rx.observables.ConnectableObservable;
import dji.thirdparty.rx.observables.GroupedObservable;
import dji.thirdparty.rx.observables.SyncOnSubscribe;
import dji.thirdparty.rx.observers.SafeSubscriber;
import dji.thirdparty.rx.plugins.RxJavaObservableExecutionHook;
import dji.thirdparty.rx.plugins.RxJavaPlugins;
import dji.thirdparty.rx.schedulers.Schedulers;
import dji.thirdparty.rx.schedulers.TimeInterval;
import dji.thirdparty.rx.schedulers.Timestamped;
import dji.thirdparty.rx.subscriptions.Subscriptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Observable<T>
{
  static final RxJavaObservableExecutionHook hook = RxJavaPlugins.getInstance().getObservableExecutionHook();
  final OnSubscribe<T> onSubscribe;
  
  protected Observable(OnSubscribe<T> paramOnSubscribe)
  {
    this.onSubscribe = paramOnSubscribe;
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2));
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2, paramObservable3));
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2, paramObservable3, paramObservable4));
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5));
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6));
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7));
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8));
  }
  
  public static <T> Observable<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    return create(OnSubscribeAmb.amb(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8, paramObservable9));
  }
  
  public static <T> Observable<T> amb(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return create(OnSubscribeAmb.amb(paramIterable));
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Observable<? extends T7> paramObservable6, Observable<? extends T8> paramObservable7, Observable<? extends T9> paramObservable8, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunc9)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8 }), Functions.fromFunc(paramFunc9));
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Observable<? extends T7> paramObservable6, Observable<? extends T8> paramObservable7, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunc8)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7 }), Functions.fromFunc(paramFunc8));
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Observable<? extends T7> paramObservable6, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunc7)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6 }), Functions.fromFunc(paramFunc7));
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunc6)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5 }), Functions.fromFunc(paramFunc6));
  }
  
  public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunc5)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4 }), Functions.fromFunc(paramFunc5));
  }
  
  public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunc4)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3 }), Functions.fromFunc(paramFunc4));
  }
  
  public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Func3<? super T1, ? super T2, ? super T3, ? extends R> paramFunc3)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1, paramObservable2 }), Functions.fromFunc(paramFunc3));
  }
  
  public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    return combineLatest(Arrays.asList(new Observable[] { paramObservable, paramObservable1 }), Functions.fromFunc(paramFunc2));
  }
  
  public static <T, R> Observable<R> combineLatest(Iterable<? extends Observable<? extends T>> paramIterable, FuncN<? extends R> paramFuncN)
  {
    return create(new OnSubscribeCombineLatest(paramIterable, paramFuncN));
  }
  
  public static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> paramList, FuncN<? extends R> paramFuncN)
  {
    return create(new OnSubscribeCombineLatest(paramList, paramFuncN));
  }
  
  public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends Observable<? extends T>> paramIterable, FuncN<? extends R> paramFuncN)
  {
    return create(new OnSubscribeCombineLatest(null, paramIterable, paramFuncN, RxRingBuffer.SIZE, true));
  }
  
  public static <T> Observable<T> concat(Observable<? extends Observable<? extends T>> paramObservable)
  {
    return paramObservable.concatMap(UtilityFunctions.identity());
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    return concat(just(paramObservable1, paramObservable2));
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    return concat(just(paramObservable1, paramObservable2, paramObservable3));
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    return concat(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4));
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    return concat(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5));
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    return concat(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6));
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    return concat(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7));
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    return concat(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8));
  }
  
  public static <T> Observable<T> concat(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    return concat(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8, paramObservable9));
  }
  
  public static <T> Observable<T> concatDelayError(Observable<? extends Observable<? extends T>> paramObservable)
  {
    return paramObservable.concatMapDelayError(UtilityFunctions.identity());
  }
  
  public static <T> Observable<T> concatDelayError(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return concatDelayError(from(paramIterable));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> paramObservable)
  {
    return paramObservable.concatMapEager(UtilityFunctions.identity());
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> paramObservable, int paramInt)
  {
    return paramObservable.concatMapEager(UtilityFunctions.identity(), paramInt);
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2 }));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2, paramObservable3 }));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4 }));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5 }));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6 }));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7 }));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8 }));
  }
  
  public static <T> Observable<T> concatEager(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    return concatEager(Arrays.asList(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8, paramObservable9 }));
  }
  
  public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return from(paramIterable).concatMapEager(UtilityFunctions.identity());
  }
  
  public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> paramIterable, int paramInt)
  {
    return from(paramIterable).concatMapEager(UtilityFunctions.identity(), paramInt);
  }
  
  public static <T> Observable<T> create(OnSubscribe<T> paramOnSubscribe)
  {
    return new Observable(hook.onCreate(paramOnSubscribe));
  }
  
  public static <S, T> Observable<T> create(AsyncOnSubscribe<S, T> paramAsyncOnSubscribe)
  {
    return new Observable(hook.onCreate(paramAsyncOnSubscribe));
  }
  
  public static <S, T> Observable<T> create(SyncOnSubscribe<S, T> paramSyncOnSubscribe)
  {
    return new Observable(hook.onCreate(paramSyncOnSubscribe));
  }
  
  public static <T> Observable<T> defer(Func0<Observable<T>> paramFunc0)
  {
    return create(new OnSubscribeDefer(paramFunc0));
  }
  
  public static <T> Observable<T> empty()
  {
    return EmptyHolder.INSTANCE;
  }
  
  public static <T> Observable<T> error(Throwable paramThrowable)
  {
    return new ThrowObservable(paramThrowable);
  }
  
  public static <T> Observable<T> from(Iterable<? extends T> paramIterable)
  {
    return create(new OnSubscribeFromIterable(paramIterable));
  }
  
  public static <T> Observable<T> from(Future<? extends T> paramFuture)
  {
    return create(OnSubscribeToObservableFuture.toObservableFuture(paramFuture));
  }
  
  public static <T> Observable<T> from(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return create(OnSubscribeToObservableFuture.toObservableFuture(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static <T> Observable<T> from(Future<? extends T> paramFuture, Scheduler paramScheduler)
  {
    return create(OnSubscribeToObservableFuture.toObservableFuture(paramFuture)).subscribeOn(paramScheduler);
  }
  
  public static <T> Observable<T> from(T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    if (i == 0) {
      return empty();
    }
    if (i == 1) {
      return just(paramArrayOfT[0]);
    }
    return create(new OnSubscribeFromArray(paramArrayOfT));
  }
  
  public static <T> Observable<T> fromCallable(Callable<? extends T> paramCallable)
  {
    return create(new OnSubscribeFromCallable(paramCallable));
  }
  
  public static Observable<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return interval(paramLong1, paramLong2, paramTimeUnit, Schedulers.computation());
  }
  
  public static Observable<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return create(new OnSubscribeTimerPeriodically(paramLong1, paramLong2, paramTimeUnit, paramScheduler));
  }
  
  public static Observable<Long> interval(long paramLong, TimeUnit paramTimeUnit)
  {
    return interval(paramLong, paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  public static Observable<Long> interval(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return interval(paramLong, paramLong, paramTimeUnit, paramScheduler);
  }
  
  public static <T> Observable<T> just(T paramT)
  {
    return ScalarSynchronousObservable.create(paramT);
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2)
  {
    return from((Object[])new Object[] { paramT1, paramT2 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3, paramT4 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8, paramT9 });
  }
  
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9, T paramT10)
  {
    return from((Object[])new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8, paramT9, paramT10 });
  }
  
  private <R> Observable<R> mapNotification(Func1<? super T, ? extends R> paramFunc1, Func1<? super Throwable, ? extends R> paramFunc11, Func0<? extends R> paramFunc0)
  {
    return null;
  }
  
  public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> paramObservable)
  {
    if (paramObservable.getClass() == ScalarSynchronousObservable.class) {
      return ((ScalarSynchronousObservable)paramObservable).scalarFlatMap(UtilityFunctions.identity());
    }
    return paramObservable.lift(OperatorMerge.instance(false));
  }
  
  public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> paramObservable, int paramInt)
  {
    if (paramObservable.getClass() == ScalarSynchronousObservable.class) {
      return ((ScalarSynchronousObservable)paramObservable).scalarFlatMap(UtilityFunctions.identity());
    }
    return paramObservable.lift(OperatorMerge.instance(false, paramInt));
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2 });
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2, paramObservable3 });
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4 });
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5 });
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6 });
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7 });
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8 });
  }
  
  public static <T> Observable<T> merge(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    return merge(new Observable[] { paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8, paramObservable9 });
  }
  
  public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return merge(from(paramIterable));
  }
  
  public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> paramIterable, int paramInt)
  {
    return merge(from(paramIterable), paramInt);
  }
  
  public static <T> Observable<T> merge(Observable<? extends T>[] paramArrayOfObservable)
  {
    return merge(from(paramArrayOfObservable));
  }
  
  public static <T> Observable<T> merge(Observable<? extends T>[] paramArrayOfObservable, int paramInt)
  {
    return merge(from(paramArrayOfObservable), paramInt);
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> paramObservable)
  {
    return paramObservable.lift(OperatorMerge.instance(true));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> paramObservable, int paramInt)
  {
    return paramObservable.lift(OperatorMerge.instance(true, paramInt));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2, paramObservable3));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8));
  }
  
  public static <T> Observable<T> mergeDelayError(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    return mergeDelayError(just(paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8, paramObservable9));
  }
  
  public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return mergeDelayError(from(paramIterable));
  }
  
  public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> paramIterable, int paramInt)
  {
    return mergeDelayError(from(paramIterable), paramInt);
  }
  
  public static <T> Observable<T> never()
  {
    return NeverObservable.instance();
  }
  
  public static Observable<Integer> range(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      if (paramInt2 == 0) {
        return empty();
      }
      if (paramInt1 <= Integer.MAX_VALUE - paramInt2 + 1)
      {
        if (paramInt2 == 1) {
          return just(Integer.valueOf(paramInt1));
        }
        return create(new OnSubscribeRange(paramInt1, paramInt2 - 1 + paramInt1));
      }
      throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
    }
    throw new IllegalArgumentException("Count can not be negative");
  }
  
  public static Observable<Integer> range(int paramInt1, int paramInt2, Scheduler paramScheduler)
  {
    return range(paramInt1, paramInt2).subscribeOn(paramScheduler);
  }
  
  public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    sequenceEqual(paramObservable1, paramObservable2, new Func2()
    {
      public final Boolean call(T paramAnonymousT1, T paramAnonymousT2)
      {
        if (paramAnonymousT1 == null)
        {
          boolean bool;
          if (paramAnonymousT2 == null) {
            bool = true;
          } else {
            bool = false;
          }
          return Boolean.valueOf(bool);
        }
        return Boolean.valueOf(paramAnonymousT1.equals(paramAnonymousT2));
      }
    });
  }
  
  public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Func2<? super T, ? super T, Boolean> paramFunc2)
  {
    return OperatorSequenceEqual.sequenceEqual(paramObservable1, paramObservable2, paramFunc2);
  }
  
  private static <T> Subscription subscribe(Subscriber<? super T> paramSubscriber, Observable<T> paramObservable)
  {
    if (paramSubscriber != null)
    {
      if (paramObservable.onSubscribe != null)
      {
        paramSubscriber.onStart();
        Object localObject = paramSubscriber;
        if (!(paramSubscriber instanceof SafeSubscriber)) {
          localObject = new SafeSubscriber(paramSubscriber);
        }
        try
        {
          hook.onSubscribeStart(paramObservable, paramObservable.onSubscribe).call(localObject);
          paramSubscriber = hook.onSubscribeReturn((Subscription)localObject);
          return paramSubscriber;
        }
        finally
        {
          Exceptions.throwIfFatal(paramSubscriber);
          try
          {
            ((Subscriber)localObject).onError(hook.onSubscribeError(paramSubscriber));
            return Subscriptions.unsubscribed();
          }
          finally
          {
            Exceptions.throwIfFatal(paramObservable);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Error occurred attempting to subscribe [");
            ((StringBuilder)localObject).append(paramSubscriber.getMessage());
            ((StringBuilder)localObject).append("] and then again while trying to pass to onError.");
            paramSubscriber = new RuntimeException(((StringBuilder)localObject).toString(), paramObservable);
            hook.onSubscribeError(paramSubscriber);
          }
        }
      }
      throw new IllegalStateException("onSubscribe function can not be null.");
    }
    throw new IllegalArgumentException("observer can not be null");
  }
  
  public static <T> Observable<T> switchOnNext(Observable<? extends Observable<? extends T>> paramObservable)
  {
    return paramObservable.lift(OperatorSwitch.instance(false));
  }
  
  public static <T> Observable<T> switchOnNextDelayError(Observable<? extends Observable<? extends T>> paramObservable)
  {
    return paramObservable.lift(OperatorSwitch.instance(true));
  }
  
  @Deprecated
  public static Observable<Long> timer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return interval(paramLong1, paramLong2, paramTimeUnit, Schedulers.computation());
  }
  
  @Deprecated
  public static Observable<Long> timer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return interval(paramLong1, paramLong2, paramTimeUnit, paramScheduler);
  }
  
  public static Observable<Long> timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  public static Observable<Long> timer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return create(new OnSubscribeTimerOnce(paramLong, paramTimeUnit, paramScheduler));
  }
  
  public static <T, Resource> Observable<T> using(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Observable<? extends T>> paramFunc1, Action1<? super Resource> paramAction1)
  {
    return using(paramFunc0, paramFunc1, paramAction1, false);
  }
  
  public static <T, Resource> Observable<T> using(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Observable<? extends T>> paramFunc1, Action1<? super Resource> paramAction1, boolean paramBoolean)
  {
    return create(new OnSubscribeUsing(paramFunc0, paramFunc1, paramAction1, paramBoolean));
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Observable<? extends T7> paramObservable6, Observable<? extends T8> paramObservable7, Observable<? extends T9> paramObservable8, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunc9)
  {
    return just(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7, paramObservable8 }).lift(new OperatorZip(paramFunc9));
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Observable<? extends T7> paramObservable6, Observable<? extends T8> paramObservable7, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunc8)
  {
    return just(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6, paramObservable7 }).lift(new OperatorZip(paramFunc8));
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Observable<? extends T7> paramObservable6, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunc7)
  {
    return just(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5, paramObservable6 }).lift(new OperatorZip(paramFunc7));
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Observable<? extends T6> paramObservable5, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunc6)
  {
    return just(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4, paramObservable5 }).lift(new OperatorZip(paramFunc6));
  }
  
  public static <T1, T2, T3, T4, T5, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Observable<? extends T5> paramObservable4, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunc5)
  {
    return just(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3, paramObservable4 }).lift(new OperatorZip(paramFunc5));
  }
  
  public static <T1, T2, T3, T4, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Observable<? extends T4> paramObservable3, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunc4)
  {
    return just(new Observable[] { paramObservable, paramObservable1, paramObservable2, paramObservable3 }).lift(new OperatorZip(paramFunc4));
  }
  
  public static <T1, T2, T3, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Observable<? extends T3> paramObservable2, Func3<? super T1, ? super T2, ? super T3, ? extends R> paramFunc3)
  {
    return just(new Observable[] { paramObservable, paramObservable1, paramObservable2 }).lift(new OperatorZip(paramFunc3));
  }
  
  public static <T1, T2, R> Observable<R> zip(Observable<? extends T1> paramObservable, Observable<? extends T2> paramObservable1, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    return just(new Observable[] { paramObservable, paramObservable1 }).lift(new OperatorZip(paramFunc2));
  }
  
  public static <R> Observable<R> zip(Observable<? extends Observable<?>> paramObservable, FuncN<? extends R> paramFuncN)
  {
    paramObservable.toList().map(new Func1()
    {
      public Observable<?>[] call(List<? extends Observable<?>> paramAnonymousList)
      {
        return null;
      }
    }).lift(new OperatorZip(paramFuncN));
  }
  
  public static <R> Observable<R> zip(Iterable<? extends Observable<?>> paramIterable, FuncN<? extends R> paramFuncN)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add((Observable)paramIterable.next());
    }
    return just(localArrayList.toArray(new Observable[localArrayList.size()])).lift(new OperatorZip(paramFuncN));
  }
  
  public final Observable<Boolean> all(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> ambWith(Observable<? extends T> paramObservable)
  {
    return amb(this, paramObservable);
  }
  
  public final Observable<T> asObservable()
  {
    return null;
  }
  
  public final Observable<List<T>> buffer(int paramInt)
  {
    return buffer(paramInt, paramInt);
  }
  
  public final Observable<List<T>> buffer(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final Observable<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return null;
  }
  
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <B> Observable<List<T>> buffer(Observable<B> paramObservable)
  {
    return buffer(paramObservable, 16);
  }
  
  public final <B> Observable<List<T>> buffer(Observable<B> paramObservable, int paramInt)
  {
    return null;
  }
  
  public final <TOpening, TClosing> Observable<List<T>> buffer(Observable<? extends TOpening> paramObservable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> paramFunc1)
  {
    return null;
  }
  
  public final <TClosing> Observable<List<T>> buffer(Func0<? extends Observable<? extends TClosing>> paramFunc0)
  {
    return null;
  }
  
  public final Observable<T> cache()
  {
    return CachedObservable.from(this);
  }
  
  @Deprecated
  public final Observable<T> cache(int paramInt)
  {
    return cacheWithInitialCapacity(paramInt);
  }
  
  public final Observable<T> cacheWithInitialCapacity(int paramInt)
  {
    return CachedObservable.from(this, paramInt);
  }
  
  public final <R> Observable<R> cast(Class<R> paramClass)
  {
    return null;
  }
  
  public final <R> Observable<R> collect(Func0<R> paramFunc0, Action2<R, ? super T> paramAction2)
  {
    return null;
  }
  
  public <R> Observable<R> compose(Transformer<? super T, ? extends R> paramTransformer)
  {
    return (Observable)paramTransformer.call(this);
  }
  
  public final <R> Observable<R> concatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return null;
  }
  
  public final <R> Observable<R> concatMapDelayError(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return null;
  }
  
  public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return concatMapEager(paramFunc1, RxRingBuffer.SIZE);
  }
  
  public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt)
  {
    return null;
  }
  
  public final <R> Observable<R> concatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> paramFunc1)
  {
    return concat(map(OperatorMapPair.convertSelector(paramFunc1)));
  }
  
  public final Observable<T> concatWith(Observable<? extends T> paramObservable)
  {
    return concat(this, paramObservable);
  }
  
  public final Observable<Boolean> contains(Object paramObject)
  {
    return null;
  }
  
  public final Observable<Integer> count()
  {
    return null;
  }
  
  public final Observable<Long> countLong()
  {
    return null;
  }
  
  public final Observable<T> debounce(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> debounce(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <U> Observable<T> debounce(Func1<? super T, ? extends Observable<U>> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> defaultIfEmpty(T paramT)
  {
    return null;
  }
  
  public final Observable<T> delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <U, V> Observable<T> delay(Func0<? extends Observable<U>> paramFunc0, Func1<? super T, ? extends Observable<V>> paramFunc1)
  {
    return null;
  }
  
  public final <U> Observable<T> delay(Func1<? super T, ? extends Observable<U>> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <U> Observable<T> delaySubscription(Observable<U> paramObservable)
  {
    return null;
  }
  
  public final <U> Observable<T> delaySubscription(Func0<? extends Observable<U>> paramFunc0)
  {
    return null;
  }
  
  public final <T2> Observable<T2> dematerialize()
  {
    return null;
  }
  
  public final Observable<T> distinct()
  {
    return null;
  }
  
  public final <U> Observable<T> distinct(Func1<? super T, ? extends U> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> distinctUntilChanged()
  {
    return null;
  }
  
  public final <U> Observable<T> distinctUntilChanged(Func1<? super T, ? extends U> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> doAfterTerminate(Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> doOnCompleted(Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> doOnEach(Observer<? super T> paramObserver)
  {
    return null;
  }
  
  public final Observable<T> doOnEach(Action1<Notification<? super T>> paramAction1)
  {
    return null;
  }
  
  public final Observable<T> doOnError(Action1<Throwable> paramAction1)
  {
    return null;
  }
  
  public final Observable<T> doOnNext(Action1<? super T> paramAction1)
  {
    return null;
  }
  
  public final Observable<T> doOnRequest(Action1<Long> paramAction1)
  {
    return null;
  }
  
  public final Observable<T> doOnSubscribe(Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> doOnTerminate(Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> doOnUnsubscribe(Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> elementAt(int paramInt)
  {
    return null;
  }
  
  public final Observable<T> elementAtOrDefault(int paramInt, T paramT)
  {
    return null;
  }
  
  public final Observable<Boolean> exists(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public <R> R extend(Func1<? super OnSubscribe<T>, ? extends R> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> filter(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  @Deprecated
  public final Observable<T> finallyDo(Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> first()
  {
    return null;
  }
  
  public final Observable<T> first(Func1<? super T, Boolean> paramFunc1)
  {
    return takeFirst(paramFunc1).single();
  }
  
  public final Observable<T> firstOrDefault(T paramT)
  {
    return null;
  }
  
  public final Observable<T> firstOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return takeFirst(paramFunc1).singleOrDefault(paramT);
  }
  
  public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return null;
  }
  
  public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt)
  {
    return null;
  }
  
  public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, Func1<? super Throwable, ? extends Observable<? extends R>> paramFunc11, Func0<? extends Observable<? extends R>> paramFunc0)
  {
    return merge(mapNotification(paramFunc1, paramFunc11, paramFunc0));
  }
  
  public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, Func1<? super Throwable, ? extends Observable<? extends R>> paramFunc11, Func0<? extends Observable<? extends R>> paramFunc0, int paramInt)
  {
    return merge(mapNotification(paramFunc1, paramFunc11, paramFunc0), paramInt);
  }
  
  public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> paramFunc1, Func2<? super T, ? super U, ? extends R> paramFunc2)
  {
    return null;
  }
  
  public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> paramFunc1, Func2<? super T, ? super U, ? extends R> paramFunc2, int paramInt)
  {
    return null;
  }
  
  public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> paramFunc1)
  {
    return merge(map(OperatorMapPair.convertSelector(paramFunc1)));
  }
  
  public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> paramFunc1, int paramInt)
  {
    return merge(map(OperatorMapPair.convertSelector(paramFunc1)), paramInt);
  }
  
  public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> paramFunc1, Func2<? super T, ? super U, ? extends R> paramFunc2)
  {
    return flatMap(OperatorMapPair.convertSelector(paramFunc1), paramFunc2);
  }
  
  public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> paramFunc1, Func2<? super T, ? super U, ? extends R> paramFunc2, int paramInt)
  {
    return flatMap(OperatorMapPair.convertSelector(paramFunc1), paramFunc2, paramInt);
  }
  
  public final void forEach(Action1<? super T> paramAction1)
  {
    subscribe(paramAction1);
  }
  
  public final void forEach(Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    subscribe(paramAction1, paramAction11);
  }
  
  public final void forEach(Action1<? super T> paramAction1, Action1<Throwable> paramAction11, Action0 paramAction0)
  {
    subscribe(paramAction1, paramAction11, paramAction0);
  }
  
  public final <K> Observable<GroupedObservable<K, T>> groupBy(Func1<? super T, ? extends K> paramFunc1)
  {
    return null;
  }
  
  public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends R> paramFunc11)
  {
    return null;
  }
  
  public final <T2, D1, D2, R> Observable<R> groupJoin(Observable<T2> paramObservable, Func1<? super T, ? extends Observable<D1>> paramFunc1, Func1<? super T2, ? extends Observable<D2>> paramFunc11, Func2<? super T, ? super Observable<T2>, ? extends R> paramFunc2)
  {
    return null;
  }
  
  public final Observable<T> ignoreElements()
  {
    return null;
  }
  
  public final Observable<Boolean> isEmpty()
  {
    return lift(HolderAnyForEmpty.INSTANCE);
  }
  
  public final <TRight, TLeftDuration, TRightDuration, R> Observable<R> join(Observable<TRight> paramObservable, Func1<T, Observable<TLeftDuration>> paramFunc1, Func1<TRight, Observable<TRightDuration>> paramFunc11, Func2<T, TRight, R> paramFunc2)
  {
    return null;
  }
  
  public final Observable<T> last()
  {
    return null;
  }
  
  public final Observable<T> last(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> lastOrDefault(T paramT)
  {
    return null;
  }
  
  public final Observable<T> lastOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final <R> Observable<R> lift(Operator<? extends R, ? super T> paramOperator)
  {
    return null;
  }
  
  public final Observable<T> limit(int paramInt)
  {
    return take(paramInt);
  }
  
  public final <R> Observable<R> map(Func1<? super T, ? extends R> paramFunc1)
  {
    return null;
  }
  
  public final Observable<Notification<T>> materialize()
  {
    return null;
  }
  
  public final Observable<T> mergeWith(Observable<? extends T> paramObservable)
  {
    return merge(this, paramObservable);
  }
  
  public final Observable<Observable<T>> nest()
  {
    return just(this);
  }
  
  public final Observable<T> observeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> observeOn(Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  public final <R> Observable<R> ofType(Class<R> paramClass)
  {
    return null;
  }
  
  public final Observable<T> onBackpressureBuffer()
  {
    return null;
  }
  
  public final Observable<T> onBackpressureBuffer(long paramLong)
  {
    return null;
  }
  
  public final Observable<T> onBackpressureBuffer(long paramLong, Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> onBackpressureBuffer(long paramLong, Action0 paramAction0, BackpressureOverflow.Strategy paramStrategy)
  {
    return null;
  }
  
  public final Observable<T> onBackpressureDrop()
  {
    return null;
  }
  
  public final Observable<T> onBackpressureDrop(Action1<? super T> paramAction1)
  {
    return null;
  }
  
  public final Observable<T> onBackpressureLatest()
  {
    return null;
  }
  
  public final Observable<T> onErrorResumeNext(Observable<? extends T> paramObservable)
  {
    return lift(OperatorOnErrorResumeNextViaFunction.withOther(paramObservable));
  }
  
  public final Observable<T> onErrorResumeNext(Func1<Throwable, ? extends Observable<? extends T>> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> onErrorReturn(Func1<Throwable, ? extends T> paramFunc1)
  {
    return lift(OperatorOnErrorResumeNextViaFunction.withSingle(paramFunc1));
  }
  
  public final Observable<T> onExceptionResumeNext(Observable<? extends T> paramObservable)
  {
    return lift(OperatorOnErrorResumeNextViaFunction.withException(paramObservable));
  }
  
  public final <R> Observable<R> publish(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1)
  {
    return OperatorPublish.create(this, paramFunc1);
  }
  
  public final ConnectableObservable<T> publish()
  {
    return OperatorPublish.create(this);
  }
  
  public final Observable<T> reduce(Func2<T, T, T> paramFunc2)
  {
    return scan(paramFunc2).last();
  }
  
  public final <R> Observable<R> reduce(R paramR, Func2<R, ? super T, R> paramFunc2)
  {
    return scan(paramR, paramFunc2).takeLast(1);
  }
  
  public final Observable<T> repeat()
  {
    return OnSubscribeRedo.repeat(this);
  }
  
  public final Observable<T> repeat(long paramLong)
  {
    return OnSubscribeRedo.repeat(this, paramLong);
  }
  
  public final Observable<T> repeat(long paramLong, Scheduler paramScheduler)
  {
    return OnSubscribeRedo.repeat(this, paramLong, paramScheduler);
  }
  
  public final Observable<T> repeat(Scheduler paramScheduler)
  {
    return OnSubscribeRedo.repeat(this, paramScheduler);
  }
  
  public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, int paramInt)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final ConnectableObservable<T> replay()
  {
    return OperatorReplay.create(this);
  }
  
  public final ConnectableObservable<T> replay(int paramInt)
  {
    return OperatorReplay.create(this, paramInt);
  }
  
  public final ConnectableObservable<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final ConnectableObservable<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final ConnectableObservable<T> replay(int paramInt, Scheduler paramScheduler)
  {
    return OperatorReplay.observeOn(replay(paramInt), paramScheduler);
  }
  
  public final ConnectableObservable<T> replay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final ConnectableObservable<T> replay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return OperatorReplay.create(this, paramLong, paramTimeUnit, paramScheduler);
  }
  
  public final ConnectableObservable<T> replay(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> retry()
  {
    return OnSubscribeRedo.retry(this);
  }
  
  public final Observable<T> retry(long paramLong)
  {
    return OnSubscribeRedo.retry(this, paramLong);
  }
  
  public final Observable<T> retry(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    return null;
  }
  
  public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> sample(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> sample(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <U> Observable<T> sample(Observable<U> paramObservable)
  {
    return null;
  }
  
  public final Observable<T> scan(Func2<T, T, T> paramFunc2)
  {
    return null;
  }
  
  public final <R> Observable<R> scan(R paramR, Func2<R, ? super T, R> paramFunc2)
  {
    return null;
  }
  
  public final Observable<T> serialize()
  {
    return null;
  }
  
  public final Observable<T> share()
  {
    return null;
  }
  
  public final Observable<T> single()
  {
    return null;
  }
  
  public final Observable<T> single(Func1<? super T, Boolean> paramFunc1)
  {
    return filter(paramFunc1).single();
  }
  
  public final Observable<T> singleOrDefault(T paramT)
  {
    return null;
  }
  
  public final Observable<T> singleOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return filter(paramFunc1).singleOrDefault(paramT);
  }
  
  public final Observable<T> skip(int paramInt)
  {
    return null;
  }
  
  public final Observable<T> skip(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> skip(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> skipLast(int paramInt)
  {
    return null;
  }
  
  public final Observable<T> skipLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <U> Observable<T> skipUntil(Observable<U> paramObservable)
  {
    return null;
  }
  
  public final Observable<T> skipWhile(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> startWith(Observable<T> paramObservable)
  {
    return concat(paramObservable, this);
  }
  
  public final Observable<T> startWith(Iterable<T> paramIterable)
  {
    return concat(from(paramIterable), this);
  }
  
  public final Observable<T> startWith(T paramT)
  {
    return concat(just(paramT), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2)
  {
    return concat(just(paramT1, paramT2), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2, T paramT3)
  {
    return concat(just(paramT1, paramT2, paramT3), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    return concat(just(paramT1, paramT2, paramT3, paramT4), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5)
  {
    return concat(just(paramT1, paramT2, paramT3, paramT4, paramT5), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6)
  {
    return concat(just(paramT1, paramT2, paramT3, paramT4, paramT5, paramT6), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7)
  {
    return concat(just(paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8)
  {
    return concat(just(paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8), this);
  }
  
  public final Observable<T> startWith(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9)
  {
    return concat(just(paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8, paramT9), this);
  }
  
  public final Subscription subscribe()
  {
    return null;
  }
  
  public final Subscription subscribe(Observer<? super T> paramObserver)
  {
    return null;
  }
  
  public final Subscription subscribe(Subscriber<? super T> paramSubscriber)
  {
    return subscribe(paramSubscriber, this);
  }
  
  public final Subscription subscribe(Action1<? super T> paramAction1)
  {
    return null;
  }
  
  public final Subscription subscribe(Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    return null;
  }
  
  public final Subscription subscribe(Action1<? super T> paramAction1, Action1<Throwable> paramAction11, Action0 paramAction0)
  {
    return null;
  }
  
  public final Observable<T> subscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> switchIfEmpty(Observable<? extends T> paramObservable)
  {
    return null;
  }
  
  public final <R> Observable<R> switchMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return switchOnNext(map(paramFunc1));
  }
  
  public final <R> Observable<R> switchMapDelayError(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return switchOnNextDelayError(map(paramFunc1));
  }
  
  public final Observable<T> take(int paramInt)
  {
    return null;
  }
  
  public final Observable<T> take(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> take(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> takeFirst(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> takeLast(int paramInt)
  {
    return null;
  }
  
  public final Observable<T> takeLast(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> takeLast(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> takeLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<List<T>> takeLastBuffer(int paramInt)
  {
    return takeLast(paramInt).toList();
  }
  
  public final Observable<List<T>> takeLastBuffer(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return takeLast(paramInt, paramLong, paramTimeUnit).toList();
  }
  
  public final Observable<List<T>> takeLastBuffer(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return takeLast(paramInt, paramLong, paramTimeUnit, paramScheduler).toList();
  }
  
  public final Observable<List<T>> takeLastBuffer(long paramLong, TimeUnit paramTimeUnit)
  {
    return takeLast(paramLong, paramTimeUnit).toList();
  }
  
  public final Observable<List<T>> takeLastBuffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return takeLast(paramLong, paramTimeUnit, paramScheduler).toList();
  }
  
  public final <E> Observable<T> takeUntil(Observable<? extends E> paramObservable)
  {
    return null;
  }
  
  public final Observable<T> takeUntil(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> takeWhile(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public final Observable<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> throttleLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return sample(paramLong, paramTimeUnit);
  }
  
  public final Observable<T> throttleLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return sample(paramLong, paramTimeUnit, paramScheduler);
  }
  
  public final Observable<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return debounce(paramLong, paramTimeUnit);
  }
  
  public final Observable<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return debounce(paramLong, paramTimeUnit, paramScheduler);
  }
  
  public final Observable<TimeInterval<T>> timeInterval()
  {
    return null;
  }
  
  public final Observable<TimeInterval<T>> timeInterval(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Observable<? extends T> paramObservable)
  {
    return null;
  }
  
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> paramFunc0, Func1<? super T, ? extends Observable<V>> paramFunc1)
  {
    return timeout(paramFunc0, paramFunc1, null);
  }
  
  public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> paramFunc0, Func1<? super T, ? extends Observable<V>> paramFunc1, Observable<? extends T> paramObservable)
  {
    return null;
  }
  
  public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> paramFunc1)
  {
    return timeout(null, paramFunc1, null);
  }
  
  public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> paramFunc1, Observable<? extends T> paramObservable)
  {
    return timeout(null, paramFunc1, paramObservable);
  }
  
  public final Observable<Timestamped<T>> timestamp()
  {
    return null;
  }
  
  public final Observable<Timestamped<T>> timestamp(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final BlockingObservable<T> toBlocking()
  {
    return BlockingObservable.from(this);
  }
  
  public Completable toCompletable()
  {
    return Completable.fromObservable(this);
  }
  
  public final Observable<List<T>> toList()
  {
    return null;
  }
  
  public final <K> Observable<Map<K, T>> toMap(Func1<? super T, ? extends K> paramFunc1)
  {
    return null;
  }
  
  public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    return null;
  }
  
  public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, V>> paramFunc0)
  {
    return null;
  }
  
  public final <K> Observable<Map<K, Collection<T>>> toMultimap(Func1<? super T, ? extends K> paramFunc1)
  {
    return null;
  }
  
  public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    return null;
  }
  
  public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0)
  {
    return null;
  }
  
  public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0, Func1<? super K, ? extends Collection<V>> paramFunc12)
  {
    return null;
  }
  
  public Single<T> toSingle()
  {
    return null;
  }
  
  public final Observable<List<T>> toSortedList()
  {
    return null;
  }
  
  public final Observable<List<T>> toSortedList(int paramInt)
  {
    return null;
  }
  
  public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> paramFunc2)
  {
    return null;
  }
  
  public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> paramFunc2, int paramInt)
  {
    return null;
  }
  
  public final Subscription unsafeSubscribe(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  public final Observable<T> unsubscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(int paramInt)
  {
    return window(paramInt, paramInt);
  }
  
  public final Observable<Observable<T>> window(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final Observable<Observable<T>> window(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  public final <U> Observable<Observable<T>> window(Observable<U> paramObservable)
  {
    return null;
  }
  
  public final <TOpening, TClosing> Observable<Observable<T>> window(Observable<? extends TOpening> paramObservable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> paramFunc1)
  {
    return null;
  }
  
  public final <TClosing> Observable<Observable<T>> window(Func0<? extends Observable<? extends TClosing>> paramFunc0)
  {
    return null;
  }
  
  public final <U, R> Observable<R> withLatestFrom(Observable<? extends U> paramObservable, Func2<? super T, ? super U, ? extends R> paramFunc2)
  {
    return null;
  }
  
  public final <T2, R> Observable<R> zipWith(Observable<? extends T2> paramObservable, Func2<? super T, ? super T2, ? extends R> paramFunc2)
  {
    return zip(this, paramObservable, paramFunc2);
  }
  
  public final <T2, R> Observable<R> zipWith(Iterable<? extends T2> paramIterable, Func2<? super T, ? super T2, ? extends R> paramFunc2)
  {
    return null;
  }
  
  private static final class CountHolder
  {
    static final Func2<Integer, Object, Integer> INSTANCE = new Func2()
    {
      public final Integer call(Integer paramAnonymousInteger, Object paramAnonymousObject)
      {
        return Integer.valueOf(paramAnonymousInteger.intValue() + 1);
      }
    };
  }
  
  private static final class CountLongHolder
  {
    static final Func2<Long, Object, Long> INSTANCE = new Func2()
    {
      public final Long call(Long paramAnonymousLong, Object paramAnonymousObject)
      {
        return null;
      }
    };
  }
  
  private static final class EmptyHolder
  {
    static final Observable<Object> INSTANCE = Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Object> paramAnonymousSubscriber)
      {
        paramAnonymousSubscriber.onCompleted();
      }
    });
  }
  
  private static class HolderAnyForEmpty
  {
    static final OperatorAny<?> INSTANCE = new OperatorAny(UtilityFunctions.alwaysTrue(), true);
  }
  
  private static class NeverObservable<T>
    extends Observable<T>
  {
    NeverObservable()
    {
      super()
      {
        public void call(Subscriber<? super T> paramAnonymousSubscriber) {}
      };
    }
    
    static <T> NeverObservable<T> instance()
    {
      return Holder.INSTANCE;
    }
    
    private static class Holder
    {
      static final Observable.NeverObservable<?> INSTANCE = new Observable.NeverObservable();
    }
  }
  
  public static abstract interface OnSubscribe<T>
    extends Action1<Subscriber<? super T>>
  {}
  
  public static abstract interface Operator<R, T>
    extends Func1<Subscriber<? super R>, Subscriber<? super T>>
  {}
  
  private static class ThrowObservable<T>
    extends Observable<T>
  {
    public ThrowObservable(Throwable paramThrowable)
    {
      super()
      {
        public void call(Subscriber<? super T> paramAnonymousSubscriber)
        {
          paramAnonymousSubscriber.onError(Observable.ThrowObservable.this);
        }
      };
    }
  }
  
  public static abstract interface Transformer<T, R>
    extends Func1<Observable<T>, Observable<R>>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Observable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */