package lecho.lib.hellocharts.renderer;

import android.graphics.Canvas;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.model.Viewport;

public abstract interface ChartRenderer
{
  public abstract boolean checkTouch(float paramFloat1, float paramFloat2);
  
  public abstract void clearTouch();
  
  public abstract void draw(Canvas paramCanvas);
  
  public abstract void drawUnclipped(Canvas paramCanvas);
  
  public abstract Viewport getCurrentViewport();
  
  public abstract Viewport getMaximumViewport();
  
  public abstract SelectedValue getSelectedValue();
  
  public abstract boolean isTouched();
  
  public abstract boolean isViewportCalculationEnabled();
  
  public abstract void onChartDataChanged();
  
  public abstract void onChartSizeChanged();
  
  public abstract void onChartViewportChanged();
  
  public abstract void resetRenderer();
  
  public abstract void selectValue(SelectedValue paramSelectedValue);
  
  public abstract void setCurrentViewport(Viewport paramViewport);
  
  public abstract void setMaximumViewport(Viewport paramViewport);
  
  public abstract void setViewportCalculationEnabled(boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\ChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */