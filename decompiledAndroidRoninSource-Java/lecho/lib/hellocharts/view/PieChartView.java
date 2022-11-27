package lecho.lib.hellocharts.view;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import lecho.lib.hellocharts.animation.PieChartRotationAnimator;
import lecho.lib.hellocharts.animation.PieChartRotationAnimatorV14;
import lecho.lib.hellocharts.animation.PieChartRotationAnimatorV8;
import lecho.lib.hellocharts.gesture.PieChartTouchHandler;
import lecho.lib.hellocharts.listener.DummyPieChartOnValueSelectListener;
import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.provider.PieChartDataProvider;
import lecho.lib.hellocharts.renderer.PieChartRenderer;

public class PieChartView
  extends AbstractChartView
  implements PieChartDataProvider
{
  private static final String TAG = "PieChartView";
  protected PieChartData data;
  protected PieChartOnValueSelectListener onValueTouchListener = new DummyPieChartOnValueSelectListener();
  protected PieChartRenderer pieChartRenderer = new PieChartRenderer(paramContext, this, this);
  protected PieChartRotationAnimator rotationAnimator;
  
  public PieChartView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PieChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PieChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.touchHandler = new PieChartTouchHandler(paramContext, this);
    setChartRenderer(this.pieChartRenderer);
    if (Build.VERSION.SDK_INT < 14) {
      this.rotationAnimator = new PieChartRotationAnimatorV8(this);
    } else {
      this.rotationAnimator = new PieChartRotationAnimatorV14(this);
    }
    setPieChartData(PieChartData.generateDummyData());
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
  
  public int getChartRotation()
  {
    return this.pieChartRenderer.getChartRotation();
  }
  
  public float getCircleFillRatio()
  {
    return this.pieChartRenderer.getCircleFillRatio();
  }
  
  public RectF getCircleOval()
  {
    return this.pieChartRenderer.getCircleOval();
  }
  
  public PieChartOnValueSelectListener getOnValueTouchListener()
  {
    return this.onValueTouchListener;
  }
  
  public PieChartData getPieChartData()
  {
    return this.data;
  }
  
  public SliceValue getValueForAngle(int paramInt, SelectedValue paramSelectedValue)
  {
    return this.pieChartRenderer.getValueForAngle(paramInt, paramSelectedValue);
  }
  
  public boolean isChartRotationEnabled()
  {
    return false;
  }
  
  /* Error */
  public void setChartRotation(int arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setChartRotationEnabled(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCircleFillRatio(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCircleOval(RectF arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnValueTouchListener(PieChartOnValueSelectListener paramPieChartOnValueSelectListener)
  {
    if (paramPieChartOnValueSelectListener != null) {
      this.onValueTouchListener = paramPieChartOnValueSelectListener;
    }
  }
  
  /* Error */
  public void setPieChartData(PieChartData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\view\PieChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */