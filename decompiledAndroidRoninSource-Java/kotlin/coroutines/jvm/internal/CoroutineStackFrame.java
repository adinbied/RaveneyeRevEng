package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\004\n\002\030\002\n\000\bg\030\0002\0020\001J\n\020\005\032\004\030\0010\006H&R\024\020\002\032\004\030\0010\000X¦\004¢\006\006\032\004\b\003\020\004¨\006\007"}, d2={"Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface CoroutineStackFrame
{
  public abstract CoroutineStackFrame getCallerFrame();
  
  public abstract StackTraceElement getStackTraceElement();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\CoroutineStackFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */