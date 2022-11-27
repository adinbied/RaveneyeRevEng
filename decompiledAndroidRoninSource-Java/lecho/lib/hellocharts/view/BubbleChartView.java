package lecho.lib.hellocharts.view;

import android.content.Context;
import android.util.AttributeSet;
import lecho.lib.hellocharts.listener.BubbleChartOnValueSelectListener;
import lecho.lib.hellocharts.listener.DummyBubbleChartOnValueSelectListener;
import lecho.lib.hellocharts.model.BubbleChartData;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.provider.BubbleChartDataProvider;
import lecho.lib.hellocharts.renderer.BubbleChartRenderer;

public class BubbleChartView
  extends AbstractChartView
  implements BubbleChartDataProvider
{
  private static final String TAG = "BubbleChartView";
  protected BubbleChartRenderer bubbleChartRenderer;
  protected BubbleChartData data;
  protected BubbleChartOnValueSelectListener onValueTouchListener = new DummyBubbleChartOnValueSelectListener();
  
  public BubbleChartView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public BubbleChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BubbleChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new BubbleChartRenderer(paramContext, this, this);
    this.bubbleChartRenderer = paramContext;
    setChartRenderer(paramContext);
    setBubbleChartData(BubbleChartData.generateDummyData());
  }
  
  /* Error */
  public void callTouchListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public BubbleChartData getBubbleChartData()
  {
    return this.data;
  }
  
  public ChartData getChartData()
  {
    return this.data;
  }
  
  public BubbleChartOnValueSelectListener getOnValueTouchListener()
  {
    return this.onValueTouchListener;
  }
  
  /* Error */
  public void removeMargins()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setBubbleChartData(BubbleChartData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnValueTouchListener(BubbleChartOnValueSelectListener paramBubbleChartOnValueSelectListener)
  {
    if (paramBubbleChartOnValueSelectListener != null) {
      this.onValueTouchListener = paramBubbleChartOnValueSelectListener;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\BubbleChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */