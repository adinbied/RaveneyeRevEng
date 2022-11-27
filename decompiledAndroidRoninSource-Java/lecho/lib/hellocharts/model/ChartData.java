package lecho.lib.hellocharts.model;

import android.graphics.Typeface;

public abstract interface ChartData
{
  public abstract void finish();
  
  public abstract Axis getAxisXBottom();
  
  public abstract Axis getAxisXTop();
  
  public abstract Axis getAxisYLeft();
  
  public abstract Axis getAxisYRight();
  
  public abstract int getValueLabelBackgroundColor();
  
  public abstract int getValueLabelTextColor();
  
  public abstract int getValueLabelTextSize();
  
  public abstract Typeface getValueLabelTypeface();
  
  public abstract boolean isValueLabelBackgroundAuto();
  
  public abstract boolean isValueLabelBackgroundEnabled();
  
  public abstract void setAxisXBottom(Axis paramAxis);
  
  public abstract void setAxisXTop(Axis paramAxis);
  
  public abstract void setAxisYLeft(Axis paramAxis);
  
  public abstract void setAxisYRight(Axis paramAxis);
  
  public abstract void setValueLabelBackgroundAuto(boolean paramBoolean);
  
  public abstract void setValueLabelBackgroundColor(int paramInt);
  
  public abstract void setValueLabelBackgroundEnabled(boolean paramBoolean);
  
  public abstract void setValueLabelTextSize(int paramInt);
  
  public abstract void setValueLabelTypeface(Typeface paramTypeface);
  
  public abstract void setValueLabelsTextColor(int paramInt);
  
  public abstract void update(float paramFloat);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\ChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */