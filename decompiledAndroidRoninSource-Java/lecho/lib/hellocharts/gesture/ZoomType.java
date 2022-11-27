package lecho.lib.hellocharts.gesture;

public enum ZoomType
{
  static
  {
    ZoomType localZoomType = new ZoomType("HORIZONTAL_AND_VERTICAL", 2);
    HORIZONTAL_AND_VERTICAL = localZoomType;
    $VALUES = new ZoomType[] { HORIZONTAL, VERTICAL, localZoomType };
  }
  
  private ZoomType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\ZoomType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */