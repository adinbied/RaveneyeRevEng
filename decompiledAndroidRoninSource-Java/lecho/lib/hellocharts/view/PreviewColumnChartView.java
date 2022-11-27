package lecho.lib.hellocharts.view;

import android.content.Context;
import android.util.AttributeSet;
import lecho.lib.hellocharts.computator.PreviewChartComputator;
import lecho.lib.hellocharts.gesture.PreviewChartTouchHandler;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.renderer.PreviewColumnChartRenderer;

public class PreviewColumnChartView
  extends ColumnChartView
{
  private static final String TAG = "ColumnChartView";
  protected PreviewColumnChartRenderer previewChartRenderer = new PreviewColumnChartRenderer(paramContext, this, this);
  
  public PreviewColumnChartView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PreviewColumnChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreviewColumnChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.chartComputator = new PreviewChartComputator();
    this.touchHandler = new PreviewChartTouchHandler(paramContext, this);
    setChartRenderer(this.previewChartRenderer);
    setColumnChartData(ColumnChartData.generateDummyData());
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public int getPreviewColor()
  {
    return this.previewChartRenderer.getPreviewColor();
  }
  
  /* Error */
  public void setPreviewColor(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\PreviewColumnChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */