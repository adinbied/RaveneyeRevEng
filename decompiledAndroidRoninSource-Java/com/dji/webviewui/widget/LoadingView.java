package com.dji.webviewui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import dji.thirdparty.afinal.http.HttpHandler;
import java.io.File;

public class LoadingView
  extends FrameLayout
{
  HttpHandler<File> downloadHandle = null;
  
  public LoadingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      paramView = this.downloadHandle;
      if (paramView != null) {
        paramView.cancel(true);
      }
    }
  }
  
  public void setDownloadHandel(HttpHandler<File> paramHttpHandler)
  {
    this.downloadHandle = paramHttpHandler;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\widget\LoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */