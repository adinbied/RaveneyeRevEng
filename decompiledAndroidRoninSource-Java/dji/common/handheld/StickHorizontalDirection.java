package dji.common.handheld;

public enum StickHorizontalDirection
{
  static
  {
    StickHorizontalDirection localStickHorizontalDirection = new StickHorizontalDirection("UNKNOWN", 3);
    UNKNOWN = localStickHorizontalDirection;
    $VALUES = new StickHorizontalDirection[] { CENTER, LEFT, RIGHT, localStickHorizontalDirection };
  }
  
  private StickHorizontalDirection() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\handheld\StickHorizontalDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */