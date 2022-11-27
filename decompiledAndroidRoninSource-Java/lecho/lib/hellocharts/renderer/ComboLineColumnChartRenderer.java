package lecho.lib.hellocharts.renderer;

import android.content.Context;
import java.util.List;
import lecho.lib.hellocharts.provider.ColumnChartDataProvider;
import lecho.lib.hellocharts.provider.LineChartDataProvider;
import lecho.lib.hellocharts.view.Chart;

public class ComboLineColumnChartRenderer
  extends ComboChartRenderer
{
  private ColumnChartRenderer columnChartRenderer;
  private LineChartRenderer lineChartRenderer;
  
  public ComboLineColumnChartRenderer(Context paramContext, Chart paramChart, ColumnChartDataProvider paramColumnChartDataProvider, LineChartDataProvider paramLineChartDataProvider)
  {
    this(paramContext, paramChart, new ColumnChartRenderer(paramContext, paramChart, paramColumnChartDataProvider), new LineChartRenderer(paramContext, paramChart, paramLineChartDataProvider));
  }
  
  public ComboLineColumnChartRenderer(Context paramContext, Chart paramChart, ColumnChartDataProvider paramColumnChartDataProvider, LineChartRenderer paramLineChartRenderer)
  {
    this(paramContext, paramChart, new ColumnChartRenderer(paramContext, paramChart, paramColumnChartDataProvider), paramLineChartRenderer);
  }
  
  public ComboLineColumnChartRenderer(Context paramContext, Chart paramChart, ColumnChartRenderer paramColumnChartRenderer, LineChartDataProvider paramLineChartDataProvider)
  {
    this(paramContext, paramChart, paramColumnChartRenderer, new LineChartRenderer(paramContext, paramChart, paramLineChartDataProvider));
  }
  
  public ComboLineColumnChartRenderer(Context paramContext, Chart paramChart, ColumnChartRenderer paramColumnChartRenderer, LineChartRenderer paramLineChartRenderer)
  {
    super(paramContext, paramChart);
    this.columnChartRenderer = paramColumnChartRenderer;
    this.lineChartRenderer = paramLineChartRenderer;
    this.renderers.add(this.columnChartRenderer);
    this.renderers.add(this.lineChartRenderer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\ComboLineColumnChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */