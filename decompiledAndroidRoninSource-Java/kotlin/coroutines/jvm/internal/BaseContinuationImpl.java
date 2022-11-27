package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\030\002\n\002\020\000\n\002\030\002\n\002\030\002\n\002\b\b\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\016\n\000\b!\030\0002\n\022\006\022\004\030\0010\0020\0012\0020\0032\0020\004B\027\022\020\020\005\032\f\022\006\022\004\030\0010\002\030\0010\001¢\006\002\020\006J$\020\f\032\b\022\004\022\0020\r0\0012\b\020\016\032\004\030\0010\0022\n\020\005\032\006\022\002\b\0030\001H\026J\032\020\f\032\b\022\004\022\0020\r0\0012\n\020\005\032\006\022\002\b\0030\001H\026J\n\020\017\032\004\030\0010\020H\026J\"\020\021\032\004\030\0010\0022\016\020\022\032\n\022\006\022\004\030\0010\0020\023H$ø\001\000¢\006\002\020\024J\b\020\025\032\0020\rH\024J\036\020\026\032\0020\r2\016\020\022\032\n\022\006\022\004\030\0010\0020\023ø\001\000¢\006\002\020\027J\b\020\030\032\0020\031H\026R\026\020\007\032\004\030\0010\0038VX\004¢\006\006\032\004\b\b\020\tR\033\020\005\032\f\022\006\022\004\030\0010\002\030\0010\001¢\006\b\n\000\032\004\b\n\020\013\002\004\n\002\b\031¨\006\032"}, d2={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class BaseContinuationImpl
  implements Continuation<Object>, CoroutineStackFrame, Serializable
{
  private final Continuation<Object> completion;
  
  public BaseContinuationImpl(Continuation<Object> paramContinuation)
  {
    this.completion = paramContinuation;
  }
  
  public Continuation<Unit> create(Object paramObject, Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden"));
  }
  
  public Continuation<Unit> create(Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Continuation) has not been overridden"));
  }
  
  public CoroutineStackFrame getCallerFrame()
  {
    Continuation localContinuation2 = this.completion;
    Continuation localContinuation1 = localContinuation2;
    if (!(localContinuation2 instanceof CoroutineStackFrame)) {
      localContinuation1 = null;
    }
    return (CoroutineStackFrame)localContinuation1;
  }
  
  public final Continuation<Object> getCompletion()
  {
    return this.completion;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return DebugMetadataKt.getStackTraceElement(this);
  }
  
  protected abstract Object invokeSuspend(Object paramObject);
  
  protected void releaseIntercepted() {}
  
  public final void resumeWith(Object paramObject)
  {
    Continuation localContinuation;
    for (BaseContinuationImpl localBaseContinuationImpl = (BaseContinuationImpl)this;; localBaseContinuationImpl = (BaseContinuationImpl)localContinuation)
    {
      DebugProbesKt.probeCoroutineResumed((Continuation)localBaseContinuationImpl);
      localContinuation = localBaseContinuationImpl.completion;
      if (localContinuation == null) {
        Intrinsics.throwNpe();
      }
      try
      {
        paramObject = localBaseContinuationImpl.invokeSuspend(paramObject);
        if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
          return;
        }
        localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(paramObject);
      }
      finally
      {
        Result.Companion localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(ResultKt.createFailure((Throwable)paramObject));
      }
      localBaseContinuationImpl.releaseIntercepted();
      if (!(localContinuation instanceof BaseContinuationImpl)) {
        break;
      }
    }
    localContinuation.resumeWith(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Continuation at ");
    Object localObject = getStackTraceElement();
    if (localObject == null) {
      localObject = getClass().getName();
    }
    localStringBuilder.append((Serializable)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\BaseContinuationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */