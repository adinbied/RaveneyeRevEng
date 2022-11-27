package lecho.lib.hellocharts.listener;

import lecho.lib.hellocharts.model.SubcolumnValue;

public abstract interface ColumnChartOnValueSelectListener
  extends OnValueDeselectListener
{
  public abstract void onValueSelected(int paramInt1, int paramInt2, SubcolumnValue paramSubcolumnValue);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\listener\ColumnChartOnValueSelectListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */