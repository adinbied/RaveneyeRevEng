package kotlin.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\b\003\n\002\030\002\n\002\030\002\n\002\020\000\n\002\b\004\0325\020\000\032\002H\001\"\004\b\000\020\0012\034\b\004\020\002\032\026\022\n\022\b\022\004\022\002H\0010\004\022\006\022\004\030\0010\0050\003HHø\001\000¢\006\002\020\006\0325\020\007\032\002H\001\"\004\b\000\020\0012\034\b\004\020\002\032\026\022\n\022\b\022\004\022\002H\0010\004\022\006\022\004\030\0010\0050\003HHø\001\000¢\006\002\020\006\032\037\020\b\032\b\022\004\022\002H\0010\004\"\004\b\000\020\001*\b\022\004\022\002H\0010\004H\b\002\004\n\002\b\t¨\006\t"}, d2={"suspendCoroutineOrReturn", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "suspendCoroutineUninterceptedOrReturn", "intercepted", "kotlin-stdlib-coroutines"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/coroutines/experimental/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsKt
  extends IntrinsicsKt__IntrinsicsJvmKt
{
  private static final <T> Continuation<T> intercepted(Continuation<? super T> paramContinuation)
  {
    throw ((Throwable)new NotImplementedError("Implementation of intercepted is intrinsic"));
  }
  
  private static final <T> Object suspendCoroutineOrReturn(Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    InlineMarker.mark(0);
    paramFunction1 = paramFunction1.invoke(CoroutineIntrinsics.normalizeContinuation(paramContinuation));
    InlineMarker.mark(1);
    return paramFunction1;
  }
  
  private static final <T> Object suspendCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    throw ((Throwable)new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic"));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\intrinsics\IntrinsicsKt__IntrinsicsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */