package lecho.lib.hellocharts.renderer;

import android.content.Context;
import android.graphics.Paint;
import lecho.lib.hellocharts.provider.ColumnChartDataProvider;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;

public class PreviewColumnChartRenderer
  extends ColumnChartRenderer
{
  private static final int DEFAULT_PREVIEW_STROKE_WIDTH_DP = 2;
  private static final int DEFAULT_PREVIEW_TRANSPARENCY = 64;
  private static final int FULL_ALPHA = 255;
  private Paint previewPaint;
  
  public PreviewColumnChartRenderer(Context paramContext, Chart paramChart, ColumnChartDataProvider paramColumnChartDataProvider)
  {
    super(paramContext, paramChart, paramColumnChartDataProvider);
    paramContext = new Paint();
    this.previewPaint = paramContext;
    paramContext.setAntiAlias(true);
    this.previewPaint.setColor(-3355444);
    this.previewPaint.setStrokeWidth(ChartUtils.dp2px(this.density, 2));
  }
  
  /* Error */
  public void drawUnclipped(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getPreviewColor()
  {
    return this.previewPaint.getColor();
  }
  
  public void setPreviewColor(int paramInt)
  {
    this.previewPaint.setColor(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\PreviewColumnChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */