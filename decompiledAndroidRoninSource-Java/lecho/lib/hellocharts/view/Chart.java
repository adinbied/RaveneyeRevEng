package lecho.lib.hellocharts.view;

import lecho.lib.hellocharts.animation.ChartAnimationListener;
import lecho.lib.hellocharts.computator.ChartComputator;
import lecho.lib.hellocharts.gesture.ChartTouchHandler;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ViewportChangeListener;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.renderer.AxesRenderer;
import lecho.lib.hellocharts.renderer.ChartRenderer;

public abstract interface Chart
{
  public abstract void animationDataFinished();
  
  public abstract void animationDataUpdate(float paramFloat);
  
  public abstract void callTouchListener();
  
  public abstract void cancelDataAnimation();
  
  public abstract AxesRenderer getAxesRenderer();
  
  public abstract ChartComputator getChartComputator();
  
  public abstract ChartData getChartData();
  
  public abstract ChartRenderer getChartRenderer();
  
  public abstract Viewport getCurrentViewport();
  
  public abstract float getMaxZoom();
  
  public abstract Viewport getMaximumViewport();
  
  public abstract SelectedValue getSelectedValue();
  
  public abstract ChartTouchHandler getTouchHandler();
  
  public abstract float getZoomLevel();
  
  public abstract ZoomType getZoomType();
  
  public abstract boolean isContainerScrollEnabled();
  
  public abstract boolean isInteractive();
  
  public abstract boolean isScrollEnabled();
  
  public abstract boolean isValueSelectionEnabled();
  
  public abstract boolean isValueTouchEnabled();
  
  public abstract boolean isViewportCalculationEnabled();
  
  public abstract boolean isZoomEnabled();
  
  public abstract void moveTo(float paramFloat1, float paramFloat2);
  
  public abstract void moveToWithAnimation(float paramFloat1, float paramFloat2);
  
  public abstract void resetViewports();
  
  public abstract void selectValue(SelectedValue paramSelectedValue);
  
  public abstract void setChartRenderer(ChartRenderer paramChartRenderer);
  
  public abstract void setContainerScrollEnabled(boolean paramBoolean, ContainerScrollType paramContainerScrollType);
  
  public abstract void setCurrentViewport(Viewport paramViewport);
  
  public abstract void setCurrentViewportWithAnimation(Viewport paramViewport);
  
  public abstract void setCurrentViewportWithAnimation(Viewport paramViewport, long paramLong);
  
  public abstract void setDataAnimationListener(ChartAnimationListener paramChartAnimationListener);
  
  public abstract void setInteractive(boolean paramBoolean);
  
  public abstract void setMaxZoom(float paramFloat);
  
  public abstract void setMaximumViewport(Viewport paramViewport);
  
  public abstract void setScrollEnabled(boolean paramBoolean);
  
  public abstract void setValueSelectionEnabled(boolean paramBoolean);
  
  public abstract void setValueTouchEnabled(boolean paramBoolean);
  
  public abstract void setViewportAnimationListener(ChartAnimationListener paramChartAnimationListener);
  
  public abstract void setViewportCalculationEnabled(boolean paramBoolean);
  
  public abstract void setViewportChangeListener(ViewportChangeListener paramViewportChangeListener);
  
  public abstract void setZoomEnabled(boolean paramBoolean);
  
  public abstract void setZoomLevel(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setZoomLevelWithAnimation(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setZoomType(ZoomType paramZoomType);
  
  public abstract void startDataAnimation();
  
  public abstract void startDataAnimation(long paramLong);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\Chart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */