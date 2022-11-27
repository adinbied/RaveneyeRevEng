package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum NotificationLite
{
  static
  {
    NotificationLite localNotificationLite = new NotificationLite("COMPLETE", 0);
    COMPLETE = localNotificationLite;
    $VALUES = new NotificationLite[] { localNotificationLite };
  }
  
  private NotificationLite() {}
  
  public static <T> boolean accept(Object paramObject, Observer<? super T> paramObserver)
  {
    if (paramObject == COMPLETE)
    {
      paramObserver.onComplete();
      return true;
    }
    if ((paramObject instanceof ErrorNotification))
    {
      paramObserver.onError(((ErrorNotification)paramObject).e);
      return true;
    }
    paramObserver.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean accept(Object paramObject, Subscriber<? super T> paramSubscriber)
  {
    if (paramObject == COMPLETE)
    {
      paramSubscriber.onComplete();
      return true;
    }
    if ((paramObject instanceof ErrorNotification))
    {
      paramSubscriber.onError(((ErrorNotification)paramObject).e);
      return true;
    }
    paramSubscriber.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, Observer<? super T> paramObserver)
  {
    if (paramObject == COMPLETE)
    {
      paramObserver.onComplete();
      return true;
    }
    if ((paramObject instanceof ErrorNotification))
    {
      paramObserver.onError(((ErrorNotification)paramObject).e);
      return true;
    }
    if ((paramObject instanceof DisposableNotification))
    {
      paramObserver.onSubscribe(((DisposableNotification)paramObject).upstream);
      return false;
    }
    paramObserver.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, Subscriber<? super T> paramSubscriber)
  {
    if (paramObject == COMPLETE)
    {
      paramSubscriber.onComplete();
      return true;
    }
    if ((paramObject instanceof ErrorNotification))
    {
      paramSubscriber.onError(((ErrorNotification)paramObject).e);
      return true;
    }
    if ((paramObject instanceof SubscriptionNotification))
    {
      paramSubscriber.onSubscribe(((SubscriptionNotification)paramObject).upstream);
      return false;
    }
    paramSubscriber.onNext(paramObject);
    return false;
  }
  
  public static Object complete()
  {
    return COMPLETE;
  }
  
  public static Object disposable(Disposable paramDisposable)
  {
    return new DisposableNotification(paramDisposable);
  }
  
  public static Object error(Throwable paramThrowable)
  {
    return new ErrorNotification(paramThrowable);
  }
  
  public static Disposable getDisposable(Object paramObject)
  {
    return ((DisposableNotification)paramObject).upstream;
  }
  
  public static Throwable getError(Object paramObject)
  {
    return ((ErrorNotification)paramObject).e;
  }
  
  public static Subscription getSubscription(Object paramObject)
  {
    return ((SubscriptionNotification)paramObject).upstream;
  }
  
  public static <T> T getValue(Object paramObject)
  {
    return (T)paramObject;
  }
  
  public static boolean isComplete(Object paramObject)
  {
    return paramObject == COMPLETE;
  }
  
  public static boolean isDisposable(Object paramObject)
  {
    return paramObject instanceof DisposableNotification;
  }
  
  public static boolean isError(Object paramObject)
  {
    return paramObject instanceof ErrorNotification;
  }
  
  public static boolean isSubscription(Object paramObject)
  {
    return paramObject instanceof SubscriptionNotification;
  }
  
  public static <T> Object next(T paramT)
  {
    return paramT;
  }
  
  public static Object subscription(Subscription paramSubscription)
  {
    return new SubscriptionNotification(paramSubscription);
  }
  
  public String toString()
  {
    return "NotificationLite.Complete";
  }
  
  static final class DisposableNotification
    implements Serializable
  {
    private static final long serialVersionUID = -7482590109178395495L;
    final Disposable upstream;
    
    DisposableNotification(Disposable paramDisposable)
    {
      this.upstream = paramDisposable;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  static final class ErrorNotification
    implements Serializable
  {
    private static final long serialVersionUID = -8759979445933046293L;
    final Throwable e;
    
    ErrorNotification(Throwable paramThrowable)
    {
      this.e = paramThrowable;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return this.e.hashCode();
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  static final class SubscriptionNotification
    implements Serializable
  {
    private static final long serialVersionUID = -1322257508628817540L;
    final Subscription upstream;
    
    SubscriptionNotification(Subscription paramSubscription)
    {
      this.upstream = paramSubscription;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\NotificationLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */