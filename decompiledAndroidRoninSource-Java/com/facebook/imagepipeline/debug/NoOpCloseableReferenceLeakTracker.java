package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import javax.annotation.Nullable;

public class NoOpCloseableReferenceLeakTracker
  implements CloseableReferenceLeakTracker
{
  public boolean isSet()
  {
    return false;
  }
  
  public void setListener(@Nullable CloseableReferenceLeakTracker.Listener paramListener) {}
  
  public void trackCloseableReferenceLeak(SharedReference<Object> paramSharedReference, @Nullable Throwable paramThrowable) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\debug\NoOpCloseableReferenceLeakTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */