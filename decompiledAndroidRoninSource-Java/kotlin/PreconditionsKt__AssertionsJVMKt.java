package kotlin;

import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={"\000\030\n\000\n\002\020\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\020\000\n\000\032\021\020\000\032\0020\0012\006\020\002\032\0020\003H\b\032\037\020\000\032\0020\0012\006\020\002\032\0020\0032\f\020\004\032\b\022\004\022\0020\0060\005H\b¨\006\007"}, d2={"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/PreconditionsKt")
class PreconditionsKt__AssertionsJVMKt
{
  private static final void jdMethod_assert(boolean paramBoolean)
  {
    if (_Assertions.ENABLED)
    {
      if (paramBoolean) {
        return;
      }
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
  }
  
  private static final void jdMethod_assert(boolean paramBoolean, Function0<? extends Object> paramFunction0)
  {
    if (_Assertions.ENABLED)
    {
      if (paramBoolean) {
        return;
      }
      throw ((Throwable)new AssertionError(paramFunction0.invoke()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\PreconditionsKt__AssertionsJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */