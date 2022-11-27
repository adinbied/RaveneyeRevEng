package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ForwardingImageOriginListener
  implements ImageOriginListener
{
  private static final String TAG = "ForwardingImageOriginListener";
  private final List<ImageOriginListener> mImageOriginListeners;
  
  public ForwardingImageOriginListener(Set<ImageOriginListener> paramSet)
  {
    this.mImageOriginListeners = new ArrayList(paramSet);
  }
  
  public ForwardingImageOriginListener(ImageOriginListener... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    this.mImageOriginListeners = localArrayList;
    Collections.addAll(localArrayList, paramVarArgs);
  }
  
  public void addImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      this.mImageOriginListeners.add(paramImageOriginListener);
      return;
    }
    finally
    {
      paramImageOriginListener = finally;
      throw paramImageOriginListener;
    }
  }
  
  public void onImageLoaded(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    try
    {
      int j = this.mImageOriginListeners.size();
      int i = 0;
      while (i < j)
      {
        ImageOriginListener localImageOriginListener = (ImageOriginListener)this.mImageOriginListeners.get(i);
        if (localImageOriginListener != null) {
          try
          {
            localImageOriginListener.onImageLoaded(paramString1, paramInt, paramBoolean, paramString2);
          }
          catch (Exception localException)
          {
            FLog.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", localException);
          }
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void removeImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      this.mImageOriginListeners.remove(paramImageOriginListener);
      return;
    }
    finally
    {
      paramImageOriginListener = finally;
      throw paramImageOriginListener;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ForwardingImageOriginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */