package lecho.lib.hellocharts.animation;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.Chart;

public class ChartViewportAnimatorV8
  implements ChartViewportAnimator
{
  private ChartAnimationListener animationListener = new DummyChartAnimationListener();
  final Chart chart;
  private long duration;
  final Handler handler;
  final Interpolator interpolator = new AccelerateDecelerateInterpolator();
  boolean isAnimationStarted = false;
  private Viewport newViewport = new Viewport();
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
  private Viewport startViewport = new Viewport();
  private Viewport targetViewport = new Viewport();
  
  public ChartViewportAnimatorV8(Chart paramChart)
  {
    this.chart = paramChart;
    this.duration = 300L;
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
  public void startAnimation(Viewport arg1, Viewport arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startAnimation(Viewport arg1, Viewport arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\ChartViewportAnimatorV8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */