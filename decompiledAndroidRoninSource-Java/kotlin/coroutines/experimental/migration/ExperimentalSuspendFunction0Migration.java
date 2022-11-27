package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\006\b\002\030\000*\004\b\000\020\0012\026\022\n\022\b\022\004\022\002H\0010\003\022\006\022\004\030\0010\0040\002B!\022\032\020\005\032\026\022\n\022\b\022\004\022\0028\0000\006\022\006\022\004\030\0010\0040\002¢\006\002\020\007J\031\020\n\032\004\030\0010\0042\f\020\013\032\b\022\004\022\0028\0000\003H\002R%\020\005\032\026\022\n\022\b\022\004\022\0028\0000\006\022\006\022\004\030\0010\0040\002¢\006\b\n\000\032\004\b\b\020\t¨\006\f"}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction0Migration;", "R", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "function", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "getFunction", "()Lkotlin/jvm/functions/Function1;", "invoke", "continuation", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
final class ExperimentalSuspendFunction0Migration<R>
  implements Function1<kotlin.coroutines.experimental.Continuation<? super R>, Object>
{
  private final Function1<kotlin.coroutines.Continuation<? super R>, Object> function;
  
  public ExperimentalSuspendFunction0Migration(Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction1)
  {
    this.function = paramFunction1;
  }
  
  public final Function1<kotlin.coroutines.Continuation<? super R>, Object> getFunction()
  {
    return this.function;
  }
  
  public Object invoke(kotlin.coroutines.experimental.Continuation<? super R> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    return this.function.invoke(CoroutinesMigrationKt.toContinuation(paramContinuation));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\migration\ExperimentalSuspendFunction0Migration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */