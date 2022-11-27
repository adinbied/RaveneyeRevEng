package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.flowables.GroupedFlowable;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDefer;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper.RequestMax;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableNever;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import io.reactivex.subscribers.TestSubscriber;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Flowable<T>
  implements Publisher<T>
{
  static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> amb(Iterable<? extends Publisher<? extends T>> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new FlowableAmb(null, paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> ambArray(Publisher<? extends T>... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    int i = paramVarArgs.length;
    if (i == 0) {
      return empty();
    }
    if (i == 1) {
      return fromPublisher(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new FlowableAmb(paramVarArgs, null));
  }
  
  public static int bufferSize()
  {
    return BUFFER_SIZE;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatest(Function<? super Object[], ? extends R> paramFunction, Publisher<? extends T>... paramVarArgs)
  {
    return combineLatest(paramVarArgs, paramFunction, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatest(paramIterable, paramFunction, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new FlowableCombineLatest(paramIterable, paramFunction, paramInt, false));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    return combineLatest(Functions.toFunction(paramBiFunction), new Publisher[] { paramPublisher, paramPublisher1 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Function3<? super T1, ? super T2, ? super T3, ? extends R> paramFunction3)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    return combineLatest(Functions.toFunction(paramFunction3), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunction4)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    return combineLatest(Functions.toFunction(paramFunction4), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunction5)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    return combineLatest(Functions.toFunction(paramFunction5), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunction6)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    return combineLatest(Functions.toFunction(paramFunction6), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Publisher<? extends T7> paramPublisher6, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunction7)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    ObjectHelper.requireNonNull(paramPublisher6, "source7 is null");
    return combineLatest(Functions.toFunction(paramFunction7), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Publisher<? extends T7> paramPublisher6, Publisher<? extends T8> paramPublisher7, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunction8)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    ObjectHelper.requireNonNull(paramPublisher6, "source7 is null");
    ObjectHelper.requireNonNull(paramPublisher7, "source8 is null");
    return combineLatest(Functions.toFunction(paramFunction8), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Publisher<? extends T7> paramPublisher6, Publisher<? extends T8> paramPublisher7, Publisher<? extends T9> paramPublisher8, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunction9)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    ObjectHelper.requireNonNull(paramPublisher6, "source7 is null");
    ObjectHelper.requireNonNull(paramPublisher7, "source8 is null");
    ObjectHelper.requireNonNull(paramPublisher8, "source9 is null");
    return combineLatest(Functions.toFunction(paramFunction9), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7, paramPublisher8 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] paramArrayOfPublisher, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatest(paramArrayOfPublisher, paramFunction, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] paramArrayOfPublisher, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramArrayOfPublisher, "sources is null");
    if (paramArrayOfPublisher.length == 0) {
      return empty();
    }
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new FlowableCombineLatest(paramArrayOfPublisher, paramFunction, paramInt, false));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> paramFunction, int paramInt, Publisher<? extends T>... paramVarArgs)
  {
    return combineLatestDelayError(paramVarArgs, paramFunction, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> paramFunction, Publisher<? extends T>... paramVarArgs)
  {
    return combineLatestDelayError(paramVarArgs, paramFunction, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatestDelayError(paramIterable, paramFunction, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new FlowableCombineLatest(paramIterable, paramFunction, paramInt, true));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] paramArrayOfPublisher, Function<? super Object[], ? extends R> paramFunction)
  {
    return combineLatestDelayError(paramArrayOfPublisher, paramFunction, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] paramArrayOfPublisher, Function<? super Object[], ? extends R> paramFunction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramArrayOfPublisher, "sources is null");
    ObjectHelper.requireNonNull(paramFunction, "combiner is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    if (paramArrayOfPublisher.length == 0) {
      return empty();
    }
    return RxJavaPlugins.onAssembly(new FlowableCombineLatest(paramArrayOfPublisher, paramFunction, paramInt, true));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Iterable<? extends Publisher<? extends T>> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return fromIterable(paramIterable).concatMapDelayError(Functions.identity(), 2, false);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> paramPublisher)
  {
    return concat(paramPublisher, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> paramPublisher, int paramInt)
  {
    return fromPublisher(paramPublisher).concatMap(Functions.identity(), paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    return concatArray(new Publisher[] { paramPublisher1, paramPublisher2 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, Publisher<? extends T> paramPublisher3)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source3 is null");
    return concatArray(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, Publisher<? extends T> paramPublisher3, Publisher<? extends T> paramPublisher4)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source4 is null");
    return concatArray(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArray(Publisher<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return fromPublisher(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new FlowableConcatArray(paramVarArgs, false));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArrayDelayError(Publisher<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return fromPublisher(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new FlowableConcatArray(paramVarArgs, true));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArrayEager(int paramInt1, int paramInt2, Publisher<? extends T>... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    ObjectHelper.verifyPositive(paramInt1, "maxConcurrency");
    ObjectHelper.verifyPositive(paramInt2, "prefetch");
    return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromArray(paramVarArgs), Functions.identity(), paramInt1, paramInt2, ErrorMode.IMMEDIATE));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArrayEager(Publisher<? extends T>... paramVarArgs)
  {
    return concatArrayEager(bufferSize(), bufferSize(), paramVarArgs);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArrayEagerDelayError(int paramInt1, int paramInt2, Publisher<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).concatMapEagerDelayError(Functions.identity(), paramInt1, paramInt2, true);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArrayEagerDelayError(Publisher<? extends T>... paramVarArgs)
  {
    return concatArrayEagerDelayError(bufferSize(), bufferSize(), paramVarArgs);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatDelayError(Iterable<? extends Publisher<? extends T>> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return fromIterable(paramIterable).concatMapDelayError(Functions.identity());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> paramPublisher)
  {
    return concatDelayError(paramPublisher, bufferSize(), true);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> paramPublisher, int paramInt, boolean paramBoolean)
  {
    return fromPublisher(paramPublisher).concatMapDelayError(Functions.identity(), paramInt, paramBoolean);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> paramIterable)
  {
    return concatEager(paramIterable, bufferSize(), bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    ObjectHelper.verifyPositive(paramInt1, "maxConcurrency");
    ObjectHelper.verifyPositive(paramInt2, "prefetch");
    return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromIterable(paramIterable), Functions.identity(), paramInt1, paramInt2, ErrorMode.IMMEDIATE));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> paramPublisher)
  {
    return concatEager(paramPublisher, bufferSize(), bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> paramPublisher, int paramInt1, int paramInt2)
  {
    ObjectHelper.requireNonNull(paramPublisher, "sources is null");
    ObjectHelper.verifyPositive(paramInt1, "maxConcurrency");
    ObjectHelper.verifyPositive(paramInt2, "prefetch");
    return RxJavaPlugins.onAssembly(new FlowableConcatMapEagerPublisher(paramPublisher, Functions.identity(), paramInt1, paramInt2, ErrorMode.IMMEDIATE));
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> create(FlowableOnSubscribe<T> paramFlowableOnSubscribe, BackpressureStrategy paramBackpressureStrategy)
  {
    ObjectHelper.requireNonNull(paramFlowableOnSubscribe, "source is null");
    ObjectHelper.requireNonNull(paramBackpressureStrategy, "mode is null");
    return RxJavaPlugins.onAssembly(new FlowableCreate(paramFlowableOnSubscribe, paramBackpressureStrategy));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> defer(Callable<? extends Publisher<? extends T>> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "supplier is null");
    return RxJavaPlugins.onAssembly(new FlowableDefer(paramCallable));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  private Flowable<T> doOnEach(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction1, Action paramAction2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> empty()
  {
    return RxJavaPlugins.onAssembly(FlowableEmpty.INSTANCE);
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> error(Throwable paramThrowable)
  {
    ObjectHelper.requireNonNull(paramThrowable, "throwable is null");
    return error(Functions.justCallable(paramThrowable));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> error(Callable<? extends Throwable> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "supplier is null");
    return RxJavaPlugins.onAssembly(new FlowableError(paramCallable));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> fromArray(T... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "items is null");
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return just(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new FlowableFromArray(paramVarArgs));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> fromCallable(Callable<? extends T> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "supplier is null");
    return RxJavaPlugins.onAssembly(new FlowableFromCallable(paramCallable));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> fromFuture(Future<? extends T> paramFuture)
  {
    ObjectHelper.requireNonNull(paramFuture, "future is null");
    return RxJavaPlugins.onAssembly(new FlowableFromFuture(paramFuture, 0L, null));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    ObjectHelper.requireNonNull(paramFuture, "future is null");
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    return RxJavaPlugins.onAssembly(new FlowableFromFuture(paramFuture, paramLong, paramTimeUnit));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static <T> Flowable<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return fromFuture(paramFuture, paramLong, paramTimeUnit).subscribeOn(paramScheduler);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static <T> Flowable<T> fromFuture(Future<? extends T> paramFuture, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return fromFuture(paramFuture).subscribeOn(paramScheduler);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> fromIterable(Iterable<? extends T> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "source is null");
    return RxJavaPlugins.onAssembly(new FlowableFromIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> fromPublisher(Publisher<? extends T> paramPublisher)
  {
    if ((paramPublisher instanceof Flowable)) {
      return RxJavaPlugins.onAssembly((Flowable)paramPublisher);
    }
    ObjectHelper.requireNonNull(paramPublisher, "source is null");
    return RxJavaPlugins.onAssembly(new FlowableFromPublisher(paramPublisher));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> generate(Consumer<Emitter<T>> paramConsumer)
  {
    ObjectHelper.requireNonNull(paramConsumer, "generator is null");
    return generate(Functions.nullSupplier(), FlowableInternalHelper.simpleGenerator(paramConsumer), Functions.emptyConsumer());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Flowable<T> generate(Callable<S> paramCallable, BiConsumer<S, Emitter<T>> paramBiConsumer)
  {
    ObjectHelper.requireNonNull(paramBiConsumer, "generator is null");
    return generate(paramCallable, FlowableInternalHelper.simpleBiGenerator(paramBiConsumer), Functions.emptyConsumer());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Flowable<T> generate(Callable<S> paramCallable, BiConsumer<S, Emitter<T>> paramBiConsumer, Consumer<? super S> paramConsumer)
  {
    ObjectHelper.requireNonNull(paramBiConsumer, "generator is null");
    return generate(paramCallable, FlowableInternalHelper.simpleBiGenerator(paramBiConsumer), paramConsumer);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Flowable<T> generate(Callable<S> paramCallable, BiFunction<S, Emitter<T>, S> paramBiFunction)
  {
    return generate(paramCallable, paramBiFunction, Functions.emptyConsumer());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, S> Flowable<T> generate(Callable<S> paramCallable, BiFunction<S, Emitter<T>, S> paramBiFunction, Consumer<? super S> paramConsumer)
  {
    ObjectHelper.requireNonNull(paramCallable, "initialState is null");
    ObjectHelper.requireNonNull(paramBiFunction, "generator is null");
    ObjectHelper.requireNonNull(paramConsumer, "disposeState is null");
    return RxJavaPlugins.onAssembly(new FlowableGenerate(paramCallable, paramBiFunction, paramConsumer));
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Flowable<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return interval(paramLong1, paramLong2, paramTimeUnit, Schedulers.computation());
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Flowable<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return RxJavaPlugins.onAssembly(new FlowableInterval(Math.max(0L, paramLong1), Math.max(0L, paramLong2), paramTimeUnit, paramScheduler));
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Flowable<Long> interval(long paramLong, TimeUnit paramTimeUnit)
  {
    return interval(paramLong, paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Flowable<Long> interval(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return interval(paramLong, paramLong, paramTimeUnit, paramScheduler);
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Flowable<Long> intervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit)
  {
    return intervalRange(paramLong1, paramLong2, paramLong3, paramLong4, paramTimeUnit, Schedulers.computation());
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Flowable<Long> intervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, Scheduler paramScheduler)
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
      return RxJavaPlugins.onAssembly(new FlowableIntervalRange(paramLong1, paramLong2, Math.max(0L, paramLong3), Math.max(0L, paramLong4), paramTimeUnit, paramScheduler));
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("count >= 0 required but it was ");
    paramTimeUnit.append(paramLong2);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT)
  {
    ObjectHelper.requireNonNull(paramT, "item is null");
    return RxJavaPlugins.onAssembly(new FlowableJust(paramT));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    return fromArray(new Object[] { paramT1, paramT2 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6)
  {
    ObjectHelper.requireNonNull(paramT1, "item1 is null");
    ObjectHelper.requireNonNull(paramT2, "item2 is null");
    ObjectHelper.requireNonNull(paramT3, "item3 is null");
    ObjectHelper.requireNonNull(paramT4, "item4 is null");
    ObjectHelper.requireNonNull(paramT5, "item5 is null");
    ObjectHelper.requireNonNull(paramT6, "item6 is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7)
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
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8)
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
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9)
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
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9, T paramT10)
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
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> paramIterable)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> paramIterable, int paramInt)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), false, paramInt1, paramInt2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> paramPublisher)
  {
    return merge(paramPublisher, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> paramPublisher, int paramInt)
  {
    return fromPublisher(paramPublisher).flatMap(Functions.identity(), paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    return fromArray(new Publisher[] { paramPublisher1, paramPublisher2 }).flatMap(Functions.identity(), false, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, Publisher<? extends T> paramPublisher3)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source3 is null");
    return fromArray(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 }).flatMap(Functions.identity(), false, 3);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, Publisher<? extends T> paramPublisher3, Publisher<? extends T> paramPublisher4)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source4 is null");
    return fromArray(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 }).flatMap(Functions.identity(), false, 4);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeArray(int paramInt1, int paramInt2, Publisher<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), false, paramInt1, paramInt2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeArray(Publisher<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), paramVarArgs.length);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeArrayDelayError(int paramInt1, int paramInt2, Publisher<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), true, paramInt1, paramInt2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeArrayDelayError(Publisher<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(Functions.identity(), true, paramVarArgs.length);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> paramIterable)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), true);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> paramIterable, int paramInt)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), true, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).flatMap(Functions.identity(), true, paramInt1, paramInt2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> paramPublisher)
  {
    return mergeDelayError(paramPublisher, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> paramPublisher, int paramInt)
  {
    return fromPublisher(paramPublisher).flatMap(Functions.identity(), true, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    return fromArray(new Publisher[] { paramPublisher1, paramPublisher2 }).flatMap(Functions.identity(), true, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, Publisher<? extends T> paramPublisher3)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source3 is null");
    return fromArray(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 }).flatMap(Functions.identity(), true, 3);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, Publisher<? extends T> paramPublisher3, Publisher<? extends T> paramPublisher4)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source4 is null");
    return fromArray(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 }).flatMap(Functions.identity(), true, 4);
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> never()
  {
    return RxJavaPlugins.onAssembly(FlowableNever.INSTANCE);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Flowable<Integer> range(int paramInt1, int paramInt2)
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
        return RxJavaPlugins.onAssembly(new FlowableRange(paramInt1, paramInt2));
      }
      throw new IllegalArgumentException("Integer overflow");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramInt2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Flowable<Long> rangeLong(long paramLong1, long paramLong2)
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
      return RxJavaPlugins.onAssembly(new FlowableRangeLong(paramLong1, paramLong2));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramLong2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2)
  {
    return sequenceEqual(paramPublisher1, paramPublisher2, ObjectHelper.equalsPredicate(), bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, int paramInt)
  {
    return sequenceEqual(paramPublisher1, paramPublisher2, ObjectHelper.equalsPredicate(), paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, BiPredicate<? super T, ? super T> paramBiPredicate)
  {
    return sequenceEqual(paramPublisher1, paramPublisher2, paramBiPredicate, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, BiPredicate<? super T, ? super T> paramBiPredicate, int paramInt)
  {
    ObjectHelper.requireNonNull(paramPublisher1, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source2 is null");
    ObjectHelper.requireNonNull(paramBiPredicate, "isEqual is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new FlowableSequenceEqualSingle(paramPublisher1, paramPublisher2, paramBiPredicate, paramInt));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> paramPublisher)
  {
    return fromPublisher(paramPublisher).switchMap(Functions.identity());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> paramPublisher, int paramInt)
  {
    return fromPublisher(paramPublisher).switchMap(Functions.identity(), paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> paramPublisher)
  {
    return switchOnNextDelayError(paramPublisher, bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> paramPublisher, int paramInt)
  {
    return fromPublisher(paramPublisher).switchMapDelayError(Functions.identity(), paramInt);
  }
  
  private Flowable<T> timeout0(long paramLong, TimeUnit paramTimeUnit, Publisher<? extends T> paramPublisher, Scheduler paramScheduler)
  {
    return null;
  }
  
  private <U, V> Flowable<T> timeout0(Publisher<U> paramPublisher, Function<? super T, ? extends Publisher<V>> paramFunction, Publisher<? extends T> paramPublisher1)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Flowable<Long> timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Flowable<Long> timer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return RxJavaPlugins.onAssembly(new FlowableTimer(Math.max(0L, paramLong), paramTimeUnit, paramScheduler));
  }
  
  @BackpressureSupport(BackpressureKind.NONE)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> unsafeCreate(Publisher<T> paramPublisher)
  {
    ObjectHelper.requireNonNull(paramPublisher, "onSubscribe is null");
    if (!(paramPublisher instanceof Flowable)) {
      return RxJavaPlugins.onAssembly(new FlowableFromPublisher(paramPublisher));
    }
    throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, D> Flowable<T> using(Callable<? extends D> paramCallable, Function<? super D, ? extends Publisher<? extends T>> paramFunction, Consumer<? super D> paramConsumer)
  {
    return using(paramCallable, paramFunction, paramConsumer, true);
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, D> Flowable<T> using(Callable<? extends D> paramCallable, Function<? super D, ? extends Publisher<? extends T>> paramFunction, Consumer<? super D> paramConsumer, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramCallable, "resourceSupplier is null");
    ObjectHelper.requireNonNull(paramFunction, "sourceSupplier is null");
    ObjectHelper.requireNonNull(paramConsumer, "resourceDisposer is null");
    return RxJavaPlugins.onAssembly(new FlowableUsing(paramCallable, paramFunction, paramConsumer, paramBoolean));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> zip(Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new FlowableZip(null, paramIterable, paramFunction, bufferSize(), false));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> zip(Publisher<? extends Publisher<? extends T>> paramPublisher, Function<? super Object[], ? extends R> paramFunction)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    return fromPublisher(paramPublisher).toList().flatMapPublisher(FlowableInternalHelper.zipIterable(paramFunction));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    return zipArray(Functions.toFunction(paramBiFunction), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    return zipArray(Functions.toFunction(paramBiFunction), paramBoolean, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    return zipArray(Functions.toFunction(paramBiFunction), paramBoolean, paramInt, new Publisher[] { paramPublisher, paramPublisher1 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Function3<? super T1, ? super T2, ? super T3, ? extends R> paramFunction3)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    return zipArray(Functions.toFunction(paramFunction3), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunction4)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    return zipArray(Functions.toFunction(paramFunction4), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunction5)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    return zipArray(Functions.toFunction(paramFunction5), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunction6)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    return zipArray(Functions.toFunction(paramFunction6), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Publisher<? extends T7> paramPublisher6, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunction7)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    ObjectHelper.requireNonNull(paramPublisher6, "source7 is null");
    return zipArray(Functions.toFunction(paramFunction7), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Publisher<? extends T7> paramPublisher6, Publisher<? extends T8> paramPublisher7, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunction8)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    ObjectHelper.requireNonNull(paramPublisher6, "source7 is null");
    ObjectHelper.requireNonNull(paramPublisher7, "source8 is null");
    return zipArray(Functions.toFunction(paramFunction8), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(Publisher<? extends T1> paramPublisher, Publisher<? extends T2> paramPublisher1, Publisher<? extends T3> paramPublisher2, Publisher<? extends T4> paramPublisher3, Publisher<? extends T5> paramPublisher4, Publisher<? extends T6> paramPublisher5, Publisher<? extends T7> paramPublisher6, Publisher<? extends T8> paramPublisher7, Publisher<? extends T9> paramPublisher8, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunction9)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source1 is null");
    ObjectHelper.requireNonNull(paramPublisher1, "source2 is null");
    ObjectHelper.requireNonNull(paramPublisher2, "source3 is null");
    ObjectHelper.requireNonNull(paramPublisher3, "source4 is null");
    ObjectHelper.requireNonNull(paramPublisher4, "source5 is null");
    ObjectHelper.requireNonNull(paramPublisher5, "source6 is null");
    ObjectHelper.requireNonNull(paramPublisher6, "source7 is null");
    ObjectHelper.requireNonNull(paramPublisher7, "source8 is null");
    ObjectHelper.requireNonNull(paramPublisher8, "source9 is null");
    return zipArray(Functions.toFunction(paramFunction9), false, bufferSize(), new Publisher[] { paramPublisher, paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7, paramPublisher8 });
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> zipArray(Function<? super Object[], ? extends R> paramFunction, boolean paramBoolean, int paramInt, Publisher<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new FlowableZip(paramVarArgs, null, paramFunction, paramInt, paramBoolean));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Flowable<R> zipIterable(Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, boolean paramBoolean, int paramInt)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    return RxJavaPlugins.onAssembly(new FlowableZip(null, paramIterable, paramFunction, paramInt, paramBoolean));
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> all(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> ambWith(Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> any(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> R as(FlowableConverter<T, ? extends R> paramFlowableConverter)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingFirst()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingFirst(T paramT)
  {
    return null;
  }
  
  /* Error */
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @SchedulerSupport("none")
  public final void blockingForEach(Consumer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingIterable()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingIterable(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingLast()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingLast(T paramT)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingLatest()
  {
    return new BlockingFlowableLatest(this);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingMostRecent(T paramT)
  {
    return new BlockingFlowableMostRecent(this, paramT);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Iterable<T> blockingNext()
  {
    return new BlockingFlowableNext(this);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingSingle()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingSingle(T paramT)
  {
    return (T)single(paramT).blockingGet();
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @SchedulerSupport("none")
  public final void blockingSubscribe()
  {
    FlowableBlockingSubscribe.subscribe(this);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer)
  {
    FlowableBlockingSubscribe.subscribe(this, paramConsumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer, int paramInt)
  {
    FlowableBlockingSubscribe.subscribe(this, paramConsumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1)
  {
    FlowableBlockingSubscribe.subscribe(this, paramConsumer, paramConsumer1, Functions.EMPTY_ACTION);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, int paramInt)
  {
    FlowableBlockingSubscribe.subscribe(this, paramConsumer, paramConsumer1, Functions.EMPTY_ACTION, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction)
  {
    FlowableBlockingSubscribe.subscribe(this, paramConsumer, paramConsumer1, paramAction);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @SchedulerSupport("none")
  public final void blockingSubscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction, int paramInt)
  {
    FlowableBlockingSubscribe.subscribe(this, paramConsumer, paramConsumer1, paramAction, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @SchedulerSupport("none")
  public final void blockingSubscribe(Subscriber<? super T> paramSubscriber)
  {
    FlowableBlockingSubscribe.subscribe(this, paramSubscriber);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<List<T>> buffer(int paramInt)
  {
    return buffer(paramInt, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<List<T>> buffer(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U extends Collection<? super T>> Flowable<U> buffer(int paramInt1, int paramInt2, Callable<U> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U extends Collection<? super T>> Flowable<U> buffer(int paramInt, Callable<U> paramCallable)
  {
    return buffer(paramInt, paramInt, paramCallable);
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <U extends Collection<? super T>> Flowable<U> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, Callable<U> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <U extends Collection<? super T>> Flowable<U> buffer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt, Callable<U> paramCallable, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TOpening, TClosing> Flowable<List<T>> buffer(Flowable<? extends TOpening> paramFlowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> buffer(Flowable<? extends TOpening> paramFlowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> paramFunction, Callable<U> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Flowable<List<T>> buffer(Callable<? extends Publisher<B>> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B, U extends Collection<? super T>> Flowable<U> buffer(Callable<? extends Publisher<B>> paramCallable, Callable<U> paramCallable1)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Flowable<List<T>> buffer(Publisher<B> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Flowable<List<T>> buffer(Publisher<B> paramPublisher, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B, U extends Collection<? super T>> Flowable<U> buffer(Publisher<B> paramPublisher, Callable<U> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> cache()
  {
    return cacheWithInitialCapacity(16);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> cacheWithInitialCapacity(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<U> cast(Class<U> paramClass)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<U> collect(Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<U> collectInto(U paramU, BiConsumer<? super U, ? super T> paramBiConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> compose(FlowableTransformer<? super T, ? extends R> paramFlowableTransformer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return concatMap(paramFunction, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return concatMapCompletable(paramFunction, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return concatMapCompletableDelayError(paramFunction, true, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean)
  {
    return concatMapCompletableDelayError(paramFunction, paramBoolean, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return concatMapDelayError(paramFunction, 2, true);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return concatMapIterable(paramFunction, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return concatMapMaybe(paramFunction, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return concatMapMaybeDelayError(paramFunction, true, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return concatMapMaybeDelayError(paramFunction, paramBoolean, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return concatMapSingle(paramFunction, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return concatMapSingleDelayError(paramFunction, true, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    return concatMapSingleDelayError(paramFunction, paramBoolean, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> concatWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> concatWith(MaybeSource<? extends T> paramMaybeSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> concatWith(SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> concatWith(Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> contains(Object paramObject)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Long> count()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> debounce(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> debounce(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<T> debounce(Function<? super T, ? extends Publisher<U>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> defaultIfEmpty(T paramT)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> delay(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<T> delay(Function<? super T, ? extends Publisher<U>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Flowable<T> delay(Publisher<U> paramPublisher, Function<? super T, ? extends Publisher<V>> paramFunction)
  {
    return delaySubscription(paramPublisher).delay(paramFunction);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return delaySubscription(timer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<T> delaySubscription(Publisher<U> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  @Deprecated
  public final <T2> Flowable<T2> dematerialize()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> dematerialize(Function<? super T, Notification<R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> distinct()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Flowable<T> distinct(Function<? super T, K> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Flowable<T> distinct(Function<? super T, K> paramFunction, Callable<? extends Collection<? super K>> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> distinctUntilChanged()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> paramBiPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Flowable<T> distinctUntilChanged(Function<? super T, K> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doAfterNext(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doAfterTerminate(Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doFinally(Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnCancel(Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnComplete(Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnEach(Consumer<? super Notification<T>> paramConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnEach(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnError(Consumer<? super Throwable> paramConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnLifecycle(Consumer<? super Subscription> paramConsumer, LongConsumer paramLongConsumer, Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnNext(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnRequest(LongConsumer paramLongConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnSubscribe(Consumer<? super Subscription> paramConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> doOnTerminate(Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> elementAt(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> elementAt(long paramLong, T paramT)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> elementAtOrError(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> filter(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> first(T paramT)
  {
    return elementAt(0L, paramT);
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> firstElement()
  {
    return elementAt(0L);
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> firstOrError()
  {
    return elementAtOrError(0L);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, Function<? super Throwable, ? extends Publisher<? extends R>> paramFunction1, Callable<? extends Publisher<? extends R>> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, Function<Throwable, ? extends Publisher<? extends R>> paramFunction1, Callable<? extends Publisher<? extends R>> paramCallable, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends V> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends V> paramBiFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.NONE)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEach(Consumer<? super T> paramConsumer)
  {
    return subscribe(paramConsumer);
  }
  
  @BackpressureSupport(BackpressureKind.NONE)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEachWhile(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.NONE)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEachWhile(Predicate<? super T> paramPredicate, Consumer<? super Throwable> paramConsumer)
  {
    return forEachWhile(paramPredicate, paramConsumer, Functions.EMPTY_ACTION);
  }
  
  @BackpressureSupport(BackpressureKind.NONE)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable forEachWhile(Predicate<? super T> paramPredicate, Consumer<? super Throwable> paramConsumer, Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, boolean paramBoolean, int paramInt, Function<? super Consumer<Object>, ? extends Map<K, Object>> paramFunction2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> groupJoin(Publisher<? extends TRight> paramPublisher, Function<? super T, ? extends Publisher<TLeftEnd>> paramFunction, Function<? super TRight, ? extends Publisher<TRightEnd>> paramFunction1, BiFunction<? super T, ? super Flowable<TRight>, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> hide()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable ignoreElements()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> isEmpty()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> join(Publisher<? extends TRight> paramPublisher, Function<? super T, ? extends Publisher<TLeftEnd>> paramFunction, Function<? super TRight, ? extends Publisher<TRightEnd>> paramFunction1, BiFunction<? super T, ? super TRight, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> last(T paramT)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> lastElement()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> lastOrError()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> lift(FlowableOperator<? extends R, ? super T> paramFlowableOperator)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> limit(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> map(Function<? super T, ? extends R> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Notification<T>> materialize()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> mergeWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> mergeWith(MaybeSource<? extends T> paramMaybeSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> mergeWith(SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> mergeWith(Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> observeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> observeOn(Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> observeOn(Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<U> ofType(Class<U> paramClass)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer(int paramInt)
  {
    return onBackpressureBuffer(paramInt, false, false);
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer(int paramInt, Action paramAction)
  {
    return onBackpressureBuffer(paramInt, false, false, paramAction);
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer(int paramInt, boolean paramBoolean)
  {
    return onBackpressureBuffer(paramInt, paramBoolean, false);
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Action paramAction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer(long paramLong, Action paramAction, BackpressureOverflowStrategy paramBackpressureOverflowStrategy)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureBuffer(boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureDrop()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureDrop(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onBackpressureLatest()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onErrorResumeNext(Function<? super Throwable, ? extends Publisher<? extends T>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onErrorResumeNext(Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onErrorReturn(Function<? super Throwable, ? extends T> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onErrorReturnItem(T paramT)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onExceptionResumeNext(Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> onTerminateDetach()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ParallelFlowable<T> parallel()
  {
    return ParallelFlowable.from(this);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ParallelFlowable<T> parallel(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ParallelFlowable<T> parallel(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ConnectableFlowable<T> publish()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ConnectableFlowable<T> publish(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> rebatchRequests(int paramInt)
  {
    return observeOn(ImmediateThinScheduler.INSTANCE, true, paramInt);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> reduce(BiFunction<T, T, T> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> reduce(R paramR, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> reduceWith(Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeat()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeat(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeatUntil(BooleanSupplier paramBooleanSupplier)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ConnectableFlowable<T> replay()
  {
    return FlowableReplay.createFrom(this);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final ConnectableFlowable<T> replay(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final ConnectableFlowable<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableFlowable<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableFlowable<T> replay(int paramInt, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final ConnectableFlowable<T> replay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableFlowable<T> replay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final ConnectableFlowable<T> replay(Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> retry()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> retry(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> retry(long paramLong, Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> retry(BiPredicate<? super Integer, ? super Throwable> paramBiPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> retry(Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> retryUntil(BooleanSupplier paramBooleanSupplier)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> paramFunction)
  {
    return null;
  }
  
  /* Error */
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @SchedulerSupport("none")
  public final void safeSubscribe(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> sample(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> sample(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> sample(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> sample(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<T> sample(Publisher<U> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<T> sample(Publisher<U> paramPublisher, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> scan(BiFunction<T, T, T> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> scan(R paramR, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> scanWith(Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> serialize()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> share()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> single(T paramT)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> singleElement()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> singleOrError()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> skip(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> skip(long paramLong, TimeUnit paramTimeUnit)
  {
    return skipUntil(timer(paramLong, paramTimeUnit));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> skip(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return skipUntil(timer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> skipLast(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> skipLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> skipLast(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<T> skipUntil(Publisher<U> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> skipWhile(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> sorted()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> sorted(Comparator<? super T> paramComparator)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> startWith(Iterable<? extends T> paramIterable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> startWith(T paramT)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> startWith(Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> startWithArray(T... paramVarArgs)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @SchedulerSupport("none")
  public final Disposable subscribe()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction)
  {
    return subscribe(paramConsumer, paramConsumer1, paramAction, FlowableInternalHelper.RequestMax.INSTANCE);
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction, Consumer<? super Subscription> paramConsumer2)
  {
    return null;
  }
  
  /* Error */
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @SchedulerSupport("none")
  public final void subscribe(FlowableSubscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @SchedulerSupport("none")
  public final void subscribe(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void subscribeActual(Subscriber<? super T> paramSubscriber);
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> subscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> subscribeOn(Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <E extends Subscriber<? super T>> E subscribeWith(E paramE)
  {
    subscribe(paramE);
    return paramE;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> switchIfEmpty(Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt)
  {
    return switchMap0(paramFunction, paramInt, false);
  }
  
  <R> Flowable<R> switchMap0(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable switchMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt)
  {
    return switchMap0(paramFunction, paramInt, true);
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> take(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> take(long paramLong, TimeUnit paramTimeUnit)
  {
    return takeUntil(timer(paramLong, paramTimeUnit));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> take(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return takeUntil(timer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> takeLast(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> takeLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> takeLast(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> takeUntil(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<T> takeUntil(Publisher<U> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> takeWhile(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestSubscriber<T> test()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestSubscriber<T> test(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestSubscriber<T> test(long paramLong, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> throttleLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return sample(paramLong, paramTimeUnit);
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> throttleLast(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return sample(paramLong, paramTimeUnit, paramScheduler);
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return debounce(paramLong, paramTimeUnit);
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return debounce(paramLong, paramTimeUnit, paramScheduler);
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timeInterval()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timeInterval(Scheduler paramScheduler)
  {
    return timeInterval(TimeUnit.MILLISECONDS, paramScheduler);
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timeInterval(TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timeInterval(TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> timeout(long paramLong, TimeUnit paramTimeUnit, Publisher<? extends T> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> paramFunction)
  {
    return timeout0(null, paramFunction, null);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> paramFunction, Flowable<? extends T> paramFlowable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Flowable<T> timeout(Publisher<U> paramPublisher, Function<? super T, ? extends Publisher<V>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Flowable<T> timeout(Publisher<U> paramPublisher, Function<? super T, ? extends Publisher<V>> paramFunction, Publisher<? extends T> paramPublisher1)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timestamp()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timestamp(Scheduler paramScheduler)
  {
    return timestamp(TimeUnit.MILLISECONDS, paramScheduler);
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timestamp(TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Timed<T>> timestamp(TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.SPECIAL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> R to(Function<? super Flowable<T>, R> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Future<T> toFuture()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toList()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toList(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U extends Collection<? super T>> Single<U> toList(Callable<U> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Callable<? extends Map<K, V>> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Callable<Map<K, Collection<V>>> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Callable<? extends Map<K, Collection<V>>> paramCallable, Function<? super K, ? extends Collection<? super V>> paramFunction2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> toObservable()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList(Comparator<? super T> paramComparator)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<List<T>> toSortedList(Comparator<? super T> paramComparator, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> unsubscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Flowable<T>> window(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Flowable<T>> window(long paramLong1, long paramLong2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<Flowable<T>> window(long paramLong1, long paramLong2, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<Flowable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<Flowable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<Flowable<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<Flowable<T>> window(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<Flowable<T>> window(long paramLong1, TimeUnit paramTimeUnit, long paramLong2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<Flowable<T>> window(long paramLong1, TimeUnit paramTimeUnit, long paramLong2, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<Flowable<T>> window(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<Flowable<T>> window(long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong2)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<Flowable<T>> window(long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong2, boolean paramBoolean)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<Flowable<T>> window(long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong2, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> paramCallable)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> paramCallable, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Flowable<Flowable<T>> window(Publisher<B> paramPublisher)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <B> Flowable<Flowable<T>> window(Publisher<B> paramPublisher, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Flowable<Flowable<T>> window(Publisher<U> paramPublisher, Function<? super U, ? extends Publisher<V>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.ERROR)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, V> Flowable<Flowable<T>> window(Publisher<U> paramPublisher, Function<? super U, ? extends Publisher<V>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> withLatestFrom(Iterable<? extends Publisher<?>> paramIterable, Function<? super Object[], R> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> withLatestFrom(Publisher<? extends U> paramPublisher, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T1, T2, R> Flowable<R> withLatestFrom(Publisher<T1> paramPublisher, Publisher<T2> paramPublisher1, Function3<? super T, ? super T1, ? super T2, R> paramFunction3)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T1, T2, T3, R> Flowable<R> withLatestFrom(Publisher<T1> paramPublisher, Publisher<T2> paramPublisher1, Publisher<T3> paramPublisher2, Function4<? super T, ? super T1, ? super T2, ? super T3, R> paramFunction4)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Publisher<T1> paramPublisher, Publisher<T2> paramPublisher1, Publisher<T3> paramPublisher2, Publisher<T4> paramPublisher3, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> paramFunction5)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> withLatestFrom(Publisher<?>[] paramArrayOfPublisher, Function<? super Object[], R> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> zipWith(Iterable<U> paramIterable, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> zipWith(Publisher<? extends U> paramPublisher, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> zipWith(Publisher<? extends U> paramPublisher, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean)
  {
    return zip(this, paramPublisher, paramBiFunction, paramBoolean);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Flowable<R> zipWith(Publisher<? extends U> paramPublisher, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, boolean paramBoolean, int paramInt)
  {
    return zip(this, paramPublisher, paramBiFunction, paramBoolean, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Flowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */