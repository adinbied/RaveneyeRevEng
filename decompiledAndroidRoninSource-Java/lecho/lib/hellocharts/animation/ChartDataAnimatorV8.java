package lecho.lib.hellocharts.animation;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import lecho.lib.hellocharts.view.Chart;

public class ChartDataAnimatorV8
  implements ChartDataAnimator
{
  private ChartAnimationListener animationListener = new DummyChartAnimationListener();
  final Chart chart;
  long duration;
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
  
  public ChartDataAnimatorV8(Chart paramChart)
  {
    this.chart = paramChart;
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
  public void startAnimation(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\ChartDataAnimatorV8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */