package uk.co.senab.photoview.scrollerproxy;

import android.content.Context;
import android.os.Build.VERSION;

public abstract class ScrollerProxy
{
  public static ScrollerProxy getScroller(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return new PreGingerScroller(paramContext);
    }
    if (Build.VERSION.SDK_INT < 14) {
      return new GingerScroller(paramContext);
    }
    return new IcsScroller(paramContext);
  }
  
  public abstract boolean computeScrollOffset();
  
  public abstract void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public abstract void forceFinished(boolean paramBoolean);
  
  public abstract int getCurrX();
  
  public abstract int getCurrY();
  
  public abstract boolean isFinished();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\scrollerproxy\ScrollerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */