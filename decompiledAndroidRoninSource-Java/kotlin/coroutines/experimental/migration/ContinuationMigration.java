package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b\002\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B\023\022\f\020\003\032\b\022\004\022\0028\0000\004¢\006\002\020\005J\036\020\f\032\0020\r2\f\020\016\032\b\022\004\022\0028\0000\017H\026ø\001\000¢\006\002\020\020R\024\020\006\032\0020\007X\004¢\006\b\n\000\032\004\b\b\020\tR\027\020\003\032\b\022\004\022\0028\0000\004¢\006\b\n\000\032\004\b\n\020\013\002\004\n\002\b\031¨\006\021"}, d2={"Lkotlin/coroutines/experimental/migration/ContinuationMigration;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlin/coroutines/experimental/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContinuation", "()Lkotlin/coroutines/experimental/Continuation;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
final class ContinuationMigration<T>
  implements kotlin.coroutines.Continuation<T>
{
  private final CoroutineContext context;
  private final kotlin.coroutines.experimental.Continuation<T> continuation;
  
  public ContinuationMigration(kotlin.coroutines.experimental.Continuation<? super T> paramContinuation)
  {
    this.continuation = paramContinuation;
    this.context = CoroutinesMigrationKt.toCoroutineContext(paramContinuation.getContext());
  }
  
  public CoroutineContext getContext()
  {
    return this.context;
  }
  
  public final kotlin.coroutines.experimental.Continuation<T> getContinuation()
  {
    return this.continuation;
  }
  
  public void resumeWith(Object paramObject)
  {
    if (Result.isSuccess-impl(paramObject)) {
      this.continuation.resume(paramObject);
    }
    paramObject = Result.exceptionOrNull-impl(paramObject);
    if (paramObject != null) {
      this.continuation.resumeWithException((Throwable)paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\migration\ContinuationMigration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */