package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\000\n\002\b\003\n\002\020\013\n\002\b\t\n\002\020\003\n\002\b\005\n\002\020\b\n\000\n\002\020\016\n\002\b\005\b@\030\000 \036*\006\b\000\020\001 \0012\0060\002j\002`\003:\002\036\037B\026\b\001\022\b\020\004\032\004\030\0010\005ø\001\000¢\006\004\b\006\020\007J\023\020\020\032\0020\t2\b\020\021\032\004\030\0010\005HÖ\003J\017\020\022\032\004\030\0010\023¢\006\004\b\024\020\025J\022\020\026\032\004\030\0018\000H\b¢\006\004\b\027\020\007J\t\020\030\032\0020\031HÖ\001J\017\020\032\032\0020\033H\026¢\006\004\b\034\020\035R\021\020\b\032\0020\t8F¢\006\006\032\004\b\n\020\013R\021\020\f\032\0020\t8F¢\006\006\032\004\b\r\020\013R\030\020\004\032\004\030\0010\0058\000X\004¢\006\b\n\000\022\004\b\016\020\017ø\001\000\002\004\n\002\b\031¨\006 "}, d2={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class Result<T>
  implements Serializable
{
  public static final Companion Companion = new Companion(null);
  private final Object value;
  
  public static Object constructor-impl(Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean equals-impl(Object paramObject1, Object paramObject2)
  {
    return ((paramObject2 instanceof Result)) && (Intrinsics.areEqual(paramObject1, ((Result)paramObject2).unbox-impl()));
  }
  
  public static final boolean equals-impl0(Object paramObject1, Object paramObject2)
  {
    throw null;
  }
  
  public static final Throwable exceptionOrNull-impl(Object paramObject)
  {
    if ((paramObject instanceof Failure)) {
      return ((Failure)paramObject).exception;
    }
    return null;
  }
  
  private static final T getOrNull-impl(Object paramObject)
  {
    Object localObject = paramObject;
    if (isFailure-impl(paramObject)) {
      localObject = null;
    }
    return (T)localObject;
  }
  
  public static int hashCode-impl(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  public static final boolean isFailure-impl(Object paramObject)
  {
    return paramObject instanceof Failure;
  }
  
  public static final boolean isSuccess-impl(Object paramObject)
  {
    return paramObject instanceof Failure ^ true;
  }
  
  public static String toString-impl(Object paramObject)
  {
    if ((paramObject instanceof Failure)) {
      return paramObject.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Success(");
    localStringBuilder.append(paramObject);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.value, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.value);
  }
  
  public String toString()
  {
    return toString-impl(this.value);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\003\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J%\020\003\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\006\020\006\032\0020\007H\bø\001\000¢\006\002\020\bJ%\020\t\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\006\020\n\032\002H\005H\bø\001\000¢\006\002\020\013\002\004\n\002\b\031¨\006\f"}, d2={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    private final <T> Object failure(Throwable paramThrowable)
    {
      return Result.constructor-impl(ResultKt.createFailure(paramThrowable));
    }
    
    private final <T> Object success(T paramT)
    {
      return Result.constructor-impl(paramT);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\003\n\002\b\002\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\000\b\000\030\0002\0060\001j\002`\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\023\020\006\032\0020\0072\b\020\b\032\004\030\0010\tH\002J\b\020\n\032\0020\013H\026J\b\020\f\032\0020\rH\026R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\016"}, d2={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Failure
    implements Serializable
  {
    public final Throwable exception;
    
    public Failure(Throwable paramThrowable)
    {
      this.exception = paramThrowable;
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof Failure)) && (Intrinsics.areEqual(this.exception, ((Failure)paramObject).exception));
    }
    
    public int hashCode()
    {
      return this.exception.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failure(");
      localStringBuilder.append(this.exception);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */