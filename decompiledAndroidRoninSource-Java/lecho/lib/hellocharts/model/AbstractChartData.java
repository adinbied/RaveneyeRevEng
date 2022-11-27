package lecho.lib.hellocharts.model;

import android.graphics.Typeface;
import lecho.lib.hellocharts.util.ChartUtils;

public abstract class AbstractChartData
  implements ChartData
{
  public static final int DEFAULT_TEXT_SIZE_SP = 12;
  protected Axis axisXBottom;
  protected Axis axisXTop;
  protected Axis axisYLeft;
  protected Axis axisYRight;
  protected boolean isValueLabelBackgroundEnabled = true;
  protected boolean isValueLabelBackgrountAuto = true;
  protected int valueLabelBackgroundColor = ChartUtils.darkenColor(ChartUtils.DEFAULT_DARKEN_COLOR);
  protected int valueLabelTextColor = -1;
  protected int valueLabelTextSize = 12;
  protected Typeface valueLabelTypeface;
  
  public AbstractChartData() {}
  
  public AbstractChartData(AbstractChartData paramAbstractChartData)
  {
    Axis localAxis = paramAbstractChartData.axisXBottom;
    if (localAxis != null) {
      this.axisXBottom = new Axis(localAxis);
    }
    localAxis = paramAbstractChartData.axisXTop;
    if (localAxis != null) {
      this.axisXTop = new Axis(localAxis);
    }
    localAxis = paramAbstractChartData.axisYLeft;
    if (localAxis != null) {
      this.axisYLeft = new Axis(localAxis);
    }
    localAxis = paramAbstractChartData.axisYRight;
    if (localAxis != null) {
      this.axisYRight = new Axis(localAxis);
    }
    this.valueLabelTextColor = paramAbstractChartData.valueLabelTextColor;
    this.valueLabelTextSize = paramAbstractChartData.valueLabelTextSize;
    this.valueLabelTypeface = paramAbstractChartData.valueLabelTypeface;
  }
  
  public Axis getAxisXBottom()
  {
    return this.axisXBottom;
  }
  
  public Axis getAxisXTop()
  {
    return this.axisXTop;
  }
  
  public Axis getAxisYLeft()
  {
    return this.axisYLeft;
  }
  
  public Axis getAxisYRight()
  {
    return this.axisYRight;
  }
  
  public int getValueLabelBackgroundColor()
  {
    return this.valueLabelBackgroundColor;
  }
  
  public int getValueLabelTextColor()
  {
    return this.valueLabelTextColor;
  }
  
  public int getValueLabelTextSize()
  {
    return this.valueLabelTextSize;
  }
  
  public Typeface getValueLabelTypeface()
  {
    return this.valueLabelTypeface;
  }
  
  public boolean isValueLabelBackgroundAuto()
  {
    return this.isValueLabelBackgrountAuto;
  }
  
  public boolean isValueLabelBackgroundEnabled()
  {
    return this.isValueLabelBackgroundEnabled;
  }
  
  public void setAxisXBottom(Axis paramAxis)
  {
    this.axisXBottom = paramAxis;
  }
  
  public void setAxisXTop(Axis paramAxis)
  {
    this.axisXTop = paramAxis;
  }
  
  public void setAxisYLeft(Axis paramAxis)
  {
    this.axisYLeft = paramAxis;
  }
  
  public void setAxisYRight(Axis paramAxis)
  {
    this.axisYRight = paramAxis;
  }
  
  public void setValueLabelBackgroundAuto(boolean paramBoolean)
  {
    this.isValueLabelBackgrountAuto = paramBoolean;
  }
  
  public void setValueLabelBackgroundColor(int paramInt)
  {
    this.valueLabelBackgroundColor = paramInt;
  }
  
  public void setValueLabelBackgroundEnabled(boolean paramBoolean)
  {
    this.isValueLabelBackgroundEnabled = paramBoolean;
  }
  
  public void setValueLabelTextSize(int paramInt)
  {
    this.valueLabelTextSize = paramInt;
  }
  
  public void setValueLabelTypeface(Typeface paramTypeface)
  {
    this.valueLabelTypeface = paramTypeface;
  }
  
  public void setValueLabelsTextColor(int paramInt)
  {
    this.valueLabelTextColor = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\AbstractChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */