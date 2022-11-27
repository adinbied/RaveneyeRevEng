package lecho.lib.hellocharts.view;

import android.content.Context;
import android.util.AttributeSet;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.listener.DummyColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.provider.ColumnChartDataProvider;
import lecho.lib.hellocharts.renderer.ColumnChartRenderer;

public class ColumnChartView
  extends AbstractChartView
  implements ColumnChartDataProvider
{
  private static final String TAG = "ColumnChartView";
  private ColumnChartData data;
  private ColumnChartOnValueSelectListener onValueTouchListener = new DummyColumnChartOnValueSelectListener();
  
  public ColumnChartView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ColumnChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColumnChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setChartRenderer(new ColumnChartRenderer(paramContext, this, this));
    setColumnChartData(ColumnChartData.generateDummyData());
  }
  
  /* Error */
  public void callTouchListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ColumnChartData getChartData()
  {
    return this.data;
  }
  
  public ColumnChartData getColumnChartData()
  {
    return this.data;
  }
  
  public ColumnChartOnValueSelectListener getOnValueTouchListener()
  {
    return this.onValueTouchListener;
  }
  
  /* Error */
  public void setColumnChartData(ColumnChartData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnValueTouchListener(ColumnChartOnValueSelectListener paramColumnChartOnValueSelectListener)
  {
    if (paramColumnChartOnValueSelectListener != null) {
      this.onValueTouchListener = paramColumnChartOnValueSelectListener;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\ColumnChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */