package lecho.lib.hellocharts.formatter;

public class ValueFormatterHelper
{
  public static final int DEFAULT_DIGITS_NUMBER = 0;
  private static final String TAG = "ValueFormatterHelper";
  private char[] appendedText = new char[0];
  private int decimalDigitsNumber = Integer.MIN_VALUE;
  private char decimalSeparator = '.';
  private char[] prependedText = new char[0];
  
  /* Error */
  public void appendText(char[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void determineDecimalSeparator()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int formatFloatValue(char[] paramArrayOfChar, float paramFloat, int paramInt)
  {
    return 0;
  }
  
  public int formatFloatValueWithPrependedAndAppendedText(char[] paramArrayOfChar, float paramFloat, int paramInt)
  {
    return formatFloatValueWithPrependedAndAppendedText(paramArrayOfChar, paramFloat, paramInt, null);
  }
  
  public int formatFloatValueWithPrependedAndAppendedText(char[] paramArrayOfChar1, float paramFloat, int paramInt, char[] paramArrayOfChar2)
  {
    return 0;
  }
  
  public int formatFloatValueWithPrependedAndAppendedText(char[] paramArrayOfChar1, float paramFloat, char[] paramArrayOfChar2)
  {
    return formatFloatValueWithPrependedAndAppendedText(paramArrayOfChar1, paramFloat, 0, paramArrayOfChar2);
  }
  
  public char[] getAppendedText()
  {
    return this.appendedText;
  }
  
  public int getAppliedDecimalDigitsNumber(int paramInt)
  {
    int i = this.decimalDigitsNumber;
    if (i < 0) {
      return paramInt;
    }
    return i;
  }
  
  public int getDecimalDigitsNumber()
  {
    return this.decimalDigitsNumber;
  }
  
  public char getDecimalSeparator()
  {
    return this.decimalSeparator;
  }
  
  public char[] getPrependedText()
  {
    return this.prependedText;
  }
  
  /* Error */
  public void prependText(char[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ValueFormatterHelper setAppendedText(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null) {
      this.appendedText = paramArrayOfChar;
    }
    return this;
  }
  
  public ValueFormatterHelper setDecimalDigitsNumber(int paramInt)
  {
    this.decimalDigitsNumber = paramInt;
    return this;
  }
  
  public ValueFormatterHelper setDecimalSeparator(char paramChar)
  {
    if (paramChar != 0) {
      this.decimalSeparator = paramChar;
    }
    return this;
  }
  
  public ValueFormatterHelper setPrependedText(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null) {
      this.prependedText = paramArrayOfChar;
    }
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\formatter\ValueFormatterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */