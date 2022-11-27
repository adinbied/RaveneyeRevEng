package lecho.lib.hellocharts.provider;

import lecho.lib.hellocharts.model.LineChartData;

public abstract interface LineChartDataProvider
{
  public abstract LineChartData getLineChartData();
  
  public abstract void setLineChartData(LineChartData paramLineChartData);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\provider\LineChartDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */