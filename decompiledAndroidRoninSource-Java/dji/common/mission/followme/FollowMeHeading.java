package dji.common.mission.followme;

public enum FollowMeHeading
{
  private int value;
  
  static
  {
    FollowMeHeading localFollowMeHeading = new FollowMeHeading("CONTROLLED_BY_REMOTE_CONTROLLER", 1, 1);
    CONTROLLED_BY_REMOTE_CONTROLLER = localFollowMeHeading;
    $VALUES = new FollowMeHeading[] { TOWARD_FOLLOW_POSITION, localFollowMeHeading };
  }
  
  private FollowMeHeading(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static FollowMeHeading find(int paramInt)
  {
    FollowMeHeading localFollowMeHeading = TOWARD_FOLLOW_POSITION;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFollowMeHeading;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\followme\FollowMeHeading.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */