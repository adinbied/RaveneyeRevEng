package lecho.lib.hellocharts.gesture;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import lecho.lib.hellocharts.view.Chart;

public class PreviewChartTouchHandler
  extends ChartTouchHandler
{
  public PreviewChartTouchHandler(Context paramContext, Chart paramChart)
  {
    super(paramContext, paramChart);
    this.gestureDetector = new GestureDetector(paramContext, new PreviewChartGestureListener());
    this.scaleGestureDetector = new ScaleGestureDetector(paramContext, new ChartScaleGestureListener());
    this.isValueTouchEnabled = false;
    this.isValueSelectionEnabled = false;
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
  
  protected class PreviewChartGestureListener
    extends ChartTouchHandler.ChartGestureListener
  {
    protected PreviewChartGestureListener()
    {
      super();
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, -paramFloat1, -paramFloat2);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, -paramFloat1, -paramFloat2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\PreviewChartTouchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */