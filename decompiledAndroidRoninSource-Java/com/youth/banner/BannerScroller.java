package com.youth.banner;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class BannerScroller
  extends Scroller
{
  private int mDuration = 800;
  
  public BannerScroller(Context paramContext)
  {
    super(paramContext);
  }
  
  public BannerScroller(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public BannerScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    super(paramContext, paramInterpolator, paramBoolean);
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  /* Error */
  public void startScroll(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void startScroll(int arg1, int arg2, int arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\BannerScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */