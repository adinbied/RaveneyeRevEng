package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\bÀ\002\030\0002\n\022\006\022\004\030\0010\0020\001B\007\b\002¢\006\002\020\003J \020\b\032\0020\t2\016\020\n\032\n\022\006\022\004\030\0010\0020\013H\026ø\001\000¢\006\002\020\fJ\b\020\r\032\0020\016H\026R\024\020\004\032\0020\0058VX\004¢\006\006\032\004\b\006\020\007\002\004\n\002\b\031¨\006\017"}, d2={"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class CompletedContinuation
  implements Continuation<Object>
{
  public static final CompletedContinuation INSTANCE = new CompletedContinuation();
  
  public CoroutineContext getContext()
  {
    throw ((Throwable)new IllegalStateException("This continuation is already complete".toString()));
  }
  
  public void resumeWith(Object paramObject)
  {
    throw ((Throwable)new IllegalStateException("This continuation is already complete".toString()));
  }
  
  public String toString()
  {
    return "This continuation is already complete";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\CompletedContinuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */