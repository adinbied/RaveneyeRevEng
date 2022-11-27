package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\032\"\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\f\020\003\032\b\022\004\022\002H\0020\001H\001\032\024\020\004\032\0020\0052\n\020\006\032\006\022\002\b\0030\001H\001\032\024\020\007\032\0020\0052\n\020\006\032\006\022\002\b\0030\001H\001¨\006\b"}, d2={"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", "T", "completion", "probeCoroutineResumed", "", "frame", "probeCoroutineSuspended", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class DebugProbesKt
{
  public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return paramContinuation;
  }
  
  public static final void probeCoroutineResumed(Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "frame");
  }
  
  public static final void probeCoroutineSuspended(Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "frame");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\DebugProbesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */