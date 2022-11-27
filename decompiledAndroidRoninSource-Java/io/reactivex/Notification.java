package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T>
{
  static final Notification<Object> COMPLETE = new Notification(null);
  final Object value;
  
  private Notification(Object paramObject)
  {
    this.value = paramObject;
  }
  
  public static <T> Notification<T> createOnComplete()
  {
    return COMPLETE;
  }
  
  public static <T> Notification<T> createOnError(Throwable paramThrowable)
  {
    ObjectHelper.requireNonNull(paramThrowable, "error is null");
    return new Notification(NotificationLite.error(paramThrowable));
  }
  
  public static <T> Notification<T> createOnNext(T paramT)
  {
    ObjectHelper.requireNonNull(paramT, "value is null");
    return new Notification(paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public Throwable getError()
  {
    return null;
  }
  
  public T getValue()
  {
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isOnComplete()
  {
    return this.value == null;
  }
  
  public boolean isOnError()
  {
    return NotificationLite.isError(this.value);
  }
  
  public boolean isOnNext()
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Notification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */