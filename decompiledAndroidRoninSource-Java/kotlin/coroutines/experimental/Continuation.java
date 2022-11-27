package kotlin.coroutines.experimental;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\000\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\004\n\002\020\003\n\000\bg\030\000*\006\b\000\020\001 \0002\0020\002J\025\020\007\032\0020\b2\006\020\t\032\0028\000H&¢\006\002\020\nJ\020\020\013\032\0020\b2\006\020\f\032\0020\rH&R\022\020\003\032\0020\004X¦\004¢\006\006\032\004\b\005\020\006¨\006\016"}, d2={"Lkotlin/coroutines/experimental/Continuation;", "T", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "", "value", "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
public abstract interface Continuation<T>
{
  public abstract CoroutineContext getContext();
  
  public abstract void resume(T paramT);
  
  public abstract void resumeWithException(Throwable paramThrowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\Continuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */