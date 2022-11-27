package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\000\n\000\n\002\030\002\n\000\032 \020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\f\020\003\032\b\022\004\022\002H\0020\004\032*\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\b\020\005\032\004\030\0010\0062\f\020\003\032\b\022\004\022\002H\0020\004\032(\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\006\020\007\032\0020\b2\f\020\003\032\b\022\004\022\002H\0020\004¨\006\t"}, d2={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/LazyKt")
class LazyKt__LazyJVMKt
{
  public static final <T> Lazy<T> lazy(Object paramObject, Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "initializer");
    return (Lazy)new SynchronizedLazyImpl(paramFunction0, paramObject);
  }
  
  public static final <T> Lazy<T> lazy(LazyThreadSafetyMode paramLazyThreadSafetyMode, Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyThreadSafetyMode, "mode");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "initializer");
    int i = LazyKt.WhenMappings.$EnumSwitchMapping$0[paramLazyThreadSafetyMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return (Lazy)new UnsafeLazyImpl(paramFunction0);
        }
        throw new NoWhenBranchMatchedException();
      }
      return (Lazy)new SafePublicationLazyImpl(paramFunction0);
    }
    return (Lazy)new SynchronizedLazyImpl(paramFunction0, null, 2, null);
  }
  
  public static final <T> Lazy<T> lazy(Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "initializer");
    return (Lazy)new SynchronizedLazyImpl(paramFunction0, null, 2, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\LazyKt__LazyJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */