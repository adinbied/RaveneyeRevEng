package lecho.lib.hellocharts.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import lecho.lib.hellocharts.animation.ChartAnimationListener;
import lecho.lib.hellocharts.animation.ChartDataAnimator;
import lecho.lib.hellocharts.animation.ChartDataAnimatorV14;
import lecho.lib.hellocharts.animation.ChartDataAnimatorV8;
import lecho.lib.hellocharts.animation.ChartViewportAnimator;
import lecho.lib.hellocharts.animation.ChartViewportAnimatorV14;
import lecho.lib.hellocharts.animation.ChartViewportAnimatorV8;
import lecho.lib.hellocharts.computator.ChartComputator;
import lecho.lib.hellocharts.gesture.ChartTouchHandler;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ViewportChangeListener;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.renderer.AxesRenderer;
import lecho.lib.hellocharts.renderer.ChartRenderer;

public abstract class AbstractChartView
  extends View
  implements Chart
{
  protected AxesRenderer axesRenderer = new AxesRenderer(paramContext, this);
  protected ChartComputator chartComputator = new ChartComputator();
  protected ChartRenderer chartRenderer;
  protected ContainerScrollType containerScrollType;
  protected ChartDataAnimator dataAnimator;
  protected boolean isContainerScrollEnabled = false;
  protected boolean isInteractive = true;
  protected ChartTouchHandler touchHandler = new ChartTouchHandler(paramContext, this);
  protected ChartViewportAnimator viewportAnimator;
  
  public AbstractChartView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public AbstractChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbstractChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT < 14)
    {
      this.dataAnimator = new ChartDataAnimatorV8(this);
      this.viewportAnimator = new ChartViewportAnimatorV8(this);
      return;
    }
    this.viewportAnimator = new ChartViewportAnimatorV14(this);
    this.dataAnimator = new ChartDataAnimatorV14(this);
  }
  
  private Viewport computeScrollViewport(float paramFloat1, float paramFloat2)
  {
    return null;
  }
  
  private Viewport computeZoomViewport(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return null;
  }
  
  /* Error */
  public void animationDataFinished()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void animationDataUpdate(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public void cancelDataAnimation()
  {
    this.dataAnimator.cancelAnimation();
  }
  
  /* Error */
  public void computeScroll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public AxesRenderer getAxesRenderer()
  {
    return this.axesRenderer;
  }
  
  public ChartComputator getChartComputator()
  {
    return this.chartComputator;
  }
  
  public ChartRenderer getChartRenderer()
  {
    return this.chartRenderer;
  }
  
  public Viewport getCurrentViewport()
  {
    return null;
  }
  
  public float getMaxZoom()
  {
    return this.chartComputator.getMaxZoom();
  }
  
  public Viewport getMaximumViewport()
  {
    return this.chartRenderer.getMaximumViewport();
  }
  
  public SelectedValue getSelectedValue()
  {
    return this.chartRenderer.getSelectedValue();
  }
  
  public ChartTouchHandler getTouchHandler()
  {
    return this.touchHandler;
  }
  
  public float getZoomLevel()
  {
    return 0.0F;
  }
  
  public ZoomType getZoomType()
  {
    return this.touchHandler.getZoomType();
  }
  
  public boolean isContainerScrollEnabled()
  {
    return this.isContainerScrollEnabled;
  }
  
  public boolean isInteractive()
  {
    return this.isInteractive;
  }
  
  public boolean isScrollEnabled()
  {
    return this.touchHandler.isScrollEnabled();
  }
  
  public boolean isValueSelectionEnabled()
  {
    return this.touchHandler.isValueSelectionEnabled();
  }
  
  public boolean isValueTouchEnabled()
  {
    return this.touchHandler.isValueTouchEnabled();
  }
  
  public boolean isViewportCalculationEnabled()
  {
    return this.chartRenderer.isViewportCalculationEnabled();
  }
  
  public boolean isZoomEnabled()
  {
    return this.touchHandler.isZoomEnabled();
  }
  
  public void moveTo(float paramFloat1, float paramFloat2)
  {
    setCurrentViewport(computeScrollViewport(paramFloat1, paramFloat2));
  }
  
  public void moveToWithAnimation(float paramFloat1, float paramFloat2)
  {
    setCurrentViewportWithAnimation(computeScrollViewport(paramFloat1, paramFloat2));
  }
  
  /* Error */
  protected void onChartDataChange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDraw(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  /* Error */
  protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  protected void resetRendererAndTouchHandler()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resetViewports()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void selectValue(SelectedValue arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setChartRenderer(ChartRenderer paramChartRenderer)
  {
    this.chartRenderer = paramChartRenderer;
    resetRendererAndTouchHandler();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public void setContainerScrollEnabled(boolean paramBoolean, ContainerScrollType paramContainerScrollType)
  {
    this.isContainerScrollEnabled = paramBoolean;
    this.containerScrollType = paramContainerScrollType;
  }
  
  /* Error */
  public void setCurrentViewport(Viewport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCurrentViewportWithAnimation(Viewport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCurrentViewportWithAnimation(Viewport arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setDataAnimationListener(ChartAnimationListener paramChartAnimationListener)
  {
    this.dataAnimator.setChartAnimationListener(paramChartAnimationListener);
  }
  
  public void setInteractive(boolean paramBoolean)
  {
    this.isInteractive = paramBoolean;
  }
  
  /* Error */
  public void setMaxZoom(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMaximumViewport(Viewport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.touchHandler.setScrollEnabled(paramBoolean);
  }
  
  public void setValueSelectionEnabled(boolean paramBoolean)
  {
    this.touchHandler.setValueSelectionEnabled(paramBoolean);
  }
  
  public void setValueTouchEnabled(boolean paramBoolean)
  {
    this.touchHandler.setValueTouchEnabled(paramBoolean);
  }
  
  public void setViewportAnimationListener(ChartAnimationListener paramChartAnimationListener)
  {
    this.viewportAnimator.setChartAnimationListener(paramChartAnimationListener);
  }
  
  public void setViewportCalculationEnabled(boolean paramBoolean)
  {
    this.chartRenderer.setViewportCalculationEnabled(paramBoolean);
  }
  
  public void setViewportChangeListener(ViewportChangeListener paramViewportChangeListener)
  {
    this.chartComputator.setViewportChangeListener(paramViewportChangeListener);
  }
  
  public void setZoomEnabled(boolean paramBoolean)
  {
    this.touchHandler.setZoomEnabled(paramBoolean);
  }
  
  public void setZoomLevel(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    setCurrentViewport(computeZoomViewport(paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void setZoomLevelWithAnimation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    setCurrentViewportWithAnimation(computeZoomViewport(paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void setZoomType(ZoomType paramZoomType)
  {
    this.touchHandler.setZoomType(paramZoomType);
  }
  
  public void startDataAnimation()
  {
    this.dataAnimator.startAnimation(Long.MIN_VALUE);
  }
  
  public void startDataAnimation(long paramLong)
  {
    this.dataAnimator.startAnimation(paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\AbstractChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */