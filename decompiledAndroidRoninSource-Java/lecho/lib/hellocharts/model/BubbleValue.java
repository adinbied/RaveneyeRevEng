package lecho.lib.hellocharts.model;

import lecho.lib.hellocharts.util.ChartUtils;

public class BubbleValue
{
  private int color = ChartUtils.DEFAULT_COLOR;
  private int darkenColor = ChartUtils.DEFAULT_DARKEN_COLOR;
  private float diffX;
  private float diffY;
  private float diffZ;
  private char[] label;
  private float originX;
  private float originY;
  private float originZ;
  private ValueShape shape = ValueShape.CIRCLE;
  private float x;
  private float y;
  private float z;
  
  public BubbleValue()
  {
    set(0.0F, 0.0F, 0.0F);
  }
  
  public BubbleValue(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    set(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public BubbleValue(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    set(paramFloat1, paramFloat2, paramFloat3);
    setColor(paramInt);
  }
  
  public BubbleValue(BubbleValue paramBubbleValue)
  {
    set(paramBubbleValue.x, paramBubbleValue.y, paramBubbleValue.z);
    setColor(paramBubbleValue.color);
    this.label = paramBubbleValue.label;
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
  
  public ValueShape getShape()
  {
    return this.shape;
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public float getZ()
  {
    return this.z;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public BubbleValue set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.originX = paramFloat1;
    this.originY = paramFloat2;
    this.originZ = paramFloat3;
    this.diffX = 0.0F;
    this.diffY = 0.0F;
    this.diffZ = 0.0F;
    return this;
  }
  
  public BubbleValue setColor(int paramInt)
  {
    this.color = paramInt;
    this.darkenColor = ChartUtils.darkenColor(paramInt);
    return this;
  }
  
  public BubbleValue setLabel(String paramString)
  {
    this.label = paramString.toCharArray();
    return this;
  }
  
  @Deprecated
  public BubbleValue setLabel(char[] paramArrayOfChar)
  {
    this.label = paramArrayOfChar;
    return this;
  }
  
  public BubbleValue setShape(ValueShape paramValueShape)
  {
    this.shape = paramValueShape;
    return this;
  }
  
  public BubbleValue setTarget(float paramFloat1, float paramFloat2, float paramFloat3)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\BubbleValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */