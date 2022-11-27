package lecho.lib.hellocharts.computator;

import lecho.lib.hellocharts.listener.ViewportChangeListener;
import lecho.lib.hellocharts.model.Viewport;

public class PreviewChartComputator
  extends ChartComputator
{
  public float computeRawX(float paramFloat)
  {
    return 0.0F;
  }
  
  public float computeRawY(float paramFloat)
  {
    return 0.0F;
  }
  
  public void constrainViewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super.constrainViewport(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.viewportChangeListener.onViewportChanged(this.currentViewport);
  }
  
  public Viewport getVisibleViewport()
  {
    return this.maxViewport;
  }
  
  public void setVisibleViewport(Viewport paramViewport)
  {
    setMaxViewport(paramViewport);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\computator\PreviewChartComputator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */