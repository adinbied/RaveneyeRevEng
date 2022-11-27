package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b!\030\0002\0020\001B\027\022\020\020\002\032\f\022\006\022\004\030\0010\004\030\0010\003¢\006\002\020\005R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\t¨\006\n"}, d2={"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class RestrictedContinuationImpl
  extends BaseContinuationImpl
{
  public RestrictedContinuationImpl(Continuation<Object> paramContinuation)
  {
    super(paramContinuation);
    if (paramContinuation != null)
    {
      int i;
      if (paramContinuation.getContext() == EmptyCoroutineContext.INSTANCE) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString()));
    }
  }
  
  public CoroutineContext getContext()
  {
    return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\RestrictedContinuationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */