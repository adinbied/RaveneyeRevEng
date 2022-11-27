package lecho.lib.hellocharts.formatter;

import lecho.lib.hellocharts.model.PointValue;

public class SimpleLineChartValueFormatter
  implements LineChartValueFormatter
{
  private ValueFormatterHelper valueFormatterHelper;
  
  public SimpleLineChartValueFormatter()
  {
    ValueFormatterHelper localValueFormatterHelper = new ValueFormatterHelper();
    this.valueFormatterHelper = localValueFormatterHelper;
    localValueFormatterHelper.determineDecimalSeparator();
  }
  
  public SimpleLineChartValueFormatter(int paramInt)
  {
    this();
    this.valueFormatterHelper.setDecimalDigitsNumber(paramInt);
  }
  
  public int formatChartValue(char[] paramArrayOfChar, PointValue paramPointValue)
  {
    return 0;
  }
  
  public char[] getAppendedText()
  {
    return this.valueFormatterHelper.getAppendedText();
  }
  
  public int getDecimalDigitsNumber()
  {
    return this.valueFormatterHelper.getDecimalDigitsNumber();
  }
  
  public char getDecimalSeparator()
  {
    return this.valueFormatterHelper.getDecimalSeparator();
  }
  
  public char[] getPrependedText()
  {
    return this.valueFormatterHelper.getPrependedText();
  }
  
  public SimpleLineChartValueFormatter setAppendedText(char[] paramArrayOfChar)
  {
    this.valueFormatterHelper.setAppendedText(paramArrayOfChar);
    return this;
  }
  
  public SimpleLineChartValueFormatter setDecimalDigitsNumber(int paramInt)
  {
    this.valueFormatterHelper.setDecimalDigitsNumber(paramInt);
    return this;
  }
  
  public SimpleLineChartValueFormatter setDecimalSeparator(char paramChar)
  {
    this.valueFormatterHelper.setDecimalSeparator(paramChar);
    return this;
  }
  
  public SimpleLineChartValueFormatter setPrependedText(char[] paramArrayOfChar)
  {
    this.valueFormatterHelper.setPrependedText(paramArrayOfChar);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\formatter\SimpleLineChartValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */