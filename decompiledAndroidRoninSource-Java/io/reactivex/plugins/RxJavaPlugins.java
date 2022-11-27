package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

public final class RxJavaPlugins
{
  static volatile Consumer<? super Throwable> errorHandler;
  static volatile boolean failNonBlockingScheduler;
  static volatile boolean lockdown;
  static volatile BooleanSupplier onBeforeBlocking;
  static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
  static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;
  static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
  static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly;
  static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly;
  static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
  static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe;
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;
  static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
  static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;
  static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe;
  static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;
  static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
  static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
  static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly;
  static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
  static volatile Function<? super Single, ? extends Single> onSingleAssembly;
  static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;
  static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;
  
  private RxJavaPlugins()
  {
    throw new IllegalStateException("No instances!");
  }
  
  static <T, U, R> R apply(BiFunction<T, U, R> paramBiFunction, T paramT, U paramU)
  {
    try
    {
      paramBiFunction = paramBiFunction.apply(paramT, paramU);
      return paramBiFunction;
    }
    finally {}
  }
  
  static <T, R> R apply(Function<T, R> paramFunction, T paramT)
  {
    try
    {
      paramFunction = paramFunction.apply(paramT);
      return paramFunction;
    }
    finally {}
  }
  
  static Scheduler applyRequireNonNull(Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction, Callable<Scheduler> paramCallable)
  {
    return (Scheduler)ObjectHelper.requireNonNull(apply(paramFunction, paramCallable), "Scheduler Callable result can't be null");
  }
  
  static Scheduler callRequireNonNull(Callable<Scheduler> paramCallable)
  {
    try
    {
      paramCallable = (Scheduler)ObjectHelper.requireNonNull(paramCallable.call(), "Scheduler Callable result can't be null");
      return paramCallable;
    }
    finally {}
  }
  
  public static Scheduler createComputationScheduler(ThreadFactory paramThreadFactory)
  {
    return new ComputationScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  public static Scheduler createIoScheduler(ThreadFactory paramThreadFactory)
  {
    return new IoScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  public static Scheduler createNewThreadScheduler(ThreadFactory paramThreadFactory)
  {
    return new NewThreadScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  public static Scheduler createSingleScheduler(ThreadFactory paramThreadFactory)
  {
    return new SingleScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler()
  {
    return onComputationHandler;
  }
  
  public static Consumer<? super Throwable> getErrorHandler()
  {
    return errorHandler;
  }
  
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler()
  {
    return onInitComputationHandler;
  }
  
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler()
  {
    return onInitIoHandler;
  }
  
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler()
  {
    return onInitNewThreadHandler;
  }
  
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler()
  {
    return onInitSingleHandler;
  }
  
  public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler()
  {
    return onIoHandler;
  }
  
  public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler()
  {
    return onNewThreadHandler;
  }
  
  public static BooleanSupplier getOnBeforeBlocking()
  {
    return onBeforeBlocking;
  }
  
  public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly()
  {
    return onCompletableAssembly;
  }
  
  public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe()
  {
    return onCompletableSubscribe;
  }
  
  public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly()
  {
    return onConnectableFlowableAssembly;
  }
  
  public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly()
  {
    return onConnectableObservableAssembly;
  }
  
  public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly()
  {
    return onFlowableAssembly;
  }
  
  public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe()
  {
    return onFlowableSubscribe;
  }
  
  public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly()
  {
    return onMaybeAssembly;
  }
  
  public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe()
  {
    return onMaybeSubscribe;
  }
  
  public static Function<? super Observable, ? extends Observable> getOnObservableAssembly()
  {
    return onObservableAssembly;
  }
  
  public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe()
  {
    return onObservableSubscribe;
  }
  
  public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly()
  {
    return onParallelAssembly;
  }
  
  public static Function<? super Single, ? extends Single> getOnSingleAssembly()
  {
    return onSingleAssembly;
  }
  
  public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe()
  {
    return onSingleSubscribe;
  }
  
  public static Function<? super Runnable, ? extends Runnable> getScheduleHandler()
  {
    return onScheduleHandler;
  }
  
  public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler()
  {
    return onSingleHandler;
  }
  
  public static Scheduler initComputationScheduler(Callable<Scheduler> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function localFunction = onInitComputationHandler;
    if (localFunction == null) {
      return callRequireNonNull(paramCallable);
    }
    return applyRequireNonNull(localFunction, paramCallable);
  }
  
  public static Scheduler initIoScheduler(Callable<Scheduler> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function localFunction = onInitIoHandler;
    if (localFunction == null) {
      return callRequireNonNull(paramCallable);
    }
    return applyRequireNonNull(localFunction, paramCallable);
  }
  
  public static Scheduler initNewThreadScheduler(Callable<Scheduler> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function localFunction = onInitNewThreadHandler;
    if (localFunction == null) {
      return callRequireNonNull(paramCallable);
    }
    return applyRequireNonNull(localFunction, paramCallable);
  }
  
  public static Scheduler initSingleScheduler(Callable<Scheduler> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function localFunction = onInitSingleHandler;
    if (localFunction == null) {
      return callRequireNonNull(paramCallable);
    }
    return applyRequireNonNull(localFunction, paramCallable);
  }
  
  static boolean isBug(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof OnErrorNotImplementedException)) {
      return true;
    }
    if ((paramThrowable instanceof MissingBackpressureException)) {
      return true;
    }
    if ((paramThrowable instanceof IllegalStateException)) {
      return true;
    }
    if ((paramThrowable instanceof NullPointerException)) {
      return true;
    }
    if ((paramThrowable instanceof IllegalArgumentException)) {
      return true;
    }
    return (paramThrowable instanceof CompositeException);
  }
  
  public static boolean isFailOnNonBlockingScheduler()
  {
    return failNonBlockingScheduler;
  }
  
  public static boolean isLockdown()
  {
    return lockdown;
  }
  
  public static void lockdown()
  {
    lockdown = true;
  }
  
  public static Completable onAssembly(Completable paramCompletable)
  {
    Function localFunction = onCompletableAssembly;
    Completable localCompletable = paramCompletable;
    if (localFunction != null) {
      localCompletable = (Completable)apply(localFunction, paramCompletable);
    }
    return localCompletable;
  }
  
  public static <T> Flowable<T> onAssembly(Flowable<T> paramFlowable)
  {
    Function localFunction = onFlowableAssembly;
    Object localObject = paramFlowable;
    if (localFunction != null) {
      localObject = (Flowable)apply(localFunction, paramFlowable);
    }
    return (Flowable<T>)localObject;
  }
  
  public static <T> Maybe<T> onAssembly(Maybe<T> paramMaybe)
  {
    Function localFunction = onMaybeAssembly;
    Object localObject = paramMaybe;
    if (localFunction != null) {
      localObject = (Maybe)apply(localFunction, paramMaybe);
    }
    return (Maybe<T>)localObject;
  }
  
  public static <T> Observable<T> onAssembly(Observable<T> paramObservable)
  {
    Function localFunction = onObservableAssembly;
    Object localObject = paramObservable;
    if (localFunction != null) {
      localObject = (Observable)apply(localFunction, paramObservable);
    }
    return (Observable<T>)localObject;
  }
  
  public static <T> Single<T> onAssembly(Single<T> paramSingle)
  {
    Function localFunction = onSingleAssembly;
    Object localObject = paramSingle;
    if (localFunction != null) {
      localObject = (Single)apply(localFunction, paramSingle);
    }
    return (Single<T>)localObject;
  }
  
  public static <T> ConnectableFlowable<T> onAssembly(ConnectableFlowable<T> paramConnectableFlowable)
  {
    Function localFunction = onConnectableFlowableAssembly;
    Object localObject = paramConnectableFlowable;
    if (localFunction != null) {
      localObject = (ConnectableFlowable)apply(localFunction, paramConnectableFlowable);
    }
    return (ConnectableFlowable<T>)localObject;
  }
  
  public static <T> ConnectableObservable<T> onAssembly(ConnectableObservable<T> paramConnectableObservable)
  {
    Function localFunction = onConnectableObservableAssembly;
    Object localObject = paramConnectableObservable;
    if (localFunction != null) {
      localObject = (ConnectableObservable)apply(localFunction, paramConnectableObservable);
    }
    return (ConnectableObservable<T>)localObject;
  }
  
  public static <T> ParallelFlowable<T> onAssembly(ParallelFlowable<T> paramParallelFlowable)
  {
    Function localFunction = onParallelAssembly;
    Object localObject = paramParallelFlowable;
    if (localFunction != null) {
      localObject = (ParallelFlowable)apply(localFunction, paramParallelFlowable);
    }
    return (ParallelFlowable<T>)localObject;
  }
  
  public static boolean onBeforeBlocking()
  {
    BooleanSupplier localBooleanSupplier = onBeforeBlocking;
    if (localBooleanSupplier != null) {
      try
      {
        boolean bool = localBooleanSupplier.getAsBoolean();
        return bool;
      }
      finally {}
    }
    return false;
  }
  
  public static Scheduler onComputationScheduler(Scheduler paramScheduler)
  {
    Function localFunction = onComputationHandler;
    if (localFunction == null) {
      return paramScheduler;
    }
    return (Scheduler)apply(localFunction, paramScheduler);
  }
  
  public static void onError(Throwable paramThrowable)
  {
    Consumer localConsumer = errorHandler;
    Object localObject;
    if (paramThrowable == null)
    {
      localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    }
    else
    {
      localObject = paramThrowable;
      if (!isBug(paramThrowable)) {
        localObject = new UndeliverableException(paramThrowable);
      }
    }
    if (localConsumer != null) {
      try
      {
        localConsumer.accept(localObject);
        return;
      }
      finally
      {
        paramThrowable.printStackTrace();
        uncaught(paramThrowable);
      }
    }
    ((Throwable)localObject).printStackTrace();
    uncaught((Throwable)localObject);
  }
  
  public static Scheduler onIoScheduler(Scheduler paramScheduler)
  {
    Function localFunction = onIoHandler;
    if (localFunction == null) {
      return paramScheduler;
    }
    return (Scheduler)apply(localFunction, paramScheduler);
  }
  
  public static Scheduler onNewThreadScheduler(Scheduler paramScheduler)
  {
    Function localFunction = onNewThreadHandler;
    if (localFunction == null) {
      return paramScheduler;
    }
    return (Scheduler)apply(localFunction, paramScheduler);
  }
  
  public static Runnable onSchedule(Runnable paramRunnable)
  {
    ObjectHelper.requireNonNull(paramRunnable, "run is null");
    Function localFunction = onScheduleHandler;
    if (localFunction == null) {
      return paramRunnable;
    }
    return (Runnable)apply(localFunction, paramRunnable);
  }
  
  public static Scheduler onSingleScheduler(Scheduler paramScheduler)
  {
    Function localFunction = onSingleHandler;
    if (localFunction == null) {
      return paramScheduler;
    }
    return (Scheduler)apply(localFunction, paramScheduler);
  }
  
  public static CompletableObserver onSubscribe(Completable paramCompletable, CompletableObserver paramCompletableObserver)
  {
    BiFunction localBiFunction = onCompletableSubscribe;
    if (localBiFunction != null) {
      return (CompletableObserver)apply(localBiFunction, paramCompletable, paramCompletableObserver);
    }
    return paramCompletableObserver;
  }
  
  public static <T> MaybeObserver<? super T> onSubscribe(Maybe<T> paramMaybe, MaybeObserver<? super T> paramMaybeObserver)
  {
    BiFunction localBiFunction = onMaybeSubscribe;
    if (localBiFunction != null) {
      return (MaybeObserver)apply(localBiFunction, paramMaybe, paramMaybeObserver);
    }
    return paramMaybeObserver;
  }
  
  public static <T> Observer<? super T> onSubscribe(Observable<T> paramObservable, Observer<? super T> paramObserver)
  {
    BiFunction localBiFunction = onObservableSubscribe;
    if (localBiFunction != null) {
      return (Observer)apply(localBiFunction, paramObservable, paramObserver);
    }
    return paramObserver;
  }
  
  public static <T> SingleObserver<? super T> onSubscribe(Single<T> paramSingle, SingleObserver<? super T> paramSingleObserver)
  {
    BiFunction localBiFunction = onSingleSubscribe;
    if (localBiFunction != null) {
      return (SingleObserver)apply(localBiFunction, paramSingle, paramSingleObserver);
    }
    return paramSingleObserver;
  }
  
  public static <T> Subscriber<? super T> onSubscribe(Flowable<T> paramFlowable, Subscriber<? super T> paramSubscriber)
  {
    BiFunction localBiFunction = onFlowableSubscribe;
    if (localBiFunction != null) {
      return (Subscriber)apply(localBiFunction, paramFlowable, paramSubscriber);
    }
    return paramSubscriber;
  }
  
  public static void reset()
  {
    setErrorHandler(null);
    setScheduleHandler(null);
    setComputationSchedulerHandler(null);
    setInitComputationSchedulerHandler(null);
    setIoSchedulerHandler(null);
    setInitIoSchedulerHandler(null);
    setSingleSchedulerHandler(null);
    setInitSingleSchedulerHandler(null);
    setNewThreadSchedulerHandler(null);
    setInitNewThreadSchedulerHandler(null);
    setOnFlowableAssembly(null);
    setOnFlowableSubscribe(null);
    setOnObservableAssembly(null);
    setOnObservableSubscribe(null);
    setOnSingleAssembly(null);
    setOnSingleSubscribe(null);
    setOnCompletableAssembly(null);
    setOnCompletableSubscribe(null);
    setOnConnectableFlowableAssembly(null);
    setOnConnectableObservableAssembly(null);
    setOnMaybeAssembly(null);
    setOnMaybeSubscribe(null);
    setOnParallelAssembly(null);
    setFailOnNonBlockingScheduler(false);
    setOnBeforeBlocking(null);
  }
  
  public static void setComputationSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onComputationHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setErrorHandler(Consumer<? super Throwable> paramConsumer)
  {
    if (!lockdown)
    {
      errorHandler = paramConsumer;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setFailOnNonBlockingScheduler(boolean paramBoolean)
  {
    if (!lockdown)
    {
      failNonBlockingScheduler = paramBoolean;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitComputationSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onInitComputationHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitIoSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onInitIoHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitNewThreadSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onInitNewThreadHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitSingleSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onInitSingleHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setIoSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onIoHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setNewThreadSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onNewThreadHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnBeforeBlocking(BooleanSupplier paramBooleanSupplier)
  {
    if (!lockdown)
    {
      onBeforeBlocking = paramBooleanSupplier;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnCompletableAssembly(Function<? super Completable, ? extends Completable> paramFunction)
  {
    if (!lockdown)
    {
      onCompletableAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnCompletableSubscribe(BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> paramBiFunction)
  {
    if (!lockdown)
    {
      onCompletableSubscribe = paramBiFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnConnectableFlowableAssembly(Function<? super ConnectableFlowable, ? extends ConnectableFlowable> paramFunction)
  {
    if (!lockdown)
    {
      onConnectableFlowableAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnConnectableObservableAssembly(Function<? super ConnectableObservable, ? extends ConnectableObservable> paramFunction)
  {
    if (!lockdown)
    {
      onConnectableObservableAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnFlowableAssembly(Function<? super Flowable, ? extends Flowable> paramFunction)
  {
    if (!lockdown)
    {
      onFlowableAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnFlowableSubscribe(BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> paramBiFunction)
  {
    if (!lockdown)
    {
      onFlowableSubscribe = paramBiFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnMaybeAssembly(Function<? super Maybe, ? extends Maybe> paramFunction)
  {
    if (!lockdown)
    {
      onMaybeAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnMaybeSubscribe(BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> paramBiFunction)
  {
    if (!lockdown)
    {
      onMaybeSubscribe = paramBiFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnObservableAssembly(Function<? super Observable, ? extends Observable> paramFunction)
  {
    if (!lockdown)
    {
      onObservableAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnObservableSubscribe(BiFunction<? super Observable, ? super Observer, ? extends Observer> paramBiFunction)
  {
    if (!lockdown)
    {
      onObservableSubscribe = paramBiFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnParallelAssembly(Function<? super ParallelFlowable, ? extends ParallelFlowable> paramFunction)
  {
    if (!lockdown)
    {
      onParallelAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnSingleAssembly(Function<? super Single, ? extends Single> paramFunction)
  {
    if (!lockdown)
    {
      onSingleAssembly = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnSingleSubscribe(BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> paramBiFunction)
  {
    if (!lockdown)
    {
      onSingleSubscribe = paramBiFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setScheduleHandler(Function<? super Runnable, ? extends Runnable> paramFunction)
  {
    if (!lockdown)
    {
      onScheduleHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setSingleSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> paramFunction)
  {
    if (!lockdown)
    {
      onSingleHandler = paramFunction;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  static void uncaught(Throwable paramThrowable)
  {
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
  }
  
  static void unlock()
  {
    lockdown = false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\plugins\RxJavaPlugins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */