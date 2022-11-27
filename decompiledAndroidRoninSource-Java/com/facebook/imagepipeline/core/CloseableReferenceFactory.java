package com.facebook.imagepipeline.core;

import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.CloseableReference.LeakHandler;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.Nullable;

public class CloseableReferenceFactory
{
  private final CloseableReference.LeakHandler mLeakHandler;
  
  public CloseableReferenceFactory(final CloseableReferenceLeakTracker paramCloseableReferenceLeakTracker)
  {
    this.mLeakHandler = new CloseableReference.LeakHandler()
    {
      public void reportLeak(SharedReference<Object> paramAnonymousSharedReference, @Nullable Throwable paramAnonymousThrowable)
      {
        paramCloseableReferenceLeakTracker.trackCloseableReferenceLeak(paramAnonymousSharedReference, paramAnonymousThrowable);
        FLog.w("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(paramAnonymousSharedReference)), paramAnonymousSharedReference.get().getClass().getName(), CloseableReferenceFactory.getStackTraceString(paramAnonymousThrowable) });
      }
      
      public boolean requiresStacktrace()
      {
        return paramCloseableReferenceLeakTracker.isSet();
      }
    };
  }
  
  private static String getStackTraceString(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public <U extends Closeable> CloseableReference<U> create(U paramU)
  {
    return CloseableReference.of(paramU, this.mLeakHandler);
  }
  
  public <T> CloseableReference<T> create(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    return CloseableReference.of(paramT, paramResourceReleaser, this.mLeakHandler);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\CloseableReferenceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */