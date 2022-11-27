package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
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
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

public final class Functions
{
  static final Predicate<Object> ALWAYS_FALSE;
  static final Predicate<Object> ALWAYS_TRUE;
  public static final Action EMPTY_ACTION;
  static final Consumer<Object> EMPTY_CONSUMER;
  public static final LongConsumer EMPTY_LONG_CONSUMER;
  public static final Runnable EMPTY_RUNNABLE;
  public static final Consumer<Throwable> ERROR_CONSUMER;
  static final Function<Object, Object> IDENTITY = new Identity();
  static final Comparator<Object> NATURAL_COMPARATOR = new NaturalObjectComparator();
  static final Callable<Object> NULL_SUPPLIER;
  public static final Consumer<Throwable> ON_ERROR_MISSING;
  public static final Consumer<Subscription> REQUEST_MAX = new MaxRequestSubscription();
  
  static
  {
    EMPTY_RUNNABLE = new EmptyRunnable();
    EMPTY_ACTION = new EmptyAction();
    EMPTY_CONSUMER = new EmptyConsumer();
    ERROR_CONSUMER = new ErrorConsumer();
    ON_ERROR_MISSING = new OnErrorMissingConsumer();
    EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    ALWAYS_TRUE = new TruePredicate();
    ALWAYS_FALSE = new FalsePredicate();
    NULL_SUPPLIER = new NullCallable();
  }
  
  private Functions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Consumer<T> actionConsumer(Action paramAction)
  {
    return new ActionConsumer(paramAction);
  }
  
  public static <T> Predicate<T> alwaysFalse()
  {
    return ALWAYS_FALSE;
  }
  
  public static <T> Predicate<T> alwaysTrue()
  {
    return ALWAYS_TRUE;
  }
  
  public static <T> Consumer<T> boundedConsumer(int paramInt)
  {
    return new BoundedConsumer(paramInt);
  }
  
  public static <T, U> Function<T, U> castFunction(Class<U> paramClass)
  {
    return new CastToClass(paramClass);
  }
  
  public static <T> Callable<List<T>> createArrayList(int paramInt)
  {
    return new ArrayListCapacityCallable(paramInt);
  }
  
  public static <T> Callable<Set<T>> createHashSet()
  {
    return HashSetCallable.INSTANCE;
  }
  
  public static <T> Consumer<T> emptyConsumer()
  {
    return EMPTY_CONSUMER;
  }
  
  public static <T> Predicate<T> equalsWith(T paramT)
  {
    return new EqualsPredicate(paramT);
  }
  
  public static Action futureAction(Future<?> paramFuture)
  {
    return new FutureAction(paramFuture);
  }
  
  public static <T> Function<T, T> identity()
  {
    return IDENTITY;
  }
  
  public static <T, U> Predicate<T> isInstanceOf(Class<U> paramClass)
  {
    return new ClassFilter(paramClass);
  }
  
  public static <T> Callable<T> justCallable(T paramT)
  {
    return new JustValue(paramT);
  }
  
  public static <T, U> Function<T, U> justFunction(U paramU)
  {
    return new JustValue(paramU);
  }
  
  public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> paramComparator)
  {
    return new ListSorter(paramComparator);
  }
  
  public static <T> Comparator<T> naturalComparator()
  {
    return NaturalComparator.INSTANCE;
  }
  
  public static <T> Comparator<T> naturalOrder()
  {
    return NATURAL_COMPARATOR;
  }
  
  public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> paramConsumer)
  {
    return new NotificationOnComplete(paramConsumer);
  }
  
  public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> paramConsumer)
  {
    return new NotificationOnError(paramConsumer);
  }
  
  public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> paramConsumer)
  {
    return new NotificationOnNext(paramConsumer);
  }
  
  public static <T> Callable<T> nullSupplier()
  {
    return NULL_SUPPLIER;
  }
  
  public static <T> Predicate<T> predicateReverseFor(BooleanSupplier paramBooleanSupplier)
  {
    return new BooleanSupplierPredicateReverse(paramBooleanSupplier);
  }
  
  public static <T> Function<T, Timed<T>> timestampWith(TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return new TimestampFunction(paramTimeUnit, paramScheduler);
  }
  
  public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction)
  {
    ObjectHelper.requireNonNull(paramBiFunction, "f is null");
    return new Array2Func(paramBiFunction);
  }
  
  public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> paramFunction3)
  {
    ObjectHelper.requireNonNull(paramFunction3, "f is null");
    return new Array3Func(paramFunction3);
  }
  
  public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> paramFunction4)
  {
    ObjectHelper.requireNonNull(paramFunction4, "f is null");
    return new Array4Func(paramFunction4);
  }
  
  public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> paramFunction5)
  {
    ObjectHelper.requireNonNull(paramFunction5, "f is null");
    return new Array5Func(paramFunction5);
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> paramFunction6)
  {
    ObjectHelper.requireNonNull(paramFunction6, "f is null");
    return new Array6Func(paramFunction6);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> paramFunction7)
  {
    ObjectHelper.requireNonNull(paramFunction7, "f is null");
    return new Array7Func(paramFunction7);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> paramFunction8)
  {
    ObjectHelper.requireNonNull(paramFunction8, "f is null");
    return new Array8Func(paramFunction8);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> paramFunction9)
  {
    ObjectHelper.requireNonNull(paramFunction9, "f is null");
    return new Array9Func(paramFunction9);
  }
  
  public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> paramFunction)
  {
    return new ToMapKeySelector(paramFunction);
  }
  
  public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1)
  {
    return new ToMapKeyValueSelector(paramFunction1, paramFunction);
  }
  
  public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Function<? super K, ? extends Collection<? super V>> paramFunction2)
  {
    return new ToMultimapKeyValueSelector(paramFunction2, paramFunction1, paramFunction);
  }
  
  static final class ActionConsumer<T>
    implements Consumer<T>
  {
    final Action action;
    
    ActionConsumer(Action paramAction)
    {
      this.action = paramAction;
    }
    
    public void accept(T paramT)
      throws Exception
    {
      this.action.run();
    }
  }
  
  static final class Array2Func<T1, T2, R>
    implements Function<Object[], R>
  {
    final BiFunction<? super T1, ? super T2, ? extends R> f;
    
    Array2Func(BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction)
    {
      this.f = paramBiFunction;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class Array3Func<T1, T2, T3, R>
    implements Function<Object[], R>
  {
    final Function3<T1, T2, T3, R> f;
    
    Array3Func(Function3<T1, T2, T3, R> paramFunction3)
    {
      this.f = paramFunction3;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class Array4Func<T1, T2, T3, T4, R>
    implements Function<Object[], R>
  {
    final Function4<T1, T2, T3, T4, R> f;
    
    Array4Func(Function4<T1, T2, T3, T4, R> paramFunction4)
    {
      this.f = paramFunction4;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class Array5Func<T1, T2, T3, T4, T5, R>
    implements Function<Object[], R>
  {
    private final Function5<T1, T2, T3, T4, T5, R> f;
    
    Array5Func(Function5<T1, T2, T3, T4, T5, R> paramFunction5)
    {
      this.f = paramFunction5;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class Array6Func<T1, T2, T3, T4, T5, T6, R>
    implements Function<Object[], R>
  {
    final Function6<T1, T2, T3, T4, T5, T6, R> f;
    
    Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> paramFunction6)
    {
      this.f = paramFunction6;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R>
    implements Function<Object[], R>
  {
    final Function7<T1, T2, T3, T4, T5, T6, T7, R> f;
    
    Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> paramFunction7)
    {
      this.f = paramFunction7;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R>
    implements Function<Object[], R>
  {
    final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f;
    
    Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> paramFunction8)
    {
      this.f = paramFunction8;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>
    implements Function<Object[], R>
  {
    final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f;
    
    Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> paramFunction9)
    {
      this.f = paramFunction9;
    }
    
    public R apply(Object[] paramArrayOfObject)
      throws Exception
    {
      return null;
    }
  }
  
  static final class ArrayListCapacityCallable<T>
    implements Callable<List<T>>
  {
    final int capacity;
    
    ArrayListCapacityCallable(int paramInt)
    {
      this.capacity = paramInt;
    }
    
    public List<T> call()
      throws Exception
    {
      return new ArrayList(this.capacity);
    }
  }
  
  static final class BooleanSupplierPredicateReverse<T>
    implements Predicate<T>
  {
    final BooleanSupplier supplier;
    
    BooleanSupplierPredicateReverse(BooleanSupplier paramBooleanSupplier)
    {
      this.supplier = paramBooleanSupplier;
    }
    
    public boolean test(T paramT)
      throws Exception
    {
      return this.supplier.getAsBoolean() ^ true;
    }
  }
  
  public static class BoundedConsumer
    implements Consumer<Subscription>
  {
    final int bufferSize;
    
    BoundedConsumer(int paramInt)
    {
      this.bufferSize = paramInt;
    }
    
    public void accept(Subscription paramSubscription)
      throws Exception
    {
      paramSubscription.request(this.bufferSize);
    }
  }
  
  static final class CastToClass<T, U>
    implements Function<T, U>
  {
    final Class<U> clazz;
    
    CastToClass(Class<U> paramClass)
    {
      this.clazz = paramClass;
    }
    
    public U apply(T paramT)
      throws Exception
    {
      return (U)this.clazz.cast(paramT);
    }
  }
  
  static final class ClassFilter<T, U>
    implements Predicate<T>
  {
    final Class<U> clazz;
    
    ClassFilter(Class<U> paramClass)
    {
      this.clazz = paramClass;
    }
    
    public boolean test(T paramT)
      throws Exception
    {
      return this.clazz.isInstance(paramT);
    }
  }
  
  static final class EmptyAction
    implements Action
  {
    public void run() {}
    
    public String toString()
    {
      return "EmptyAction";
    }
  }
  
  static final class EmptyConsumer
    implements Consumer<Object>
  {
    public void accept(Object paramObject) {}
    
    public String toString()
    {
      return "EmptyConsumer";
    }
  }
  
  static final class EmptyLongConsumer
    implements LongConsumer
  {
    public void accept(long paramLong) {}
  }
  
  static final class EmptyRunnable
    implements Runnable
  {
    public void run() {}
    
    public String toString()
    {
      return "EmptyRunnable";
    }
  }
  
  static final class EqualsPredicate<T>
    implements Predicate<T>
  {
    final T value;
    
    EqualsPredicate(T paramT)
    {
      this.value = paramT;
    }
    
    public boolean test(T paramT)
      throws Exception
    {
      return ObjectHelper.equals(paramT, this.value);
    }
  }
  
  static final class ErrorConsumer
    implements Consumer<Throwable>
  {
    public void accept(Throwable paramThrowable)
    {
      RxJavaPlugins.onError(paramThrowable);
    }
  }
  
  static final class FalsePredicate
    implements Predicate<Object>
  {
    public boolean test(Object paramObject)
    {
      return false;
    }
  }
  
  static final class FutureAction
    implements Action
  {
    final Future<?> future;
    
    FutureAction(Future<?> paramFuture)
    {
      this.future = paramFuture;
    }
    
    public void run()
      throws Exception
    {
      this.future.get();
    }
  }
  
  static enum HashSetCallable
    implements Callable<Set<Object>>
  {
    static
    {
      HashSetCallable localHashSetCallable = new HashSetCallable("INSTANCE", 0);
      INSTANCE = localHashSetCallable;
      $VALUES = new HashSetCallable[] { localHashSetCallable };
    }
    
    private HashSetCallable() {}
    
    public Set<Object> call()
      throws Exception
    {
      return new HashSet();
    }
  }
  
  static final class Identity
    implements Function<Object, Object>
  {
    public Object apply(Object paramObject)
    {
      return paramObject;
    }
    
    public String toString()
    {
      return "IdentityFunction";
    }
  }
  
  static final class JustValue<T, U>
    implements Callable<U>, Function<T, U>
  {
    final U value;
    
    JustValue(U paramU)
    {
      this.value = paramU;
    }
    
    public U apply(T paramT)
      throws Exception
    {
      return (U)this.value;
    }
    
    public U call()
      throws Exception
    {
      return (U)this.value;
    }
  }
  
  static final class ListSorter<T>
    implements Function<List<T>, List<T>>
  {
    final Comparator<? super T> comparator;
    
    ListSorter(Comparator<? super T> paramComparator)
    {
      this.comparator = paramComparator;
    }
    
    public List<T> apply(List<T> paramList)
    {
      Collections.sort(paramList, this.comparator);
      return paramList;
    }
  }
  
  static final class MaxRequestSubscription
    implements Consumer<Subscription>
  {
    /* Error */
    public void accept(Subscription arg1)
      throws Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static enum NaturalComparator
    implements Comparator<Object>
  {
    static
    {
      NaturalComparator localNaturalComparator = new NaturalComparator("INSTANCE", 0);
      INSTANCE = localNaturalComparator;
      $VALUES = new NaturalComparator[] { localNaturalComparator };
    }
    
    private NaturalComparator() {}
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
  }
  
  static final class NaturalObjectComparator
    implements Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
  }
  
  static final class NotificationOnComplete<T>
    implements Action
  {
    final Consumer<? super Notification<T>> onNotification;
    
    NotificationOnComplete(Consumer<? super Notification<T>> paramConsumer)
    {
      this.onNotification = paramConsumer;
    }
    
    /* Error */
    public void run()
      throws Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class NotificationOnError<T>
    implements Consumer<Throwable>
  {
    final Consumer<? super Notification<T>> onNotification;
    
    NotificationOnError(Consumer<? super Notification<T>> paramConsumer)
    {
      this.onNotification = paramConsumer;
    }
    
    /* Error */
    public void accept(Throwable arg1)
      throws Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class NotificationOnNext<T>
    implements Consumer<T>
  {
    final Consumer<? super Notification<T>> onNotification;
    
    NotificationOnNext(Consumer<? super Notification<T>> paramConsumer)
    {
      this.onNotification = paramConsumer;
    }
    
    /* Error */
    public void accept(T arg1)
      throws Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class NullCallable
    implements Callable<Object>
  {
    public Object call()
    {
      return null;
    }
  }
  
  static final class OnErrorMissingConsumer
    implements Consumer<Throwable>
  {
    /* Error */
    public void accept(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class TimestampFunction<T>
    implements Function<T, Timed<T>>
  {
    final Scheduler scheduler;
    final TimeUnit unit;
    
    TimestampFunction(TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public Timed<T> apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class ToMapKeySelector<K, T>
    implements BiConsumer<Map<K, T>, T>
  {
    private final Function<? super T, ? extends K> keySelector;
    
    ToMapKeySelector(Function<? super T, ? extends K> paramFunction)
    {
      this.keySelector = paramFunction;
    }
    
    /* Error */
    public void accept(Map<K, T> arg1, T arg2)
      throws Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ToMapKeyValueSelector<K, V, T>
    implements BiConsumer<Map<K, V>, T>
  {
    private final Function<? super T, ? extends K> keySelector;
    private final Function<? super T, ? extends V> valueSelector;
    
    ToMapKeyValueSelector(Function<? super T, ? extends V> paramFunction, Function<? super T, ? extends K> paramFunction1)
    {
      this.valueSelector = paramFunction;
      this.keySelector = paramFunction1;
    }
    
    /* Error */
    public void accept(Map<K, V> arg1, T arg2)
      throws Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ToMultimapKeyValueSelector<K, V, T>
    implements BiConsumer<Map<K, Collection<V>>, T>
  {
    private final Function<? super K, ? extends Collection<? super V>> collectionFactory;
    private final Function<? super T, ? extends K> keySelector;
    private final Function<? super T, ? extends V> valueSelector;
    
    ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> paramFunction, Function<? super T, ? extends V> paramFunction1, Function<? super T, ? extends K> paramFunction2)
    {
      this.collectionFactory = paramFunction;
      this.valueSelector = paramFunction1;
      this.keySelector = paramFunction2;
    }
    
    /* Error */
    public void accept(Map<K, Collection<V>> arg1, T arg2)
      throws Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class TruePredicate
    implements Predicate<Object>
  {
    public boolean test(Object paramObject)
    {
      return true;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\functions\Functions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */