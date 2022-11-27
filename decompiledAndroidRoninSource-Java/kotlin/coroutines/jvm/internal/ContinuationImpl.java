package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\002\n\000\b!\030\0002\0020\001B\031\b\026\022\020\020\002\032\f\022\006\022\004\030\0010\004\030\0010\003¢\006\002\020\005B!\022\020\020\002\032\f\022\006\022\004\030\0010\004\030\0010\003\022\b\020\006\032\004\030\0010\007¢\006\002\020\bJ\016\020\f\032\n\022\006\022\004\030\0010\0040\003J\b\020\r\032\0020\016H\024R\020\020\006\032\004\030\0010\007X\004¢\006\002\n\000R\024\020\t\032\0020\0078VX\004¢\006\006\032\004\b\n\020\013R\030\020\f\032\f\022\006\022\004\030\0010\004\030\0010\003X\016¢\006\002\n\000¨\006\017"}, d2={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class ContinuationImpl
  extends BaseContinuationImpl
{
  private final CoroutineContext _context;
  private transient Continuation<Object> intercepted;
  
  public ContinuationImpl(Continuation<Object> paramContinuation)
  {
    this(paramContinuation, localCoroutineContext);
  }
  
  public ContinuationImpl(Continuation<Object> paramContinuation, CoroutineContext paramCoroutineContext)
  {
    super(paramContinuation);
    this._context = paramCoroutineContext;
  }
  
  public CoroutineContext getContext()
  {
    CoroutineContext localCoroutineContext = this._context;
    if (localCoroutineContext == null) {
      Intrinsics.throwNpe();
    }
    return localCoroutineContext;
  }
  
  public final Continuation<Object> intercepted()
  {
    Object localObject = this.intercepted;
    if (localObject != null) {
      return (Continuation<Object>)localObject;
    }
    localObject = (ContinuationInterceptor)getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
    if (localObject != null)
    {
      localObject = ((ContinuationInterceptor)localObject).interceptContinuation((Continuation)this);
      if (localObject != null) {}
    }
    else
    {
      localObject = (Continuation)this;
    }
    this.intercepted = ((Continuation)localObject);
    return (Continuation<Object>)localObject;
  }
  
  protected void releaseIntercepted()
  {
    Continuation localContinuation = this.intercepted;
    if ((localContinuation != null) && (localContinuation != (ContinuationImpl)this))
    {
      CoroutineContext.Element localElement = getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
      if (localElement == null) {
        Intrinsics.throwNpe();
      }
      ((ContinuationInterceptor)localElement).releaseInterceptedContinuation(localContinuation);
    }
    this.intercepted = ((Continuation)CompletedContinuation.INSTANCE);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\ContinuationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */