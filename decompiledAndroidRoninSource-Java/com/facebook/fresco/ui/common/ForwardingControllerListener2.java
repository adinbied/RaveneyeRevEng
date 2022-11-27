package com.facebook.fresco.ui.common;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class ForwardingControllerListener2<I>
  extends BaseControllerListener2<I>
{
  private static final String TAG = "FwdControllerListener2";
  private final List<ControllerListener2<I>> mListeners = new ArrayList(2);
  
  private void onException(String paramString, Throwable paramThrowable)
  {
    try
    {
      Log.e("FwdControllerListener2", paramString, paramThrowable);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void addListener(ControllerListener2<I> paramControllerListener2)
  {
    try
    {
      this.mListeners.add(paramControllerListener2);
      return;
    }
    finally
    {
      paramControllerListener2 = finally;
      throw paramControllerListener2;
    }
  }
  
  public void onFailure(String paramString, Throwable paramThrowable, ControllerListener2.Extras paramExtras)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        ControllerListener2 localControllerListener2 = (ControllerListener2)this.mListeners.get(i);
        if (localControllerListener2 != null) {
          localControllerListener2.onFailure(paramString, paramThrowable, paramExtras);
        }
      }
      catch (Exception localException)
      {
        onException("ForwardingControllerListener2 exception in onFailure", localException);
      }
      i += 1;
    }
  }
  
  public void onFinalImageSet(String paramString, @Nullable I paramI, ControllerListener2.Extras paramExtras)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        ControllerListener2 localControllerListener2 = (ControllerListener2)this.mListeners.get(i);
        if (localControllerListener2 != null) {
          localControllerListener2.onFinalImageSet(paramString, paramI, paramExtras);
        }
      }
      catch (Exception localException)
      {
        onException("ForwardingControllerListener2 exception in onFinalImageSet", localException);
      }
      i += 1;
    }
  }
  
  public void onRelease(String paramString, ControllerListener2.Extras paramExtras)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        ControllerListener2 localControllerListener2 = (ControllerListener2)this.mListeners.get(i);
        if (localControllerListener2 != null) {
          localControllerListener2.onRelease(paramString, paramExtras);
        }
      }
      catch (Exception localException)
      {
        onException("ForwardingControllerListener2 exception in onRelease", localException);
      }
      i += 1;
    }
  }
  
  public void onSubmit(String paramString, Object paramObject, ControllerListener2.Extras paramExtras)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        ControllerListener2 localControllerListener2 = (ControllerListener2)this.mListeners.get(i);
        if (localControllerListener2 != null) {
          localControllerListener2.onSubmit(paramString, paramObject, paramExtras);
        }
      }
      catch (Exception localException)
      {
        onException("ForwardingControllerListener2 exception in onSubmit", localException);
      }
      i += 1;
    }
  }
  
  public void removeAllListeners()
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
  
  public void removeListener(ControllerListener2<I> paramControllerListener2)
  {
    try
    {
      int i = this.mListeners.indexOf(paramControllerListener2);
      if (i != -1) {
        this.mListeners.set(i, null);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\fresc\\ui\common\ForwardingControllerListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */