package lecho.lib.hellocharts.listener;

import lecho.lib.hellocharts.model.BubbleValue;

public abstract interface BubbleChartOnValueSelectListener
  extends OnValueDeselectListener
{
  public abstract void onValueSelected(int paramInt, BubbleValue paramBubbleValue);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\listener\BubbleChartOnValueSelectListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */