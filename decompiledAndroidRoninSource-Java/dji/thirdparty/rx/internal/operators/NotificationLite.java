package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Notification.Kind;
import dji.thirdparty.rx.Observer;
import java.io.Serializable;

public final class NotificationLite<T>
{
  private static final NotificationLite INSTANCE = new NotificationLite();
  private static final Object ON_COMPLETED_SENTINEL = new Serializable()
  {
    private static final long serialVersionUID = 1L;
    
    public String toString()
    {
      return "Notification=>Completed";
    }
  };
  private static final Object ON_NEXT_NULL_SENTINEL = new Serializable()
  {
    private static final long serialVersionUID = 2L;
    
    public String toString()
    {
      return "Notification=>NULL";
    }
  };
  
  public static <T> NotificationLite<T> instance()
  {
    return INSTANCE;
  }
  
  public boolean accept(Observer<? super T> paramObserver, Object paramObject)
  {
    return false;
  }
  
  public Object completed()
  {
    return ON_COMPLETED_SENTINEL;
  }
  
  public Object error(Throwable paramThrowable)
  {
    return new OnErrorSentinel(paramThrowable);
  }
  
  public Throwable getError(Object paramObject)
  {
    return ((OnErrorSentinel)paramObject).e;
  }
  
  public T getValue(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == ON_NEXT_NULL_SENTINEL) {
      localObject = null;
    }
    return (T)localObject;
  }
  
  public boolean isCompleted(Object paramObject)
  {
    return paramObject == ON_COMPLETED_SENTINEL;
  }
  
  public boolean isError(Object paramObject)
  {
    return paramObject instanceof OnErrorSentinel;
  }
  
  public boolean isNext(Object paramObject)
  {
    return false;
  }
  
  public boolean isNull(Object paramObject)
  {
    return paramObject == ON_NEXT_NULL_SENTINEL;
  }
  
  public Notification.Kind kind(Object paramObject)
  {
    return null;
  }
  
  public Object next(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = ON_NEXT_NULL_SENTINEL;
    }
    return localObject;
  }
  
  private static class OnErrorSentinel
    implements Serializable
  {
    private static final long serialVersionUID = 3L;
    final Throwable e;
    
    public OnErrorSentinel(Throwable paramThrowable)
    {
      this.e = paramThrowable;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\NotificationLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */