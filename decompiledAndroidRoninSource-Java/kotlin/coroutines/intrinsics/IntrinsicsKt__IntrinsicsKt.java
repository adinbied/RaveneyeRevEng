package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"\000\026\n\000\n\002\020\000\n\002\b\007\n\002\030\002\n\002\030\002\n\002\b\002\0325\020\006\032\002H\007\"\004\b\000\020\0072\034\b\004\020\b\032\026\022\n\022\b\022\004\022\002H\0070\n\022\006\022\004\030\0010\0010\tHHø\001\000¢\006\002\020\013\"\032\020\000\032\0020\0018FX\004¢\006\f\022\004\b\002\020\003\032\004\b\004\020\005\002\004\n\002\b\031¨\006\f"}, d2={"COROUTINE_SUSPENDED", "", "COROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "suspendCoroutineUninterceptedOrReturn", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/coroutines/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsKt
  extends IntrinsicsKt__IntrinsicsJvmKt
{
  public static final Object getCOROUTINE_SUSPENDED()
  {
    return CoroutineSingletons.COROUTINE_SUSPENDED;
  }
  
  private static final <T> Object suspendCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    throw ((Throwable)new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic"));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\intrinsics\IntrinsicsKt__IntrinsicsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */