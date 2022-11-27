package lecho.lib.hellocharts.formatter;

import lecho.lib.hellocharts.model.SliceValue;

public class SimplePieChartValueFormatter
  implements PieChartValueFormatter
{
  private ValueFormatterHelper valueFormatterHelper;
  
  public SimplePieChartValueFormatter()
  {
    ValueFormatterHelper localValueFormatterHelper = new ValueFormatterHelper();
    this.valueFormatterHelper = localValueFormatterHelper;
    localValueFormatterHelper.determineDecimalSeparator();
  }
  
  public SimplePieChartValueFormatter(int paramInt)
  {
    this();
    this.valueFormatterHelper.setDecimalDigitsNumber(paramInt);
  }
  
  public int formatChartValue(char[] paramArrayOfChar, SliceValue paramSliceValue)
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
  
  public SimplePieChartValueFormatter setAppendedText(char[] paramArrayOfChar)
  {
    this.valueFormatterHelper.setAppendedText(paramArrayOfChar);
    return this;
  }
  
  public SimplePieChartValueFormatter setDecimalDigitsNumber(int paramInt)
  {
    this.valueFormatterHelper.setDecimalDigitsNumber(paramInt);
    return this;
  }
  
  public SimplePieChartValueFormatter setDecimalSeparator(char paramChar)
  {
    this.valueFormatterHelper.setDecimalSeparator(paramChar);
    return this;
  }
  
  public SimplePieChartValueFormatter setPrependedText(char[] paramArrayOfChar)
  {
    this.valueFormatterHelper.setPrependedText(paramArrayOfChar);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\formatter\SimplePieChartValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */