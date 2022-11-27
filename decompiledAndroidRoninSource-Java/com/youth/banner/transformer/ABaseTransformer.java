package com.youth.banner.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager.PageTransformer;

public abstract class ABaseTransformer
  implements ViewPager.PageTransformer
{
  protected static final float min(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 < paramFloat2) {
      f = paramFloat2;
    }
    return f;
  }
  
  protected boolean hideOffscreenPages()
  {
    return true;
  }
  
  protected boolean isPagingEnabled()
  {
    return false;
  }
  
  protected void onPostTransform(View paramView, float paramFloat) {}
  
  /* Error */
  protected void onPreTransform(View arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void onTransform(View paramView, float paramFloat);
  
  public void transformPage(View paramView, float paramFloat)
  {
    onPreTransform(paramView, paramFloat);
    onTransform(paramView, paramFloat);
    onPostTransform(paramView, paramFloat);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\transformer\ABaseTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */