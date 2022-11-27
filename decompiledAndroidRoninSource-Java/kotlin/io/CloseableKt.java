package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\000\n\002\020\002\n\002\030\002\n\000\n\002\020\003\n\002\b\004\n\002\030\002\n\002\b\003\032\030\020\000\032\0020\001*\004\030\0010\0022\b\020\003\032\004\030\0010\004H\001\032;\020\005\032\002H\006\"\n\b\000\020\007*\004\030\0010\002\"\004\b\001\020\006*\002H\0072\022\020\b\032\016\022\004\022\002H\007\022\004\022\002H\0060\tH\bø\001\000¢\006\002\020\013\002\b\n\006\b\021(\n0\001¨\006\f"}, d2={"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class CloseableKt
{
  public static final void closeFinally(Closeable paramCloseable, Throwable paramThrowable)
  {
    if (paramCloseable == null) {
      return;
    }
    if (paramThrowable == null)
    {
      paramCloseable.close();
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    finally
    {
      ExceptionsKt.addSuppressed(paramThrowable, paramCloseable);
    }
  }
  
  private static final <T extends Closeable, R> R use(T paramT, Function1<? super T, ? extends R> paramFunction1)
  {
    Throwable localThrowable1 = (Throwable)null;
    try
    {
      paramFunction1 = paramFunction1.invoke(paramT);
      InlineMarker.finallyStart(1);
      if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
        closeFinally(paramT, localThrowable1);
      } else if (paramT != null) {
        paramT.close();
      }
      InlineMarker.finallyEnd(1);
      return paramFunction1;
    }
    finally
    {
      try
      {
        throw localThrowable2;
      }
      finally
      {
        InlineMarker.finallyStart(1);
        if ((PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) || (paramT != null)) {}
        try
        {
          paramT.close();
        }
        finally {}
      }
    }
    InlineMarker.finallyEnd(1);
    throw paramFunction1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\CloseableKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */