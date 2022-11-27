package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class EndConsumerHelper
{
  private EndConsumerHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static String composeMessage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("It is not allowed to subscribe with a(n) ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" multiple times. Please create a fresh instance of ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" and subscribe that to the target source instead.");
    return localStringBuilder.toString();
  }
  
  public static void reportDoubleSubscription(Class<?> paramClass)
  {
    RxJavaPlugins.onError(new ProtocolViolationException(composeMessage(paramClass.getName())));
  }
  
  public static boolean setOnce(AtomicReference<Disposable> paramAtomicReference, Disposable paramDisposable, Class<?> paramClass)
  {
    ObjectHelper.requireNonNull(paramDisposable, "next is null");
    if (!paramAtomicReference.compareAndSet(null, paramDisposable))
    {
      paramDisposable.dispose();
      if (paramAtomicReference.get() != DisposableHelper.DISPOSED) {
        reportDoubleSubscription(paramClass);
      }
      return false;
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<Subscription> paramAtomicReference, Subscription paramSubscription, Class<?> paramClass)
  {
    ObjectHelper.requireNonNull(paramSubscription, "next is null");
    if (!paramAtomicReference.compareAndSet(null, paramSubscription))
    {
      paramSubscription.cancel();
      if (paramAtomicReference.get() != SubscriptionHelper.CANCELLED) {
        reportDoubleSubscription(paramClass);
      }
      return false;
    }
    return true;
  }
  
  public static boolean validate(Disposable paramDisposable1, Disposable paramDisposable2, Class<?> paramClass)
  {
    ObjectHelper.requireNonNull(paramDisposable2, "next is null");
    if (paramDisposable1 != null)
    {
      paramDisposable2.dispose();
      if (paramDisposable1 != DisposableHelper.DISPOSED) {
        reportDoubleSubscription(paramClass);
      }
      return false;
    }
    return true;
  }
  
  public static boolean validate(Subscription paramSubscription1, Subscription paramSubscription2, Class<?> paramClass)
  {
    ObjectHelper.requireNonNull(paramSubscription2, "next is null");
    if (paramSubscription1 != null)
    {
      paramSubscription2.cancel();
      if (paramSubscription1 != SubscriptionHelper.CANCELLED) {
        reportDoubleSubscription(paramClass);
      }
      return false;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\EndConsumerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */