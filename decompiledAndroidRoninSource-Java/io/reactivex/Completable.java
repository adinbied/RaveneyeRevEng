package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromObservable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableNever;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Completable
  implements CompletableSource
{
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable amb(Iterable<? extends CompletableSource> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new CompletableAmb(null, paramIterable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable ambArray(CompletableSource... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new CompletableAmb(paramVarArgs, null));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable complete()
  {
    return RxJavaPlugins.onAssembly(CompletableEmpty.INSTANCE);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable concat(Iterable<? extends CompletableSource> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new CompletableConcatIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable concat(Publisher<? extends CompletableSource> paramPublisher)
  {
    return concat(paramPublisher, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable concat(Publisher<? extends CompletableSource> paramPublisher, int paramInt)
  {
    ObjectHelper.requireNonNull(paramPublisher, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly(new CompletableConcat(paramPublisher, paramInt));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable concatArray(CompletableSource... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new CompletableConcatArray(paramVarArgs));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable create(CompletableOnSubscribe paramCompletableOnSubscribe)
  {
    ObjectHelper.requireNonNull(paramCompletableOnSubscribe, "source is null");
    return RxJavaPlugins.onAssembly(new CompletableCreate(paramCompletableOnSubscribe));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable defer(Callable<? extends CompletableSource> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "completableSupplier");
    return RxJavaPlugins.onAssembly(new CompletableDefer(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  private Completable doOnLifecycle(Consumer<? super Disposable> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable error(Throwable paramThrowable)
  {
    ObjectHelper.requireNonNull(paramThrowable, "error is null");
    return RxJavaPlugins.onAssembly(new CompletableError(paramThrowable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable error(Callable<? extends Throwable> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "errorSupplier is null");
    return RxJavaPlugins.onAssembly(new CompletableErrorSupplier(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable fromAction(Action paramAction)
  {
    ObjectHelper.requireNonNull(paramAction, "run is null");
    return RxJavaPlugins.onAssembly(new CompletableFromAction(paramAction));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable fromCallable(Callable<?> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "callable is null");
    return RxJavaPlugins.onAssembly(new CompletableFromCallable(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable fromFuture(Future<?> paramFuture)
  {
    ObjectHelper.requireNonNull(paramFuture, "future is null");
    return fromAction(Functions.futureAction(paramFuture));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Completable fromMaybe(MaybeSource<T> paramMaybeSource)
  {
    ObjectHelper.requireNonNull(paramMaybeSource, "maybe is null");
    return RxJavaPlugins.onAssembly(new MaybeIgnoreElementCompletable(paramMaybeSource));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Completable fromObservable(ObservableSource<T> paramObservableSource)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "observable is null");
    return RxJavaPlugins.onAssembly(new CompletableFromObservable(paramObservableSource));
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Completable fromPublisher(Publisher<T> paramPublisher)
  {
    ObjectHelper.requireNonNull(paramPublisher, "publisher is null");
    return RxJavaPlugins.onAssembly(new CompletableFromPublisher(paramPublisher));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable fromRunnable(Runnable paramRunnable)
  {
    ObjectHelper.requireNonNull(paramRunnable, "run is null");
    return RxJavaPlugins.onAssembly(new CompletableFromRunnable(paramRunnable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Completable fromSingle(SingleSource<T> paramSingleSource)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "single is null");
    return RxJavaPlugins.onAssembly(new CompletableFromSingle(paramSingleSource));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable merge(Iterable<? extends CompletableSource> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new CompletableMergeIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable merge(Publisher<? extends CompletableSource> paramPublisher)
  {
    return merge0(paramPublisher, Integer.MAX_VALUE, false);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable merge(Publisher<? extends CompletableSource> paramPublisher, int paramInt)
  {
    return merge0(paramPublisher, paramInt, false);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  private static Completable merge0(Publisher<? extends CompletableSource> paramPublisher, int paramInt, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramPublisher, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "maxConcurrency");
    return RxJavaPlugins.onAssembly(new CompletableMerge(paramPublisher, paramInt, paramBoolean));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable mergeArray(CompletableSource... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return complete();
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new CompletableMergeArray(paramVarArgs));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable mergeArrayDelayError(CompletableSource... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    return RxJavaPlugins.onAssembly(new CompletableMergeDelayErrorArray(paramVarArgs));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable mergeDelayError(Iterable<? extends CompletableSource> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new CompletableMergeDelayErrorIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable mergeDelayError(Publisher<? extends CompletableSource> paramPublisher)
  {
    return merge0(paramPublisher, Integer.MAX_VALUE, true);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable mergeDelayError(Publisher<? extends CompletableSource> paramPublisher, int paramInt)
  {
    return merge0(paramPublisher, paramInt, true);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable never()
  {
    return RxJavaPlugins.onAssembly(CompletableNever.INSTANCE);
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  private Completable timeout0(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Completable timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Completable timer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return RxJavaPlugins.onAssembly(new CompletableTimer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  private static NullPointerException toNpe(Throwable paramThrowable)
  {
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    return localNullPointerException;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable unsafeCreate(CompletableSource paramCompletableSource)
  {
    ObjectHelper.requireNonNull(paramCompletableSource, "source is null");
    if (!(paramCompletableSource instanceof Completable)) {
      return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(paramCompletableSource));
    }
    throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <R> Completable using(Callable<R> paramCallable, Function<? super R, ? extends CompletableSource> paramFunction, Consumer<? super R> paramConsumer)
  {
    return using(paramCallable, paramFunction, paramConsumer, true);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <R> Completable using(Callable<R> paramCallable, Function<? super R, ? extends CompletableSource> paramFunction, Consumer<? super R> paramConsumer, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramCallable, "resourceSupplier is null");
    ObjectHelper.requireNonNull(paramFunction, "completableFunction is null");
    ObjectHelper.requireNonNull(paramConsumer, "disposer is null");
    return RxJavaPlugins.onAssembly(new CompletableUsing(paramCallable, paramFunction, paramConsumer, paramBoolean));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static Completable wrap(CompletableSource paramCompletableSource)
  {
    ObjectHelper.requireNonNull(paramCompletableSource, "source is null");
    if ((paramCompletableSource instanceof Completable)) {
      return RxJavaPlugins.onAssembly((Completable)paramCompletableSource);
    }
    return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(paramCompletableSource));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable ambWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable andThen(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Flowable<T> andThen(Publisher<T> paramPublisher)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Maybe<T> andThen(MaybeSource<T> paramMaybeSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Observable<T> andThen(ObservableSource<T> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Single<T> andThen(SingleSource<T> paramSingleSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> R as(CompletableConverter<? extends R> paramCompletableConverter)
  {
    return null;
  }
  
  /* Error */
  @SchedulerSupport("none")
  public final void blockingAwait()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final boolean blockingAwait(long paramLong, TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Throwable blockingGet()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Throwable blockingGet(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable cache()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable compose(CompletableTransformer paramCompletableTransformer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable concatWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Completable delaySubscription(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable delaySubscription(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return timer(paramLong, paramTimeUnit, paramScheduler).andThen(this);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doAfterTerminate(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doFinally(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doOnComplete(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doOnDispose(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doOnError(Consumer<? super Throwable> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doOnEvent(Consumer<? super Throwable> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doOnSubscribe(Consumer<? super Disposable> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable doOnTerminate(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable hide()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable lift(CompletableOperator paramCompletableOperator)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Single<Notification<T>> materialize()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable mergeWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable observeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable onErrorComplete()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable onErrorComplete(Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable onTerminateDetach()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable repeat()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable repeat(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable repeatUntil(BooleanSupplier paramBooleanSupplier)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable retry()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable retry(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable retry(long paramLong, Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable retry(BiPredicate<? super Integer, ? super Throwable> paramBiPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable retry(Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable startWith(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Flowable<T> startWith(Publisher<T> paramPublisher)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Observable<T> startWith(Observable<T> paramObservable)
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
  public final Disposable subscribe(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Action paramAction, Consumer<? super Throwable> paramConsumer)
  {
    return null;
  }
  
  /* Error */
  @SchedulerSupport("none")
  public final void subscribe(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected abstract void subscribeActual(CompletableObserver paramCompletableObserver);
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable subscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <E extends CompletableObserver> E subscribeWith(E paramE)
  {
    subscribe(paramE);
    return paramE;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable takeUntil(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestObserver<Void> test()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestObserver<Void> test(boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> U to(Function<? super Completable, U> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Flowable<T> toFlowable()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Maybe<T> toMaybe()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Observable<T> toObservable()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Single<T> toSingle(Callable<? extends T> paramCallable)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <T> Single<T> toSingleDefault(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Completable unsubscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Completable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */