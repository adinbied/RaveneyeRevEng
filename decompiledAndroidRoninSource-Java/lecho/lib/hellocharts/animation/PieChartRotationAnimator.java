package lecho.lib.hellocharts.animation;

public abstract interface PieChartRotationAnimator
{
  public static final int FAST_ANIMATION_DURATION = 200;
  
  public abstract void cancelAnimation();
  
  public abstract boolean isAnimationStarted();
  
  public abstract void setChartAnimationListener(ChartAnimationListener paramChartAnimationListener);
  
  public abstract void startAnimation(float paramFloat1, float paramFloat2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\PieChartRotationAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */