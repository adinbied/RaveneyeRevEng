package lecho.lib.hellocharts.gesture;

public enum ContainerScrollType
{
  static
  {
    ContainerScrollType localContainerScrollType = new ContainerScrollType("VERTICAL", 1);
    VERTICAL = localContainerScrollType;
    $VALUES = new ContainerScrollType[] { HORIZONTAL, localContainerScrollType };
  }
  
  private ContainerScrollType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\gesture\ContainerScrollType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */