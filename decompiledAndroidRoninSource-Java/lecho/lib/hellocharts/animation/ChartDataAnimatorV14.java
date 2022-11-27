package lecho.lib.hellocharts.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import lecho.lib.hellocharts.view.Chart;

public class ChartDataAnimatorV14
  implements ChartDataAnimator, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private ChartAnimationListener animationListener = new DummyChartAnimationListener();
  private ValueAnimator animator;
  private final Chart chart;
  
  public ChartDataAnimatorV14(Chart paramChart)
  {
    this.chart = paramChart;
    paramChart = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator = paramChart;
    paramChart.addListener(this);
    this.animator.addUpdateListener(this);
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
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.chart.animationDataFinished();
    this.animationListener.onAnimationFinished();
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
  public void startAnimation(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\animation\ChartDataAnimatorV14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */