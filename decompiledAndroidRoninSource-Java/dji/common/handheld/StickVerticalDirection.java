package dji.common.handheld;

public enum StickVerticalDirection
{
  static
  {
    DOWN = new StickVerticalDirection("DOWN", 2);
    StickVerticalDirection localStickVerticalDirection = new StickVerticalDirection("UNKNOWN", 3);
    UNKNOWN = localStickVerticalDirection;
    $VALUES = new StickVerticalDirection[] { CENTER, UP, DOWN, localStickVerticalDirection };
  }
  
  private StickVerticalDirection() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\handheld\StickVerticalDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */