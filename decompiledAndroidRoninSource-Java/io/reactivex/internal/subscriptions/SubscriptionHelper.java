package io.reactivex.internal.subscriptions;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public enum SubscriptionHelper
  implements Subscription
{
  static
  {
    SubscriptionHelper localSubscriptionHelper = new SubscriptionHelper("CANCELLED", 0);
    CANCELLED = localSubscriptionHelper;
    $VALUES = new SubscriptionHelper[] { localSubscriptionHelper };
  }
  
  private SubscriptionHelper() {}
  
  public static boolean cancel(AtomicReference<Subscription> paramAtomicReference)
  {
    Subscription localSubscription = (Subscription)paramAtomicReference.get();
    SubscriptionHelper localSubscriptionHelper = CANCELLED;
    if (localSubscription != localSubscriptionHelper)
    {
      paramAtomicReference = (Subscription)paramAtomicReference.getAndSet(localSubscriptionHelper);
      if (paramAtomicReference != CANCELLED)
      {
        if (paramAtomicReference != null) {
          paramAtomicReference.cancel();
        }
        return true;
      }
    }
    return false;
  }
  
  public static void deferredRequest(AtomicReference<Subscription> paramAtomicReference, AtomicLong paramAtomicLong, long paramLong)
  {
    Subscription localSubscription = (Subscription)paramAtomicReference.get();
    if (localSubscription != null)
    {
      localSubscription.request(paramLong);
      return;
    }
    if (validate(paramLong))
    {
      BackpressureHelper.add(paramAtomicLong, paramLong);
      paramAtomicReference = (Subscription)paramAtomicReference.get();
      if (paramAtomicReference != null)
      {
        paramLong = paramAtomicLong.getAndSet(0L);
        if (paramLong != 0L) {
          paramAtomicReference.request(paramLong);
        }
      }
    }
  }
  
  public static boolean deferredSetOnce(AtomicReference<Subscription> paramAtomicReference, AtomicLong paramAtomicLong, Subscription paramSubscription)
  {
    if (setOnce(paramAtomicReference, paramSubscription))
    {
      long l = paramAtomicLong.getAndSet(0L);
      if (l != 0L) {
        paramSubscription.request(l);
      }
      return true;
    }
    return false;
  }
  
  public static boolean replace(AtomicReference<Subscription> paramAtomicReference, Subscription paramSubscription)
  {
    Subscription localSubscription;
    do
    {
      localSubscription = (Subscription)paramAtomicReference.get();
      if (localSubscription == CANCELLED)
      {
        if (paramSubscription != null) {
          paramSubscription.cancel();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localSubscription, paramSubscription));
    return true;
  }
  
  public static void reportMoreProduced(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("More produced than requested: ");
    localStringBuilder.append(paramLong);
    RxJavaPlugins.onError(new ProtocolViolationException(localStringBuilder.toString()));
  }
  
  public static void reportSubscriptionSet()
  {
    RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
  }
  
  public static boolean set(AtomicReference<Subscription> paramAtomicReference, Subscription paramSubscription)
  {
    Subscription localSubscription;
    do
    {
      localSubscription = (Subscription)paramAtomicReference.get();
      if (localSubscription == CANCELLED)
      {
        if (paramSubscription != null) {
          paramSubscription.cancel();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localSubscription, paramSubscription));
    if (localSubscription != null) {
      localSubscription.cancel();
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<Subscription> paramAtomicReference, Subscription paramSubscription)
  {
    ObjectHelper.requireNonNull(paramSubscription, "s is null");
    if (!paramAtomicReference.compareAndSet(null, paramSubscription))
    {
      paramSubscription.cancel();
      if (paramAtomicReference.get() != CANCELLED) {
        reportSubscriptionSet();
      }
      return false;
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<Subscription> paramAtomicReference, Subscription paramSubscription, long paramLong)
  {
    if (setOnce(paramAtomicReference, paramSubscription))
    {
      paramSubscription.request(paramLong);
      return true;
    }
    return false;
  }
  
  public static boolean validate(long paramLong)
  {
    if (paramLong <= 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("n > 0 required but it was ");
      localStringBuilder.append(paramLong);
      RxJavaPlugins.onError(new IllegalArgumentException(localStringBuilder.toString()));
      return false;
    }
    return true;
  }
  
  public static boolean validate(Subscription paramSubscription1, Subscription paramSubscription2)
  {
    if (paramSubscription2 == null)
    {
      RxJavaPlugins.onError(new NullPointerException("next is null"));
      return false;
    }
    if (paramSubscription1 != null)
    {
      paramSubscription2.cancel();
      reportSubscriptionSet();
      return false;
    }
    return true;
  }
  
  public void cancel() {}
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\SubscriptionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */