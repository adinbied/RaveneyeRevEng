package lecho.lib.hellocharts.model;

import lecho.lib.hellocharts.util.ChartUtils;

public class SliceValue
{
  private static final int DEFAULT_SLICE_SPACING_DP = 2;
  private int color = ChartUtils.DEFAULT_COLOR;
  private int darkenColor = ChartUtils.DEFAULT_DARKEN_COLOR;
  private float diff;
  private char[] label;
  private float originValue;
  @Deprecated
  private int sliceSpacing = 2;
  private float value;
  
  public SliceValue()
  {
    setValue(0.0F);
  }
  
  public SliceValue(float paramFloat)
  {
    setValue(paramFloat);
  }
  
  public SliceValue(float paramFloat, int paramInt)
  {
    setValue(paramFloat);
    setColor(paramInt);
  }
  
  public SliceValue(float paramFloat, int paramInt1, int paramInt2)
  {
    setValue(paramFloat);
    setColor(paramInt1);
    this.sliceSpacing = paramInt2;
  }
  
  public SliceValue(SliceValue paramSliceValue)
  {
    setValue(paramSliceValue.value);
    setColor(paramSliceValue.color);
    this.sliceSpacing = paramSliceValue.sliceSpacing;
    this.label = paramSliceValue.label;
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
  
  @Deprecated
  public int getSliceSpacing()
  {
    return this.sliceSpacing;
  }
  
  public float getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public SliceValue setColor(int paramInt)
  {
    this.color = paramInt;
    this.darkenColor = ChartUtils.darkenColor(paramInt);
    return this;
  }
  
  public SliceValue setLabel(String paramString)
  {
    this.label = paramString.toCharArray();
    return this;
  }
  
  @Deprecated
  public SliceValue setLabel(char[] paramArrayOfChar)
  {
    this.label = paramArrayOfChar;
    return this;
  }
  
  @Deprecated
  public SliceValue setSliceSpacing(int paramInt)
  {
    this.sliceSpacing = paramInt;
    return this;
  }
  
  public SliceValue setTarget(float paramFloat)
  {
    return null;
  }
  
  public SliceValue setValue(float paramFloat)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\SliceValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */