package lecho.lib.hellocharts.animation;

import lecho.lib.hellocharts.model.Viewport;

public abstract interface ChartViewportAnimator
{
  public static final int FAST_ANIMATION_DURATION = 300;
  
  public abstract void cancelAnimation();
  
  public abstract boolean isAnimationStarted();
  
  public abstract void setChartAnimationListener(ChartAnimationListener paramChartAnimationListener);
  
  public abstract void startAnimation(Viewport paramViewport1, Viewport paramViewport2);
  
  public abstract void startAnimation(Viewport paramViewport1, Viewport paramViewport2, long paramLong);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\ChartViewportAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */