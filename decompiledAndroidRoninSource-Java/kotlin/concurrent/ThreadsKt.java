package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\b\n\000\n\002\030\002\n\002\020\002\n\002\b\002\n\002\020\000\n\002\030\002\n\002\b\003\032J\020\000\032\0020\0012\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\n\b\002\020\005\032\004\030\0010\0062\n\b\002\020\007\032\004\030\0010\b2\b\b\002\020\t\032\0020\n2\f\020\013\032\b\022\004\022\0020\r0\f\0320\020\016\032\002H\017\"\b\b\000\020\017*\0020\020*\b\022\004\022\002H\0170\0212\f\020\022\032\b\022\004\022\002H\0170\fH\b¢\006\002\020\023¨\006\024"}, d2={"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ThreadsKt
{
  private static final <T> T getOrSet(ThreadLocal<T> paramThreadLocal, Function0<? extends T> paramFunction0)
  {
    Object localObject = paramThreadLocal.get();
    if (localObject != null) {
      return (T)localObject;
    }
    paramFunction0 = paramFunction0.invoke();
    paramThreadLocal.set(paramFunction0);
    return paramFunction0;
  }
  
  public static final Thread thread(boolean paramBoolean1, boolean paramBoolean2, ClassLoader paramClassLoader, String paramString, int paramInt, Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new Thread()
    {
      public void run()
      {
        this.$block.invoke();
      }
    };
    if (paramBoolean2) {
      paramFunction0.setDaemon(true);
    }
    if (paramInt > 0) {
      paramFunction0.setPriority(paramInt);
    }
    if (paramString != null) {
      paramFunction0.setName(paramString);
    }
    if (paramClassLoader != null) {
      paramFunction0.setContextClassLoader(paramClassLoader);
    }
    if (paramBoolean1) {
      paramFunction0.start();
    }
    return (Thread)paramFunction0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\concurrent\ThreadsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */