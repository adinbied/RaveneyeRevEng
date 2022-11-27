package lecho.lib.hellocharts.gesture;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.ViewParent;
import lecho.lib.hellocharts.computator.ChartComputator;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.renderer.ChartRenderer;
import lecho.lib.hellocharts.view.Chart;

public class ChartTouchHandler
{
  protected Chart chart;
  protected ChartScroller chartScroller;
  protected ChartZoomer chartZoomer;
  protected ChartComputator computator;
  protected ContainerScrollType containerScrollType;
  protected GestureDetector gestureDetector;
  protected boolean isScrollEnabled = true;
  protected boolean isValueSelectionEnabled = false;
  protected boolean isValueTouchEnabled = true;
  protected boolean isZoomEnabled = true;
  protected SelectedValue oldSelectedValue = new SelectedValue();
  protected ChartRenderer renderer;
  protected ScaleGestureDetector scaleGestureDetector;
  protected SelectedValue selectedValue = new SelectedValue();
  protected SelectedValue selectionModeOldValue = new SelectedValue();
  protected ViewParent viewParent;
  
  public ChartTouchHandler(Context paramContext, Chart paramChart)
  {
    this.chart = paramChart;
    this.computator = paramChart.getChartComputator();
    this.renderer = paramChart.getChartRenderer();
    this.gestureDetector = new GestureDetector(paramContext, new ChartGestureListener());
    this.scaleGestureDetector = new ScaleGestureDetector(paramContext, new ChartScaleGestureListener());
    this.chartScroller = new ChartScroller(paramContext);
    this.chartZoomer = new ChartZoomer(paramContext, ZoomType.HORIZONTAL_AND_VERTICAL);
  }
  
  /* Error */
  private void allowParentInterceptTouchEvent(ChartScroller.ScrollResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean checkTouch(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  private boolean computeTouch(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  private void disallowParentInterceptTouchEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean computeScroll()
  {
    return false;
  }
  
  public ZoomType getZoomType()
  {
    return this.chartZoomer.getZoomType();
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent, ViewParent paramViewParent, ContainerScrollType paramContainerScrollType)
  {
    this.viewParent = paramViewParent;
    this.containerScrollType = paramContainerScrollType;
    return handleTouchEvent(paramMotionEvent);
  }
  
  public boolean isScrollEnabled()
  {
    return this.isScrollEnabled;
  }
  
  public boolean isValueSelectionEnabled()
  {
    return this.isValueSelectionEnabled;
  }
  
  public boolean isValueTouchEnabled()
  {
    return this.isValueTouchEnabled;
  }
  
  public boolean isZoomEnabled()
  {
    return this.isZoomEnabled;
  }
  
  /* Error */
  public void resetTouchHandler()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.isScrollEnabled = paramBoolean;
  }
  
  public void setValueSelectionEnabled(boolean paramBoolean)
  {
    this.isValueSelectionEnabled = paramBoolean;
  }
  
  public void setValueTouchEnabled(boolean paramBoolean)
  {
    this.isValueTouchEnabled = paramBoolean;
  }
  
  public void setZoomEnabled(boolean paramBoolean)
  {
    this.isZoomEnabled = paramBoolean;
  }
  
  public void setZoomType(ZoomType paramZoomType)
  {
    this.chartZoomer.setZoomType(paramZoomType);
  }
  
  protected class ChartGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    protected ChartScroller.ScrollResult scrollResult = new ChartScroller.ScrollResult();
    
    protected ChartGestureListener() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (ChartTouchHandler.this.isScrollEnabled) {
        return ChartTouchHandler.this.chartScroller.fling((int)-paramFloat1, (int)-paramFloat2, ChartTouchHandler.this.computator);
      }
      return false;
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
  }
  
  protected class ChartScaleGestureListener
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    protected ChartScaleGestureListener() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\ChartTouchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */