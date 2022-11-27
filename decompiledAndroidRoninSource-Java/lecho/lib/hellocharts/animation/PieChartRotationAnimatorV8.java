package lecho.lib.hellocharts.animation;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartRotationAnimatorV8
  implements PieChartRotationAnimator
{
  private ChartAnimationListener animationListener = new DummyChartAnimationListener();
  final PieChartView chart;
  final long duration;
  final Handler handler;
  final Interpolator interpolator = new AccelerateDecelerateInterpolator();
  boolean isAnimationStarted = false;
  private final Runnable runnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  long start;
  private float startRotation = 0.0F;
  private float targetRotation = 0.0F;
  
  public PieChartRotationAnimatorV8(PieChartView paramPieChartView)
  {
    this(paramPieChartView, 200L);
  }
  
  public PieChartRotationAnimatorV8(PieChartView paramPieChartView, long paramLong)
  {
    this.chart = paramPieChartView;
    this.duration = paramLong;
    this.handler = new Handler();
  }
  
  /* Error */
  public void cancelAnimation()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isAnimationStarted()
  {
    return this.isAnimationStarted;
  }
  
  public void setChartAnimationListener(ChartAnimationListener paramChartAnimationListener)
  {
    if (paramChartAnimationListener == null)
    {
      this.animationListener = new DummyChartAnimationListener();
      return;
    }
    this.animationListener = paramChartAnimationListener;
  }
  
  /* Error */
  public void startAnimation(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\PieChartRotationAnimatorV8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */