package lecho.lib.hellocharts.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import lecho.lib.hellocharts.computator.ChartComputator;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;

public abstract class AbstractChartRenderer
  implements ChartRenderer
{
  public int DEFAULT_LABEL_MARGIN_DP = 4;
  protected Chart chart;
  protected ChartComputator computator;
  protected float density;
  protected Paint.FontMetricsInt fontMetrics = new Paint.FontMetricsInt();
  protected boolean isValueLabelBackgroundAuto;
  protected boolean isValueLabelBackgroundEnabled;
  protected boolean isViewportCalculationEnabled = true;
  protected Paint labelBackgroundPaint = new Paint();
  protected RectF labelBackgroundRect = new RectF();
  protected char[] labelBuffer = new char[64];
  protected int labelMargin;
  protected int labelOffset;
  protected Paint labelPaint = new Paint();
  protected float scaledDensity;
  protected SelectedValue selectedValue = new SelectedValue();
  
  public AbstractChartRenderer(Context paramContext, Chart paramChart)
  {
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.scaledDensity = paramContext.getResources().getDisplayMetrics().scaledDensity;
    this.chart = paramChart;
    this.computator = paramChart.getChartComputator();
    int i = ChartUtils.dp2px(this.density, this.DEFAULT_LABEL_MARGIN_DP);
    this.labelMargin = i;
    this.labelOffset = i;
    this.labelPaint.setAntiAlias(true);
    this.labelPaint.setStyle(Paint.Style.FILL);
    this.labelPaint.setTextAlign(Paint.Align.LEFT);
    this.labelPaint.setTypeface(Typeface.defaultFromStyle(1));
    this.labelPaint.setColor(-1);
    this.labelBackgroundPaint.setAntiAlias(true);
    this.labelBackgroundPaint.setStyle(Paint.Style.FILL);
  }
  
  public void clearTouch()
  {
    this.selectedValue.clear();
  }
  
  /* Error */
  protected void drawLabelTextAndBackground(android.graphics.Canvas arg1, char[] arg2, int arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Viewport getCurrentViewport()
  {
    return this.computator.getCurrentViewport();
  }
  
  public Viewport getMaximumViewport()
  {
    return this.computator.getMaximumViewport();
  }
  
  public SelectedValue getSelectedValue()
  {
    return this.selectedValue;
  }
  
  public boolean isTouched()
  {
    return this.selectedValue.isSet();
  }
  
  public boolean isViewportCalculationEnabled()
  {
    return this.isViewportCalculationEnabled;
  }
  
  /* Error */
  public void onChartDataChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resetRenderer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void selectValue(SelectedValue paramSelectedValue)
  {
    this.selectedValue.set(paramSelectedValue);
  }
  
  public void setCurrentViewport(Viewport paramViewport)
  {
    if (paramViewport != null) {
      this.computator.setCurrentViewport(paramViewport);
    }
  }
  
  public void setMaximumViewport(Viewport paramViewport)
  {
    if (paramViewport != null) {
      this.computator.setMaxViewport(paramViewport);
    }
  }
  
  public void setViewportCalculationEnabled(boolean paramBoolean)
  {
    this.isViewportCalculationEnabled = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\AbstractChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */