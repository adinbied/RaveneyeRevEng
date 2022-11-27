package lecho.lib.hellocharts.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import lecho.lib.hellocharts.computator.ChartComputator;
import lecho.lib.hellocharts.model.Viewport;

public class ChartZoomer
{
  public static final float ZOOM_AMOUNT = 0.25F;
  private Viewport scrollerStartViewport = new Viewport();
  private PointF viewportFocus = new PointF();
  private PointF zoomFocalPoint = new PointF();
  private ZoomType zoomType;
  private ZoomerCompat zoomer;
  
  public ChartZoomer(Context paramContext, ZoomType paramZoomType)
  {
    this.zoomer = new ZoomerCompat(paramContext);
    this.zoomType = paramZoomType;
  }
  
  /* Error */
  private void setCurrentViewport(ChartComputator arg1, float arg2, float arg3, float arg4, float arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean computeZoom(ChartComputator paramChartComputator)
  {
    return false;
  }
  
  public ZoomType getZoomType()
  {
    return this.zoomType;
  }
  
  public boolean scale(ChartComputator paramChartComputator, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return false;
  }
  
  public void setZoomType(ZoomType paramZoomType)
  {
    this.zoomType = paramZoomType;
  }
  
  public boolean startZoom(MotionEvent paramMotionEvent, ChartComputator paramChartComputator)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\ChartZoomer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */