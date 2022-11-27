package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import javax.annotation.Nullable;

public abstract interface CloseableReferenceLeakTracker
{
  public abstract boolean isSet();
  
  public abstract void setListener(@Nullable Listener paramListener);
  
  public abstract void trackCloseableReferenceLeak(SharedReference<Object> paramSharedReference, @Nullable Throwable paramThrowable);
  
  public static abstract interface Listener
  {
    public abstract void onCloseableReferenceLeak(SharedReference<Object> paramSharedReference, @Nullable Throwable paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\debug\CloseableReferenceLeakTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */