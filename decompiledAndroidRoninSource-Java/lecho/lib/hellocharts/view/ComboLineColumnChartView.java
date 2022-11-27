package lecho.lib.hellocharts.view;

import android.content.Context;
import android.util.AttributeSet;
import lecho.lib.hellocharts.listener.ComboLineColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.listener.DummyCompoLineColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.ComboLineColumnChartData;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.provider.ColumnChartDataProvider;
import lecho.lib.hellocharts.provider.ComboLineColumnChartDataProvider;
import lecho.lib.hellocharts.provider.LineChartDataProvider;
import lecho.lib.hellocharts.renderer.ComboLineColumnChartRenderer;

public class ComboLineColumnChartView
  extends AbstractChartView
  implements ComboLineColumnChartDataProvider
{
  private static final String TAG = "ComboLineColumnChartView";
  protected ColumnChartDataProvider columnChartDataProvider = new ComboColumnChartDataProvider(null);
  protected ComboLineColumnChartData data;
  protected LineChartDataProvider lineChartDataProvider = new ComboLineChartDataProvider(null);
  protected ComboLineColumnChartOnValueSelectListener onValueTouchListener = new DummyCompoLineColumnChartOnValueSelectListener();
  
  public ComboLineColumnChartView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ComboLineColumnChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ComboLineColumnChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setChartRenderer(new ComboLineColumnChartRenderer(paramContext, this, this.columnChartDataProvider, this.lineChartDataProvider));
    setComboLineColumnChartData(ComboLineColumnChartData.generateDummyData());
  }
  
  /* Error */
  public void callTouchListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ChartData getChartData()
  {
    return this.data;
  }
  
  public ComboLineColumnChartData getComboLineColumnChartData()
  {
    return this.data;
  }
  
  public ComboLineColumnChartOnValueSelectListener getOnValueTouchListener()
  {
    return this.onValueTouchListener;
  }
  
  /* Error */
  public void setColumnChartRenderer(Context arg1, lecho.lib.hellocharts.renderer.ColumnChartRenderer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setComboLineColumnChartData(ComboLineColumnChartData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setLineChartRenderer(Context arg1, lecho.lib.hellocharts.renderer.LineChartRenderer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnValueTouchListener(ComboLineColumnChartOnValueSelectListener paramComboLineColumnChartOnValueSelectListener)
  {
    if (paramComboLineColumnChartOnValueSelectListener != null) {
      this.onValueTouchListener = paramComboLineColumnChartOnValueSelectListener;
    }
  }
  
  private class ComboColumnChartDataProvider
    implements ColumnChartDataProvider
  {
    private ComboColumnChartDataProvider() {}
    
    public ColumnChartData getColumnChartData()
    {
      return null;
    }
    
    public void setColumnChartData(ColumnChartData paramColumnChartData)
    {
      ComboLineColumnChartView.this.data.setColumnChartData(paramColumnChartData);
    }
  }
  
  private class ComboLineChartDataProvider
    implements LineChartDataProvider
  {
    private ComboLineChartDataProvider() {}
    
    public LineChartData getLineChartData()
    {
      return null;
    }
    
    public void setLineChartData(LineChartData paramLineChartData)
    {
      ComboLineColumnChartView.this.data.setLineChartData(paramLineChartData);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\ComboLineColumnChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */