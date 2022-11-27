package dji.midware.ar.min3d.vos;

public enum RenderType
{
  private final int _glValue;
  
  static
  {
    LINES = new RenderType("LINES", 1, 1);
    LINE_LOOP = new RenderType("LINE_LOOP", 2, 2);
    LINE_STRIP = new RenderType("LINE_STRIP", 3, 3);
    TRIANGLES = new RenderType("TRIANGLES", 4, 4);
    TRIANGLE_STRIP = new RenderType("TRIANGLE_STRIP", 5, 5);
    RenderType localRenderType = new RenderType("TRIANGLE_FAN", 6, 6);
    TRIANGLE_FAN = localRenderType;
    $VALUES = new RenderType[] { POINTS, LINES, LINE_LOOP, LINE_STRIP, TRIANGLES, TRIANGLE_STRIP, localRenderType };
  }
  
  private RenderType(int paramInt)
  {
    this._glValue = paramInt;
  }
  
  public int glValue()
  {
    return this._glValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\RenderType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */