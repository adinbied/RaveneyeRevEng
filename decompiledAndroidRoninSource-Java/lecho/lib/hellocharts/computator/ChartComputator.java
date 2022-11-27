package lecho.lib.hellocharts.computator;

import android.graphics.PointF;
import android.graphics.Rect;
import lecho.lib.hellocharts.listener.DummyVieportChangeListener;
import lecho.lib.hellocharts.listener.ViewportChangeListener;
import lecho.lib.hellocharts.model.Viewport;

public class ChartComputator
{
  protected static final float DEFAULT_MAXIMUM_ZOOM = 20.0F;
  protected int chartHeight;
  protected int chartWidth;
  protected Rect contentRectMinusAllMargins = new Rect();
  protected Rect contentRectMinusAxesMargins = new Rect();
  protected Viewport currentViewport = new Viewport();
  protected Rect maxContentRect = new Rect();
  protected Viewport maxViewport = new Viewport();
  protected float maxZoom = 20.0F;
  protected float minViewportHeight;
  protected float minViewportWidth;
  protected ViewportChangeListener viewportChangeListener = new DummyVieportChangeListener();
  
  /* Error */
  private void computeMinimumWidthAndHeight()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float computeRawDistanceX(float paramFloat)
  {
    return 0.0F;
  }
  
  public float computeRawDistanceY(float paramFloat)
  {
    return 0.0F;
  }
  
  public float computeRawX(float paramFloat)
  {
    return 0.0F;
  }
  
  public float computeRawY(float paramFloat)
  {
    return 0.0F;
  }
  
  /* Error */
  public void computeScrollSurfaceSize(android.graphics.Point arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void constrainViewport(float arg1, float arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  public int getChartHeight()
  {
    return this.chartHeight;
  }
  
  public int getChartWidth()
  {
    return this.chartWidth;
  }
  
  public Rect getContentRectMinusAllMargins()
  {
    return this.contentRectMinusAllMargins;
  }
  
  public Rect getContentRectMinusAxesMargins()
  {
    return this.contentRectMinusAxesMargins;
  }
  
  public Viewport getCurrentViewport()
  {
    return this.currentViewport;
  }
  
  public float getMaxZoom()
  {
    return this.maxZoom;
  }
  
  public Viewport getMaximumViewport()
  {
    return this.maxViewport;
  }
  
  public float getMinimumViewportHeight()
  {
    return this.minViewportHeight;
  }
  
  public float getMinimumViewportWidth()
  {
    return this.minViewportWidth;
  }
  
  public Viewport getVisibleViewport()
  {
    return this.currentViewport;
  }
  
  /* Error */
  public void insetContentRect(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void insetContentRectByInternalMargins(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  public boolean isWithinContentRect(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return false;
  }
  
  public boolean rawPixelsToDataPoint(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    return false;
  }
  
  /* Error */
  public void resetContentRect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setContentRect(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  public void setCurrentViewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    constrainViewport(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
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
  public void setMaxViewport(float arg1, float arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void setMaxViewport(Viewport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMaxZoom(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setViewportChangeListener(ViewportChangeListener paramViewportChangeListener)
  {
    if (paramViewportChangeListener == null)
    {
      this.viewportChangeListener = new DummyVieportChangeListener();
      return;
    }
    this.viewportChangeListener = paramViewportChangeListener;
  }
  
  /* Error */
  public void setViewportTopLeft(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setVisibleViewport(Viewport paramViewport)
  {
    setCurrentViewport(paramViewport);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\computator\ChartComputator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */