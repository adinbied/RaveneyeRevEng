package lecho.lib.hellocharts.animation;

public abstract interface ChartDataAnimator
{
  public static final long DEFAULT_ANIMATION_DURATION = 500L;
  
  public abstract void cancelAnimation();
  
  public abstract boolean isAnimationStarted();
  
  public abstract void setChartAnimationListener(ChartAnimationListener paramChartAnimationListener);
  
  public abstract void startAnimation(long paramLong);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\ChartDataAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */