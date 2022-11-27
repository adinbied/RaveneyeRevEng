package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\002\020\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\002\n\002\b\004\n\002\020\003\n\002\b\003\b&\030\0002\n\022\006\022\004\030\0010\0020\0012\n\022\006\022\004\030\0010\0020\003B\037\022\006\020\004\032\0020\005\022\020\020\006\032\f\022\006\022\004\030\0010\002\030\0010\003¢\006\002\020\007J$\020\022\032\b\022\004\022\0020\0230\0032\b\020\024\032\004\030\0010\0022\n\020\006\032\006\022\002\b\0030\003H\026J\032\020\022\032\b\022\004\022\0020\0230\0032\n\020\006\032\006\022\002\b\0030\003H\026J\036\020\025\032\004\030\0010\0022\b\020\026\032\004\030\0010\0022\b\020\027\032\004\030\0010\030H$J\022\020\031\032\0020\0232\b\020\024\032\004\030\0010\002H\026J\020\020\032\032\0020\0232\006\020\027\032\0020\030H\026R\020\020\b\032\004\030\0010\tX\004¢\006\002\n\000R\030\020\n\032\f\022\006\022\004\030\0010\002\030\0010\003X\016¢\006\002\n\000R\034\020\006\032\f\022\006\022\004\030\0010\002\030\0010\0038\004@\004X\016¢\006\002\n\000R\024\020\013\032\0020\t8VX\004¢\006\006\032\004\b\f\020\rR\031\020\016\032\n\022\006\022\004\030\0010\0020\0038F¢\006\006\032\004\b\017\020\020R\022\020\021\032\0020\0058\004@\004X\016¢\006\002\n\000¨\006\033"}, d2={"Lkotlin/coroutines/experimental/jvm/internal/CoroutineImpl;", "Lkotlin/jvm/internal/Lambda;", "", "Lkotlin/coroutines/experimental/Continuation;", "arity", "", "completion", "(ILkotlin/coroutines/experimental/Continuation;)V", "_context", "Lkotlin/coroutines/experimental/CoroutineContext;", "_facade", "context", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "facade", "getFacade", "()Lkotlin/coroutines/experimental/Continuation;", "label", "create", "", "value", "doResume", "data", "exception", "", "resume", "resumeWithException", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
public abstract class CoroutineImpl
  extends Lambda<Object>
  implements Continuation<Object>
{
  private final CoroutineContext _context;
  private Continuation<Object> _facade;
  protected Continuation<Object> completion;
  protected int label;
  
  public CoroutineImpl(int paramInt, Continuation<Object> paramContinuation)
  {
    super(paramInt);
    this.completion = paramContinuation;
    if (paramContinuation != null) {
      paramInt = 0;
    } else {
      paramInt = -1;
    }
    this.label = paramInt;
    paramContinuation = this.completion;
    if (paramContinuation != null) {
      paramContinuation = paramContinuation.getContext();
    } else {
      paramContinuation = null;
    }
    this._context = paramContinuation;
  }
  
  public Continuation<Unit> create(Object paramObject, Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new IllegalStateException("create(Any?;Continuation) has not been overridden"));
  }
  
  public Continuation<Unit> create(Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new IllegalStateException("create(Continuation) has not been overridden"));
  }
  
  protected abstract Object doResume(Object paramObject, Throwable paramThrowable);
  
  public CoroutineContext getContext()
  {
    CoroutineContext localCoroutineContext = this._context;
    if (localCoroutineContext == null) {
      Intrinsics.throwNpe();
    }
    return localCoroutineContext;
  }
  
  public final Continuation<Object> getFacade()
  {
    if (this._facade == null)
    {
      localObject = this._context;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this._facade = CoroutineIntrinsics.interceptContinuationIfNeeded((CoroutineContext)localObject, (Continuation)this);
    }
    Object localObject = this._facade;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return (Continuation<Object>)localObject;
  }
  
  public void resume(Object paramObject)
  {
    Continuation localContinuation = this.completion;
    if (localContinuation == null) {
      Intrinsics.throwNpe();
    }
    try
    {
      paramObject = doResume(paramObject, null);
      if (paramObject != IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        if (localContinuation != null)
        {
          localContinuation.resume(paramObject);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
      }
    }
    finally
    {
      localContinuation.resumeWithException((Throwable)paramObject);
    }
  }
  
  public void resumeWithException(Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    Continuation localContinuation = this.completion;
    if (localContinuation == null) {
      Intrinsics.throwNpe();
    }
    try
    {
      paramThrowable = doResume(null, paramThrowable);
      if (paramThrowable != IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        if (localContinuation != null) {
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
      }
    }
    finally
    {
      localContinuation.resumeWithException(paramThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\jvm\internal\CoroutineImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */