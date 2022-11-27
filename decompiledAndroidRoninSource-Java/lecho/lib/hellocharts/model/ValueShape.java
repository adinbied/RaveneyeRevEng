package lecho.lib.hellocharts.model;

public enum ValueShape
{
  static
  {
    ValueShape localValueShape = new ValueShape("DIAMOND", 2);
    DIAMOND = localValueShape;
    $VALUES = new ValueShape[] { CIRCLE, SQUARE, localValueShape };
  }
  
  private ValueShape() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\ValueShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */