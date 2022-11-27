package lecho.lib.hellocharts.gesture;

import android.content.Context;
import android.graphics.Point;
import androidx.core.widget.ScrollerCompat;
import lecho.lib.hellocharts.computator.ChartComputator;
import lecho.lib.hellocharts.model.Viewport;

public class ChartScroller
{
  private ScrollerCompat scroller;
  private Viewport scrollerStartViewport = new Viewport();
  private Point surfaceSizeBuffer = new Point();
  
  public ChartScroller(Context paramContext)
  {
    this.scroller = ScrollerCompat.create(paramContext);
  }
  
  public boolean computeScrollOffset(ChartComputator paramChartComputator)
  {
    return false;
  }
  
  public boolean fling(int paramInt1, int paramInt2, ChartComputator paramChartComputator)
  {
    return false;
  }
  
  public boolean scroll(ChartComputator paramChartComputator, float paramFloat1, float paramFloat2, ScrollResult paramScrollResult)
  {
    return false;
  }
  
  public boolean startScroll(ChartComputator paramChartComputator)
  {
    return false;
  }
  
  public static class ScrollResult
  {
    public boolean canScrollX;
    public boolean canScrollY;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\ChartScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */