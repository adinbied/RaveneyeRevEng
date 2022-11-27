package lecho.lib.hellocharts.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.Chart;

public class ChartViewportAnimatorV14
  implements ChartViewportAnimator, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private ChartAnimationListener animationListener = new DummyChartAnimationListener();
  private ValueAnimator animator;
  private final Chart chart;
  private Viewport newViewport = new Viewport();
  private Viewport startViewport = new Viewport();
  private Viewport targetViewport = new Viewport();
  
  public ChartViewportAnimatorV14(Chart paramChart)
  {
    this.chart = paramChart;
    paramChart = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator = paramChart;
    paramChart.addListener(this);
    this.animator.addUpdateListener(this);
    this.animator.setDuration(300L);
  }
  
  public void cancelAnimation()
  {
    this.animator.cancel();
  }
  
  public boolean isAnimationStarted()
  {
    return this.animator.isStarted();
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  /* Error */
  public void onAnimationEnd(Animator arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.animationListener.onAnimationStarted();
  }
  
  /* Error */
  public void onAnimationUpdate(ValueAnimator arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\ChartViewportAnimatorV14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */