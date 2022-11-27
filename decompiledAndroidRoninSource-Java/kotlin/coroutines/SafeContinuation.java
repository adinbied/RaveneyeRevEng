package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result.Failure;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(bv={1, 0, 3}, d1={"\000<\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\000\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\b\001\030\000 \032*\006\b\000\020\001 \0002\b\022\004\022\002H\0010\0022\0020\003:\001\032B\025\b\021\022\f\020\004\032\b\022\004\022\0028\0000\002¢\006\002\020\005B\037\b\000\022\f\020\004\032\b\022\004\022\0028\0000\002\022\b\020\006\032\004\030\0010\007¢\006\002\020\bJ\n\020\021\032\004\030\0010\007H\001J\n\020\022\032\004\030\0010\023H\026J\036\020\024\032\0020\0252\f\020\020\032\b\022\004\022\0028\0000\026H\026ø\001\000¢\006\002\020\027J\b\020\030\032\0020\031H\026R\026\020\t\032\004\030\0010\0038VX\004¢\006\006\032\004\b\n\020\013R\024\020\f\032\0020\r8VX\004¢\006\006\032\004\b\016\020\017R\024\020\004\032\b\022\004\022\0028\0000\002X\004¢\006\002\n\000R\020\020\020\032\004\030\0010\007X\016¢\006\002\n\000\002\004\n\002\b\031¨\006\033"}, d2={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class SafeContinuation<T>
  implements Continuation<T>, CoroutineStackFrame
{
  @Deprecated
  public static final Companion Companion = new Companion(null);
  private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
  private final Continuation<T> delegate;
  private volatile Object result;
  
  public SafeContinuation(Continuation<? super T> paramContinuation)
  {
    this(paramContinuation, CoroutineSingletons.UNDECIDED);
  }
  
  public SafeContinuation(Continuation<? super T> paramContinuation, Object paramObject)
  {
    this.delegate = paramContinuation;
    this.result = paramObject;
  }
  
  public CoroutineStackFrame getCallerFrame()
  {
    Continuation localContinuation2 = this.delegate;
    Continuation localContinuation1 = localContinuation2;
    if (!(localContinuation2 instanceof CoroutineStackFrame)) {
      localContinuation1 = null;
    }
    return (CoroutineStackFrame)localContinuation1;
  }
  
  public CoroutineContext getContext()
  {
    return this.delegate.getContext();
  }
  
  public final Object getOrThrow()
  {
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == CoroutineSingletons.UNDECIDED)
    {
      if (RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      localObject1 = this.result;
    }
    if (localObject1 == CoroutineSingletons.RESUMED) {
      return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
    if (!(localObject1 instanceof Result.Failure)) {
      return localObject1;
    }
    throw ((Result.Failure)localObject1).exception;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public void resumeWith(Object paramObject)
  {
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != CoroutineSingletons.UNDECIDED) {
          break;
        }
      } while (!RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, paramObject));
      return;
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        break;
      }
    } while (!RESULT.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED));
    this.delegate.resumeWith(paramObject);
    return;
    throw ((Throwable)new IllegalStateException("Already resumed"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SafeContinuation for ");
    localStringBuilder.append(this.delegate);
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002RZ\020\003\032F\022\024\022\022\022\002\b\003 \006*\b\022\002\b\003\030\0010\0050\005\022\006\022\004\030\0010\001 \006*\"\022\024\022\022\022\002\b\003 \006*\b\022\002\b\003\030\0010\0050\005\022\006\022\004\030\0010\001\030\0010\0040\0048\002X\004¢\006\b\n\000\022\004\b\007\020\002¨\006\b"}, d2={"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT$annotations", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  private static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\SafeContinuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */