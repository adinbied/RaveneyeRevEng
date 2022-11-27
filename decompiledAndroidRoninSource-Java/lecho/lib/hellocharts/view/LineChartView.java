package lecho.lib.hellocharts.view;

import android.content.Context;
import android.util.AttributeSet;
import lecho.lib.hellocharts.listener.DummyLineChartOnValueSelectListener;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.provider.LineChartDataProvider;
import lecho.lib.hellocharts.renderer.LineChartRenderer;

public class LineChartView
  extends AbstractChartView
  implements LineChartDataProvider
{
  private static final String TAG = "LineChartView";
  protected LineChartData data;
  protected LineChartOnValueSelectListener onValueTouchListener = new DummyLineChartOnValueSelectListener();
  
  public LineChartView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public LineChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LineChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setChartRenderer(new LineChartRenderer(paramContext, this, this));
    setLineChartData(LineChartData.generateDummyData());
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
  
  public LineChartData getLineChartData()
  {
    return this.data;
  }
  
  public LineChartOnValueSelectListener getOnValueTouchListener()
  {
    return this.onValueTouchListener;
  }
  
  /* Error */
  public void setLineChartData(LineChartData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setLineShader(android.graphics.Shader arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnValueTouchListener(LineChartOnValueSelectListener paramLineChartOnValueSelectListener)
  {
    if (paramLineChartOnValueSelectListener != null) {
      this.onValueTouchListener = paramLineChartOnValueSelectListener;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\LineChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */