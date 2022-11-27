package lecho.lib.hellocharts.model;

public class AxisValue
{
  private char[] label;
  private float value;
  
  public AxisValue(float paramFloat)
  {
    setValue(paramFloat);
  }
  
  @Deprecated
  public AxisValue(float paramFloat, char[] paramArrayOfChar)
  {
    this.value = paramFloat;
    this.label = paramArrayOfChar;
  }
  
  public AxisValue(AxisValue paramAxisValue)
  {
    this.value = paramAxisValue.value;
    this.label = paramAxisValue.label;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
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
  
  public AxisValue setLabel(String paramString)
  {
    this.label = paramString.toCharArray();
    return this;
  }
  
  @Deprecated
  public AxisValue setLabel(char[] paramArrayOfChar)
  {
    this.label = paramArrayOfChar;
    return this;
  }
  
  public AxisValue setValue(float paramFloat)
  {
    this.value = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\AxisValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */