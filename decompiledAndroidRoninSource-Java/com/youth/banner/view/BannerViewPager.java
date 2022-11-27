package com.youth.banner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class BannerViewPager
  extends ViewPager
{
  private boolean scrollable = true;
  
  public BannerViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public BannerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.scrollable = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\view\BannerViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */