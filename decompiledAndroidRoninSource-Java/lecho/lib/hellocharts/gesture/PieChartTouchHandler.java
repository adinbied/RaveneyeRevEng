package lecho.lib.hellocharts.gesture;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import androidx.core.widget.ScrollerCompat;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartTouchHandler
  extends ChartTouchHandler
{
  public static final int FLING_VELOCITY_DOWNSCALE = 4;
  private boolean isRotationEnabled = true;
  protected PieChartView pieChart;
  protected ScrollerCompat scroller;
  
  public PieChartTouchHandler(Context paramContext, PieChartView paramPieChartView)
  {
    super(paramContext, paramPieChartView);
    this.pieChart = paramPieChartView;
    this.scroller = ScrollerCompat.create(paramContext);
    this.gestureDetector = new GestureDetector(paramContext, new ChartGestureListener(null));
    this.scaleGestureDetector = new ScaleGestureDetector(paramContext, new ChartScaleGestureListener(null));
    this.isZoomEnabled = false;
  }
  
  public boolean computeScroll()
  {
    return false;
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean isRotationEnabled()
  {
    return this.isRotationEnabled;
  }
  
  public void setRotationEnabled(boolean paramBoolean)
  {
    this.isRotationEnabled = paramBoolean;
  }
  
  private class ChartGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private ChartGestureListener() {}
    
    private float vectorToScalarScroll(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return 0.0F;
    }
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      if (PieChartTouchHandler.this.isRotationEnabled)
      {
        PieChartTouchHandler.this.scroller.abortAnimation();
        return true;
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
  }
  
  private class ChartScaleGestureListener
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private ChartScaleGestureListener() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\PieChartTouchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */