package dji.thirdparty.rx;

public final class Notification<T>
{
  private static final Notification<Void> ON_COMPLETED = new Notification(Kind.OnCompleted, null, null);
  private final Kind kind;
  private final Throwable throwable;
  private final T value;
  
  private Notification(Kind paramKind, T paramT, Throwable paramThrowable)
  {
    this.value = paramT;
    this.throwable = paramThrowable;
    this.kind = paramKind;
  }
  
  public static <T> Notification<T> createOnCompleted()
  {
    return ON_COMPLETED;
  }
  
  public static <T> Notification<T> createOnCompleted(Class<T> paramClass)
  {
    return ON_COMPLETED;
  }
  
  public static <T> Notification<T> createOnError(Throwable paramThrowable)
  {
    return new Notification(Kind.OnError, null, paramThrowable);
  }
  
  public static <T> Notification<T> createOnNext(T paramT)
  {
    return new Notification(Kind.OnNext, paramT, null);
  }
  
  /* Error */
  public void accept(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public Kind getKind()
  {
    return this.kind;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  public T getValue()
  {
    return (T)this.value;
  }
  
  public boolean hasThrowable()
  {
    return false;
  }
  
  public boolean hasValue()
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isOnCompleted()
  {
    return false;
  }
  
  public boolean isOnError()
  {
    return false;
  }
  
  public boolean isOnNext()
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static enum Kind
  {
    static
    {
      OnError = new Kind("OnError", 1);
      Kind localKind = new Kind("OnCompleted", 2);
      OnCompleted = localKind;
      $VALUES = new Kind[] { OnNext, OnError, localKind };
    }
    
    private Kind() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Notification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */