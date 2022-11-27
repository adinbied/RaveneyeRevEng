package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class ForwardingControllerListener<INFO>
  implements ControllerListener<INFO>, OnDrawControllerListener<INFO>
{
  private static final String TAG = "FdingControllerListener";
  private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);
  
  public static <INFO> ForwardingControllerListener<INFO> create()
  {
    return new ForwardingControllerListener();
  }
  
  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener);
    return localForwardingControllerListener;
  }
  
  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener1);
    localForwardingControllerListener.addListener(paramControllerListener2);
    return localForwardingControllerListener;
  }
  
  private void onException(String paramString, Throwable paramThrowable)
  {
    try
    {
      Log.e("FdingControllerListener", paramString, paramThrowable);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void addListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      this.mListeners.add(paramControllerListener);
      return;
    }
    finally
    {
      paramControllerListener = finally;
      throw paramControllerListener;
    }
  }
  
  public void clearListeners()
  {
    try
    {
      this.mListeners.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onFailure(String paramString, Throwable paramThrowable)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (i < j)
      {
        try
        {
          ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
          if (localControllerListener != null) {
            localControllerListener.onFailure(paramString, paramThrowable);
          }
        }
        catch (Exception localException)
        {
          onException("InternalListener exception in onFailure", localException);
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void onFinalImageSet(String paramString, @Nullable INFO paramINFO, @Nullable Animatable paramAnimatable)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (i < j)
      {
        try
        {
          ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
          if (localControllerListener != null) {
            localControllerListener.onFinalImageSet(paramString, paramINFO, paramAnimatable);
          }
        }
        catch (Exception localException)
        {
          onException("InternalListener exception in onFinalImageSet", localException);
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void onImageDrawn(String paramString, INFO paramINFO, DimensionsInfo paramDimensionsInfo)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
        if ((localControllerListener instanceof OnDrawControllerListener)) {
          ((OnDrawControllerListener)localControllerListener).onImageDrawn(paramString, paramINFO, paramDimensionsInfo);
        }
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onImageDrawn", localException);
      }
      i += 1;
    }
  }
  
  public void onIntermediateImageFailed(String paramString, Throwable paramThrowable)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
        if (localControllerListener != null) {
          localControllerListener.onIntermediateImageFailed(paramString, paramThrowable);
        }
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onIntermediateImageFailed", localException);
      }
      i += 1;
    }
  }
  
  public void onIntermediateImageSet(String paramString, @Nullable INFO paramINFO)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
        if (localControllerListener != null) {
          localControllerListener.onIntermediateImageSet(paramString, paramINFO);
        }
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onIntermediateImageSet", localException);
      }
      i += 1;
    }
  }
  
  public void onRelease(String paramString)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (i < j)
      {
        try
        {
          ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
          if (localControllerListener != null) {
            localControllerListener.onRelease(paramString);
          }
        }
        catch (Exception localException)
        {
          onException("InternalListener exception in onRelease", localException);
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void onSubmit(String paramString, Object paramObject)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (i < j)
      {
        try
        {
          ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
          if (localControllerListener != null) {
            localControllerListener.onSubmit(paramString, paramObject);
          }
        }
        catch (Exception localException)
        {
          onException("InternalListener exception in onSubmit", localException);
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void removeListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      int i = this.mListeners.indexOf(paramControllerListener);
      if (i != -1) {
        this.mListeners.set(i, null);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\controller\ForwardingControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */