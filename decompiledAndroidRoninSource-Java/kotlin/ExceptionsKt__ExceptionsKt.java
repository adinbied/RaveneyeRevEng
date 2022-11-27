package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\000\n\002\020\021\n\002\030\002\n\002\020\003\n\002\b\005\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\032\022\020\b\032\0020\t*\0020\0032\006\020\n\032\0020\003\032\r\020\013\032\0020\t*\0020\003H\b\032\025\020\013\032\0020\t*\0020\0032\006\020\f\032\0020\rH\b\032\025\020\013\032\0020\t*\0020\0032\006\020\016\032\0020\017H\b\"!\020\000\032\b\022\004\022\0020\0020\001*\0020\0038F¢\006\f\022\004\b\004\020\005\032\004\b\006\020\007¨\006\020"}, d2={"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "stackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/ExceptionsKt")
class ExceptionsKt__ExceptionsKt
{
  public static final void addSuppressed(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable1, "$this$addSuppressed");
    Intrinsics.checkParameterIsNotNull(paramThrowable2, "exception");
    PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(paramThrowable1, paramThrowable2);
  }
  
  public static final StackTraceElement[] getStackTrace(Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "$this$stackTrace");
    paramThrowable = paramThrowable.getStackTrace();
    if (paramThrowable == null) {
      Intrinsics.throwNpe();
    }
    return paramThrowable;
  }
  
  private static final void printStackTrace(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      paramThrowable.printStackTrace();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
  }
  
  private static final void printStackTrace(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    if (paramThrowable != null)
    {
      paramThrowable.printStackTrace(paramPrintStream);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
  }
  
  private static final void printStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    if (paramThrowable != null)
    {
      paramThrowable.printStackTrace(paramPrintWriter);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ExceptionsKt__ExceptionsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */