package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Observable<T>
  implements ObservableSource<T>
{
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new ObservableAmb(null, paramIterable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> ambArray(ObservableSource<? extends T>... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    int i = paramVarArgs.length;
    if (i == 0) {
      return empty();
    }
    if (i == 1) {
      return wrap(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new ObservableAmb(paramVarArgs, null));
  }
  
  public static int bufferSize()
  {
    return Flowable.bufferSize();
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, ObservableSource<? extends T7> paramObservableSource6, ObservableSource<? extends T8> paramObservableSource7, ObservableSource<? extends T9> paramObservableSource8, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunction9)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramObservableSource6, "source7 is null");
    ObjectHelper.requireNonNull(paramObservableSource7, "source8 is null");
    ObjectHelper.requireNonNull(paramObservableSource8, "source9 is null");
    return combineLatest(Functions.toFunction(paramFunction9), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5, paramObservableSource6, paramObservableSource7, paramObservableSource8 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, ObservableSource<? extends T7> paramObservableSource6, ObservableSource<? extends T8> paramObservableSource7, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunction8)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramObservableSource6, "source7 is null");
    ObjectHelper.requireNonNull(paramObservableSource7, "source8 is null");
    return combineLatest(Functions.toFunction(paramFunction8), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5, paramObservableSource6, paramObservableSource7 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, ObservableSource<? extends T7> paramObservableSource6, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunction7)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramObservableSource6, "source7 is null");
    return combineLatest(Functions.toFunction(paramFunction7), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5, paramObservableSource6 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunction6)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    return combineLatest(Functions.toFunction(paramFunction6), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunction5)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    return combineLatest(Functions.toFunction(paramFunction5), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunction4)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    return combineLatest(Functions.toFunction(paramFunction4), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, Function3<? super T1, ? super T2, ? super T3, ? extends R> paramFunction3)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    return combineLatest(Functions.toFunction(paramFunction3), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    return combineLatest(Functions.toFunction(paramBiFunction), bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> paramFunction, int paramInt, ObservableSource<? extends T>... paramVarArgs)
  {
    return combineLatest(paramVarArgs, paramFunction, paramInt);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatest(paramIterable, paramFunction, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, paramIterable, paramFunction, paramInt << 1, false));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] paramArrayOfObservableSource, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatest(paramArrayOfObservableSource, paramFunction, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] paramArrayOfObservableSource, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramArrayOfObservableSource, "sources is null");
    if (paramArrayOfObservableSource.length == 0) {
      return empty();
    }
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new ObservableCombineLatest(paramArrayOfObservableSource, null, paramFunction, paramInt << 1, false));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> paramFunction, int paramInt, ObservableSource<? extends T>... paramVarArgs)
  {
    return combineLatestDelayError(paramVarArgs, paramFunction, paramInt);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatestDelayError(paramIterable, paramFunction, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, paramIterable, paramFunction, paramInt << 1, true));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] paramArrayOfObservableSource, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatestDelayError(paramArrayOfObservableSource, paramFunction, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] paramArrayOfObservableSource, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    if (paramArrayOfObservableSource.length == 0) {
      return empty();
    }
    return RxJavaPlugins.onAssembly(new ObservableCombineLatest(paramArrayOfObservableSource, null, paramFunction, paramInt << 1, true));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource)
  {
    return concat(paramObservableSource, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, int paramInt)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly(new ObservableConcatMap(paramObservableSource, Functions.identity(), paramInt, ErrorMode.IMMEDIATE));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concat(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    return concatArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concat(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, ObservableSource<? extends T> paramObservableSource3)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source3 is null");
    return concatArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2, paramObservableSource3 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concat(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, ObservableSource<? extends T> paramObservableSource3, ObservableSource<? extends T> paramObservableSource4)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source4 is null");
    return concatArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return fromIterable(paramIterable).concatMapDelayError(Functions.identity(), bufferSize(), false);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatArray(ObservableSource<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new ObservableConcatMap(fromArray(paramVarArgs), Functions.identity(), bufferSize(), ErrorMode.BOUNDARY));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return concatDelayError(fromArray(paramVarArgs));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatArrayEager(int paramInt1, int paramInt2, ObservableSource<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).concatMapEagerDelayError(Functions.identity(), paramInt1, paramInt2, false);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... paramVarArgs)
  {
    return concatArrayEager(bufferSize(), bufferSize(), paramVarArgs);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatArrayEagerDelayError(int paramInt1, int paramInt2, ObservableSource<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).concatMapEagerDelayError(Functions.identity(), paramInt1, paramInt2, true);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatArrayEagerDelayError(ObservableSource<? extends T>... paramVarArgs)
  {
    return concatArrayEagerDelayError(bufferSize(), bufferSize(), paramVarArgs);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource)
  {
    return concatDelayError(paramObservableSource, bufferSize(), true);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, int paramInt, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "prefetch is null");
    Function localFunction = Functions.identity();
    ErrorMode localErrorMode;
    if (paramBoolean) {
      localErrorMode = ErrorMode.END;
    } else {
      localErrorMode = ErrorMode.BOUNDARY;
    }
    return RxJavaPlugins.onAssembly(new ObservableConcatMap(paramObservableSource, localFunction, paramInt, localErrorMode));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return concatDelayError(fromIterable(paramIterable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource)
  {
    return concatEager(paramObservableSource, bufferSize(), bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, int paramInt1, int paramInt2)
  {
    return wrap(paramObservableSource).concatMapEager(Functions.identity(), paramInt1, paramInt2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> paramIterable)
  {
    return concatEager(paramIterable, bufferSize(), bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).concatMapEagerDelayError(Functions.identity(), paramInt1, paramInt2, false);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> create(ObservableOnSubscribe<T> paramObservableOnSubscribe)
  {
    ObjectHelper.requireNonNull(paramObservableOnSubscribe, "source is null");
    return RxJavaPlugins.onAssembly(new ObservableCreate(paramObservableOnSubscribe));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "supplier is null");
    return RxJavaPlugins.onAssembly(new ObservableDefer(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  private Observable<T> doOnEach(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction1, Action paramAction2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> empty()
  {
    return RxJavaPlugins.onAssembly(ObservableEmpty.INSTANCE);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> error(Throwable paramThrowable)
  {
    ObjectHelper.requireNonNull(paramThrowable, "exception is null");
    return error(Functions.justCallable(paramThrowable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> error(Callable<? extends Throwable> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "errorSupplier is null");
    return RxJavaPlugins.onAssembly(new ObservableError(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> fromArray(T... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "items is null");
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return just(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new ObservableFromArray(paramVarArgs));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> fromCallable(Callable<? extends T> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "supplier is null");
    return RxJavaPlugins.onAssembly(new ObservableFromCallable(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> fromFuture(Future<? extends T> paramFuture)
  {
    ObjectHelper.requireNonNull(paramFuture, "future is null");
    return RxJavaPlugins.onAssembly(new ObservableFromFuture(paramFuture, 0L, null));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    ObjectHelper.requireNonNull(paramFuture, "future is null");
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    return RxJavaPlugins.onAssembly(new ObservableFromFuture(paramFuture, paramLong, paramTimeUnit));
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static <T> Observable<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return fromFuture(paramFuture, paramLong, paramTimeUnit).subscribeOn(paramScheduler);
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static <T> Observable<T> fromFuture(Future<? extends T> paramFuture, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return fromFuture(paramFuture).subscribeOn(paramScheduler);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> fromIterable(Iterable<? extends T> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "source is null");
    return RxJavaPlugins.onAssembly(new ObservableFromIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> fromPublisher(Publisher<? extends T> paramPublisher)
  {
    ObjectHelper.requireNonNull(paramPublisher, "publisher is null");
    return RxJavaPlugins.onAssembly(new ObservableFromPublisher(paramPublisher));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> generate(Consumer<Emitter<T>> paramConsumer)
  {
    ObjectHelper.requireNonNull(paramConsumer, "generator is null");
    return generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(paramConsumer), Functions.emptyConsumer());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Observable<T> generate(Callable<S> paramCallable, BiConsumer<S, Emitter<T>> paramBiConsumer)
  {
    ObjectHelper.requireNonNull(paramBiConsumer, "generator is null");
    return generate(paramCallable, ObservableInternalHelper.simpleBiGenerator(paramBiConsumer), Functions.emptyConsumer());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Observable<T> generate(Callable<S> paramCallable, BiConsumer<S, Emitter<T>> paramBiConsumer, Consumer<? super S> paramConsumer)
  {
    ObjectHelper.requireNonNull(paramBiConsumer, "generator is null");
    return generate(paramCallable, ObservableInternalHelper.simpleBiGenerator(paramBiConsumer), paramConsumer);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Observable<T> generate(Callable<S> paramCallable, BiFunction<S, Emitter<T>, S> paramBiFunction)
  {
    return generate(paramCallable, paramBiFunction, Functions.emptyConsumer());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Observable<T> generate(Callable<S> paramCallable, BiFunction<S, Emitter<T>, S> paramBiFunction, Consumer<? super S> paramConsumer)
  {
    ObjectHelper.requireNonNull(paramCallable, "initialState is null");
    ObjectHelper.requireNonNull(paramBiFunction, "generator is null");
    ObjectHelper.requireNonNull(paramConsumer, "disposeState is null");
    return RxJavaPlugins.onAssembly(new ObservableGenerate(paramCallable, paramBiFunction, paramConsumer));
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Observable<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return interval(paramLong1, paramLong2, paramTimeUnit, Schedulers.computation());
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Observable<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0L, paramLong1), Math.max(0L, paramLong2), paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Observable<Long> interval(long paramLong, TimeUnit paramTimeUnit)
  {
    return interval(paramLong, paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Observable<Long> interval(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return interval(paramLong, paramLong, paramTimeUnit, paramScheduler);
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Observable<Long> intervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit)
  {
    return intervalRange(paramLong1, paramLong2, paramLong3, paramLong4, paramTimeUnit, Schedulers.computation());
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Observable<Long> intervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    boolean bool = paramLong2 < 0L;
    if (!bool)
    {
      if (!bool) {
        return empty().delay(paramLong3, paramTimeUnit, paramScheduler);
      }
      paramLong2 = paramLong1 + (paramLong2 - 1L);
      if ((paramLong1 > 0L) && (paramLong2 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
      ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
      return RxJavaPlugins.onAssembly(new ObservableIntervalRange(paramLong1, paramLong2, Math.max(0L, paramLong3), Math.max(0L, paramLong4), paramTimeUnit, paramScheduler));
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("count >= 0 required but it was ");
    paramTimeUnit.append(paramLong2);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT)
  {
    ObjectHelper.requireNonNull(paramT, "item is null");
    return RxJavaPlugins.onAssembly(new ObservableJust(paramT));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    return fromArray(new Object[] { paramT1, paramT2 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    ObjectHelper.requireNonNull(paramT6, "item6 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    ObjectHelper.requireNonNull(paramT6, "item6 is null");
    ObjectHelper.requireNonNull(paramT7, "item7 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    ObjectHelper.requireNonNull(paramT6, "item6 is null");
    ObjectHelper.requireNonNull(paramT7, "item7 is null");
    ObjectHelper.requireNonNull(paramT8, "item8 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    ObjectHelper.requireNonNull(paramT6, "item6 is null");
    ObjectHelper.requireNonNull(paramT7, "item7 is null");
    ObjectHelper.requireNonNull(paramT8, "item8 is null");
    ObjectHelper.requireNonNull(paramT9, "item9 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8, paramT9 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9, T paramT10)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    ObjectHelper.requireNonNull(paramT6, "item6 is null");
    ObjectHelper.requireNonNull(paramT7, "item7 is null");
    ObjectHelper.requireNonNull(paramT8, "item8 is null");
    ObjectHelper.requireNonNull(paramT9, "item9 is null");
    ObjectHelper.requireNonNull(paramT10, "item10 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8, paramT9, paramT10 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    return RxJavaPlugins.onAssembly(new ObservableFlatMap(paramObservableSource, Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, int paramInt)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "maxConcurrency");
    return RxJavaPlugins.onAssembly(new ObservableFlatMap(paramObservableSource, Functions.identity(), false, paramInt, bufferSize()));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    return fromArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2 }).flatMap(Functions.identity(), false, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, ObservableSource<? extends T> paramObservableSource3)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source3 is null");
    return fromArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2, paramObservableSource3 }).flatMap(Functions.identity(), false, 3);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, ObservableSource<? extends T> paramObservableSource3, ObservableSource<? extends T> paramObservableSource4)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source4 is null");
    return fromArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4 }).flatMap(Functions.identity(), false, 4);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> paramIterable)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> paramIterable, int paramInt)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), paramInt);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), false, paramInt1, paramInt2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeArray(int paramInt1, int paramInt2, ObservableSource<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), false, paramInt1, paramInt2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), paramVarArgs.length);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeArrayDelayError(int paramInt1, int paramInt2, ObservableSource<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), true, paramInt1, paramInt2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), true, paramVarArgs.length);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    return RxJavaPlugins.onAssembly(new ObservableFlatMap(paramObservableSource, Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, int paramInt)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "maxConcurrency");
    return RxJavaPlugins.onAssembly(new ObservableFlatMap(paramObservableSource, Functions.identity(), true, paramInt, bufferSize()));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    return fromArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2 }).flatMap(Functions.identity(), true, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, ObservableSource<? extends T> paramObservableSource3)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source3 is null");
    return fromArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2, paramObservableSource3 }).flatMap(Functions.identity(), true, 3);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, ObservableSource<? extends T> paramObservableSource3, ObservableSource<? extends T> paramObservableSource4)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source4 is null");
    return fromArray(new ObservableSource[] { paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4 }).flatMap(Functions.identity(), true, 4);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> paramIterable)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), true);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> paramIterable, int paramInt)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), true, paramInt);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), true, paramInt1, paramInt2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> never()
  {
    return RxJavaPlugins.onAssembly(ObservableNever.INSTANCE);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Observable<Integer> range(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      if (paramInt2 == 0) {
        return empty();
      }
      if (paramInt2 == 1) {
        return just(Integer.valueOf(paramInt1));
      }
      if (paramInt1 + (paramInt2 - 1) <= 2147483647L) {
        return RxJavaPlugins.onAssembly(new ObservableRange(paramInt1, paramInt2));
      }
      throw new IllegalArgumentException("Integer overflow");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramInt2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Observable<Long> rangeLong(long paramLong1, long paramLong2)
  {
    boolean bool = paramLong2 < 0L;
    if (!bool)
    {
      if (!bool) {
        return empty();
      }
      if (paramLong2 == 1L) {
        return just(Long.valueOf(paramLong1));
      }
      if ((paramLong1 > 0L) && (paramLong2 - 1L + paramLong1 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      return RxJavaPlugins.onAssembly(new ObservableRangeLong(paramLong1, paramLong2));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramLong2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2)
  {
    return sequenceEqual(paramObservableSource1, paramObservableSource2, ObjectHelper.equalsPredicate(), bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, int paramInt)
  {
    return sequenceEqual(paramObservableSource1, paramObservableSource2, ObjectHelper.equalsPredicate(), paramInt);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, BiPredicate<? super T, ? super T> paramBiPredicate)
  {
    return sequenceEqual(paramObservableSource1, paramObservableSource2, paramBiPredicate, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, BiPredicate<? super T, ? super T> paramBiPredicate, int paramInt)
  {
    ObjectHelper.requireNonNull(paramObservableSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramBiPredicate, "isEqual is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new ObservableSequenceEqualSingle(paramObservableSource1, paramObservableSource2, paramBiPredicate, paramInt));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource)
  {
    return switchOnNext(paramObservableSource, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, int paramInt)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new ObservableSwitchMap(paramObservableSource, Functions.identity(), paramInt, false));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource)
  {
    return switchOnNextDelayError(paramObservableSource, bufferSize());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, int paramInt)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly(new ObservableSwitchMap(paramObservableSource, Functions.identity(), paramInt, true));
  }
  
  private Observable<T> timeout0(long paramLong, TimeUnit paramTimeUnit, ObservableSource<? extends T> paramObservableSource, Scheduler paramScheduler)
  {
    return null;
  }
  
  private <U, V> Observable<T> timeout0(ObservableSource<U> paramObservableSource, Function<? super T, ? extends ObservableSource<V>> paramFunction, ObservableSource<? extends T> paramObservableSource1)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Observable<Long> timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Observable<Long> timer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return RxJavaPlugins.onAssembly(new ObservableTimer(Math.max(paramLong, 0L), paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> unsafeCreate(ObservableSource<T> paramObservableSource)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "onSubscribe is null");
    if (!(paramObservableSource instanceof Observable)) {
      return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(paramObservableSource));
    }
    throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, D> Observable<T> using(Callable<? extends D> paramCallable, Function<? super D, ? extends ObservableSource<? extends T>> paramFunction, Consumer<? super D> paramConsumer)
  {
    return using(paramCallable, paramFunction, paramConsumer, true);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, D> Observable<T> using(Callable<? extends D> paramCallable, Function<? super D, ? extends ObservableSource<? extends T>> paramFunction, Consumer<? super D> paramConsumer, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramCallable, "resourceSupplier is null");
    ObjectHelper.requireNonNull(paramFunction, "sourceSupplier is null");
    ObjectHelper.requireNonNull(paramConsumer, "disposer is null");
    return RxJavaPlugins.onAssembly(new ObservableUsing(paramCallable, paramFunction, paramConsumer, paramBoolean));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> wrap(ObservableSource<T> paramObservableSource)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source is null");
    if ((paramObservableSource instanceof Observable)) {
      return RxJavaPlugins.onAssembly((Observable)paramObservableSource);
    }
    return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(paramObservableSource));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, ObservableSource<? extends T7> paramObservableSource6, ObservableSource<? extends T8> paramObservableSource7, ObservableSource<? extends T9> paramObservableSource8, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunction9)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramObservableSource6, "source7 is null");
    ObjectHelper.requireNonNull(paramObservableSource7, "source8 is null");
    ObjectHelper.requireNonNull(paramObservableSource8, "source9 is null");
    return zipArray(Functions.toFunction(paramFunction9), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5, paramObservableSource6, paramObservableSource7, paramObservableSource8 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, ObservableSource<? extends T7> paramObservableSource6, ObservableSource<? extends T8> paramObservableSource7, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunction8)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramObservableSource6, "source7 is null");
    ObjectHelper.requireNonNull(paramObservableSource7, "source8 is null");
    return zipArray(Functions.toFunction(paramFunction8), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5, paramObservableSource6, paramObservableSource7 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, ObservableSource<? extends T7> paramObservableSource6, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunction7)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramObservableSource6, "source7 is null");
    return zipArray(Functions.toFunction(paramFunction7), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5, paramObservableSource6 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, ObservableSource<? extends T6> paramObservableSource5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunction6)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramObservableSource5, "source6 is null");
    return zipArray(Functions.toFunction(paramFunction6), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4, paramObservableSource5 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, ObservableSource<? extends T5> paramObservableSource4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunction5)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramObservableSource4, "source5 is null");
    return zipArray(Functions.toFunction(paramFunction5), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3, paramObservableSource4 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, ObservableSource<? extends T4> paramObservableSource3, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunction4)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramObservableSource3, "source4 is null");
    return zipArray(Functions.toFunction(paramFunction4), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2, paramObservableSource3 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, ObservableSource<? extends T3> paramObservableSource2, Function3<? super T1, ? super T2, ? super T3, ? extends R> paramFunction3)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramObservableSource2, "source3 is null");
    return zipArray(Functions.toFunction(paramFunction3), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1, paramObservableSource2 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    return zipArray(Functions.toFunction(paramBiFunction), false, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    return zipArray(Functions.toFunction(paramBiFunction), paramBoolean, bufferSize(), new ObservableSource[] { paramObservableSource, paramObservableSource1 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> paramObservableSource, ObservableSource<? extends T2> paramObservableSource1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "source1 is null");
    ObjectHelper.requireNonNull(paramObservableSource1, "source2 is null");
    return zipArray(Functions.toFunction(paramBiFunction), paramBoolean, paramInt, new ObservableSource[] { paramObservableSource, paramObservableSource1 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> paramObservableSource, Function<? super Object[], ? extends R> paramFunction)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    return RxJavaPlugins.onAssembly(new ObservableToList(paramObservableSource, 16).flatMap(ObservableInternalHelper.zipIterable(paramFunction)));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new ObservableZip(null, paramIterable, paramFunction, bufferSize(), false));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> paramFunction, boolean paramBoolean, int paramInt, ObservableSource<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new ObservableZip(paramVarArgs, null, paramFunction, paramInt, paramBoolean));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, boolean paramBoolean, int paramInt)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new ObservableZip(null, paramIterable, paramFunction, paramInt, paramBoolean));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> all(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> ambWith(ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> any(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> R as(ObservableConverter<T, ? extends R> paramObservableConverter)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingFirst()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingFirst(T paramT)
  {
    return null;
  }
  
  /* Error */
  @SchedulerSupport("none")
  public final void blockingForEach(Consumer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingIterable()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingIterable(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingLast()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingLast(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingLatest()
  {
    return new BlockingObservableLatest(this);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingMostRecent(T paramT)
  {
    return new BlockingObservableMostRecent(this, paramT);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingNext()
  {
    return new BlockingObservableNext(this);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingSingle()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingSingle(T paramT)
  {
    return (T)single(paramT).blockingGet();
  }
  
  @SchedulerSupport("none")
  public final void blockingSubscribe()
  {
    ObservableBlockingSubscribe.subscribe(this);
  }
  
  @SchedulerSupport("none")
  public final void blockingSubscribe(Observer<? super T> paramObserver)
  {
    ObservableBlockingSubscribe.subscribe(this, paramObserver);
  }
  
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer)
  {
    ObservableBlockingSubscribe.subscribe(this, paramConsumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
  }
  
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1)
  {
    ObservableBlockingSubscribe.subscribe(this, paramConsumer, paramConsumer1, Functions.EMPTY_ACTION);
  }
  
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction)
  {
    ObservableBlockingSubscribe.subscribe(this, paramConsumer, paramConsumer1, paramAction);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<List<T>> buffer(int paramInt)
  {
    return buffer(paramInt, paramInt);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<List<T>> buffer(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U extends Collection<? super T>> Observable<U> buffer(int paramInt1, int paramInt2, Callable<U> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U extends Collection<? super T>> Observable<U> buffer(int paramInt, Callable<U> paramCallable)
  {
    return buffer(paramInt, paramInt, paramCallable);
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <U extends Collection<? super T>> Observable<U> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, Callable<U> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <U extends Collection<? super T>> Observable<U> buffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt, Callable<U> paramCallable, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Observable<List<T>> buffer(ObservableSource<B> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Observable<List<T>> buffer(ObservableSource<B> paramObservableSource, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> paramObservableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> paramObservableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> paramFunction, Callable<U> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> paramObservableSource, Callable<U> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> paramCallable, Callable<U> paramCallable1)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> cache()
  {
    return cacheWithInitialCapacity(16);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> cacheWithInitialCapacity(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<U> cast(Class<U> paramClass)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<U> collect(Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<U> collectInto(U paramU, BiConsumer<? super U, ? super T> paramBiConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> paramObservableTransformer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    return concatMap(paramFunction, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return concatMapCompletable(paramFunction, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return concatMapCompletableDelayError(paramFunction, true, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean)
  {
    return concatMapCompletableDelayError(paramFunction, paramBoolean, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return concatMapMaybe(paramFunction, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return concatMapMaybeDelayError(paramFunction, true, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return concatMapMaybeDelayError(paramFunction, paramBoolean, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return concatMapSingle(paramFunction, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return concatMapSingleDelayError(paramFunction, true, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return concatMapSingleDelayError(paramFunction, paramBoolean, 2);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> concatWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> concatWith(MaybeSource<? extends T> paramMaybeSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> concatWith(ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> concatWith(SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> contains(Object paramObject)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Long> count()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> debounce(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> debounce(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> defaultIfEmpty(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> delay(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Observable<T> delay(ObservableSource<U> paramObservableSource, Function<? super T, ? extends ObservableSource<V>> paramFunction)
  {
    return delaySubscription(paramObservableSource).delay(paramFunction);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return delaySubscription(timer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<T> delaySubscription(ObservableSource<U> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  @Deprecated
  public final <T2> Observable<T2> dematerialize()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> dematerialize(Function<? super T, Notification<R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> distinct()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Observable<T> distinct(Function<? super T, K> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Observable<T> distinct(Function<? super T, K> paramFunction, Callable<? extends Collection<? super K>> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> distinctUntilChanged()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> paramBiPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doAfterNext(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doAfterTerminate(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doFinally(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnComplete(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnDispose(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnEach(Observer<? super T> paramObserver)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnEach(Consumer<? super Notification<T>> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnError(Consumer<? super Throwable> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnLifecycle(Consumer<? super Disposable> paramConsumer, Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnNext(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnSubscribe(Consumer<? super Disposable> paramConsumer)
  {
    return doOnLifecycle(paramConsumer, Functions.EMPTY_ACTION);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> doOnTerminate(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> elementAt(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> elementAt(long paramLong, T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> elementAtOrError(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> filter(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> first(T paramT)
  {
    return elementAt(0L, paramT);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> firstElement()
  {
    return elementAt(0L);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> firstOrError()
  {
    return elementAtOrError(0L);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    return flatMap(paramFunction, false);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, Function<? super Throwable, ? extends ObservableSource<? extends R>> paramFunction1, Callable<? extends ObservableSource<? extends R>> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, Function<Throwable, ? extends ObservableSource<? extends R>> paramFunction1, Callable<? extends ObservableSource<? extends R>> paramCallable, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return flatMap(paramFunction, paramBoolean, Integer.MAX_VALUE);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return flatMapCompletable(paramFunction, false);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends V> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return flatMapMaybe(paramFunction, false);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return flatMapSingle(paramFunction, false);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEach(Consumer<? super T> paramConsumer)
  {
    return subscribe(paramConsumer);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEachWhile(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEachWhile(Predicate<? super T> paramPredicate, Consumer<? super Throwable> paramConsumer)
  {
    return forEachWhile(paramPredicate, paramConsumer, Functions.EMPTY_ACTION);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEachWhile(Predicate<? super T> paramPredicate, Consumer<? super Throwable> paramConsumer, Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> paramObservableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> paramFunction, Function<? super TRight, ? extends ObservableSource<TRightEnd>> paramFunction1, BiFunction<? super T, ? super Observable<TRight>, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> hide()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable ignoreElements()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> isEmpty()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> paramObservableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> paramFunction, Function<? super TRight, ? extends ObservableSource<TRightEnd>> paramFunction1, BiFunction<? super T, ? super TRight, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> last(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> lastElement()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> lastOrError()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> paramObservableOperator)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> map(Function<? super T, ? extends R> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Notification<T>> materialize()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> mergeWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> mergeWith(MaybeSource<? extends T> paramMaybeSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> mergeWith(ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> mergeWith(SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> observeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> observeOn(Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> observeOn(Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<U> ofType(Class<U> paramClass)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> onErrorReturnItem(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> onTerminateDetach()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ConnectableObservable<T> publish()
  {
    return ObservablePublish.create(this);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> reduce(BiFunction<T, T, T> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> reduce(R paramR, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> reduceWith(Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> repeat()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> repeat(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> repeatUntil(BooleanSupplier paramBooleanSupplier)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ConnectableObservable<T> replay()
  {
    return ObservableReplay.createFrom(this);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ConnectableObservable<T> replay(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final ConnectableObservable<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableObservable<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableObservable<T> replay(int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final ConnectableObservable<T> replay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableObservable<T> replay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableObservable<T> replay(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> retry()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> retry(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> retry(long paramLong, Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> paramBiPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> retry(Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> retryUntil(BooleanSupplier paramBooleanSupplier)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> paramFunction)
  {
    return null;
  }
  
  /* Error */
  @SchedulerSupport("none")
  public final void safeSubscribe(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> sample(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> sample(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> sample(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> sample(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<T> sample(ObservableSource<U> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<T> sample(ObservableSource<U> paramObservableSource, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> scan(BiFunction<T, T, T> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> scan(R paramR, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> scanWith(Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> serialize()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> share()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> single(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> singleElement()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> singleOrError()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> skip(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> skip(long paramLong, TimeUnit paramTimeUnit)
  {
    return skipUntil(timer(paramLong, paramTimeUnit));
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> skip(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return skipUntil(timer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> skipLast(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:trampoline")
  public final Observable<T> skipLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:trampoline")
  public final Observable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<T> skipUntil(ObservableSource<U> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> skipWhile(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> sorted()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> sorted(Comparator<? super T> paramComparator)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> startWith(ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> startWith(Iterable<? extends T> paramIterable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> startWith(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> startWithArray(T... paramVarArgs)
  {
    return null;
  }
  
  @SchedulerSupport("none")
  public final Disposable subscribe()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction, Consumer<? super Disposable> paramConsumer2)
  {
    return null;
  }
  
  /* Error */
  @SchedulerSupport("none")
  public final void subscribe(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected abstract void subscribeActual(Observer<? super T> paramObserver);
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> subscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <E extends Observer<? super T>> E subscribeWith(E paramE)
  {
    subscribe(paramE);
    return paramE;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> switchIfEmpty(ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable switchMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> take(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> take(long paramLong, TimeUnit paramTimeUnit)
  {
    return takeUntil(timer(paramLong, paramTimeUnit));
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> take(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return takeUntil(timer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> takeLast(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:trampoline")
  public final Observable<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:trampoline")
  public final Observable<T> takeLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:trampoline")
  public final Observable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<T> takeUntil(ObservableSource<U> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> takeUntil(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> takeWhile(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestObserver<T> test()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestObserver<T> test(boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> throttleLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return sample(paramLong, paramTimeUnit);
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> throttleLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return sample(paramLong, paramTimeUnit, paramScheduler);
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return debounce(paramLong, paramTimeUnit);
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return debounce(paramLong, paramTimeUnit, paramScheduler);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timeInterval()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timeInterval(Scheduler paramScheduler)
  {
    return timeInterval(TimeUnit.MILLISECONDS, paramScheduler);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timeInterval(TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timeInterval(TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit, ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Observable<T> timeout(ObservableSource<U> paramObservableSource, Function<? super T, ? extends ObservableSource<V>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Observable<T> timeout(ObservableSource<U> paramObservableSource, Function<? super T, ? extends ObservableSource<V>> paramFunction, ObservableSource<? extends T> paramObservableSource1)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> paramFunction)
  {
    return timeout0(null, paramFunction, null);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> paramFunction, ObservableSource<? extends T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timestamp()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timestamp(Scheduler paramScheduler)
  {
    return timestamp(TimeUnit.MILLISECONDS, paramScheduler);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timestamp(TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Timed<T>> timestamp(TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> R to(Function<? super Observable<T>, R> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> toFlowable(BackpressureStrategy paramBackpressureStrategy)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Future<T> toFuture()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toList()
  {
    return toList(16);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toList(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U extends Collection<? super T>> Single<U> toList(Callable<U> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Callable<? extends Map<K, V>> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Callable<Map<K, Collection<V>>> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Callable<? extends Map<K, Collection<V>>> paramCallable, Function<? super K, ? extends Collection<? super V>> paramFunction2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList(Comparator<? super T> paramComparator)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList(Comparator<? super T> paramComparator, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> unsubscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Observable<T>> window(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<Observable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<Observable<T>> window(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<Observable<T>> window(long paramLong1, TimeUnit paramTimeUnit, long paramLong2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<Observable<T>> window(long paramLong1, TimeUnit paramTimeUnit, long paramLong2, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<Observable<T>> window(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<Observable<T>> window(long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong2)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<Observable<T>> window(long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong2, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<Observable<T>> window(long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong2, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Observable<Observable<T>> window(ObservableSource<B> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Observable<Observable<T>> window(ObservableSource<B> paramObservableSource, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Observable<Observable<T>> window(ObservableSource<U> paramObservableSource, Function<? super U, ? extends ObservableSource<V>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Observable<Observable<T>> window(ObservableSource<U> paramObservableSource, Function<? super U, ? extends ObservableSource<V>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> paramCallable, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> paramObservableSource, ObservableSource<T2> paramObservableSource1, ObservableSource<T3> paramObservableSource2, ObservableSource<T4> paramObservableSource3, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> paramFunction5)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> paramObservableSource, ObservableSource<T2> paramObservableSource1, ObservableSource<T3> paramObservableSource2, Function4<? super T, ? super T1, ? super T2, ? super T3, R> paramFunction4)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> paramObservableSource, ObservableSource<T2> paramObservableSource1, Function3<? super T, ? super T1, ? super T2, R> paramFunction3)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> paramObservableSource, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> paramIterable, Function<? super Object[], R> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] paramArrayOfObservableSource, Function<? super Object[], R> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> paramObservableSource, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> paramObservableSource, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean)
  {
    return zip(this, paramObservableSource, paramBiFunction, paramBoolean);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> paramObservableSource, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt)
  {
    return zip(this, paramObservableSource, paramBiFunction, paramBoolean, paramInt);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Observable<R> zipWith(Iterable<U> paramIterable, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Observable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */