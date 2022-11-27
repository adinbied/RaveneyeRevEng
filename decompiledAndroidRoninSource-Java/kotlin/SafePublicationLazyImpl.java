package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\000\n\002\b\005\n\002\020\013\n\000\n\002\020\016\n\002\b\003\b\002\030\000 \023*\006\b\000\020\001 \0012\b\022\004\022\002H\0010\0022\0060\003j\002`\004:\001\023B\023\022\f\020\005\032\b\022\004\022\0028\0000\006¢\006\002\020\007J\b\020\016\032\0020\017H\026J\b\020\020\032\0020\021H\026J\b\020\022\032\0020\tH\002R\020\020\b\032\004\030\0010\tX\016¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\026\020\005\032\n\022\004\022\0028\000\030\0010\006X\016¢\006\002\n\000R\024\020\013\032\0028\0008VX\004¢\006\006\032\004\b\f\020\r¨\006\024"}, d2={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class SafePublicationLazyImpl<T>
  implements Lazy<T>, Serializable
{
  public static final Companion Companion = new Companion(null);
  private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
  private volatile Object _value;
  private final Object jdField_final;
  private volatile Function0<? extends T> initializer;
  
  public SafePublicationLazyImpl(Function0<? extends T> paramFunction0)
  {
    this.initializer = paramFunction0;
    this._value = UNINITIALIZED_VALUE.INSTANCE;
    this.jdField_final = UNINITIALIZED_VALUE.INSTANCE;
  }
  
  private final Object writeReplace()
  {
    return new InitializedLazyImpl(getValue());
  }
  
  public T getValue()
  {
    Object localObject = this._value;
    if (localObject != UNINITIALIZED_VALUE.INSTANCE) {
      return (T)localObject;
    }
    localObject = this.initializer;
    if (localObject != null)
    {
      localObject = ((Function0)localObject).invoke();
      if (valueUpdater.compareAndSet(this, UNINITIALIZED_VALUE.INSTANCE, localObject))
      {
        this.initializer = ((Function0)null);
        return (T)localObject;
      }
    }
    return (T)this._value;
  }
  
  public boolean isInitialized()
  {
    return this._value != UNINITIALIZED_VALUE.INSTANCE;
  }
  
  public String toString()
  {
    if (isInitialized()) {
      return String.valueOf(getValue());
    }
    return "Lazy value not initialized yet.";
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R^\020\003\032R\022\024\022\022\022\002\b\003 \006*\b\022\002\b\003\030\0010\0050\005\022\f\022\n \006*\004\030\0010\0010\001 \006*(\022\024\022\022\022\002\b\003 \006*\b\022\002\b\003\030\0010\0050\005\022\f\022\n \006*\004\030\0010\0010\001\030\0010\0040\004X\004¢\006\002\n\000¨\006\007"}, d2={"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\SafePublicationLazyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */