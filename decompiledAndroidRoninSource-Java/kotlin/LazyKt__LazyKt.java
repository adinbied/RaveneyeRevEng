package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv={1, 0, 3}, d1={"\000\030\n\000\n\002\030\002\n\002\b\005\n\002\020\000\n\000\n\002\030\002\n\002\b\002\032\037\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\006\020\003\032\002H\002¢\006\002\020\004\0324\020\005\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0012\b\020\006\032\004\030\0010\0072\n\020\b\032\006\022\002\b\0030\tH\n¢\006\002\020\n¨\006\013"}, d2={"lazyOf", "Lkotlin/Lazy;", "T", "value", "(Ljava/lang/Object;)Lkotlin/Lazy;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/Lazy;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/LazyKt")
class LazyKt__LazyKt
  extends LazyKt__LazyJVMKt
{
  private static final <T> T getValue(Lazy<? extends T> paramLazy, Object paramObject, KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramLazy, "$this$getValue");
    return (T)paramLazy.getValue();
  }
  
  public static final <T> Lazy<T> lazyOf(T paramT)
  {
    return (Lazy)new InitializedLazyImpl(paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\LazyKt__LazyKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */