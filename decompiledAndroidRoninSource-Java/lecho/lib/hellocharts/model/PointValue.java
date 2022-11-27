package lecho.lib.hellocharts.model;

public class PointValue
{
  private float diffX;
  private float diffY;
  private char[] label;
  private float originX;
  private float originY;
  private float x;
  private float y;
  
  public PointValue()
  {
    set(0.0F, 0.0F);
  }
  
  public PointValue(float paramFloat1, float paramFloat2)
  {
    set(paramFloat1, paramFloat2);
  }
  
  public PointValue(PointValue paramPointValue)
  {
    set(paramPointValue.x, paramPointValue.y);
    this.label = paramPointValue.label;
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
  
  @Deprecated
  public char[] getLabel()
  {
    return this.label;
  }
  
  public char[] getLabelAsChars()
  {
    return this.label;
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public PointValue set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.originX = paramFloat1;
    this.originY = paramFloat2;
    this.diffX = 0.0F;
    this.diffY = 0.0F;
    return this;
  }
  
  public PointValue setLabel(String paramString)
  {
    this.label = paramString.toCharArray();
    return this;
  }
  
  @Deprecated
  public PointValue setLabel(char[] paramArrayOfChar)
  {
    this.label = paramArrayOfChar;
    return this;
  }
  
  public PointValue setTarget(float paramFloat1, float paramFloat2)
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\PointValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */