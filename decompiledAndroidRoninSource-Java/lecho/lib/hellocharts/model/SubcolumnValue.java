package lecho.lib.hellocharts.model;

import lecho.lib.hellocharts.util.ChartUtils;

public class SubcolumnValue
{
  private int color = ChartUtils.DEFAULT_COLOR;
  private int darkenColor = ChartUtils.DEFAULT_DARKEN_COLOR;
  private float diff;
  private char[] label;
  private float originValue;
  private float value;
  
  public SubcolumnValue()
  {
    setValue(0.0F);
  }
  
  public SubcolumnValue(float paramFloat)
  {
    setValue(paramFloat);
  }
  
  public SubcolumnValue(float paramFloat, int paramInt)
  {
    setValue(paramFloat);
    setColor(paramInt);
  }
  
  public SubcolumnValue(SubcolumnValue paramSubcolumnValue)
  {
    setValue(paramSubcolumnValue.value);
    setColor(paramSubcolumnValue.color);
    this.label = paramSubcolumnValue.label;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public int getDarkenColor()
  {
    return this.darkenColor;
  }
  
  @Deprecated
  public char[] getLabel()
  {
    return this.label;
  }
  
  public char[] getLabelAsChars()
  {
    return this.label;
  }
  
  public float getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public SubcolumnValue setColor(int paramInt)
  {
    this.color = paramInt;
    this.darkenColor = ChartUtils.darkenColor(paramInt);
    return this;
  }
  
  public SubcolumnValue setLabel(String paramString)
  {
    this.label = paramString.toCharArray();
    return this;
  }
  
  @Deprecated
  public SubcolumnValue setLabel(char[] paramArrayOfChar)
  {
    this.label = paramArrayOfChar;
    return this;
  }
  
  public SubcolumnValue setTarget(float paramFloat)
  {
    return null;
  }
  
  public SubcolumnValue setValue(float paramFloat)
  {
    this.value = paramFloat;
    this.originValue = paramFloat;
    this.diff = 0.0F;
    return this;
  }
  
  public String toString()
  {
    return null;
  }
  
  /* Error */
  public void update(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\SubcolumnValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */