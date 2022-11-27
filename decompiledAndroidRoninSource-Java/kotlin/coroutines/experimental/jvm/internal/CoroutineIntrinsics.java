package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContext.Key;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\032*\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\006\020\003\032\0020\0042\f\020\005\032\b\022\004\022\002H\0020\001H\000\032 \020\006\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\f\020\005\032\b\022\004\022\002H\0020\001¨\006\007"}, d2={"interceptContinuationIfNeeded", "Lkotlin/coroutines/experimental/Continuation;", "T", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "continuation", "normalizeContinuation", "kotlin-stdlib-coroutines"}, k=2, mv={1, 1, 15})
public final class CoroutineIntrinsics
{
  public static final <T> Continuation<T> interceptContinuationIfNeeded(CoroutineContext paramCoroutineContext, Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    Object localObject = (ContinuationInterceptor)paramCoroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key);
    paramCoroutineContext = paramContinuation;
    if (localObject != null)
    {
      localObject = ((ContinuationInterceptor)localObject).interceptContinuation(paramContinuation);
      paramCoroutineContext = paramContinuation;
      if (localObject != null) {
        paramCoroutineContext = (CoroutineContext)localObject;
      }
    }
    return paramCoroutineContext;
  }
  
  public static final <T> Continuation<T> normalizeContinuation(Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    if (!(paramContinuation instanceof CoroutineImpl)) {
      localObject1 = null;
    } else {
      localObject1 = paramContinuation;
    }
    Object localObject2 = (CoroutineImpl)localObject1;
    Object localObject1 = paramContinuation;
    if (localObject2 != null)
    {
      localObject2 = ((CoroutineImpl)localObject2).getFacade();
      localObject1 = paramContinuation;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return (Continuation<T>)localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\jvm\internal\CoroutineIntrinsics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */